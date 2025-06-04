package FinalResult.BackEnd;

import FinalResult.BackEnd.model.BodyModel;
import FinalResult.BackEnd.model.GetResponseModel;
import FinalResult.BackEnd.model.ResponseModel;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static FinalResult.BackEnd.Authentication.getToken;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class RestFulBookerPage {
    private static final String authentication = getToken();
    private static Integer BOOKING_ID;
    private static Integer NOT_EXISTING_BOOKING_ID = 999999999;
    private final String BASE_URL = "https://restful-booker.herokuapp.com";

    @Test
    @Description("Создать данные о бронировании")
    public void createBooking() {
        ResponseModel response = RestAssured
                .given()
                        .baseUri(BASE_URL)
                        .header("Content-Type", "application/json")
                        .header("Accept", "application/json")
                        .body(new BodyModel("Jim",
                                "Brown",
                                111,
                                true,
                                new BodyModel.BookingDates("2018-01-01", "2019-01-01"),
                                "Breakfast"))
                        .when()
                        .post("/booking")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().body()
                .as(ResponseModel.class);

        ResponseModel.Booking booking = response.getBooking();
        assertThat(booking.getFirstname(), is("Jim"));
        assertThat(booking.getLastname(), is("Brown"));
        assertThat(booking.getTotalprice(), is(111));
        assertThat(booking.getDepositpaid(), is(true));
        assertThat(booking.getBookingdates().getCheckin(), is("2018-01-01"));
        assertThat(booking.getBookingdates().getCheckout(), is("2019-01-01"));
        assertThat(booking.getAdditionalneeds(), is("Breakfast"));

        BOOKING_ID = Integer.parseInt(response.getBookingid());

    }

    @Test
    @Description("Отправить данные о бронировании , без поля firstname")
    public void createWithoutNameBooking() {
        given()
                .baseUri(BASE_URL)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(new BodyModel(
                        "Brown",
                        111,
                        true,
                        new BodyModel.BookingDates("2018-01-01", "2019-01-01"),
                        "Breakfast"))
                .when()
                .post("/booking")
                .then()
                .log().all()
                .statusCode(500);
    }

    @Test
    @Description("Отправить данные о бронировании. Значение null у поля lastname")
    public void createPriceNullBooking() {
        given()
                .baseUri(BASE_URL)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(new BodyModel("Jim",
                        null,
                        111,
                        true,
                        new BodyModel.BookingDates("2018-01-01", "2019-01-01"),
                        "Breakfast"))
                .when()
                .post("/booking").
                then()
                .log().all()
                .statusCode(500);
    }

    @Test
    @Description("Отправить запрос о создании бронирование с пустыми данными")
    public void createEmptyBooking() {
        given()
                .baseUri(BASE_URL)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(new BodyModel())
                .when()
                .post("/booking").
                then()
                .log().all()
                .statusCode(500);


    }
    @Test
    @Description("Получить данные о бронировании")
    public void getBooking() {
        GetResponseModel response =
                given()
                        .baseUri(BASE_URL)
                        .header("Accept", "application/json")
                        .when()
                        .get("/booking/" + BOOKING_ID)
                        .then()
                        .statusCode(200)
                        .contentType(ContentType.JSON)
                        .extract().body()
                        .as(GetResponseModel.class);

        assertThat(response.getFirstname(), is("Jim"));
        assertThat(response.getLastname(), is("Brown"));
        assertThat(response.getTotalprice(), is(111));
        assertThat(response.getDepositpaid(), is(true));
        assertThat(response.getBookingdates().getCheckin(), is("2018-01-01"));
        assertThat(response.getBookingdates().getCheckout(), is("2019-01-01"));
        assertThat(response.getAdditionalneeds(), is("Breakfast"));
    }


    @Test
    @Description("Получить данные о бронировании, после обновление данных")
    public void getAfterUpdateBooking() {
        GetResponseModel response =
                given()
                        .baseUri(BASE_URL)
                        .header("Accept", "application/json")
                        .when()
                        .get("/booking/" + BOOKING_ID)
                        .then()
                        .statusCode(200)
                        .contentType(ContentType.JSON)
                        .extract().body()
                        .as(GetResponseModel.class);

        assertThat(response.getFirstname(), is("James"));
        assertThat(response.getLastname(), is("Brown"));
        assertThat(response.getTotalprice(), is(111));
        assertThat(response.getDepositpaid(), is(true));
        assertThat(response.getBookingdates().getCheckin(), is("2018-01-01"));
        assertThat(response.getBookingdates().getCheckout(), is("2019-01-01"));
        assertThat(response.getAdditionalneeds(), is("Breakfast"));
    }
    @Test
    @Description("Получить данные о бронировании, после удаление данных")
    public void getAfterDeleteBooking() {
        given()
                        .baseUri(BASE_URL)
                        .header("Accept", "application/json")
                        .when()
                        .get("/booking/" + BOOKING_ID)
                        .then()
                        .log().all()
                        .statusCode(404);
    }
    @Test
    @Description("Получить данные о бронировании, с несуществующим id бронирования")
    public void getNotExistingBooking() {

        given()
                        .baseUri(BASE_URL)
                        .header("Accept", "application/json")
                        .when()
                        .get("/booking/" + NOT_EXISTING_BOOKING_ID)
                        .then()
                        .log().all()
                        .statusCode(404);
    }

    @Test
    @Description("Обновление данных для существующей записи о бронировании")
    public void updateBooking() {
        GetResponseModel response =
                given()
                        .baseUri(BASE_URL)
                        .header("Content-Type", "application/json")
                        .header("Accept", "application/json")
                        .header("Cookie", "token=" + authentication)
                        .body(new BodyModel("James",
                                "Brown",
                                111,
                                true,
                                new BodyModel.BookingDates("2018-01-01", "2019-01-01"),
                                "Breakfast"))
                        .when()
                        .put("/booking/" + BOOKING_ID)
                        .then()
                        .statusCode(200)
                        .contentType(ContentType.JSON)
                        .extract().body()
                        .as(GetResponseModel.class);

        assertThat(response.getFirstname(), is("James"));
        assertThat(response.getLastname(), is("Brown"));
        assertThat(response.getTotalprice(), is(111));
        assertThat(response.getDepositpaid(), is(true));
        assertThat(response.getBookingdates().getCheckin(), is("2018-01-01"));
        assertThat(response.getBookingdates().getCheckout(), is("2019-01-01"));
        assertThat(response.getAdditionalneeds(), is("Breakfast"));
    }

    @Test
    @Description("Обновление данных для не существующей записи о бронировании")
    public void updateNoExistingBooking() {

        given()
                        .baseUri(BASE_URL)
                        .header("Content-Type", "application/json")
                        .header("Accept", "application/json")
                        .header("Cookie", "token=" + authentication)
                        .body(new BodyModel("James",
                                "Brown",
                                111,
                                true,
                                new BodyModel.BookingDates("2018-01-01", "2019-01-01"),
                                "Breakfast"))
                        .when()
                        .put("/booking/" + NOT_EXISTING_BOOKING_ID)
                        .then()
                        .log().all()
                        .statusCode(405);
    }

    @Test
    @Description("Обновление данных для существующей записи о бронировании, без firstname")
    public void updateWithoutNameBooking() {

        given()
                        .baseUri(BASE_URL)
                        .header("Content-Type", "application/json")
                        .header("Accept", "application/json")
                        .header("Cookie", "token=" + authentication)
                        .body(new BodyModel(
                                "Brown",
                                111,
                                true,
                                new BodyModel.BookingDates("2018-01-01", "2019-01-01"),
                                "Breakfast"))
                        .when()
                        .put("/booking/" + BOOKING_ID)
                        .then()
                        .log().all()
                        .statusCode(400);
    }

    @Test
    @Description("Удалить данные данные о бронировании")
    public void deleteBooking() {

        given()
                        .baseUri(BASE_URL)
                        .header("Content-Type", "application/json")
                        .header("Cookie", "token=" + authentication)
                        .when()
                        .delete("/booking/" + BOOKING_ID)
                        .then()
                        .log().all()
                        .statusCode(201);
    }

    @Test
    @Description("Удалить данные данные о бронировании с не существующим id")
    public void deleteNoExistingBooking() {

        given()
                        .baseUri(BASE_URL)
                        .header("Content-Type", "application/json")
                        .header("Cookie", "token=" + authentication)
                        .when()
                        .delete("/booking/" + NOT_EXISTING_BOOKING_ID)
                        .then()
                        .log().all()
                        .statusCode(405);
    }
    @Test
    @Description("Корректное получение, создание, обновление, удаленния данных о бронировании")
    public void t0_crudTest() {
        createBooking();
        getBooking();
        updateBooking();
    }

    @Test
    @Description("Корректное получение, создание, обновление, удаленния данных о бронировании")
    public void t1_crudTest() {
        createBooking();
        getBooking();
        updateBooking();
        getAfterUpdateBooking();
        deleteBooking();
        getAfterDeleteBooking();
    }


    @Test
    @Description("Создание записи , получение данных, обновление данных о бронировании без firstname")
    public void t2_crudTest() {
        createBooking();
        getBooking();
        updateWithoutNameBooking();
    }

    @Test
    @Description("Создание записи , получение данных, обновление данных у не существующей записи о бронировании")
    public void t3_crudTest() {
        createBooking();
        getBooking();
        updateNoExistingBooking();
    }

    @Test
    @Description("Корректное получение, создание, обновление и удаленния данных о не существующем id бронированием")
    public void t4_crudTest() {
        createBooking();
        getBooking();
        updateBooking();
        deleteNoExistingBooking();
        getAfterUpdateBooking();
    }
}

