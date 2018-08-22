package ru.yougifted.pagespackage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LogInPage {

    private String defaultUserMail = "310718@ccc.ccc";
    private String defaultUserPassword = "0000a";

    private SelenideElement enterMailOnLogInPage() {
        return $(By.name("login"));
    }

    private SelenideElement enterPasswordOnLogInPage() {
        return $(By.name("password"));
    }

    private SelenideElement submitButtonOnLogInPage() {
        return $("[type=\"submit\"]");
    }

    private SelenideElement linkForgetPassword() { return $("[href=\"/password-reset\"]"); }

    private SelenideElement recoveryPageMailField() { return $(By.name("email")); }

    private SelenideElement recoveryPageResetPassword() { return $("[type=\"submit\"]"); }

    private SelenideElement linkGoToLogInPageThroughRecoveryPage()
    { return $("[href=\"/login\"]"); }


    public TabEditProfile logInLikeTestUser() {
        new MainPage().clickLogInButtonHeaderMainPage();
        enterMailOnLogInPage().sendKeys(defaultUserMail);
        enterPasswordOnLogInPage().sendKeys(defaultUserPassword);
        submitButtonOnLogInPage().click();
        return new TabEditProfile();
    }

    public TabEditProfile logInWithNewMail(String s) {
        new MainPage().clickLogInButtonHeaderMainPage();
        enterMailOnLogInPage().sendKeys(s);
        enterPasswordOnLogInPage().sendKeys(defaultUserPassword);
        submitButtonOnLogInPage().click();
        return new TabEditProfile();
    }

    public TabEditProfile logInWithOldMailAndNewPassword(String s) {
        new MainPage().clickLogInButtonHeaderMainPage();
        enterMailOnLogInPage().sendKeys(defaultUserMail);
        enterPasswordOnLogInPage().sendKeys(s);
        submitButtonOnLogInPage().click();
        return new TabEditProfile();
    }

    public TabEditProfile setDefaultNameOnTabMyDataPersonalCabinet(String s) {
        new TabEditProfile().nameFieldPersonalCabinet().setValue(s);
        return new TabEditProfile();
    }

    public TabEditProfile setDefaultSurnameOnTabMyDataPersonalCabinet(String s) {
        new TabEditProfile().surnameFieldPersonalCabinet().setValue(s);
        return new TabEditProfile();
    }

    public TabEditProfile setDefaultMailOnTabMyDataPersonalCabinet(String s) {
        new TabEditProfile().mailFieldPersonalCabinet().setValue(s);
        return new TabEditProfile();
    }

    public TabEditProfile setDefaultPhoneOnTabMyDataPersonalCabinet(String s) {
        new TabEditProfile().phoneFieldPersonalCabinet().setValue(s);
        return new TabEditProfile();
    }

    public TabEditProfile setBirthOnTabMyDataPersonalCabinet(String s) {
        new TabEditProfile().birthDataFieldPersonalCabinet().setValue(s);
        return new TabEditProfile();
    }

    public TabEditProfile setDefaultHeightOnTabMyDataPersonalCabinet(String s) {
        new TabEditProfile().heightFieldPersonalCabinet().setValue(s);
        return new TabEditProfile();
    }

    public LogInPage linkForgetPasswordClick() {
        linkForgetPassword().click();
        return new LogInPage();
    }

    public LogInPage enterRecoveryPageMailField(String mailRecovery) {
        recoveryPageMailField().sendKeys(mailRecovery);
        return new LogInPage();
    }

    public LogInPage clickButtonRecoveryPageResetPassword() {
        recoveryPageResetPassword().click();
        return new LogInPage();
    }

    public LogInPage fieldEnterNewPasswordOnRecoveryPageAndSubmit(String newPassRecovPage) {
        enterPasswordOnLogInPage().sendKeys(newPassRecovPage);
        submitButtonOnLogInPage().click();
        return new LogInPage();
    }

    public LogInPage clickLinkGoToLogInPageThroughRecoveryPage() {
        linkGoToLogInPageThroughRecoveryPage().click();
        return new LogInPage();
    }

    public LogInPage enterNewMailAndPassAfterRecoveryAndSubmit(String mailRec, String passRec) {
        new MainPage().clickLogInButtonHeaderMainPage();
        enterMailOnLogInPage().setValue(mailRec);
        enterPasswordOnLogInPage().setValue(passRec);
        submitButtonOnLogInPage().click();
        return new LogInPage();
    }

}
