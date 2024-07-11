import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class C11_Post_JsonPathlleBodyTesti {


    @Test
    public void test(){

 /*
        https://restful-booker.herokuapp.com/booking url’ine
        asagidaki body'ye sahip bir POST request gonderdigimizde
            {
            "firstname" : "Ahmet",
            "lastname" : “Bulut",
            "totalprice" : 500,
            "depositpaid" : false,
            "bookingdates" : {
                "checkin" : "2023-01-10",
                "checkout" : "2023-01-20"},
            "additionalneeds" : "wi-fi"
            }

         donen Response’un,
            status code’unun 200,
            ve content type’inin application-json,
            ve response body’sindeki
                "firstname“in,"Ahmet",
                ve "lastname“in, "Bulut",
                ve "totalprice“in,500,
                ve "depositpaid“in,false,
                ve "checkin" tarihinin 2023-01-10
                ve "checkout" tarihinin 2023-01-20
                ve "additionalneeds“in,"wi-fi"
             oldugunu test edin

         */

        //1-end point ve request body

        String url ="https://restful-booker.herokuapp.com/booking";

        JSONObject requestBody=new JSONObject();

        JSONObject dateBookingdates=new JSONObject();
        dateBookingdates.put("checkin" , "2023-01-10");
        dateBookingdates.put("checkout" , "2023-01-20");

        requestBody.put("firstname" , "Damra");
        requestBody.put("lastname" , "Genc");
        requestBody.put("totalprice" , 500);
        requestBody.put("depositpaid" , false);
        requestBody.put( "additionalneeds" , "wi-fi");
        requestBody.put("bookingdates",dateBookingdates);

        // 2- expected data olustur
        // 3- request gonder, donen response'i kaydet

        Response response=given().contentType(ContentType.JSON).when().body(requestBody.toString()).post(url);

        response.then().assertThat().statusCode(200)
                .contentType(ContentType.JSON)
                .body("booking.firstname", equalTo("Damra"))
                .body("booking.lastname",equalTo("Genc"))
                .body("booking.totalprice",equalTo(500))
                .body("booking.depositpaid",equalTo(false))
                .body("booking.bookingdates.checkin",equalTo("2023-01-10"))
                .body("booking.bookingdates.checkout",equalTo("2023-01-20"))
                .body("booking.additionalneeds",equalTo("wi-fi"));


          response.prettyPrint();












    }
}
