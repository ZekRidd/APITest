package tests;

import TestDatas.TestDataJsonPlaceholder;
import baseUrl.BaseUrlJsonPlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C25_Put_TestDataClass extends BaseUrlJsonPlaceHolder {

    @Test
    public void test01() {
        /*
        https://jsonplaceholder.typicode.com/posts/70 url'ine
        asagidaki body’e sahip bir PUT request yolladigimizda
        donen response’in
            status kodunun 200,
            content type’inin “application/json; charset=utf-8”,
            Connection header degerinin “keep-alive”
            ve response body’sinin asagida verilen ile ayni oldugunu test ediniz
         Request Body
            {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
            }
        Response body (Expected Data) :
            {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
            }
     */

        // 1- endpoint ve request body olustur

        specJsonPlaceHolder.pathParams("pp1","posts","pp2","70");

        JSONObject reqBody = TestDataJsonPlaceholder.jsonBodyOlustur(10,70,"Ahmet","Merhaba");

        // 2- expected data olustur
        JSONObject expectedData = TestDataJsonPlaceholder.jsonBodyOlustur(10,70,"Ahmet","Merhaba");

        //3- Request gönder ve dönen response'u kaydet

        Response response = given().spec(specJsonPlaceHolder)
                            .when().body(reqBody.toString()).contentType(ContentType.JSON)
                            .put("{pp1}/{pp2}");

        // 4- Assertion
        JsonPath responseJsonPath = response.jsonPath();

        assertEquals(TestDataJsonPlaceholder.basariliSorguStatusKodu,response.statusCode());
        assertEquals(TestDataJsonPlaceholder.contentType,response.contentType());
        assertEquals(TestDataJsonPlaceholder.header,response.header("Connection"));

        assertEquals(expectedData.getInt("id"),responseJsonPath.getInt("id"));
        assertEquals(expectedData.getInt("userId"),responseJsonPath.getInt("userId"));
        assertEquals(expectedData.getString("title"),responseJsonPath.getString("title"));
        assertEquals(expectedData.getString("body"),responseJsonPath.getString("body"));

    }
}