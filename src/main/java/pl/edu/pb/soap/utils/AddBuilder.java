package pl.edu.pb.soap.utils;

import org.springframework.web.multipart.MultipartFile;
import sandboxwebapi.ArrayOfFieldsvalue;
import sandboxwebapi.DoNewAuctionExtRequest;
import sandboxwebapi.FieldsValue;
import sandboxwebapi.SellFormType;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by Mateusz on 01.06.2017.
 */
public class AddBuilder {
    public static final int TITLE = 1;
    public static final int CATEGORY = 2;
    public static final int START_DATE = 3;
    public static final int DURATION = 4;
    public static final int AMOUNT = 5;
    public static final int PRICE = 8;
    public static final int COUNTRY = 9;
    public static final int PROVINCE = 10;
    public static final int CITY = 11;
    public static final int DELIVERY_COST_TO = 12;
    public static final int PAYMENT_METHOD = 14;
    public static final int PICTURE = 16;
    public static final int DESCRIPTION = 24;
    public static final int COUNT_TYPE = 28;
    public static final int SELL_FORM = 29;
    public static final int POSTAL_CODE = 32;

    public static final String POSTAL_CODE_VALUE = "15-334";
    public static final int PAYMENT_METHOD_VALUE = 1;
    public static final int COUNT_TYPE_VALUE = 0;
    public static final int SELL_FORM_VALUE = 0;
    public static final int PROVINCE_PODLASKIE_VALUE = 10;
    public static final String CITY_VALUE = "Białystok";
    public static final int DELIVERY_COST_TO_BUYER = 1;

    public static DoNewAuctionExtRequest buildRequest(
            String title, String description,
            double price, double deliveryPrice,
            int category, int deliveryType, MultipartFile image,
            String sessionHandle, int id) throws IOException {
        DoNewAuctionExtRequest request = new DoNewAuctionExtRequest();

        request.setSessionHandle(sessionHandle);
        ArrayOfFieldsvalue arrayOfFieldsvalue = new ArrayOfFieldsvalue();
        request.setFields(arrayOfFieldsvalue);
        FieldsValue value = new FieldsValue();
        value.setFid(TITLE);
        value.setFvalueString(title);
        arrayOfFieldsvalue.getItem().add(value);

        value = new FieldsValue();
        value.setFid(CATEGORY);
        value.setFvalueInt(category);
        arrayOfFieldsvalue.getItem().add(value);

//        value = new FieldsValue();
//        value.setFid(START_DATE);
//        Calendar instance = Calendar.getInstance(TimeZone.getDefault());
//        String date = CategoryUtils.paddDate(instance.get(Calendar.DAY_OF_WEEK));
//        date+="-"+CategoryUtils.paddDate(instance.get(Calendar.MONTH))+"-";
//        date+=instance.get(Calendar.YEAR);
//        value.setFvalueDate(date);
//        arrayOfFieldsvalue.getItem().add(value);

        value = new FieldsValue();
        value.setFid(DURATION);
        value.setFvalueInt(2);
        arrayOfFieldsvalue.getItem().add(value);

        value = new FieldsValue();
        value.setFid(AMOUNT);
        value.setFvalueInt(1);
        arrayOfFieldsvalue.getItem().add(value);

        value = new FieldsValue();
        value.setFid(PRICE);
        value.setFvalueFloat((float) price);
        arrayOfFieldsvalue.getItem().add(value);

        value = new FieldsValue();
        value.setFid(COUNTRY);
        value.setFvalueInt(1);
        arrayOfFieldsvalue.getItem().add(value);

        value = new FieldsValue();
        value.setFid(PROVINCE);
        value.setFvalueInt(PROVINCE_PODLASKIE_VALUE);
        arrayOfFieldsvalue.getItem().add(value);

        value = new FieldsValue();
        value.setFid(CITY);
        value.setFvalueString(CITY_VALUE);
        arrayOfFieldsvalue.getItem().add(value);

        value = new FieldsValue();
        value.setFid(DELIVERY_COST_TO);
        value.setFvalueInt(DELIVERY_COST_TO_BUYER);
//        arrayOfFieldsvalue.getItem().add(value);

        value = new FieldsValue();
        value.setFid(PAYMENT_METHOD);
        value.setFvalueInt(PAYMENT_METHOD_VALUE);
        arrayOfFieldsvalue.getItem().add(value);

        value = new FieldsValue();
        value.setFid(DESCRIPTION);
        value.setFvalueString(description);
        arrayOfFieldsvalue.getItem().add(value);

        value = new FieldsValue();
        value.setFid(COUNT_TYPE);
        value.setFvalueInt(COUNT_TYPE_VALUE);
        arrayOfFieldsvalue.getItem().add(value);


        value = new FieldsValue();
        value.setFid(SELL_FORM);
        value.setFvalueInt(SELL_FORM_VALUE);
        arrayOfFieldsvalue.getItem().add(value);

        value = new FieldsValue();
        value.setFid(deliveryType);
        value.setFvalueFloat((float) deliveryPrice);
        arrayOfFieldsvalue.getItem().add(value);

        value = new FieldsValue();
        value.setFid(POSTAL_CODE);
        value.setFvalueString(POSTAL_CODE_VALUE);
        arrayOfFieldsvalue.getItem().add(value);

        value = new FieldsValue();
        value.setFid(PICTURE);
        value.setFvalueImage(image.getBytes());
        arrayOfFieldsvalue.getItem().add(value);

        request.setLocalId(id);
        return request;
    }

    public static DoNewAuctionExtRequest appendMissingFields(DoNewAuctionExtRequest request, List<SellFormType> missing) {
        for (SellFormType type : missing) {
            if (type.getSellFormOpt() == 1) {
                String values = type.getSellFormOptsValues();
                String[]splittedValues = values.split("\\|");
                if(splittedValues.length>1){
                    FieldsValue value = new FieldsValue();
                    value.setFid(type.getSellFormId());
                    value.setFvalueInt(Integer.parseInt(splittedValues[1]));
                    request.getFields().getItem().add(value);
                }
            }
        }
        return  request;
    }
}
