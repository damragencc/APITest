package tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.Pojo.PojoHerokuappRequestBody;
import pojos.Pojo.PojoHerokuappResponseBody;
import pojos.Pojo.PojoHerokuappbookingdates;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C32_Post_Pojo extends BaseUrlHerokuapp {

     /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un asagidaki gibi oldugunu test edin.
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

    @Test
    public void test01(){

        //1-Request url ve body olustur

        specHerokuapp.pathParam("pp1","booking");

        PojoHerokuappbookingdates bookingdatesPojo=
                new PojoHerokuappbookingdates("2021-06-01","2021-06-10");

        PojoHerokuappRequestBody requestBodyPojo=
                new PojoHerokuappRequestBody("Ahmet","Bulut",500,false,bookingdatesPojo,"wi-fi");


        //2-expected data olustur

        bookingdatesPojo=new PojoHerokuappbookingdates("2021-06-01","2021-06-10");

        PojoHerokuappRequestBody bookingPojo=new PojoHerokuappRequestBody("Ahmet","Bulut",500,false,bookingdatesPojo,"wi-fi");

        PojoHerokuappResponseBody expectedResponseBodyPojo=new PojoHerokuappResponseBody(24,bookingPojo);

        /*


        PojoHerokuappResponseBody{
        bookingid=24,
        booking=PojoHerokuappRequestBody{
                        firstname='Ahmet',
                        lastaname='Bulut',
                        totalrpice=500,
                        depositpaid=false
                 bookingdates=PojoHerokuappbookingdates{
                     checkin='2021-06-01',
                      checkout='2021-06-10'},
            additionalneeds='wi-fi'}}

         */




        //3-Response olustur, request gonderip sonucu response'a ata

        Response response =given().spec(specHerokuapp).contentType(ContentType.JSON).when().body(requestBodyPojo).post("{pp1}");

      PojoHerokuappResponseBody responsePojo= response.as(PojoHerokuappResponseBody.class);



        //4-Assertion
        // expectedResponseBodyPojo <=========> responsePojo

       assertEquals(expectedResponseBodyPojo.getBooking().getFirstname(),responsePojo.getBooking().getFirstname());
        assertEquals(expectedResponseBodyPojo.getBooking().getLastaname(),responsePojo.getBooking().getLastaname());
        assertEquals(expectedResponseBodyPojo.getBooking().getTotalrpice(),responsePojo.getBooking().getTotalrpice());
        assertEquals(expectedResponseBodyPojo.getBooking().getAdditionalneeds(),responsePojo.getBooking().getAdditionalneeds());
        assertEquals(expectedResponseBodyPojo.getBooking().isDepositpaid(),responsePojo.getBooking().isDepositpaid());


        assertEquals(expectedResponseBodyPojo.getBooking().getBookingdates().getCheckin(),responsePojo.getBooking().getBookingdates().getCheckin());
        assertEquals(expectedResponseBodyPojo.getBooking().getBookingdates().getCheckout(),responsePojo.getBooking().getBookingdates().getCheckout());








    }
}
