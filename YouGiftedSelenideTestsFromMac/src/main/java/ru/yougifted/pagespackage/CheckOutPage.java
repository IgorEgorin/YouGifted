package ru.yougifted.pagespackage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Date;
import java.util.Random;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CheckOutPage {

    private SelenideElement totalPriceFromCheckOutPage;
    private SelenideElement linkHaveYouAlreadyHadAnAccount;

    public SelenideElement linkThisPackageIsAlreadyBoughtCheckOutPage;
    private SelenideElement linkPackageWasBoughtGoToPersonalCabinet;
    private SelenideElement packageTitleCheckOutPage;


    private String varName = "Александр";
    private String varSurName = "Иванов";
    private String varMail = new Date().getTime() + "@gmaill.com";
    private String varPhone = "+79"+String.valueOf(new Random().nextInt(1234567890));




    public String varForAuthMail = "9999999593a@hjkhjkmail.com";
    public String varForAuthPass = "0000";


    public CheckOutPage() {
        this.totalPriceFromCheckOutPage = $(By.xpath("//div[@class=\"checkout-subscribe-total\"]/span"));
        this.linkHaveYouAlreadyHadAnAccount = $("#show-login-form-btn");

        this.linkThisPackageIsAlreadyBoughtCheckOutPage = $("[class=\"checkout-form-submit\"] [type=\"button\"]");
        this.linkPackageWasBoughtGoToPersonalCabinet = $("[href=\"personal/payed\"]");

        this.packageTitleCheckOutPage = $("[class=\"checkout-package-title\"]");
    }

    public CheckOutPage clickLinkHaveYouAlreadyHadAnAccount() {
        linkHaveYouAlreadyHadAnAccount.click();
        return new CheckOutPage();
    }

    public String getTotalPriceFromCheckOutPage() {
        return totalPriceFromCheckOutPage.getText()
                .replaceAll("р.", "");
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

    private SelenideElement radioButtonAnotherPaymentTypeOnCheckOutPage() {
        return $("[for=\"pay-3\"]");

    }
    private SelenideElement radioButtonPaypalPaymentTypeOnCheckOutPage() {
        return $("[for=\"pay-2\"]");
    }

    private SelenideElement radioButtonPayViaAlfaBankOnCheckOutPage() {
        return $("[for=\"pay-1\"]");
    }

    private SelenideElement checkBoxcaptchaOnCheckOutPage() {
        return $("#Recaptcha3");
    }

    private SelenideElement checkBoxIacceptUserAgreementOnCheckOutPage() {
        return $("[class=\"checkout-form-rules-field\"]");
    }

    private SelenideElement captchaIsValidImg() {
        return $("[class=\"recaptcha-checkbox-checkmark\"]");
    }

    private SelenideElement submitButtonOnCheckOutPage() {
        return $("[type=\"submit\"]");
    }

    private SelenideElement submitPaypalButtonOnCheckOutPage() {
        return $("#paypal-button");
    }

    public CheckOutPage enterDataUnregisterClient(String name, String surname, String mail, String phone){
        nameFieldOnCheckOutPage().sendKeys(name);
        surnameFieldOnCheckOutPage().sendKeys(surname);
        mailFieldOnCheckOutPage().sendKeys(mail);
        phoneFieldOnCheckOutPage().sendKeys(phone);
        return new CheckOutPage();
    }

    public CheckOutPage clickCaptchaAndSubmitRegForm(){
        checkBoxcaptchaOnCheckOutPage().click();
        submitButtonOnCheckOutPage().click();
        return new CheckOutPage();
    }


    public CheckOutPage chooseAnotherPaymentTypeAndSubmit() {

        System.out.println("\nSelect 'Another type of payment'");
        radioButtonAnotherPaymentTypeOnCheckOutPage().shouldBe(Condition.visible).click();
        submitButtonOnCheckOutPage().click();
        return new CheckOutPage();
    }


    public CheckOutPage choosePaymentViaAlfaBankAndSubmit() {
        radioButtonPayViaAlfaBankOnCheckOutPage().click();
        submitButtonOnCheckOutPage().click();
        return new CheckOutPage();
    }

    public CheckOutPage choosePaymentViaPaypalAndSubmit() {

        System.out.println("\nSelect 'Paypal' type of payment");
        radioButtonPaypalPaymentTypeOnCheckOutPage().shouldBe(Condition.visible).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        submitPaypalButtonOnCheckOutPage().click();
        return new CheckOutPage();
    }



    public CheckOutPage chooseTypeOfRegistration(String s) {
        switch (s) {
            case "YouGiftedForm":
                new CheckOutPage().enterDataUnregisterClient(varName, varSurName
                        , varMail, varPhone).clickCaptchaAndSubmitRegForm();

                break;
            case "VK":

                Selenide.open(WebDriverRunner.url().replaceAll("640", "111"));

                System.out.println("\nClick on" + " " + s + "link");
                new RegistrationPage().clickOnAgreeCheckBoxAndVKlink();
                new SocialNetworksPage().caseVK(s);
                break;

            case "Facebook":

                Selenide.open(WebDriverRunner.url().replaceAll("640", "111"));

                System.out.println("\nClick on" + " " +  s + "link");
                new RegistrationPage().clickOnAgreeCheckBoxAndFacebooklink();
                new SocialNetworksPage().caseFacebook(s);
                break;

        }
        return new CheckOutPage();
    }


    public CheckOutPage chooseTypeOfAuthorization(String s) {
        switch (s) {
            case "YouGiftedForm":
                new LogInPage().enterMailAndPassAndSubmit(varForAuthMail, varForAuthPass);

                break;
            case "VK":
                Selenide.open(WebDriverRunner.url().replaceAll("640", "111"));

                System.out.println("\nClick on tab HAVE YOU HAD AN ACCOUNT?");

//                new CheckOutPage().clickLinkHaveYouAlreadyHadAnAccount();

                System.out.println("\nClick on" + " " + s + "link");
                new RegistrationPage().clickOnAgreeCheckBoxAndVKlink();
                new SocialNetworksPage().caseVK(s);
                break;

            case "Facebook":
                System.out.println("\nClick on" + " " +  s + "link");
                new RegistrationPage().clickFacebookLinkOnRegistrartionPage();
                new SocialNetworksPage().caseFacebook(s);
                break;

        }

        return new CheckOutPage();

    }

    public CheckOutPage clickLinkPackageWasBoughtGoToPersonalCabinet() {
        linkPackageWasBoughtGoToPersonalCabinet.click();
        return new CheckOutPage();
    }

    public String textPackageTitleCheckOutPage() {
        return packageTitleCheckOutPage.getText()
                .replaceAll("Пакет тренировок «","" ).replaceAll("»", "");
    }

    public CheckOutPage ifPackageWasBoughtGoToPersonalCabinetAndAssertNamePackage() {
        System.out.println("\nTraining package is already bought");

        System.out.println("\nCopy training package name into clipboard");

        String varPackageTitle =  textPackageTitleCheckOutPage();

        System.out.println("\bGo to personal cabinet");

        clickLinkPackageWasBoughtGoToPersonalCabinet();

        System.out.println("\nAssert. Training package name exists in 'My orders'");

        Assert.assertTrue($(byText(varPackageTitle)).isDisplayed()
                ,"\nTraining package name does not exist inside personal cabinet");

        return new CheckOutPage();
    }

}
