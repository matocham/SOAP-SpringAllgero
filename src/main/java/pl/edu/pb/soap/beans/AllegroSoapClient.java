package pl.edu.pb.soap.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import pl.edu.pb.soap.model.AddItemResult;
import pl.edu.pb.soap.restModel.AddsContainer;
import pl.edu.pb.soap.restModel.Advertisement;
import pl.edu.pb.soap.restModel.Breadcrumb;
import pl.edu.pb.soap.restModel.Category;
import pl.edu.pb.soap.utils.AddBuilder;
import pl.edu.pb.soap.utils.CategoryUtils;
import sandboxwebapi.*;

import javax.xml.datatype.XMLGregorianCalendar;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by Mateusz on 27.04.2017.
 */
@Component
public class AllegroSoapClient {
    private static final Logger log = LoggerFactory.getLogger(AllegroSoapClient.class);
    public static final String ALLEGRO_SANDBOX_KEY = "allegro.sandbox.key";
    public static final String ALLEGRO_SANDOBX_USER = "allegro.sandobx.user";
    public static final String ALLEGRO_SANDBOX_PASSWORD = "allegro.sandbox.password";

    private String sessionId;
    List<Category> categories;
    List<SellFormType> formFields;
    Environment env;

    ServiceService serviceService;
    ServicePort allegro;

    @Autowired
    public AllegroSoapClient(Environment env) {
        this.env = env;
        serviceService = new ServiceService();
        allegro = serviceService.getServicePort();
        sessionId = login(env.getProperty(ALLEGRO_SANDOBX_USER), env.getProperty(ALLEGRO_SANDBOX_PASSWORD));
    }

    public String login(String username, String password) {
        DoLoginResponse response;
        String responseString = "";
        try {
            DoQuerySysStatusResponse statusRespnose = queryServerStatus();

            DoLoginRequest loginRequest = new DoLoginRequest();
            loginRequest.setUserLogin(username);
            loginRequest.setUserPassword(password);
            loginRequest.setWebapiKey(env.getProperty(ALLEGRO_SANDBOX_KEY));
            loginRequest.setLocalVersion(statusRespnose.getVerKey());
            response = allegro.doLogin(loginRequest);
            responseString = response.getSessionHandlePart();
        } catch (Exception e) {
            e.printStackTrace();
        }
        sessionId = responseString;
        return responseString;
    }

    private DoQuerySysStatusResponse queryServerStatus() {
        DoQuerySysStatusRequest statusRequest = new DoQuerySysStatusRequest();
        statusRequest.setWebapiKey(env.getProperty(ALLEGRO_SANDBOX_KEY));
        statusRequest.setSysvar(3);
        return allegro.doQuerySysStatus(statusRequest);
    }

    public List<Category> getCategoriesSoap() {
        DoGetCatsDataRequest request = new DoGetCatsDataRequest();
        request.setLocalVersion(queryServerStatus().getVerKey());
        request.setWebapiKey(env.getProperty(ALLEGRO_SANDBOX_KEY));
        DoGetCatsDataResponse response = allegro.doGetCatsData(request);
        ArrayOfCatinfotype catinfotype = response.getCatsList();
        List<Category> result = catinfotype.getItem()
                .stream()
                .map(info -> new Category(info.getCatId(), info.getCatParent(), info.getCatName(), info.getCatPosition()))
                .collect(Collectors.toList());
        return result;
    }

    public AddsContainer getAddsFromCategory(int categoryId, int offset, int size) {
        AddsContainer container = new AddsContainer();
        Integer scope = 0;

        DoGetItemsListRequest itemsreq = new DoGetItemsListRequest();
        itemsreq.setWebapiKey(env.getProperty(ALLEGRO_SANDBOX_KEY)); // Klucz WebApi
        itemsreq.setResultOffset(offset);
        itemsreq.setResultSize(size);
        itemsreq.setResultScope(scope);

        FilterOptionsType fotcat;
        fotcat = new FilterOptionsType();
        fotcat.setFilterId("category");

        ArrayOfString categories;
        categories = new ArrayOfString();
        categories.getItem().add(categoryId + "");
        fotcat.setFilterValueId(categories);

        ArrayOfFilteroptionstype filter = new ArrayOfFilteroptionstype();
        filter.getItem().add(fotcat);
        itemsreq.setFilterOptions(filter);
        DoGetItemsListResponse doGetItemsList = allegro.doGetItemsList(itemsreq);

        container.setTotalCount(doGetItemsList.getItemsCount());
        populateResultsList(container, doGetItemsList);
        return container;
    }

    private void populateResultsList(AddsContainer container, DoGetItemsListResponse doGetItemsList) {
        if (doGetItemsList.getItemsList() != null) {
            List<Advertisement> foundAdds = new ArrayList<>();
            for (ItemsListType item : doGetItemsList.getItemsList().getItem()) {
                Advertisement add = new Advertisement();
                add.setId(item.getItemId());
                for (PriceInfoType priceInfoType : item.getPriceInfo().getItem()) {
                    if (priceInfoType.getPriceType().equals("buyNow")) {
                        add.setPrice(priceInfoType.getPriceValue() + " zł");
                    } else if (priceInfoType.getPriceType().equals("withDelivery")) {
                        add.setPriceWithDelivery(priceInfoType.getPriceValue() + " zł");
                    } else if (priceInfoType.getPriceType().equals("bidding")) {
                        add.setPriceBidding(priceInfoType.getPriceValue() + " zł");
                    }
                }
                add.setTitle(item.getItemTitle());
                add.setLastTime(item.getTimeToEnd());
                XMLGregorianCalendar calendar = item.getEndingTime();
                if (calendar != null) {
                    add.setEndDate(CategoryUtils.paddDate(calendar.getDay())
                            + "-" + CategoryUtils.paddDate(calendar.getMonth())
                            + "-" + calendar.getYear()
                            + " " + CategoryUtils.paddDate(calendar.getHour())
                            + ":" + CategoryUtils.paddDate(calendar.getMinute())
                            + ":" + CategoryUtils.paddDate(calendar.getSecond()));
                }

                add.setState(item.getConditionInfo().equals("new") ? "Nowy" : "Używany");
                if (!item.getPhotosInfo().getItem().isEmpty()) {
                    List<PhotoInfoType> photos = item.getPhotosInfo().getItem();
                    for (PhotoInfoType photo : photos) {
                        log.debug(photo.isPhotoIsMain() + "");
                        log.debug(photo.getPhotoSize());
                        log.debug(photo.getPhotoUrl());
                        log.debug("__________________");
                        if (photo.isPhotoIsMain()) {
                            add.setImageUrl(photo.getPhotoUrl());
                        }
                    }
                }
                add.setOwner(item.getSellerInfo().getUserLogin());
                add.setCategory(item.getCategoryId());
                foundAdds.add(add);
            }
            container.setAdds(foundAdds);
        } else {
            container.setAdds(Collections.emptyList());
        }
    }

    public AddsContainer search(String query, int offset, int size, long category) {
        AddsContainer container = new AddsContainer();
        Integer scope = 0;
        ArrayOfFilteroptionstype filter = new ArrayOfFilteroptionstype();
        DoGetItemsListRequest itemsreq = new DoGetItemsListRequest();
        itemsreq.setWebapiKey(env.getProperty(ALLEGRO_SANDBOX_KEY)); // Klucz WebApi
        itemsreq.setResultOffset(offset);
        itemsreq.setResultSize(size);
        itemsreq.setResultScope(scope);

        FilterOptionsType searchFilter;
        searchFilter = new FilterOptionsType();
        searchFilter.setFilterId("search");

        ArrayOfString searchValue;
        searchValue = new ArrayOfString();
        searchValue.getItem().add(query);
        searchFilter.setFilterValueId(searchValue);

        if (category != -1 && category != 0) {
            FilterOptionsType categoryFilter;
            categoryFilter = new FilterOptionsType();
            categoryFilter.setFilterId("category");

            ArrayOfString categoryValue;
            categoryValue = new ArrayOfString();
            categoryValue.getItem().add(category + "");
            categoryFilter.setFilterValueId(categoryValue);
            filter.getItem().add(categoryFilter);
        }

        filter.getItem().add(searchFilter);
        itemsreq.setFilterOptions(filter);
        DoGetItemsListResponse doGetItemsList = allegro.doGetItemsList(itemsreq);

        container.setTotalCount(doGetItemsList.getItemsCount());
        populateResultsList(container, doGetItemsList);
        return container;
    }

    public List<Breadcrumb> getPathTo(Integer category) {
        List<Breadcrumb> result = new ArrayList<>();
        DoGetCategoryPathRequest request = new DoGetCategoryPathRequest();
        request.setCategoryId(category);
        request.setSessionId(getSessionId());
        DoGetCategoryPathResponse response = allegro.doGetCategoryPath(request);
        List<CategoryData> categories = response.getCategoryPath().getItem();
        for (CategoryData categoryData : categories) {
            result.add(new Breadcrumb(categoryData.getCatName(), categoryData.getCatId()));
        }
        return result;
    }

    public List<Category> getCategories() {
        if (categories == null) {
            categories = getCategoriesSoap();
        }
        return categories;
    }

    public Advertisement getAdd(long id) {
        DoGetItemsInfoRequest infoRequest = new DoGetItemsInfoRequest();
        infoRequest.setGetDesc(1);
        infoRequest.setGetAttribs(1);
        infoRequest.setGetImageUrl(1);
        infoRequest.setSessionHandle(getSessionId());

        ArrayOfLong ids = new ArrayOfLong();
        ids.getItem().add(id);
        infoRequest.setItemsIdArray(ids);
        DoGetItemsInfoResponse infoResponse = allegro.doGetItemsInfo(infoRequest);
        for (ItemInfoStruct item : infoResponse.getArrayItemListInfo().getItem()) {
            Advertisement adv = new Advertisement();
            adv.setTitle(item.getItemInfo().getItName());
            adv.setPrice(item.getItemInfo().getItBuyNowPrice() + " zł");
            adv.setOwner(item.getItemInfo().getItSellerLogin());
            adv.setPriceBidding(item.getItemInfo().getItPrice() + " zł");
            adv.setDescription(item.getItemInfo().getItDescription());
            adv.setCategory(item.getItemCats().getItem().get(item.getItemCats().getItem().size() - 1).getCatId());
            for (ItemImageList imageList : item.getItemImages().getItem()) {
                adv.setImageUrl(imageList.getImageUrl());
                break;
            }
            if (item.getItemInfo().getItState() == 8) {
                adv.setState("Używany");
            } else {
                adv.setState("Nowy");
            }
            for (AttribStruct attribStruct : item.getItemAttribs().getItem()) {
                if (attribStruct.getAttribName().equals("Stan")) {
                    adv.setState(attribStruct.getAttribValues().getItem().get(0));
                }
            }
            long endTimestamp = item.getItemInfo().getItEndingTime();
            if (endTimestamp != 0) {
                Timestamp stamp = new Timestamp(endTimestamp * 1000);
                Date date = new Date(stamp.getTime());
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
                adv.setEndDate(dateFormat.format(date));
                Date currentDate = new Date();
                Map<TimeUnit, Long> interval;
                if (currentDate.before(date)) {
                    interval = computeDiff(currentDate, date);
                } else {
                    interval = computeDiff(date, currentDate);
                }
                if (interval.get(TimeUnit.DAYS) > 0) {
                    adv.setLastTime(interval.get(TimeUnit.DAYS) + " dni");
                } else {
                    String result = interval.get(TimeUnit.HOURS) + ":";
                    result += interval.get(TimeUnit.MINUTES) + ":";
                    result += interval.get(TimeUnit.SECONDS);
                    adv.setLastTime(result + " godzin");
                }
            }
            return adv;
        }
        return new Advertisement();
    }

    private Map<TimeUnit, Long> computeDiff(Date date1, Date date2) {
        long diffInMillies = date2.getTime() - date1.getTime();
        List<TimeUnit> units = new ArrayList<>(EnumSet.allOf(TimeUnit.class));
        Collections.reverse(units);
        Map<TimeUnit, Long> result = new LinkedHashMap<>();
        long milliesRest = diffInMillies;
        for (TimeUnit unit : units) {
            long diff = unit.convert(milliesRest, TimeUnit.MILLISECONDS);
            long diffInMilliesForUnit = unit.toMillis(diff);
            milliesRest = milliesRest - diffInMilliesForUnit;
            result.put(unit, diff);
        }
        return result;
    }

    public String getSessionId() {
        return sessionId;
    }

    public AddItemResult createNewAdd(String title, String description,
                                      double price, double deliveryPrice,
                                      int category, int deliveryType, MultipartFile image) throws IOException {
        List<SellFormType> fieldsForCat = fieldsForCat(category);
        int identifier = (int) System.currentTimeMillis();
        DoNewAuctionExtRequest request = AddBuilder.buildRequest(title, description, price, deliveryPrice, category, deliveryType, image, getSessionId(), identifier);
        request = AddBuilder.appendMissingFields(request,fieldsForCat);
        DoNewAuctionExtResponse response = allegro.doNewAuctionExt(request);

        DoVerifyItemRequest verifyRequest = new DoVerifyItemRequest();
        verifyRequest.setLocalId(identifier);
        verifyRequest.setSessionHandle(getSessionId());
        DoVerifyItemResponse verifyItemResponse = allegro.doVerifyItem(verifyRequest);

        AddItemResult addItemResult = new AddItemResult();
        switch (verifyItemResponse.getItemListed()) {
            case -1:
                addItemResult.setResultMessage("Wystąpił błąd podczas dodawania oferty, spróbuj ponownie później");
                break;
            case 0:
                addItemResult.setResultMessage("Oferta czeka w kolejce na wystawienie");
                break;
            case 1:
                addItemResult.setResultMessage("Oferta została wystawiona poprawnie");
                break;
            case 2:
                addItemResult.setResultMessage("Oferta czeka na wystawienie");
                break;
            case 3:
                addItemResult.setResultMessage("Oferta czeka na ponowne wystawienie");
                break;
        }
        Timestamp stamp = new Timestamp(verifyItemResponse.getItemStartingTime() * 1000);
        addItemResult.setPublishTime(new Date(stamp.getTime()));
        addItemResult.setMessageId(verifyItemResponse.getItemListed());
        return addItemResult;
    }

    private List<SellFormType> fieldsForCat(int category){
        List<SellFormType> fields = new ArrayList<>();
        List<Breadcrumb> categoryPath = getPathTo(category);
        for( SellFormType formType : getFormFileds()){
            if(contains(formType.getSellFormCat(),categoryPath)){
                fields.add(formType);
            }
        }
        return  fields;
    }

    private boolean contains(int category, List<Breadcrumb> categoryPath){
        for(Breadcrumb b : categoryPath){
            if(b.getId() == category){
                return true;
            }
        }
        return false;
    }

    public List<SellFormType> getFormFileds() {
        if(formFields == null){
            DoGetSellFormFieldsExtRequest request = new DoGetSellFormFieldsExtRequest();
            request.setWebapiKey(env.getProperty(ALLEGRO_SANDBOX_KEY));
            request.setCountryCode(1);
            DoGetSellFormFieldsExtResponse response = allegro.doGetSellFormFieldsExt(request);
            formFields =response.getSellFormFields().getItem();
        }
        return formFields;
    }

    public int getUserId(){
        DoGetUserIDRequest request = new DoGetUserIDRequest();
        request.setUserLogin(env.getProperty(ALLEGRO_SANDOBX_USER));
        request.setWebapiKey(env.getProperty(ALLEGRO_SANDBOX_KEY));
        DoGetUserIDResponse response = allegro.doGetUserID(request);
        return response.getUserId();
    }

    public AddsContainer getMyAdds(int offset, int size) {
        AddsContainer container = new AddsContainer();
        Integer scope = 0;

        DoGetItemsListRequest itemsreq = new DoGetItemsListRequest();
        itemsreq.setWebapiKey(env.getProperty(ALLEGRO_SANDBOX_KEY)); // Klucz WebApi
        itemsreq.setResultOffset(offset);
        itemsreq.setResultSize(size);
        itemsreq.setResultScope(scope);

        FilterOptionsType userIdFilter;
        userIdFilter = new FilterOptionsType();
        userIdFilter.setFilterId("userId");

        ArrayOfString userId;
        userId = new ArrayOfString();
        userId.getItem().add(getUserId() + "");
        userIdFilter.setFilterValueId(userId);

        ArrayOfFilteroptionstype filter = new ArrayOfFilteroptionstype();
        filter.getItem().add(userIdFilter);
        itemsreq.setFilterOptions(filter);
        DoGetItemsListResponse doGetItemsList = allegro.doGetItemsList(itemsreq);

        container.setTotalCount(doGetItemsList.getItemsCount());
        populateResultsList(container, doGetItemsList);
        return container;
    }
}
