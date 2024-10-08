package tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C02_GetRequest_ResponseBilgileriniManuelTestEdilmesi {

    @Test
    public void test01(){


         /*
        https://restful-booker.herokuapp.com/booking/10 url’ine
        bir GET request gonderdigimizde donen Response’un,
           status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK
        ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz
         */

        // 1- gerekli body ve end point hazirla
        String url= "https://restful-booker.herokuapp.com/booking/10";

        // 2- expected body olustur
         //soruda donen response'ın body'sı su sekılde demiyorsa yapamaya gerek yok

        // 3- request gonder ve donen response'i kaydet

        Response response = given().when().get(url);

        response.prettyPrint();

        System.out.println("status code : " +response.getStatusCode());
        System.out.println("content type : " +response.getContentType());
        System.out.println("Server header degeri : " +response.getHeader("Server"));
        System.out.println("Status Line : " +response.getStatusLine());
        System.out.println("Response suresi : "+ response.getTime());


    }
}
