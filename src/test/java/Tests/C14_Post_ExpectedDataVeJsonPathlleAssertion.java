package Tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C14_Post_ExpectedDataVeJsonPathlleAssertion {

    @Test
    public void test(){

         /*
        https://restful-booker.herokuapp.com/booking url’ine
        asagidaki body'ye sahip bir POST request gonderdigimizde
        donen response’un id haric asagidaki gibi oldugunu test edin.

        Request body
        {
        "firstname" : "Hasan",
        "lastname" : "Yagmur",
        "totalprice" : 500,
        "depositpaid" : false,
        "bookingdates" : {
            "checkin" : "2021-06-01",
            "checkout" : "2021-06-10"
            },
        "additionalneeds" : "wi-fi"
        }

        Expected Response Body
        {
        "bookingid":24,
        "booking":{
            "firstname":"Hasan",
            "lastname":"Yagmur",
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

        //1-endPoint request body olustur

        String url="https://restful-booker.herokuapp.com/booking";
        JSONObject obj1=new JSONObject();
        JSONObject rezervasyon=new JSONObject();
        rezervasyon.put("checkin","2021-06-01");
        rezervasyon.put("checkout","2021-06-10");
        obj1.put("firstname","Damra");
        obj1.put("lastname" , "Genc");
        obj1.put("totalprice",500);
        obj1.put("depositpaid",false);
        obj1.put("bookingdates",rezervasyon);
        obj1.put("additionalneeds","wi-fi");

        System.out.println(obj1);





        //2-expected Data olustur

        JSONObject expectedData=new JSONObject();
        expectedData.put("bookingid",24);
        expectedData.put("booking",obj1);

        Response response=given().contentType(ContentType.JSON).when().body(obj1.toString()).post(url);

          response.prettyPrint();

        JsonPath responseJsonPath=response.jsonPath();
        // ilk yazilan expected ====> olusturdugumuz JSonObject : expectedData
        // ikinci yazilan actual ===> response : responseJsonPath

        assertEquals(expectedData.getJSONObject("booking").get("firstname"),responseJsonPath.get("booking.firstname"));
        assertEquals(expectedData.getJSONObject("booking").get("lastname"),responseJsonPath.get("booking.lastname"));
        assertEquals(expectedData.getJSONObject("booking").get("totalprice"),responseJsonPath.get("booking.totalprice"));
        assertEquals(expectedData.getJSONObject("booking").get("depositpaid"),responseJsonPath.get("booking.depositpaid"));
        assertEquals(expectedData.getJSONObject("booking").get("additionalneeds"),responseJsonPath.get("booking.additionalneeds"));
        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),responseJsonPath.get("booking.bookingdates.checkin"));
        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),responseJsonPath.get("booking.bookingdates.checkout"));




    }
}
