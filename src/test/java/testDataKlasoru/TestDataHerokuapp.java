package testDataKlasoru;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestDataHerokuapp {

     /*


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
         */

    public static JSONObject jsonRequestBodyOlustur(){

       JSONObject requestBody=new JSONObject();
       JSONObject bookingdatesBody=new JSONObject();


        bookingdatesBody.put("checkin","2021-06-01");
        bookingdatesBody.put("checkout","2021-06-10");

       requestBody.put("firstname","DAMRA");
       requestBody.put("lastname","GENC ");
       requestBody.put("totalprice",500);
       requestBody.put("depositpaid",false);
       requestBody.put("bookingdates",bookingdatesBody);
       requestBody.put("additionalneeds","wi-fi");



        return requestBody;
    }
    /*
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
        },
        "additionalneeds":"wi-fi"
    }
    }
         */
    public static JSONObject jsonResponseBodyOlustur(){

        JSONObject responseBody=new JSONObject();
        JSONObject bookingBody=jsonRequestBodyOlustur();

        responseBody.put("bookingid",24);
        responseBody.put("booking",bookingBody);

        return  responseBody;
    }

    public static Map<String,Object> requestBodyOlusturma(){

        Map<String,Object> requestBody=new HashMap<>();
        Map<String,Object> bookingDates=new HashMap<>();
        /*
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
        */
        bookingDates.put("checkin","2021-06-01");
        bookingDates.put("checkout","2021-06-10");

        requestBody.put("firstname","Damra");
        requestBody.put("lastname","Genc");
        requestBody.put("totalprice",500.0);
        requestBody.put("depositpaid",false);
        requestBody.put("bookingdates",bookingDates);
        requestBody.put("additionalneeds","wi-fi");

        return  requestBody;


    }
    public static Map<String,Object> responceMap(){

        Map<String,Object> responceMap=new HashMap<>();

        responceMap.put("bookingid",24);
        responceMap.put("booking",requestBodyOlusturma());


        return responceMap;

    }
}
