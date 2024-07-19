package tests;

import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testDataKlasoru.TestDataJsonPlaceholder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C28_Put_DeSerialization extends BaseUrlJsonPlaceholder {

      /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine
    asagidaki body’e sahip bir PUT request yolladigimizda
    donen response’in response body’sinin asagida verilen ile ayni oldugunu test ediniz

        Request Body

        {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
        }

        Expected Response Body:

        {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
        }
     */


    @Test
    public void test(){


        //1-endpoint ve request body olustur


        specJsonPlaceholder.pathParams("pp1","posts","pp2",70);

        // requestBody olustur

        Map<String,Object> requestBodyMap=TestDataJsonPlaceholder.bodyOlusturMap();

        //2-expected data olustur

        Map<String,Object> expectedData=TestDataJsonPlaceholder.bodyOlusturMap();

        //3-request gonder donen responsı kaydet

        Response response=given().when().contentType(ContentType.JSON).spec(specJsonPlaceholder).body(requestBodyMap).put("{pp1}/{pp2}");

        response.prettyPrint();

        //4-Assertion
        // expected Response body <=========> response

        //   Map                            Response

        // Assertion yapabilmemiz icin response'i Map'e cevirmemiz gerekir (De-Serialization)
        //
            Map<String,Object> responseMap= response.as(HashMap.class);

        assertEquals(expectedData.get("title"),responseMap.get("title"));
        assertEquals(expectedData.get("body"),responseMap.get("body"));
        assertEquals(expectedData.get("id"),responseMap.get("id"));
        assertEquals(expectedData.get("userId"),responseMap.get("userId"));













    }
}
