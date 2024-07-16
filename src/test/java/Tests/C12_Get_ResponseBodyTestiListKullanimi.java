package Tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C12_Get_ResponseBodyTestiListKullanimi {

   @Test
    public void test(){


        /*
            http://dummy.restapiexample.com/api/v1/employees url'ine
            bir GET request yolladigimizda
                donen Response'in
                    status code'unun 200,
                    ve content type'inin Aplication.JSON,
                    ve response body'sindeki
                    employees sayisinin 24
                    ve employee'lerden birinin "Ashton Cox"
                    ve girilen yaslar icinde 61,21 ve 35 degerinin oldugunu test edin.
         */


       //1- end-point  ve request body olustur

       String url="http://dummy.restapiexample.com/api/v1/employees";

       //2-expected data olustur

       //3-Request gonder ve donen respounse kaydet

       Response response=given().when().get(url);

       response.prettyPrint();

        //4-Assertion

      response.then().assertThat()
              .statusCode(200)
              .body("data.id", hasSize(24))
              .body("data.employee_name",hasItem("Ashton Cox"))
              .body("data.employee_age",hasItems(61,21,35));

   }

}
