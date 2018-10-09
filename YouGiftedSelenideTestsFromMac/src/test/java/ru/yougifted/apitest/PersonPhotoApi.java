package ru.yougifted.apitest;

import org.junit.Test;
import ru.yougifted.apipackage.MainDataForApi;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.IsCollectionContaining.hasItem;

public class PersonPhotoApi extends MainDataForApi {


    @Test
    public void getUserPhotoProgress() {

        given().auth().preemptive().oauth2(getTokenURL111())
                .get(mainUrl111 + urlApiV1UserPhotoProgress)
                .then()
                .root("last_photo.fronts")
                .body("user_id", is("37507"))
                .body("fronts.file_name", is(notNullValue()));

    }


    @Test
    public void getUserPhotoProgressEdit() {

        given().auth().preemptive().oauth2(getTokenURL111())
                .get(mainUrl111 + urlApiV1UserPhotoProgress + urlEdit)
                .then()
                .root("latestData")
                .body("date", is(notNullValue()));

    }


    @Test
    public void postUserPhotoViewFront() {


        given().multiPart("file", new File("/Users/Tester/IdeaProjects/yougifted-selenide-tests/src/main/resources/PhotoForProgressUserTest.jpg"))
                .post(mainUrl111 + urlApiV1UserBodyData + todaysDataWithYyyyMmDdFormat
                        + urlUploadPhoto + urlPhotoFront + urlToken + getTokenURL111())
                .then()
                .statusCode(200)
                .body("data", is("Data has been upload successfully."));


    }


    @Test
    public void getPreviousUserPhotoProgressAndViewIsFront() {


        given().multiPart("file", new File("/Users/Tester/IdeaProjects/yougifted-selenide-tests/src/main/resources/PhotoForProgressUserTest.jpg"))
                .post(mainUrl111 + urlApiV1UserBodyData + todaysDataWithYyyyMmDdFormat
                        + urlUploadPhoto + urlPhotoFront + urlToken + getTokenURL111())
                .then()
                .statusCode(200)
                .body("data", is("Data has been upload successfully."));


    }


    @Test
    public void getPrevUserProgressPhoto() {
        given()
                .get(mainUrl111 + urlApiV1UserPhotoProgress + urlPrev + "2018-10-09"
                        + urlPhotoFront + urlToken + getTokenURL111())
                .then()
                .body("photo_front.created_at[0]", equalTo("2018-09-10 14:59:03"));

    }

    @Test
    public void getNextUserProgressPhoto() {
        given()
                .get(mainUrl111 + urlApiV1UserPhotoProgress + urlNext + "2018-09-09"
                        + urlPhotoFront + urlToken + getTokenURL111())
                .then()
                .body("photo_front.created_at", hasItem("2018-09-10 14:59:03"));


    }
}
