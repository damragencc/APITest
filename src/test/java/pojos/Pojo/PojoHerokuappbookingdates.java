package pojos.Pojo;

public class PojoHerokuappbookingdates {

    //1-Tum variableleri private olarak olustur

    private String checkin;
    private String checkout;



    //2-tum variable'lar icin getter ve setter  metodlari olusturalim

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }


    //3-tum parametreleri kullanarak bir constructor olusturalim

    public PojoHerokuappbookingdates(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }


    //4-default constructor yerine manuel olarak parametresiz bir constructor olusturalim

    public PojoHerokuappbookingdates() {
    }


    //5- toString metodu olusturalim


    @Override
    public String toString() {
        return "PojoHerokuappbookingdates{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
