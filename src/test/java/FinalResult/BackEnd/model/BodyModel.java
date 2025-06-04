package FinalResult.BackEnd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class BodyModel {
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private int totalprice;
    private Boolean depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;

    public BodyModel(String firstname, String lastname, int totalprice, Boolean depositpaid, BookingDates bookingdates, String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalneeds;
    }
    public BodyModel( String lastname, int totalprice, Boolean depositpaid, BookingDates bookingdates, String additionalneeds) {
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalneeds;
    }

    public BodyModel(String username, String password) {
        this.username = username;
        this.password = password;
    }
    @Data
    @AllArgsConstructor
    public static class BookingDates {
        String checkin;
        String checkout;

    }

}
