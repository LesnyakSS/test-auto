package FinalResult.BackEnd.model;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetResponseModel {
    private String firstname;
    private String lastname;
    private int totalprice;
    private Boolean depositpaid;
    private String additionalneeds;
    private BookingDates bookingdates;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class BookingDates {
        private String checkin;
        private String checkout;
    }

}
