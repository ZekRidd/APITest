import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C16_PutSoftAssert {

    @Test
    public void test01() {
        /*
            http://dummy.restapiexample.com/api/v1/update/21 url’ine
            asagidaki body’ye sahip bir PUT request gonderdigimizde
            donen response’un asagidaki gibi oldugunu test edin.
            Request Body
                    {
                    "status": "success",
                    "data": {
                        "name": "Ahmet",
                        "salary": "1230",
                        "age": "44",
                        "id": 40
                            }
                   }
            Response Body
                    {
                    "status": "success",
                    "data": {
                        "status": "success",
                        "data": {
                            "name": "Ahmet",
                            "salary": "1230",
                            "age": "44",
                            "id": 40
                        }
                    },
                    "message": "Successfully! Record has been updated."
                }

     */
        //1- Endpoint ve request body oluştur

        String url= "http://dummy.restapiexample.com/api/v1/update/21";

        JSONObject reqBody = new JSONObject();
        JSONObject dataInfo=new JSONObject();

        dataInfo.put("name","Ahmet");
        dataInfo.put("salary","1230");
        dataInfo.put("age","44");
        dataInfo.put("id",40);

        reqBody.put("status","success");
        reqBody.put("data",dataInfo);

        //2-Expected Data oluştur

        JSONObject expectedData = new JSONObject();

        expectedData.put("status","success");
        expectedData.put("data",reqBody);
        expectedData.put("message","Successfully! Record has been updated.");

        //3- Request gönder ve dönen responsu kaydet.

        Response response = given().contentType(ContentType.JSON)
                            .when().body(reqBody.toString())
                            .put(url);

        //4- Assertion
        JsonPath responseJsonPath=response.jsonPath();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseJsonPath.get("status"),expectedData.get("status"));
        softAssert.assertEquals(responseJsonPath.get("message"),expectedData.get("message"));

        softAssert.assertEquals(responseJsonPath.get("data.status"),expectedData.getJSONObject("data").get("status"));

        softAssert.assertEquals(responseJsonPath.get("data.data.name"),
                expectedData.getJSONObject("data").getJSONObject("data").get("name"));
        softAssert.assertEquals(responseJsonPath.get("data.data.salary"),
                expectedData.getJSONObject("data").getJSONObject("data").get("salary"));
        softAssert.assertEquals(responseJsonPath.get("data.data.age"),
                expectedData.getJSONObject("data").getJSONObject("data").get("age"));
        softAssert.assertEquals(responseJsonPath.get("data.data.id"),
                expectedData.getJSONObject("data").getJSONObject("data").get("id"));



        softAssert.assertAll();


    }
}
