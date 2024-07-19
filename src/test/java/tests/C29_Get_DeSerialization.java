package tests;

import baseUrl.BaseUrlDummy;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testDataKlasoru.TestDataDummyExample;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C29_Get_DeSerialization extends BaseUrlDummy {


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

        //1-endpoint ve requestBody gonder

        specDummy.pathParams("pp1","employee","pp2",3);

        //2-ExpectedData olustur

        Map<String,Object> expectedData=TestDataDummyExample.bodyOlusturMap("Ashton Cox",86000.0,66.0,"",3.0);


        //3- request gonder donen response kaydet

        Response response=given().when().spec(specDummy).get("{pp1}/{pp2}");
        response.prettyPrint();

        //4-Assertion
       assertEquals(TestDataDummyExample.contentTypeDummy,response.contentType());
       assertEquals(TestDataDummyExample.basariliSorguStatusCode,response.statusCode());
        Map<String,Object> responceMap=response.as(HashMap.class);

        assertEquals(expectedData.get("status"),responceMap.get("status"));
        assertEquals(expectedData.get("message"),responceMap.get("message"));
        assertEquals(((Map)expectedData.get("data")).get("id"),((Map)responceMap.get("data")).get("id"));
        assertEquals(((Map)expectedData.get("data")).get("employee_name"),((Map)responceMap.get("data")).get("employee_name"));
        assertEquals(((Map)expectedData.get("data")).get("employee_salary"),((Map)responceMap.get("data")).get("employee_salary"));
        assertEquals(((Map)expectedData.get("data")).get("employee_age"),((Map)responceMap.get("data")).get("employee_age"));
        assertEquals(((Map)expectedData.get("data")).get("profile_image"),((Map)responceMap.get("data")).get("profile_image"));





    }
}
