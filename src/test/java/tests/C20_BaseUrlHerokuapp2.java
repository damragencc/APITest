package tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C20_BaseUrlHerokuapp2 extends BaseUrlHerokuapp {

    /*
        2- https://restful-booker.herokuapp.com/booking endpointine
        asagidaki body’ye sahip bir POST request gonderdigimizde
        donen response’un
            status code’unun 200 oldugunu
            ve “firstname” degerinin “Ahmet” oldugunu test edin

            {
            "firstname" : "Ahmet",
            "lastname" : “Bulut",
            "totalprice" : 500,
            "depositpaid" : false,
            "bookingdates" : {
                   "checkin" : "2021-06-01",
                   "checkout" : "2021-06-10"
                      },
            "additionalneeds" : "wi-fi" }
         */

    @Test
    public void test(){

        //1_end point

        specHerokuapp.pathParam("pp1","booking");


        //2 expected data olustur

        JSONObject requestBody= new JSONObject();
        JSONObject expectedData=new JSONObject();

        expectedData.put("checkin","2021-06-01");
        expectedData.put("checkout","2021-06-10");

        requestBody.put("firstname","Damra");
        requestBody.put("lastname","GENC");
        requestBody.put("totalprice","500");
        requestBody.put("depositpaid",false);
        requestBody.put("bookingdates",expectedData);
        requestBody.put("additionalneeds","wi-fi");

        //3-request gonder gonden responsi kaydet

        Response response=given().contentType(ContentType.JSON).when().spec(specHerokuapp).body(requestBody.toString()).post("/{pp1}");

        //4-Assertion

        JsonPath jsonPath=response.jsonPath();

         response.then().assertThat().statusCode(200).body("booking.firstname", Matchers.equalTo("Damra"));

    }



}
