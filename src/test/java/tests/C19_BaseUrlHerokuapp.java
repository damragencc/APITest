package tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C19_BaseUrlHerokuapp extends BaseUrlHerokuapp {

    //1-  https://restful-booker.herokuapp.com/booking endpointine
    //    bir GET request gonderdigimizde
    //    donen response’un
    //          status code’unun 200 oldugunu
    //          ve Response’ta 12 booking oldugunu test edin


    @Test
    public void test(){


        //1-end point gonder

        specHerokuapp.pathParam("pp1","booking");

        //2-expected data olustur

        //3- request gonder donen responsı kaydet

        Response response=given().when().spec(specHerokuapp).get("/{pp1}");

        //4- Assertion


        JsonPath responseJsonPath=response.jsonPath();
        System.out.println(responseJsonPath.getList("bookingid").size());

       // response.then().assertThat().statusCode(200).body("bookingid", Matchers.hasSize(827));

        response.prettyPrint();


    }
}
