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

    public PersonalCabinetPage enterDataOnLogInPageAndPressSubmit(String mail, String password) {
        new MainPage().clickLogInButtonHeaderMainPage();
        enterMailOnLogInPage().sendKeys(mail);
        enterPasswordOnLogInPage().sendKeys(password);
        submitButtonOnLogInPage().click();
        return new PersonalCabinetPage();
    }

    public PersonalCabinetPage logInLikeTestUser() {
        new MainPage().clickLogInButtonHeaderMainPage();
        enterMailOnLogInPage().sendKeys(defaultUserMail);
        enterPasswordOnLogInPage().sendKeys(defaultUserPassword);
        submitButtonOnLogInPage().click();
        return new PersonalCabinetPage();
    }

    public PersonalCabinetPage logInWithNewMail(String s) {
        new MainPage().clickLogInButtonHeaderMainPage();
        enterMailOnLogInPage().sendKeys(s);
        enterPasswordOnLogInPage().sendKeys(defaultUserPassword);
        submitButtonOnLogInPage().click();
        return new PersonalCabinetPage();
    }

    public PersonalCabinetPage setDefaultNameOnTabMyDataPersonalCabinet(String s) {
        new PersonalCabinetPage().nameFieldPersonalCabinet().setValue(s);
        return new PersonalCabinetPage();
    }

    public PersonalCabinetPage setDefaultSurnameOnTabMyDataPersonalCabinet(String s) {
        new PersonalCabinetPage().surnameFieldPersonalCabinet().setValue(s);
        return new PersonalCabinetPage();
    }

    public PersonalCabinetPage setDefaultMailOnTabMyDataPersonalCabinet(String s) {
        new PersonalCabinetPage().mailFieldPersonalCabinet().setValue(s);
        return new PersonalCabinetPage();
    }

    public PersonalCabinetPage setDefaultPhoneOnTabMyDataPersonalCabinet(String s) {
        new PersonalCabinetPage().phoneFieldPersonalCabinet().setValue(s);
        return new PersonalCabinetPage();
    }

    public PersonalCabinetPage setDefaultBirthOnTabMyDataPersonalCabinet(String s) {
        new PersonalCabinetPage().birthDataFieldPersonalCabinet().setValue(s);
        return new PersonalCabinetPage();
    }

    public PersonalCabinetPage setDefaultHeightOnTabMyDataPersonalCabinet(String s) {
        new PersonalCabinetPage().heightFieldPersonalCabinet().setValue(s);
        return new PersonalCabinetPage();
    }

}
