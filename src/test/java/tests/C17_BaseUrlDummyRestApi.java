package tests;

import baseUrl.BaseUrlJsonPlaceHolder;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C17_BaseUrlDummyRestApi extends BaseUrlJsonPlaceHolder {

    @Test
    public void test01() {
        //1-  https://jsonplaceholder.typicode.com/posts endpointine
        //    bir GET request gonderdigimizde donen response’un
        //    status code’unun 200 oldugunu ve Response’ta 100 kayit oldugunu test edin

        // 1- endpoint ve request body olustur

        specJsonPlaceHolder.pathParam("pp1","posts");

        //2- Expected data oluştur
        //3- request gönder ve dönen response'u kaydet

        Response response = given()
                            .when().spec(specJsonPlaceHolder)
                            .get("/{pp1}");

        response
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .body("title", Matchers.hasSize(100));
    }

    @Test
    public void test02(){
        //2- https://jsonplaceholder.typicode.com/posts/44 endpointine
        //   bir GET request gonderdigimizde donen response’un
        //   status code’unun 200 oldugunu
        //   ve “title” degerinin “optio dolor molestias sit” oldugunu test edin

        // 1- endpoint ve request body olustur
        specJsonPlaceHolder.pathParams("pp1","posts","pp2",44);

        // 2- expected data olustur
        // 3- request gonder ve donen response'i kaydet

        Response response = given()
                            .when().spec(specJsonPlaceHolder)
                            .get("/{pp1}/{pp2}");

        response
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .body("title",Matchers.equalTo("optio dolor molestias sit"));
    }
}