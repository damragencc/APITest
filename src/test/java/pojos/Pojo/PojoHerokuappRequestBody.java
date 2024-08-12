package pojos.Pojo;

public class PojoHerokuappRequestBody {

    // 1- tum variable'lari private olarak olustur



private String   firstname;
private String    lastaname;
private int totalrpice;
private boolean depositpaid;
private PojoHerokuappbookingdates bookingdates;
private String additionalneeds;


    //2- tum variabe'lar icin getter ve setter metodlari olusturalim

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastaname() {
        return lastaname;
    }

    public void setLastaname(String lastaname) {
        this.lastaname = lastaname;
    }

    public int getTotalrpice() {
        return totalrpice;
    }

    public void setTotalrpice(int totalrpice) {
        this.totalrpice = totalrpice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public PojoHerokuappbookingdates getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(PojoHerokuappbookingdates bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }


    // 3- tum parametreleri kullanarak bir constructor olusturalim

    public PojoHerokuappRequestBody(String firstname, String lastaname,
                                    int totalrpice,
                                    boolean depositpaid, PojoHerokuappbookingdates bookingdates,
                                    String additionalneeds) {
        this.firstname = firstname;
        this.lastaname = lastaname;
        this.totalrpice = totalrpice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalneeds;
    }


    //4- default constructor yerine manuel olarak parametresiz bir constructor olusturalim

    public PojoHerokuappRequestBody() {
    }


    // 5- toString methodu olusturalim


    @Override
    public String toString() {
        return "PojoHerokuappRequestBody{" +
                "firstname='" + firstname + '\'' +
                ", lastaname='" + lastaname + '\'' +
                ", totalrpice=" + totalrpice +
                ", depositpaid=" + depositpaid +
                ", bookingdates=" + bookingdates +
                ", additionalneeds='" + additionalneeds + '\'' +
                '}';
    }
}
