package tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C2_Request_ResponseManuelTest {

    @Test
    public void test01(){

        /*
         https://restful-booker.herokuapp.com/booking/10 url’ine bir
         GET request gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK
        ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.
     */

        //1- Gerekli body ve endpoint hazırla
        String url = "https://restful-booker.herokuapp.com/booking/10";

        //2- Expected body oluştur
        //3- Request gönder dönen response kaydet

        Response response = given().when().get(url);

        System.out.println("Status Code : "  + response.getStatusCode() +
                            "\nContent Type : " + response.getContentType() +
                            "\nServer Header : " + response.getHeader("Server")+
                            "\nStatus Line : " + response.getStatusLine()+
                            "\nResponse Time : " + response.getTime());


    }

}
