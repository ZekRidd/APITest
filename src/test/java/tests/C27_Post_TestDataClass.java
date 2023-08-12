package tests;

import TestDatas.TestDataHerokuapp;
import baseUrl.BaseUrlHerokuApp;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C27_Post_TestDataClass extends BaseUrlHerokuApp {
    @Test
    public void test01() {
        /*
                https://restful-booker.herokuapp.com/booking url’ine
                asagidaki body'ye sahip bir POST request gonderdigimizde
                donen response’un id haric asagidaki gibi oldugunu test edin.
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

        // 1- endpoint ve request body olustur
        specHerokuapp.pathParam("pp1","booking");

        JSONObject reqBody = TestDataHerokuapp.JsonRequestBodyOlustur();

        //2- Soruda varsa expectedData oluştur
        JSONObject expectedData = TestDataHerokuapp.JsonResponseBodyOlustur();

        //3- Request gönder ve dönen response'u kaydet

        Response response = given().spec(specHerokuapp).contentType(ContentType.JSON)
                            .when().body(reqBody.toString())
                            .post("{pp1}");


        JsonPath responseJP = response.jsonPath();

        //4- Assertion

        assertEquals(expectedData.getJSONObject("booking").getString("firstname"),
                        responseJP.getString("booking.firstname"));
        assertEquals(expectedData.getJSONObject("booking").getString("lastname"),
                responseJP.getString("booking.lastname"));
        assertEquals(expectedData.getJSONObject("booking").getInt("totalprice"),
                responseJP.getInt("booking.totalprice"));
        assertEquals(expectedData.getJSONObject("booking").getBoolean("depositpaid"),
                responseJP.getBoolean("booking.depositpaid"));

        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").getString("checkin"),
                responseJP.getString("booking.bookingdates.checkin"));

        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").getString("checkout"),
                responseJP.getString("booking.bookingdates.checkout"));

        assertEquals(expectedData.getJSONObject("booking").getString("additionalneeds"),
                responseJP.getString("booking.additionalneeds"));
    }
}
