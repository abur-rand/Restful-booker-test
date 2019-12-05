package config;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;

import static constants.Constants.RunVariables.*;
import static org.hamcrest.Matchers.equalTo;


public class TestConfig {

    protected ResponseSpecification responseSpecificationForGetJane = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectBody("firstname", equalTo("Jane"))
            .expectBody("lastname", equalTo("Brown"))
            .expectBody("totalprice", equalTo(150))
            .expectBody("depositpaid", equalTo(true))
            .expectBody("bookingdates.checkin", equalTo("2018-01-01"))
            .expectBody("bookingdates.checkout", equalTo("2019-01-01"))
            .expectBody("additionalneeds", equalTo("Breakfast and Pool access"))
            .build();

    protected ResponseSpecification responseSpecificationForPost = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectBody("booking.firstname", equalTo("Jim"))
            .expectBody("booking.lastname", equalTo("Brown"))
            .expectBody("booking.totalprice", equalTo(111))
            .expectBody("booking.depositpaid", equalTo(true))
            .expectBody("booking.bookingdates.checkin", equalTo("2018-01-01"))
            .expectBody("booking.bookingdates.checkout", equalTo("2019-01-01"))
            .expectBody("booking.additionalneeds", equalTo("Breakfast"))
            .build();

    protected ResponseSpecification responseSpecificationForGetToken = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();

    protected ResponseSpecification responseSpecificationForPut = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectBody("firstname", equalTo("Jane"))
            .expectBody("lastname", equalTo("Brown"))
            .expectBody("totalprice", equalTo(150))
            .expectBody("depositpaid", equalTo(true))
            .expectBody("bookingdates.checkin", equalTo("2018-01-01"))
            .expectBody("bookingdates.checkout", equalTo("2019-01-01"))
            .expectBody("additionalneeds", equalTo("Breakfast and Pool access"))
            .build();
    protected ResponseSpecification responseSpecificationForDelete = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .build();

    protected ResponseSpecification responseSpecificationForGetDeleted = new ResponseSpecBuilder()
            .expectStatusCode(404)
            .build();


    @BeforeClass
    public void setUP(){

        RestAssured.baseURI = server;
        RestAssured.basePath = path;

        RequestSpecification requestSpecificationJson = new RequestSpecBuilder()
                .addHeader("Content-Type", "application/json")
                .build();
        RestAssured.requestSpecification = requestSpecificationJson;
    }
}