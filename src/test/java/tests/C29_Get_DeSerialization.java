package tests;

import TestDatas.TestDataDummyExample;
import baseUrl.BaseUrlDummyExample;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C29_Get_DeSerialization extends BaseUrlDummyExample {

    /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine
    bir GET request gonderdigimizde
    donen response’un status code’unun 200,
    content Type’inin application/json
    ve body’sinin asagidaki gibi oldugunu test edin.
        Expected Response Body
        {
            "status":"success",
            "data":{
                    "id":3,
                    "employee_name":"Ashton Cox",
                    "employee_salary":86000,
                    "employee_age":66,
                    "profile_image":""
                    },
            "message":"Successfully! Record has been fetched."
        }
     */

    @Test
    public void test01() {
        // 1- endpoint ve request body olustur
        specDummyExample.pathParams("pp1","employee","pp2",3);

        Map<String,Object> reqBody = TestDataDummyExample.mapBodyOlustur();

        // 2- Soruda varsa expected data olustur

        Map<String,Object> expectedData = TestDataDummyExample.mapBodyOlustur();

        // 3- Request gonder donen response'i kaydet

        Response response = given().spec(specDummyExample)
                            .when()
                            .get("{pp1}/{pp2}");


        // 4- Assertion

        Map<String,Object> responseMap = response.as(HashMap.class);

        assertEquals(TestDataDummyExample.basariliSorguStatusCode,response.statusCode());
        assertEquals(TestDataDummyExample.contentType,response.contentType());

        assertEquals(expectedData.get("status"),responseMap.get("status"));
        assertEquals(expectedData.get("message"),responseMap.get("message"));

        assertEquals(((Map)expectedData.get("data")).get("profile_image"),
                            ((Map)responseMap.get("data")).get("profile_image"));

        assertEquals(((Map)expectedData.get("data")).get("id"),
                ((Map)responseMap.get("data")).get("id"));

        assertEquals(((Map)expectedData.get("data")).get("profile_image"),
                ((Map)responseMap.get("data")).get("profile_image"));

        assertEquals(((Map)expectedData.get("data")).get("profile_image"),
                ((Map)responseMap.get("data")).get("profile_image"));

    }
}