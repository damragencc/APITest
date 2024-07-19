package tests;

import baseUrl.BaseUrlDummy;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testDataKlasoru.TestDataDummyExample;
import testDataKlasoru.TestDataJsonPlaceholder;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C26_Get_TestDataKullanimi extends BaseUrlDummy {


    @Test
    public void test(){

          /*
        http://dummy.restapiexample.com/api/v1/employee/3 url’ine
        bir GET request gonderdigimizde
        donen response’un status code’unun 200,
        content Type’inin application/json
        ve body’sinin asagidaki gibi oldugunu test edin.

          Expected Response Body
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


        //1-end point gönder

        specDummy.pathParams("pp1","employee","pp2",3);

        //2-expectedData olustur

        JSONObject expectedData= TestDataDummyExample.responseJSonBodyOlusturDummy(3,"Ashton Cox",86000,66,"");

        //3-requestBody gonder donen responsi kaydet

       Response response=given().when().spec(specDummy).get("{pp1}/{pp2}");


        //4-Assert

        JsonPath responseJSPt=response.jsonPath();

        assertEquals(TestDataDummyExample.basariliSorguStatusCode,response.statusCode());
        assertEquals(TestDataDummyExample.contentTypeDummy,response.contentType());
       // assertEquals(expectedData.getJSONObject("data").getInt("id"),
                //responseJSPt.getInt("data.id"));
        assertEquals(expectedData.getJSONObject("data").getString("employee_name"),responseJSPt.getString("data.employee_name"));
        assertEquals(expectedData.getJSONObject("data").getInt("id"),responseJSPt.getInt("data.id"));
        assertEquals(expectedData.getJSONObject("data").getInt("employee_salary"),responseJSPt.getInt("data.employee_salary"));
        assertEquals(expectedData.getJSONObject("data").getInt("employee_age"),responseJSPt.getInt("data.employee_age"));
        assertEquals(expectedData.getJSONObject("data").getString("profile_image"),responseJSPt.getString("data.profile_image"));
        assertEquals(expectedData.getString("message"),responseJSPt.getString("message"));
        assertEquals(expectedData.getString("status"),responseJSPt.getString("status"));








    }
}
