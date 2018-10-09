package ru.yougifted.apitest;

import org.junit.Test;
import ru.yougifted.apipackage.MainDataForApi;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;

public class PersonMealApi extends MainDataForApi {


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

        given().auth().preemptive().oauth2(getTokenURL111())
                .get(mainUrl111 + urlApiV1UserMealRecipesAvailable + urlRecipeTypeBreakfast)
                .then()
                .statusCode(200)
                .body("data.cook_time", hasItems("10 минут"));
    }
}
