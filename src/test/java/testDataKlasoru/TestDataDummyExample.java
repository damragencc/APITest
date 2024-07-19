package testDataKlasoru;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TestDataDummyExample {

    public static String contentTypeDummy="application/json";
    public static int basariliSorguStatusCode = 200;



    public static JSONObject responseJSonBodyOlusturDummy(int id, String employee_name, int salary, int age, String image){

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

        JSONObject responseBody= new JSONObject();
        JSONObject dataBody=new JSONObject();

        dataBody.put("id", id);
        dataBody.put("employee_name", employee_name);
        dataBody.put("employee_salary", salary);
        dataBody.put("employee_age", age);
        dataBody.put("profile_image", image);

        responseBody.put("data",dataBody);
        responseBody.put("message","Successfully! Record has been fetched.");
        responseBody.put("status","success");


        return responseBody;
}

        public static Map<String,Object> bodyOlusturMap(String employee_name,double employee_salary,double employee_age,String profile_image,double id){

        Map<String,Object> requestBody=new HashMap<>();
        Map<String,Object>  dataMap=new HashMap<>();
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
           dataMap.put("employee_name",employee_name);
           dataMap.put("employee_salary",employee_salary);
           dataMap.put("employee_age",employee_age);
           dataMap.put("profile_image",profile_image);
           dataMap.put("id",id);

           requestBody.put("status","success");
           requestBody.put("data",dataMap);
           requestBody.put("message","Successfully! Record has been fetched.");


            return  requestBody;
        }
    }