package ru.yougifted.apitest;

import org.junit.Ignore;
import org.junit.Test;
import ru.yougifted.apipackage.MainDataForApi;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class PersonTrainingApi extends MainDataForApi {


    private String varProgramNumber26 = "26";
    private String varTrainingPackNumber561 = "561";
    private String varTrainingPackNumber563 = "563";

    private String varTodaysDataFormatNewDataToString = todaysDataFormatNewDataToString;

    private String varYyyy = "2018";
    private String varMm = "9";

    private String varParentComment = "6478";


    @Test
    public void getUserTraining() {

        given().auth().preemptive().oauth2(getTokenURL640())
                .get(mainUrl640 + urlTraining + trainingPackNumber(varProgramNumber26))
                .then()
                .statusCode(200)
                .root("program")
                .body("id", is(varProgramNumber26))
                .body("name", is(notNullValue()));
    }


    @Test
    public void getGetCalendarYearMonthProgramId() {
        given().auth().preemptive().oauth2(getTokenURL640())
                .get(mainUrl640 + urlgetCalendar + getYyyyMmPackId(varYyyy, varMm, varProgramNumber26))
                .then()
                .statusCode(200)
                .root("month")
                .body("yearNumber", is(varYyyy))
                .body("monthNumber", is(varMm))
                .body("requestedProgramId", is(varProgramNumber26));


    }


    @Test
    public void postUserToggleLikeTrainingTrainingId() {
        given().auth().preemptive().oauth2(getTokenURL640())
                .post(mainUrl640 + urlTooglelike + varTrainingPackNumber563)
                .then()
                .statusCode(200)
                .body(containsString("success"));

    }


    @Test
    public void postUserToggleDislikeTrainingTrainingId() {
        given().auth().preemptive().oauth2(getTokenURL640())
                .post(mainUrl640 + urlToogleDislike + varTrainingPackNumber561)
                .then()
                .statusCode(200)
                .body(containsString("success"));

    }


    //14092018 Need to create new user via API and then push 'Complete' button on TrainingPackNumber563.
    //Creating user via API has not done yet.
    //It will fix later.
    @Ignore
    @Test
    public void postUserCompleteTrainingTrainingIdProgramId() {
        given().auth().preemptive().oauth2(getTokenURL640())
                .post(mainUrl640 + urlCompleteTraining + varTrainingPackNumber563 + "/" + varProgramNumber26)
                .then()
                .statusCode(200)
                .body(containsString("success"));
    }


    @Test
    public void postUserCommentTraining() {
        given().auth().preemptive().oauth2(getTokenURL640())
                .header("Content-Type","application/x-www-form-urlencoded; charset=utf-8")
                .formParam("content", "Этот коммент был написан: " + varTodaysDataFormatNewDataToString)
                .formParam("training_id", varTrainingPackNumber561)
                .formParam("pack_id", varProgramNumber26)
                .formParam("parent", varParentComment)
                .post(mainUrl640 + urlUserCommentTraining)
                .then();
        }



    @Test
    public void getUserTrainingTrainingIdComments() {
        postUserCommentTraining();
        given().auth().preemptive().oauth2(getTokenURL640())
                .get(mainUrl640 + urlTraining + varTrainingPackNumber561 + urlComments)
                .then()
                .statusCode(200)
                .body("fullname", hasItem(varClietURL640Name + " " + varClietURL640Surname))
                .body("content", hasItem(containsString(varTodaysDataFormatNewDataToString)));


    }


    @Test
    public void getUserProfileUserId() {
        given().auth().preemptive().oauth2(getTokenURL640())
                .get(mainUrl640 + urlProfile + varClietURL640id)
                .then()
                .statusCode(200)
                .body("userName", is(varClietURL640Name))
                .body("userSurname", is(varClietURL640Surname));


    }


}
