package tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testDataKlasoru.TestDataHerokuapp;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C27_Post_TestDataKullanimi extends BaseUrlHerokuapp {


    @Test
    public void test(){

         /*
                https://restful-booker.herokuapp.com/booking url’ine
                asagidaki body'ye sahip bir POST request gonderdigimizde
                donen response’un id haric asagidaki gibi oldugunu test edin.
                Request body
                       {
                        "firstname" : "Ahmet",
                        "lastname" : “Bulut",
                        "totalprice" : 500,
                        "depositpaid" : false,
                        "bookingdates" : {
                                "checkin" : "2021-06-01",
                                "checkout" : "2021-06-10"
                                },
                        "additionalneeds" : "wi-fi"
                        }
               Expected response body
                        {
                         "bookingid":24,
                         "booking":{
                            "firstname":"Ahmet",
                            "lastname":"Bulut",
                            "totalprice":500,
                            "depositpaid":false,
                            "bookingdates":{
                                    "checkin":"2021-06-01",
                                    "checkout":"2021-06-10"
                                            },
                            "additionalneeds":"wi-fi"
                                    }
                          }
         */

        //1-endpoint ve request body olustur

        specHerokuapp.pathParam("pp1","booking");
        JSONObject requestBody= TestDataHerokuapp.jsonRequestBodyOlustur();

        //2 expected data olustur

        JSONObject expectedData=TestDataHerokuapp.jsonResponseBodyOlustur();

        //3- request gonder ve donen responsi kaydet

        Response response=given().when().spec(specHerokuapp).contentType(ContentType.JSON).body(requestBody.toString()).post("{pp1}");

        //4-Assert
        JsonPath responcePath=response.jsonPath();

      assertEquals(expectedData.getJSONObject("booking").getString("firstname"),responcePath.getString("booking.firstname"));
        assertEquals(expectedData.getJSONObject("booking").getString("lastname"),responcePath.getString("booking.lastname"));
        assertEquals(expectedData.getJSONObject("booking").getInt("totalprice"),responcePath.getInt("booking.totalprice"));
        assertEquals(expectedData.getJSONObject("booking").getBoolean("depositpaid"),responcePath.getBoolean("booking.depositpaid"));
        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").getString("checkin"),responcePath.getString("booking.bookingdates.checkin"));
        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").getString("checkout"),responcePath.getString("booking.bookingdates.checkout"));
        assertEquals(expectedData.getJSONObject("booking").getString("additionalneeds"),responcePath.getString("booking.additionalneeds"));

        responcePath.prettyPrint();
    }
}
