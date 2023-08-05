import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C1_Request_ResponseBody {

    @Test
    public void get01(){

        //1- Request body ve endpoint hazırlama
        String url = "https://restful-booker.herokuapp.com/booking/10";

        //2- Expected data hazırlama
        //3- Request gönderip, dönen response'u kaydetme
        Response response = given().when().get(url);
        response.prettyPrint();
        //4- Assertion
    }
}
