package JsonArrayJar;

import org.json.JSONArray;
import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class JsonArrayTest {
    public static void main(String[] args){
        JSONObject data1=new JSONObject();
        data1.put("employee_name", "ObjectTest");
        data1.put("profile_image", "test1.png");
        data1.put("employee_age", "30");
        data1.put("employee_salary", "11111");

        JSONObject data2 = new JSONObject();

        data2.put("employee_name", "MapTest");
        data2.put("profile_image", "test2.png");
        data2.put("employee_age", "20");
        data2.put("employee_salary", "99999");

        JSONArray array=new JSONArray();
        array.put(data2);
        array.put(data1);

        JSONAssert.assertEquals(data1,data2,JSONCompareMode.LENIENT);
    }
}
