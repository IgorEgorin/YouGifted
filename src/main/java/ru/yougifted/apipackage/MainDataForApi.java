package ru.yougifted.apipackage;

import io.restassured.RestAssured;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MainDataForApi {

    protected String mainUrl111 = "http://yg111.testing.place";
    protected String urlToken = "?token=";

    protected String urlApiV1SignIn = "/api/v1/sign-in";

    protected String urlApiV1UserMealRecipesAvailable = "/api/v1/user/meal/recipes/available";
    protected String urlRecipeTypeBreakfast = "?recipe_type=breakfast";
    protected String urlApiV1UserMealRecipe10 = "/api/v1/user/meal/recipe/10";

    protected String urlApiV1UserBodyDataAll = "/api/v1/user/body_data/all";
    protected String urlApiV1UserBodyData = "/api/v1/user/body_data/";
    protected String todaysDataWithYyyyMmDdFormat = new SimpleDateFormat("yyyy-MM-dd").format(new Date());


    protected String urlApiV1UserPhotoProgress = "/api/v1/user/photo/progress";
    protected String urlEdit = "/edit";
    protected String urlUploadPhoto = "/upload_photo";
    protected String urlPhotoFront = "/photo_front";

    protected String urlPrev = "/prev/";
    protected String urlNext = "/next/";


    protected String varKeyLogIn = "email";
    protected String varClietPassword = "0000";

    protected String varKeyPassword = "password";
    protected String varClietLogIn = "tnhakdya@10mail.org";

    protected String varClietLogInAndreyka = "andreyka.ru@gmail.com";
    protected String varKeyPasswordAndreyka = "qqqqqq";


    protected String varRootForLogIn = "user";


    protected String getToken() {
        return RestAssured.given()
                .param(varKeyLogIn, varClietLogIn)
                .param(varKeyPassword, varClietPassword)
                .when()
                .post(mainUrl111 + urlApiV1SignIn)
                .then()
                .extract().path("token");

    }


    protected String getTokenAndreykaUser() {
        return RestAssured.given()
                .param(varKeyLogIn, varClietLogInAndreyka)
                .param(varKeyPassword, varKeyPasswordAndreyka)
                .when()
                .post(mainUrl111 + urlApiV1SignIn)
                .then()
                .extract().path("token");

    }



}
