package FinalResult.BackEnd.model;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseModel {
    private String bookingid;
    private Booking booking;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
        public static class Booking {
        private String firstname;
        private String lastname;
        private int totalprice;
        private Boolean depositpaid;
        private BookingDates bookingdates;
        private String additionalneeds;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class BookingDates {
        private String checkin;
        private String checkout;
    }
}
