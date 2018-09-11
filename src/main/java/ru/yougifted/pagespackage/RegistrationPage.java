package ru.yougifted.pagespackage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    private SelenideElement nameFieldRegistrationPage;
    private SelenideElement surnameFieldRegistrationPage;
    private SelenideElement mailFieldRegistrationPage;
    private SelenideElement phoneFieldRegistrationPage;
    private SelenideElement captchaRegistrationPage;
    private SelenideElement linkFacebook;
    private SelenideElement linkFacebookRegistrationPage;
    private SelenideElement linkVK;
    private SelenideElement linkVKRegistrationPage;
    private SelenideElement checkBoxIagreeRegistrationPage;
    private SelenideElement linkUserAgreement;
    private SelenideElement submitButtonRegistrationPage;


    public RegistrationPage() {
        this.nameFieldRegistrationPage = $(By.name("name"));
        this.surnameFieldRegistrationPage = $(By.name("surname"));
        this.mailFieldRegistrationPage = $(By.name("email"));
        this.phoneFieldRegistrationPage = $(By.name("iu_telephone"));
        this.captchaRegistrationPage = $("#Recaptcha");
        this.linkFacebook = $("[onclick=\"fbLogin();\"]");
        this.linkFacebookRegistrationPage = $("[onclick=\"fbRegister();\"]");
        this.linkVK = $("[onclick=\"vkLogin();\"]");
        this.linkVKRegistrationPage = $("[onclick=\"vkRegister();\"]");
        this.checkBoxIagreeRegistrationPage = $("[class=\"checkout-form-rules-field\"]");
        this.linkUserAgreement = $("[href=\"/oferta\"]");
        this.submitButtonRegistrationPage = $("#reg-submit");;
    }


    public RegistrationPage enterDataNameSurnamePhoneMailAndSubmitOnRegistrationPage (String name
            , String surname, String mail, String phone) {
        nameFieldRegistrationPage.sendKeys(name);
        surnameFieldRegistrationPage.sendKeys(surname);
        mailFieldRegistrationPage.sendKeys(mail);
        phoneFieldRegistrationPage.sendKeys(phone);
        captchaRegistrationPage.click();
        checkBoxIagreeRegistrationPage.scrollTo().click();
        submitButtonRegistrationPage.click();
        return new RegistrationPage();
    }

    public RegistrationPage enterNameAndSurname(String name, String surname) {
        nameFieldRegistrationPage.sendKeys(name);
        surnameFieldRegistrationPage.sendKeys(surname);
        return new RegistrationPage();
    }

    public RegistrationPage enterPhone(String phone) {
        phoneFieldRegistrationPage.sendKeys(phone);
        return new RegistrationPage();
    }

    public RegistrationPage clickOnLinkUserAgreement() {
        linkUserAgreement.click();
        return new RegistrationPage();
    }

    public RegistrationPage openFacebookTab() {
        checkBoxIagreeRegistrationPage.click();
        linkFacebook.click();
        return new RegistrationPage();
    }

    public RegistrationPage openVKTab() {
        checkBoxIagreeRegistrationPage.click();
        linkVK.click();
        return new RegistrationPage();
    }

    public RegistrationPage clickFacebookLinkOnAuthorizationPage() {
        linkFacebook.click();
        return new RegistrationPage();
    }


    public RegistrationPage clickVKLinkOnAuthorizationPage() {
        linkVK.click();
        return new RegistrationPage();
    }

    public RegistrationPage clickFacebookLinkOnRegistrartionPage() {
        linkFacebookRegistrationPage.click();
        return new RegistrationPage();
    }


    public RegistrationPage clickVKLinkOnRegistrartionPage() {
        linkVKRegistrationPage.click();
        return new RegistrationPage();
    }
}
