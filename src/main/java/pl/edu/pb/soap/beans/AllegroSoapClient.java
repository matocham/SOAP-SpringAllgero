package pl.edu.pb.soap.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import pl.edu.pb.soap.restModel.AddsContainer;
import pl.edu.pb.soap.restModel.Advertisement;
import pl.edu.pb.soap.restModel.Category;
import pl.edu.pb.soap.utils.CategoryUtils;
import sandboxwebapi.*;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Mateusz on 27.04.2017.
 */
@Component
public class AllegroSoapClient {
    private static final Logger log = LoggerFactory.getLogger(AllegroSoapClient.class);
    public static final int POLAND_COUNTRY_CODE = 1;
    public static final String ALLEGRO_SANDBOX_KEY = "allegro.sandbox.key";

    private String sessionId;

    @Autowired
    Environment env;

    ServiceService serviceService;
    ServicePort allegro;

    public AllegroSoapClient(){
        serviceService = new ServiceService();
        allegro = serviceService.getServicePort();
    }

    public String login(String username, String password){
        DoLoginResponse response = null;
        String responseString = "";
        try {
            DoQuerySysStatusResponse statusRespnose = queryServerStatus();

            DoLoginRequest loginRequest = new DoLoginRequest();
            loginRequest.setUserLogin(username);
            loginRequest.setUserPassword(password);
            loginRequest.setCountryCode(POLAND_COUNTRY_CODE);
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
        statusRequest.setCountryId(POLAND_COUNTRY_CODE);
        statusRequest.setSysvar(3);
        return allegro.doQuerySysStatus(statusRequest);
    }

    public List<Category> getCategories(){
        DoGetCatsDataRequest request = new DoGetCatsDataRequest();
        request.setCountryId(POLAND_COUNTRY_CODE);
        request.setLocalVersion(queryServerStatus().getVerKey());
        request.setWebapiKey(env.getProperty(ALLEGRO_SANDBOX_KEY));
        DoGetCatsDataResponse response = allegro.doGetCatsData(request);
        ArrayOfCatinfotype catinfotype = response.getCatsList();
        List<Category> result = catinfotype.getItem()
                .stream()
                .map(info -> new Category(info.getCatId(), info.getCatParent(), info.getCatName(), info.getCatPosition()))
                .collect(Collectors.toList());
        return  result;
    }

    public AddsContainer getAddsFromCategory(int categoryId, int offset, int size){
        AddsContainer container = new AddsContainer();
        Integer scope=0;

        DoGetItemsListRequest itemsreq = new DoGetItemsListRequest();
        itemsreq.setCountryId(POLAND_COUNTRY_CODE); // Kod Kraju który wcześniej trzeba było zaimplementować
        itemsreq.setWebapiKey(env.getProperty(ALLEGRO_SANDBOX_KEY)); // Klucz WebApi
        itemsreq.setResultOffset(offset);
        itemsreq.setResultSize(size);
        itemsreq.setResultScope(scope);

        FilterOptionsType fotcat;
        fotcat = new FilterOptionsType();
        fotcat.setFilterId("category");

        ArrayOfString categories;
        categories = new ArrayOfString();
        categories.getItem().add(categoryId+"");
        fotcat.setFilterValueId(categories);

        ArrayOfFilteroptionstype filter = new ArrayOfFilteroptionstype();
        filter.getItem().add(fotcat);
        itemsreq.setFilterOptions(filter);
        DoGetItemsListResponse doGetItemsList = allegro.doGetItemsList(itemsreq);

        container.setTotalCount(doGetItemsList.getItemsCount());
        if(doGetItemsList.getItemsList() != null){
            List<Advertisement> foundAdds = new ArrayList<>();
            for(ItemsListType item: doGetItemsList.getItemsList().getItem()){
                Advertisement add = new Advertisement();
                add.setId(item.getItemId());
                for(PriceInfoType priceInfoType : item.getPriceInfo().getItem()){
                    if(priceInfoType.getPriceType().equals("buyNow")){
                        add.setPrice(priceInfoType.getPriceValue()+" zł");
                        add.setPriceType("kup teraz");
                    } else if(priceInfoType.getPriceType().equals("withDelivery")){
                        add.setPriceWithDelivery(priceInfoType.getPriceValue()+" zł");
                    }
                }
                add.setTitle(item.getItemTitle());
                add.setLastTime(item.getTimeToEnd());
                XMLGregorianCalendar calendar = item.getEndingTime();
                add.setEndDate(CategoryUtils.paddDate(calendar.getDay())
                        +"-"+CategoryUtils.paddDate(calendar.getMonth())
                        +"-"+calendar.getYear()
                        +" "+CategoryUtils.paddDate(calendar.getHour())
                        +":"+CategoryUtils.paddDate(calendar.getMinute())
                        +":"+CategoryUtils.paddDate(calendar.getSecond()));
                add.setState(item.getConditionInfo().equals("new")?"Nowy":"Używany");
                foundAdds.add(add);
            }
            container.setAdds(foundAdds);
        }
        return container;
    }

    public String getSessionId() {
        return sessionId;
    }
}
