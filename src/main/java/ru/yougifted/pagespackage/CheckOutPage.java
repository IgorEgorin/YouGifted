package ru.yougifted.pagespackage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CheckOutPage {

    public String pricePerMonthOnCheckOutPage() {
        return $(By.xpath("//div[@class=\"pagespackage-subscribe-bottom\"]//span")).getText()
                .replaceAll("р.","");
    }

    private SelenideElement nameFieldOnCheckOutPage() {
        return $(By.name("name"));
    }

    private SelenideElement surnameFieldOnCheckOutPage() {
        return $(By.name("surname"));
    }

    private SelenideElement mailFieldOnCheckOutPage() {
        return $(By.name("email"));
    }

    private SelenideElement phoneFieldOnCheckOutPage() {
        return $(By.name("iu_telephone"));
    }

    private SelenideElement checkBoxAnotherPaymentTypeOnCheckOutPage() {
        return $("[for=\"pay-3\"]");
    }

    private SelenideElement checkBoxcaptchaOnCheckOutPage() {
        return $("#Recaptcha3");
    }

    private SelenideElement checkBoxIacceptUserAgreementOnCheckOutPage() {
        return $("[class=\"pagespackage-form-rules-field\"]");
    }

    private SelenideElement captchaIsValidImg() {
        return $("[class=\"recaptcha-checkbox-checkmark\"]");
    }

    private SelenideElement submitButtonOnCheckOutPage() {
        return $("[type=\"submit\"]");
    }

    public CheckOutPage enterDataUnregisterClient(String name, String surname, String mail, String phone){
        nameFieldOnCheckOutPage().sendKeys(name);
        surnameFieldOnCheckOutPage().sendKeys(surname);
        mailFieldOnCheckOutPage().sendKeys(mail);
        phoneFieldOnCheckOutPage().sendKeys(phone);
        return new CheckOutPage();
    }

    public CheckOutPage chooseAnotherPaymentTypeAndSubmit() {
        checkBoxAnotherPaymentTypeOnCheckOutPage().click();
        checkBoxcaptchaOnCheckOutPage().click();
        checkBoxIacceptUserAgreementOnCheckOutPage().click();
        submitButtonOnCheckOutPage().click();
        return new CheckOutPage();
    }

}
