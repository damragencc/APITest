package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.path.json.JsonPath.given;

public class C07_Get_ResponseBodyTest {

    @Test
    public void test(){

         /*
        https://jsonplaceholder.typicode.com/posts/44 url'ine bir GET request yolladigimizda
        donen Response’in
        	status code'unun 200,
        	ve content type'inin Aplication.JSON,
        	ve response body'sinde bulunan userId'nin 5,
        	ve response body'sinde bulunan title'in "optio dolor molestias sit"
        	oldugunu test edin.

         */

         //1- End point
        String url ="https://jsonplaceholder.typicode.com/posts/44";

        Response response = RestAssured.given().when().get(url);

        response.then().assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("userId", Matchers.equalTo(5))
                .body("title",Matchers.equalTo("optio dolor molestias sit"));

        response.prettyPrint();

    }
}
