package ru.yougifted.apitest;

import org.junit.Ignore;
import org.junit.Test;
import ru.yougifted.apipackage.MainDataForApi;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.IsCollectionContaining.hasItem;

public class PersonDataApi extends MainDataForApi {




    @Test
    public void getAllDataDimensionsUser() {

        given()
                .get(mainUrl111 + urlApiV1UserBodyDataAll + urlToken + getTokenURL111())
                .then()
                .body("data.weight", hasItem(notNullValue()));


    }


    @Test
    public void getCertainUserDimensionsDayMonthYearYyyyMmDd() {
        given()
                .get(mainUrl111 + urlApiV1UserBodyData + "2018-09-10" + urlToken + getTokenURL111())
                .then()
                .body("data.weight", is(notNullValue()));


    }


    // 02.10.2018  POST api/v1/user/body_data needs to complete from developer's side
    @Ignore
    @Test
    public void postNewUserDimensionsWeight() {
        given()
                .formParam("data.weight", "55.00")
                .when()
                .post(mainUrl111 + urlApiV1UserBodyData + urlToken + getTokenURL111())
                .then()
                .statusCode(400);

    }



}
