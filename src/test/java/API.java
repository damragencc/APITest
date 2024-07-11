import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class API {


    @Test
    public void test(){

        // https : //restful-booker.herokuapp.com/booking/10 url'ine
        //bir Get request gonderdigimizde donen Response'u yazdirin


        //1 - Request body ve end-point hazirlama

        String url ="https://restful-booker.herokuapp.com/booking/11";

        //2 - Expected data hazirlama

        // 3- Request gonderip donen response'i kaydetme

        Response response =given().when().get(url);

        response.prettyPrint();

        // 4- Assertion


    }
}
