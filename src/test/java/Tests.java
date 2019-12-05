import config.TestConfig;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static constants.Constants.Action.*;
import static constants.Constants.Path.RESTFUL_BOOKER_PATH;
import static constants.Constants.RunVariables.*;
import static constants.Constants.Server.RESTFUL_BOOKER_URL;
import static io.restassured.RestAssured.*;
import static java.sql.Types.NULL;

public class Tests extends TestConfig{

    @Test
    public void createBooking(){

        Response response = given().body(jsonBody).log().uri()
                .when().post(RESTFUL_BOOKER_PATH + RESTFUL_BOOKER_POST)
                .then().spec(responseSpecificationForPost).log().body().extract().response();
        int id = response.path("bookingid");
        assert id != NULL;
    }

    @Test
    public void updateBooking(){
        String cook = "token="+getToken();
        given().body(jsonBodyUpdate).log().uri().header("Cookie", cook)
                .when().put(RESTFUL_BOOKER_PATH+"7")
                .then().spec(responseSpecificationForPut).log().body();
    }

    @Test
    public void getBookingByID(){

        Response resp =
                given().log().uri().when().get(RESTFUL_BOOKER_PATH+RESTFUL_BOOKER_GET_JANE);
        int id = resp.path("bookingid[0]");
        given().log().uri()
                .when().get(RESTFUL_BOOKER_PATH+id)
                .then().spec(responseSpecificationForGetJane).log().body();
    }

    @Test
    public void deleteBooking(){
        int id = 1;
        String cook = "token="+getToken();
        given().log().uri().header("Cookie", cook)
                .when().delete(RESTFUL_BOOKER_PATH+id)
                .then().spec(responseSpecificationForDelete).log().body();
        given().log().uri()
                .when().get(RESTFUL_BOOKER_PATH+id)
                .then().spec(responseSpecificationForGetDeleted).log().body();
    }

    private String getToken(){
        Response response = given().body(creds).log().uri()
                .when().post(RESTFUL_BOOKER_URL + RESTFUL_BOOKER_TOKEN)
                .then().spec(responseSpecificationForGetToken).log().body().extract().response();
        String token = response.path("token");
        System.out.println("intests");
        return token;
    }
}