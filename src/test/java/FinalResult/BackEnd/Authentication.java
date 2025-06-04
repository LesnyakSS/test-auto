package FinalResult.BackEnd;

import FinalResult.BackEnd.model.AuthResponse;
import FinalResult.BackEnd.model.BodyModel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;


public class Authentication {
    private static String authToken;
    public static String getToken() {
        AuthResponse response = RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .contentType(ContentType.JSON)
                .body(new BodyModel("admin","password123"))
                .when()
                .post("/auth")
                .then()
                .statusCode(200)
                .extract().body().as(AuthResponse.class);

        authToken = response.getToken();
        return authToken;

    }


}