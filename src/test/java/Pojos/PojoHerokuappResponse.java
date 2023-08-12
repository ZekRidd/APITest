package Pojos;

public class PojoHerokuappResponse {

    /*
        Response Body // expected data
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
                        ,
                        "additionalneeds":"wi-fi"
                    }
     */

    private int bookingid;
    private PojoHerokuappRequestBody booking;

    public int getBookingid() {
        return bookingid;
    }

    public PojoHerokuappResponse(int bookingid, PojoHerokuappRequestBody booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public PojoHerokuappRequestBody getBooking() {
        return booking;
    }

    public void setBooking(PojoHerokuappRequestBody booking) {
        this.booking = booking;
    }

    public PojoHerokuappResponse() {
    }

    @Override
    public String toString() {
        return "PojoHerokuappResponse{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}
