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
        return $(By.name("rules"));
    }

    private SelenideElement submitButtonRegistrationPage() {
        return $(By.name("#reg-submit"));
    }

    public void enterDataNameSurnamePhoneMailAndSubmitOnRegistrationPage (String name
            , String surname, String mail, String phone) {
        nameFieldRegistrationPage().sendKeys(name);
        surnameFieldRegistrationPage().sendKeys(name);
        mailFieldRegistrationPage().sendKeys(name);
        phoneFieldRegistrationPage().sendKeys(name);
        captchaRegistrationPage().click();
        checkBoxIagreeRegistrationPage().click();
        submitButtonRegistrationPage().click();
    }
}
