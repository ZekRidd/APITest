package tests;

import Pojos.PojoDummyExampleInnerData;
import Pojos.PojoDummyExampleResponseBody;
import baseUrl.BaseUrlDummyExample;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C33_Get_Pojo extends BaseUrlDummyExample {

    /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine
    bir GET request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.

	Response Body
	// expected data
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
        // 1- Request url ve body olustur
        specDummyExample.pathParams("pp1","employee","pp2",3);

        //2- Soruda varsa expected data oluştur
        PojoDummyExampleInnerData innerDataPojo=
                        new PojoDummyExampleInnerData(3,"Ashton Cox",86000,66,"");

        PojoDummyExampleResponseBody expectedDataPojo=
                        new PojoDummyExampleResponseBody("success",innerDataPojo,"Successfully! Record has been fetched.");

        //3- Response gönder ve response gönder
        Response response = given().spec(specDummyExample)
                            .when()
                            .get("{pp1}/{pp2}");


        //4- Assertion
        PojoDummyExampleResponseBody responsePojo = response.as(PojoDummyExampleResponseBody.class);

        assertEquals(expectedDataPojo.getStatus(),responsePojo.getStatus());
        assertEquals(expectedDataPojo.getMessage(),responsePojo.getMessage());
        assertEquals(expectedDataPojo.getData().getId(),responsePojo.getData().getId());
        assertEquals(expectedDataPojo.getData().getEmployee_name(),responsePojo.getData().getEmployee_name());
        assertEquals(expectedDataPojo.getData().getEmployee_salary(),responsePojo.getData().getEmployee_salary());
        assertEquals(expectedDataPojo.getData().getEmployee_age(),responsePojo.getData().getEmployee_age());
        assertEquals(expectedDataPojo.getData().getProfile_image(),responsePojo.getData().getProfile_image());
    }
}