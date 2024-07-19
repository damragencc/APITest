package tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testDataKlasoru.TestDataHerokuapp;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C30_Post_DeSerialization extends BaseUrlHerokuapp {

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
                            Response Body // expected data
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
                            ,
                            "additionalneeds":"wi-fi"
                        }
         */
        //1- endpoint ve requestBody Olustur

        specHerokuapp.pathParam("pp1","booking");

        Map<String,Object> requestBody= TestDataHerokuapp.requestBodyOlusturma();

        //2-expeted data olustur

        Map<String,Object> expectedData=TestDataHerokuapp.responceMap();

        //3-request gonder donen responce kaydet

        Response response=given().when().spec(specHerokuapp).contentType(ContentType.JSON).body(requestBody).post("{pp1}");

        response.prettyPrint();

        //4-Assert
        Map<String,Object> responseMap= response.as(HashMap.class);

        assertEquals(((Map)expectedData.get("booking")).get("firstname"),
                ((Map)responseMap.get("booking")).get("firstname"));

        assertEquals(((Map)expectedData.get("booking")).get("lastname"),
                ((Map)responseMap.get("booking")).get("lastname"));

        assertEquals(((Map)expectedData.get("booking")).get("totalprice"),
                ((Map)responseMap.get("booking")).get("totalprice"));

        assertEquals(((Map)expectedData.get("booking")).get("depositpaid"),
                ((Map)responseMap.get("booking")).get("depositpaid"));

        assertEquals(((Map)expectedData.get("booking")).get("additionalneeds"),
                ((Map)responseMap.get("booking")).get("additionalneeds"));

        assertEquals(((Map)((Map) expectedData.get("booking")).get("bookingdates")).get("checkin"),((Map)((Map) responseMap.get("booking")).get("bookingdates")).get("checkin"));
        assertEquals(((Map)((Map) expectedData.get("booking")).get("bookingdates")).get("checkout"),((Map)((Map) responseMap.get("booking")).get("bookingdates")).get("checkout"));






    }
}
