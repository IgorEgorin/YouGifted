package ru.yougifted.apitest;

import org.junit.Test;
import ru.yougifted.apipackage.MainDataForApi;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class LoginApi extends MainDataForApi {
    

    @Test
    public void testAuthUserStatusCode() {
        given()
                .param(varKeyLogIn, varClietLogIn)
                .param(varKeyPassword, varClietPassword)
                .when()
                .post(mainUrl111 + urlApiV1SignIn)
                .then()
                .statusCode(200);
    }



    @Test
    public void testAuthUserAssertId() {
        given()
                .param(varKeyLogIn, varClietLogIn)
                .param(varKeyPassword, varClietPassword)
                .when()
                .post(mainUrl111 + urlApiV1SignIn)
                .then()
                .root(varRootForLogIn)
                .body("id", is("37507"));
    }


    @Test
    public void testAuthUserAssertName() {
        given()
                .param(varKeyLogIn, varClietLogIn)
                .param(varKeyPassword, varClietPassword)
                .when()
                .post(mainUrl111 + urlApiV1SignIn)
                .then()
                .root(varRootForLogIn)
                .body("name", is("Paul"));
    }

    @Test
    public void testAuthUserAssertSurname() {
        given()
                .param(varKeyLogIn, varClietLogIn)
                .param(varKeyPassword, varClietPassword)
                .when()
                .post(mainUrl111 + urlApiV1SignIn)
                .then()
                .root(varRootForLogIn)
                .body("surname", is("Miller"));
    }


    @Test
    public void testAuthUserAssertUsername() {
        given()
                .param(varKeyLogIn, varClietLogIn)
                .param(varKeyPassword, varClietPassword)
                .when()
                .post(mainUrl111 + urlApiV1SignIn)
                .then()
                .root(varRootForLogIn)
                .body("username", is(varClietLogIn));
    }



    @Test
    public void testAuthUserAssertEmail() {
        given()
                .param(varKeyLogIn, varClietLogIn)
                .param(varKeyPassword, varClietPassword)
                .when()
                .post(mainUrl111 + urlApiV1SignIn)
                .then()
                .root(varRootForLogIn)
                .body("email", is(varClietLogIn));
    }



    @Test
    public void testAuthUserAssertAccountIsActivated() {
        given()
                .param(varKeyLogIn, varClietLogIn)
                .param(varKeyPassword, varClietPassword)
                .when()
                .post(mainUrl111 + urlApiV1SignIn)
                .then()
                .root(varRootForLogIn)
                .body("is_activated", is("1"));
    }



}
