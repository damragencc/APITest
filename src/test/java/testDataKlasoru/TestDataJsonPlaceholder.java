package testDataKlasoru;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TestDataJsonPlaceholder {

    public static int basariliSorguStatusCode = 200;
    public static String contentType="application/json; charset=utf-8";
    public static String headerConnection="keep-alive";




    public static JSONObject responseBodyOlustur22() {


        JSONObject expectedData = new JSONObject();
        expectedData.put("userId", 3);
        expectedData.put("id", 22);
        expectedData.put("title", "dolor sint quo a velit explicabo quia nam");
        expectedData.put("body", "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");


        return expectedData;
    }

    public static JSONObject responseJsonBodyOlustur(int userId,int id, String title,String body) {
        /*
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


        JSONObject responceBody=new JSONObject();
        JSONObject databody=new JSONObject();

        databody.put("userId", userId);
        databody.put("id", id);
        databody.put("title", title);
        databody.put("body", body);

        responceBody.put("status","success");
        responceBody.put("data",databody);
        responceBody.put("message","Successfully! Record has been fetched.");



        return responceBody;
    }

    public static Map<String,Object> bodyOlusturMap(){

        Map<String,Object> bodyMap=new HashMap<>();

        bodyMap.put("title","Damra");
        bodyMap.put("body","Merhaba");
        bodyMap.put("userId",10.0);
        bodyMap.put("id",70.0);

        return bodyMap;



    }


    }
