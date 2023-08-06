import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.junit.Test;

public class C4_JSONObject {

    @Test
    public void test01(){

        /*
            {
                "title":"Ahmet",
                "body":"Merhaba",
                "userId":1
            }
         */

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("title","Ahmet");
        jsonObject.put("body","Merhaba");
        jsonObject.put("userId",1);

        System.out.println(jsonObject);

    }
}
