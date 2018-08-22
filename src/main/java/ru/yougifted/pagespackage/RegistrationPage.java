package ru.yougifted.pagespackage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    private SelenideElement nameFieldRegistrationPage() {
        return $(By.name("name"));
    }

    private SelenideElement surnameFieldRegistrationPage() {
        return $(By.name("surname"));
    }

    private SelenideElement mailFieldRegistrationPage() {
        return $(By.name("email"));
    }

    private SelenideElement phoneFieldRegistrationPage() {
        return $(By.name("iu_telephone"));
    }

    private SelenideElement captchaRegistrationPage() {
        return $("#Recaptcha");
    }

    private SelenideElement checkBoxIagreeRegistrationPage() {
        return $("[class=\"checkout-form-rules-field\"]");
    }

    private SelenideElement linkUserAgreement() {
        return $("[href=\"/oferta\"]");
    }

    private SelenideElement submitButtonRegistrationPage() {
        return $("#reg-submit");
    }

    public RegistrationPage enterDataNameSurnamePhoneMailAndSubmitOnRegistrationPage (String name
            , String surname, String mail, String phone) {
        nameFieldRegistrationPage().sendKeys(name);
        surnameFieldRegistrationPage().sendKeys(surname);
        mailFieldRegistrationPage().sendKeys(mail);
        phoneFieldRegistrationPage().sendKeys(phone);
        captchaRegistrationPage().click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        checkBoxIagreeRegistrationPage().scrollTo().click();
        submitButtonRegistrationPage().click();
        return new RegistrationPage();
    }

    public RegistrationPage enterNameAndSurname(String name, String surname) {
        nameFieldRegistrationPage().sendKeys(name);
        surnameFieldRegistrationPage().sendKeys(surname);
        return new RegistrationPage();
    }

    public RegistrationPage enterPhone(String phone) {
        phoneFieldRegistrationPage().sendKeys(phone);
        return new RegistrationPage();
    }

    public RegistrationPage ClickOnLinkUserAgreement() {
        linkUserAgreement().click();
        return new RegistrationPage();
    }

}
