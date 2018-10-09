package ru.yougifted.apipackage;

import io.restassured.RestAssured;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MainDataForApi {

    private String textApiV1 = "/api/v1";

    protected String mainUrl111 = "http://yg111.testing.place";
    protected String mainUrl640 = "http://yg640.testing.place";
    protected String urlToken = "?token=";

    protected String urlApiV1SignIn = textApiV1 + "/sign-in";

    protected String urlApiV1UserMealRecipesAvailable = textApiV1  + "/user/meal/recipes/available";
    protected String urlRecipeTypeBreakfast = "?recipe_type=breakfast";

    protected String urlApiV1UserMealRecipe10 = textApiV1 + "/user/meal/recipe/10";
    protected String urlApiV1UserBodyDataAll = textApiV1 + "/user/body_data/all";
    protected String urlApiV1UserBodyData = textApiV1 + "/user/body_data/";
    protected String todaysDataWithYyyyMmDdFormat = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    protected String todaysDataFormatNewDataToString = new Date().toString();


    protected String urlApiV1UserPhotoProgress = textApiV1 + "/user/photo/progress";
    protected String urlTraining = textApiV1 + "/user/training";

    protected String urlEdit = "/edit";
    protected String urlComments = "/comments";
    protected String urlUserCommentTraining = textApiV1 + "/user/comment/training";
    protected String urlUploadPhoto = "/upload_photo";
    protected String urlPhotoFront = "/photo_front";
    protected String urlgetCalendar = textApiV1 + "/get-calendar";
    protected String urlProfile = textApiV1 + "/user/profile/";

    protected String urlTooglelike = textApiV1 + "/user/toggle-like/training/";
    protected String urlToogleDislike = textApiV1 + "/user/toggle-dislike/training/";
    protected String urlCompleteTraining = textApiV1 + "/user/complete/training/";


    protected String urlPrev = "/prev/";
    protected String urlNext = "/next/";


    protected String varKeyLogIn = "email";
    protected String varClietPassword = "0000";

    protected String varKeyPassword = "password";
    protected String varClietLogIn = "tnhakdya@10mail.org";

    protected String varClietURL640LogIn = "kmhcdjgz@emlhub.com";
    protected String varClietURL640Password = "0000";
    protected String varClietURL640id = "37846";

    protected String varClietURL640Name = "Игорь";
    protected String varClietURL640Surname = "Егоров";


    protected String varClietLogInAndreyka = "andreyka.ru@gmail.com";
    protected String varKeyPasswordAndreyka = "qqqqqq";


    protected String varRootForLogIn = "user";


    protected String getTokenURL111() {
        return RestAssured.given()
                .param(varKeyLogIn, varClietLogIn)
                .param(varKeyPassword, varClietPassword)
                .when()
                .post(mainUrl111 + urlApiV1SignIn)
                .then()
                .extract().path("token");

    }


    protected String getTokenURL640() {
        return RestAssured.given()
                .param(varKeyLogIn, varClietURL640LogIn)
                .param(varKeyPassword, varClietURL640Password)
                .when()
                .post(mainUrl640 + urlApiV1SignIn)
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


    protected String trainingPackNumber (String s) {
        return "?pack=" + s;
    }

    protected String getYyyyMmPackId (String yyyy, String mm, String packId) {
        return "/" + yyyy + "/" + mm + "/" + packId;
    }

}
