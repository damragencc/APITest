import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C10_JsonPathKullanimi {

    @Test
    public void method1(){

        JSONObject kisiBilgileriJsonObj=new JSONObject();

        JSONObject adresJsonobj=new JSONObject();

        JSONArray telefonBilgileriArr=new JSONArray();

        JSONObject cepTelJsonobj=new JSONObject();

        JSONObject evTelJsonobj=new JSONObject();


        adresJsonobj.put("streetAddress","naist street");
        adresJsonobj.put("city","Nara");
        adresJsonobj.put("postalCode","630-0192");

        cepTelJsonobj.put("type","iphone");
        cepTelJsonobj.put("number","0123-4567-8888");

        evTelJsonobj.put("type","home");
        evTelJsonobj.put("number","0123-4567-8910");

        telefonBilgileriArr.put(cepTelJsonobj);
        telefonBilgileriArr.put(evTelJsonobj);

        kisiBilgileriJsonObj.put("firstname","John");
        kisiBilgileriJsonObj.put("lastname","doe");
        kisiBilgileriJsonObj.put("age",26);
        kisiBilgileriJsonObj.put("address",adresJsonobj);

        kisiBilgileriJsonObj.put("phoneNumbers",telefonBilgileriArr);

        System.out.println(kisiBilgileriJsonObj);

        System.out.println(kisiBilgileriJsonObj.get("firstname"));

        System.out.println(kisiBilgileriJsonObj.getJSONObject("address"));


        System.out.println(kisiBilgileriJsonObj.getJSONArray("phoneNumbers").getJSONObject(0));









    }
}
