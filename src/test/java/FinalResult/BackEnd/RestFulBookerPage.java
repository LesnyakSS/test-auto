package FinalResult.BackEnd;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.path.json.exception.JsonPathException;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import static FinalResult.BackEnd.Authentication.getToken;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class RestFulBookerPage {
    private static final String authentication = getToken();
    private static Integer BOOKING_ID;
    private static Integer NOT_EXISTING_BOOKING_ID = 999999999;
    private final String BASE_URL = "https://restful-booker.herokuapp.com";

    @Test
    @Description("Создать данные о бронировании")
    public void createBooking() {
        step("Отправить запрос на создания");
        Response response =
                given()
                        .baseUri(BASE_URL)
                        .header("Content-Type", "application/json")
                        .header("Accept", "application/json")
                        .body("{\n" +
                                "  \"firstname\": \"Jim\",\n" +
                                "  \"lastname\": \"Brown\",\n" +
                                "  \"totalprice\": 111,\n" +
                                "  \"depositpaid\": true,\n" +
                                "  \"bookingdates\": {\n" +
                                "     \"checkin\": \"2018-01-01\",\n" +
                                "    \"checkout\": \"2019-01-01\"\n" +
                                "  },\n" +
                                "  \"additionalneeds\": \"Breakfast\"\n" +
                                "}")
                        .when()
                        .post("/booking");

        step(String.format("\nПроверка данных о бронировании:\n" +
                        "ID бронирования: %s\n" +
                        "Статус код: %d",
                response.jsonPath().getString("bookingid"),
                response.statusCode()));

        response.then()
                .log().all()
                .statusCode(200)
                .body("bookingid", notNullValue())
                .body("booking.firstname", equalTo("Jim"))
                .body("booking.lastname", equalTo("Brown"))
                .body("booking.totalprice", equalTo(111))
                .body("booking.depositpaid", equalTo(true))
                .body("booking.bookingdates.checkin", equalTo("2018-01-01"))
                .body("booking.bookingdates.checkout", equalTo("2019-01-01"))
                .body("booking.additionalneeds", equalTo("Breakfast"));

        step("Сохраняем ID бронирования");
        BOOKING_ID = response.then()
                .extract()
                .path("bookingid");

    }

    @Test
    @Description("Отправить данные о бронировании , без поля firstname")
    public void createWithoutNameBooking() {
        step("Отправить запрос на создание");
        Response response = given()
                .baseUri(BASE_URL)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body("{\n" +
                        "  \"lastname\": \"Brown\",\n" +
                        "  \"totalprice\": 111,\n" +
                        "  \"depositpaid\": true,\n" +
                        "  \"bookingdates\": {\n" +
                        "     \"checkin\": \"2018-01-01\",\n" +
                        "    \"checkout\": \"2019-01-01\"\n" +
                        "  },\n" +
                        "  \"additionalneeds\": \"Breakfast\"\n" +
                        "}")
                .when()
                .post("/booking");

        step(String.format("\nПроверка данных о бронировании:\n" +
                "Статус код: %d", response.statusCode()));
        response.then()
                .log().all()
                .statusCode(500);
    }

    @Test
    @Description("Отправить данные о бронировании. Значение null у поля totalprice")
    public void createPriceNullBooking() {
        step("Отправить запрос на создание");
        Response response = given()
                .baseUri(BASE_URL)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body("{\n" +
                        "  \"firstname\": \"Jim\",\n" +
                        "  \"lastname\": \"Brown\",\n" +
                        "  \"totalprice\": null,\n" +
                        "  \"depositpaid\": true,\n" +
                        "  \"bookingdates\": {\n" +
                        "     \"checkin\": \"2018-01-01\",\n" +
                        "    \"checkout\": \"2019-01-01\"\n" +
                        "  },\n" +
                        "  \"additionalneeds\": \"Breakfast\"\n" +
                        "}")
                .when()
                .post("/booking");

        step(String.format("\nПроверка данных о бронировании:\n" +
                "Статус код: %d", response.statusCode()));
        response.then()
                .log().all()
                .statusCode(500);
    }

    @Test
    @Description("Отправить запрос о создании бронирование с пустыми данными")
    public void createEmptyBooking() {

        step("Отправить запрос на создание");
        Response response = given()
                .baseUri(BASE_URL)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .when()
                .post("/booking");

        step(String.format("\nПроверка данных о бронировании:\n" +
                "Статус код: %d", response.statusCode()));
        response.then()
                .log().all()
                .statusCode(500);


    }

    @Test
    @Description("Получить данные о бронировании")
    public void getBooking() {
        step(String.format("Отправить запрос на получение данных о бронировании по ID=%s: ", BOOKING_ID));
        Response response =
                given()
                        .baseUri(BASE_URL)
                        .header("Accept", "application/json")
                        .when()
                        .get("/booking/" + BOOKING_ID);

        step(String.format("\nПроверка данных о бронировании:\n" +
                        "ID бронирования: %s\n" +
                        "Статус код: %d",
                BOOKING_ID,
                response.statusCode()));

        response.then()
                .log().all()
                .statusCode(200)
                .body("firstname", equalTo("Jim"))
                .body("lastname", equalTo("Brown"))
                .body("totalprice", equalTo(111))
                .body("depositpaid", equalTo(true))
                .body("bookingdates.checkin", equalTo("2018-01-01"))
                .body("bookingdates.checkout", equalTo("2019-01-01"))
                .body("additionalneeds", equalTo("Breakfast"));
    }

    @Test
    @Description("Получить данные о бронировании, после обновление данных")
    public void getAfterUpdateBooking() {
        step(String.format("Отправить запрос на получение данных о бронировании по ID=%s: , после обновление данных", BOOKING_ID));
        Response response =
                given()
                        .baseUri(BASE_URL)
                        .header("Accept", "application/json")
                        .when()
                        .get("/booking/" + BOOKING_ID);

        step(String.format("\nПроверка данных о бронировании:\n" +
                        "ID бронирования: %s\n" +
                        "Статус код: %d",
                BOOKING_ID,
                response.statusCode()));

        response.then()
                .log().all()
                .statusCode(200)
                .body("firstname", equalTo("James"))
                .body("lastname", equalTo("Brown"))
                .body("totalprice", equalTo(111))
                .body("depositpaid", equalTo(true))
                .body("bookingdates.checkin", equalTo("2018-01-01"))
                .body("bookingdates.checkout", equalTo("2019-01-01"))
                .body("additionalneeds", equalTo("Breakfast"));
    }
    @Test
    @Description("Получить данные о бронировании, после удаление данных")
    public void getAfterDeleteBooking() {
        step(String.format("Отправить запрос на получение данных о бронировании по ID=%s: , после удаления данных", BOOKING_ID));
        Response response =
                given()
                        .baseUri(BASE_URL)
                        .header("Accept", "application/json")
                        .when()
                        .get("/booking/" + BOOKING_ID);

        step(String.format("\nПроверка данных о бронировании:\n" +
                        "ID бронирования: %s\n" +
                        "Статус код: %d",
                BOOKING_ID,
                response.statusCode()));

        response.then()
                .log().all()
                .statusCode(404);
    }
    @Test
    @Description("Получить данные о бронировании, с несуществующим id бронирования")
    public void getNotExistingBooking() {
        step(String.format("Отправить запрос на получение данных о бронировании по ID=%s: ", NOT_EXISTING_BOOKING_ID));
        Response response =
                given()
                        .baseUri(BASE_URL)
                        .header("Accept", "application/json")
                        .when()
                        .get("/booking/" + NOT_EXISTING_BOOKING_ID);

        step(String.format("\nПроверка данных о бронировании:\n" +
                        "ID бронирования: %s\n" +
                        "Статус код: %d",
                NOT_EXISTING_BOOKING_ID,
                response.statusCode()));

        response.then()
                .log().all()
                .statusCode(404);
    }

    @Test
    @Description("Обновление данных для существующей записи о бронировании")
    public void updateBooking() {
        step(String.format("Отправить запрос на изминение данных о бронировании для записи ID=%s: ", BOOKING_ID));
        Response response =
                given()
                        .baseUri(BASE_URL)
                        .header("Content-Type", "application/json")
                        .header("Accept", "application/json")
                        .header("Cookie", "token=" + authentication)
                        .body("{\n" +
                                "  \"firstname\": \"James\",\n" +
                                "  \"lastname\": \"Brown\",\n" +
                                "  \"totalprice\": 111,\n" +
                                "  \"depositpaid\": true,\n" +
                                "  \"bookingdates\": {\n" +
                                "    \"checkin\": \"2018-01-01\",\n" +
                                "    \"checkout\": \"2019-01-01\"\n" +
                                "  },\n" +
                                "  \"additionalneeds\": \"Breakfast\"\n" +
                                "}")
                        .when()
                        .put("/booking/" + BOOKING_ID);

        step(String.format("\nПроверка измененых данных о бронировании:\n" +
                        "ID бронирования: %s\n" +
                        "Статус код: %d",
                BOOKING_ID,
                response.statusCode()));

        response.then()
                .log().all()
                .statusCode(200)
                .body("firstname", equalTo("James"))
                .body("lastname", equalTo("Brown"))
                .body("totalprice", equalTo(111))
                .body("depositpaid", equalTo(true))
                .body("bookingdates.checkin", equalTo("2018-01-01"))
                .body("bookingdates.checkout", equalTo("2019-01-01"))
                .body("additionalneeds", equalTo("Breakfast"));
    }

    @Test
    @Description("Обновление данных для не существующей записи о бронировании")
    public void updateNoExistingBooking() {
        step(String.format("Отправить запрос на изминение данных о бронировании для записи ID=%s: ", NOT_EXISTING_BOOKING_ID));
        Response response =
                given()
                        .baseUri(BASE_URL)
                        .header("Content-Type", "application/json")
                        .header("Accept", "application/json")
                        .header("Cookie", "token=" + authentication)
                        .body("{\n" +
                                "  \"firstname\": \"Jim\",\n" +
                                "  \"lastname\": \"Brown\",\n" +
                                "  \"totalprice\": 111,\n" +
                                "  \"depositpaid\": true,\n" +
                                "  \"bookingdates\": {\n" +
                                "    \"checkin\": \"2018-01-01\",\n" +
                                "    \"checkout\": \"2019-01-01\"\n" +
                                "  },\n" +
                                "  \"additionalneeds\": \"Breakfast\"\n" +
                                "}")
                        .when()
                        .put("/booking/" + NOT_EXISTING_BOOKING_ID);

        step(String.format("\nПроверка измененых данных о бронировании:\n" +
                        "ID бронирования: %s\n" +
                        "Статус код: %d",
                NOT_EXISTING_BOOKING_ID,
                response.statusCode()));

        response.then()
                .log().all()
                .statusCode(405);
    }

    @Test
    @Description("Обновление данных для существующей записи о бронировании, без firstname")
    public void updateWithoutNameBooking() {
        step(String.format("Отправить запрос на изминение данных о бронировании для записи ID=%s: ", BOOKING_ID));
        Response response =
                given()
                        .baseUri(BASE_URL)
                        .header("Content-Type", "application/json")
                        .header("Accept", "application/json")
                        .header("Cookie", "token=" + authentication)
                        .body("{\n" +
                                "  \"lastname\": \"Brown\",\n" +
                                "  \"totalprice\": 111,\n" +
                                "  \"depositpaid\": true,\n" +
                                "  \"bookingdates\": {\n" +
                                "    \"checkin\": \"2018-01-01\",\n" +
                                "    \"checkout\": \"2019-01-01\"\n" +
                                "  },\n" +
                                "  \"additionalneeds\": \"Breakfast\"\n" +
                                "}")
                        .when()
                        .put("/booking/" + BOOKING_ID);

        step(String.format("\nПроверка измененых данных о бронировании:\n" +
                        "ID бронирования: %s\n" +
                        "Статус код: %d",
                BOOKING_ID,
                response.statusCode()));

        response.then()
                .log().all()
                .statusCode(400);
    }

    @Test
    @Description("Удалить данные данные о бронировании")
    public void deleteBooking() {
        step(String.format("Отправить запрос на удаление данных о бронировании для записи ID=%s: ", BOOKING_ID));
        Response response =
                given()
                        .baseUri(BASE_URL)
                        .header("Content-Type", "application/json")
                        .header("Cookie", "token=" + authentication)
                        .when()
                        .delete("/booking/" + BOOKING_ID);

        step(String.format("\nПроверка измененых данных о бронировании:\n" +
                        "ID бронирования: %s\n" +
                        "Статус код: %d",
                BOOKING_ID,
                response.statusCode()));

        response.then()
                .log().all()
                .statusCode(201);
    }

    @Test
    @Description("Удалить данные данные о бронировании с не существующим id")
    public void deleteNoExistingBooking() {
        step(String.format("Отправить запрос на удаление не существующих данных о  бронировании для записи ID=%s: ", NOT_EXISTING_BOOKING_ID));
        Response response =
                given()
                        .baseUri(BASE_URL)
                        .header("Content-Type", "application/json")
                        .header("Cookie", "token=" + authentication)
                        .when()
                        .delete("/booking/" + NOT_EXISTING_BOOKING_ID);

        step(String.format("\nПроверка измененых данных о бронировании:\n" +
                        "ID бронирования: %s\n" +
                        "Статус код: %d",
                NOT_EXISTING_BOOKING_ID,
                response.statusCode()));

        response.then()
                .log().all()
                .statusCode(405);
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

