package TestDatas;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TestDataHerokuapp {

    /*
        {
                        "firstname" : "Ahmet",
                        "lastname" : “Bulut",
                        "totalprice" : 500,
                        "depositpaid" : false,
                        "bookingdates" : {
                                "checkin" : "2021-06-01",
                                "checkout" : "2021-06-10"
                                },
                        "additionalneeds" : "wi-fi"
                        }
     */
    public static JSONObject JsonRequestBodyOlustur(){

        JSONObject requestBody = new JSONObject();
        JSONObject bookingDates = new JSONObject();

        bookingDates.put("checkin","2021-06-01");
        bookingDates.put("checkout","2021-06-10");

        requestBody.put("firstname","Ahmet");
        requestBody.put("lastname","Bulut");
        requestBody.put("totalprice",500);
        requestBody.put("depositpaid",false);
        requestBody.put("bookingdates",bookingDates);
        requestBody.put("additionalneeds","wi-fi");


        return requestBody;
    }

    public static JSONObject JsonResponseBodyOlustur(){
        /*
            Expected response body
                        {
                         "bookingid":24,
                         "booking":{
                            "firstname":"Ahmet",
                            "lastname":"Bulut",
                            "totalprice":500,
                            "depositpaid":false,
                            "bookingdates":{
                                    "checkin":"2021-06-01",
                                    "checkout":"2021-06-10"
                                            },
                            "additionalneeds":"wi-fi"
                                    }
                          }
         */

        JSONObject responseBody = new JSONObject();
        JSONObject bookingBody = JsonRequestBodyOlustur();

        responseBody.put("bookingid",24);
        responseBody.put("booking",bookingBody);

        return responseBody;
    }


    /*
            Request body
                       {
                            "firstname" : "Ahmet",
                            "lastname" : “Bulut",
                            "totalprice" : 500,
                            "depositpaid" : false,
                            "bookingdates" : {
                                     "checkin" : "2021-06-01",
                                     "checkout" : "2021-06-10"
                                              },
                            "additionalneeds" : "wi-fi"
                        }
     */
    public static Map<String,Object> requestBodyMapOlustur(){

        Map<String,Object> requestBody = new HashMap<>();
        requestBody.put("firstname","Ahmet");
        requestBody.put("lastname","Bulut");
        requestBody.put("totalprice",500.0);
        requestBody.put("depositpaid",false);
        requestBody.put("bookingdates",mapBookingdatesOlustur());
        requestBody.put("additionalneeds","wi-fi");

        return requestBody;
    }

    public static Map<String,String> mapBookingdatesOlustur(){

        Map<String,String> bookingDates=new HashMap<>();
        bookingDates.put("checkin","2021-06-01");
        bookingDates.put("checkout","2021-06-10");

        return bookingDates;
    }


    /*
        Response Body // expected data
                        {
                        "bookingid":24,
                        "booking":{
                            "firstname":"Ahmet",
                            "lastname":"Bulut",
                            "totalprice":500,
                            "depositpaid":false,
                            "bookingdates":{
                                "checkin":"2021-06-01",
                                "checkout":"2021-06-10"
                            ,
                            "additionalneeds":"wi-fi"
                        }
     */
    public static Map<String,Object> responseBodyMapOlustur(){

        Map<String,Object> responseBodyMap = new HashMap<>();
        responseBodyMap.put("bookingid",24.0);
        responseBodyMap.put("booking",requestBodyMapOlustur());

        return responseBodyMap;
    }
}
