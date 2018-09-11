package ru.yougifted.apitest;

import org.junit.Ignore;
import org.junit.Test;
import ru.yougifted.apipackage.MainDataForApi;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsCollectionContaining.hasItem;

public class PersonDataAndMealApi extends MainDataForApi {


    @Test
    public void getRecipeByidNumberTen() {
        given().auth().preemptive().oauth2(getTokenAndreykaUser())
                .get(mainUrl111 + urlApiV1UserMealRecipe10)
                .then()
                .statusCode(200)
                .root("data")
                .body("id", is("10"))
                .body("name", is("Говядина с овощами"));

    }


    @Test
    public void getCertainAvailableRecipeBreakfast() {

        given().auth().preemptive().oauth2(getToken())
                .get(mainUrl111 + urlApiV1UserMealRecipesAvailable + urlRecipeTypeBreakfast)
                .then()
                .statusCode(200)
                .body("data.cook_time", hasItems("10 минут"));
    }


    @Test
    public void getAllDataDimensionsUser() {

        given()
                .get(mainUrl111 + urlApiV1UserBodyDataAll + urlToken + getToken())
                .then()
                .body("data.weight", hasItem(notNullValue()));


    }


    @Test
    public void getCertainUserDimensionsDayMonthYearYyyyMmDd() {
        given()
                .get(mainUrl111 + urlApiV1UserBodyData + "2018-09-10" + urlToken + getToken())
                .then()
                .body("data.weight", is(notNullValue()));


    }


    // 10.09.2018  POST api/v1/user/body_data needs to complete from developer's side
    @Ignore
    @Test
    public void postNewUserDimensionsWeight() {
        given()
                .formParam("data.weight", "55.00")
                .when()
                .post(mainUrl111 + urlApiV1UserBodyData + urlToken + getToken())
                .then()
                .statusCode(400);

    }


    @Test
    public void getUserPhotoProgress() {

        given().auth().preemptive().oauth2(getToken())
                .get(mainUrl111 + urlApiV1UserPhotoProgress)
                .then()
                .root("last_photo.fronts")
                .body("user_id", is("37507"))
                .body("fronts.file_name", is(notNullValue()));

    }


    @Test
    public void getUserPhotoProgressEdit() {

        given().auth().preemptive().oauth2(getToken())
                .get(mainUrl111 + urlApiV1UserPhotoProgress + urlEdit)
                .then()
                .root("latestData")
                .body("date", is(notNullValue()));

    }


    @Test
    public void postUserPhotoViewFront() {


        given().multiPart("file", new File("C:\\Program F2\\IntelliJ IDEA Community Edition 2016.2.1\\YouGifted\\src\\main\\resources\\PhotoForProgressUserTest.jpg"))
                .post(mainUrl111 + urlApiV1UserBodyData + todaysDataWithYyyyMmDdFormat
                        + urlUploadPhoto + urlPhotoFront + urlToken + getToken())
                .then()
                .statusCode(200)
                .body("data", is("Data has been upload successfully."));


    }


    @Test
    public void getPreviousUserPhotoProgressAndViewIsFront() {


        given().multiPart("file", new File("C:\\Program F2\\IntelliJ IDEA Community Edition 2016.2.1\\YouGiftedApi\\src\\main\\resources\\Sankt-Peterburg-v-sentyabre.jpg"))
                .post(mainUrl111 + urlApiV1UserBodyData + todaysDataWithYyyyMmDdFormat
                        + urlUploadPhoto + urlPhotoFront + urlToken + getToken())
                .then()
                .statusCode(200)
                .body("data", is("Data has been upload successfully."));


    }


    @Test
    public void getPrevUserProgressPhoto() {
        given()
                .get(mainUrl111 + urlApiV1UserPhotoProgress + urlPrev + "2018-10-09"
                        + urlPhotoFront + urlToken + getToken())
                .then()
                .body("photo_front.created_at[0]", equalTo("2018-09-10 14:59:03"));

    }

    @Test
    public void getNextUserProgressPhoto() {
        given()
                .get(mainUrl111 + urlApiV1UserPhotoProgress + urlNext + "2018-09-09"
                        + urlPhotoFront + urlToken + getToken())
                .then()
                .body("photo_front.created_at", hasItem("2018-09-10 14:59:03"));


    }
}
