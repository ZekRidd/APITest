import org.json.JSONObject;
import org.junit.Test;

public class C5_JSONObject2 {

    @Test
    public void test01(){

        /*
              {
        "firstname":"Jim",
        "additionalneeds":"Breakfast",
        "bookingdates":{
                "checkin":"2018-01-01",
                "checkout":"2019-01-01"
        },
        "totalprice":111,
        "depositpaid":true,
        "lastname":"Brown"
            }
         */

        //First create inner Json Object
        JSONObject innerJSON = new JSONObject();
        innerJSON.put("checkin","2018-01-01");
        innerJSON.put("checkout","2019-01-01");

        //Then create outer Json Object
        JSONObject outerJSON = new JSONObject();
        outerJSON.put("firstname","Jim");
        outerJSON.put("additionalneeds","Breakfast");
        outerJSON.put("bookingdates",innerJSON);
        outerJSON.put("totalprice",111);
        outerJSON.put("depositpaid",true);
        outerJSON.put("lastname","Brown");

        System.out.println(outerJSON);

    }
}
