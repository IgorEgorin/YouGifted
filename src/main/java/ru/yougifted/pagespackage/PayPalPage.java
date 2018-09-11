package ru.yougifted.pagespackage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class PayPalPage {

    private SelenideElement buttonLogInOnPayPalPage;
    private SelenideElement fieldEnterMailForLogInOnPayPalPage;
    private SelenideElement buttonSubmitMailForLogInOnPayPalPage;
    private SelenideElement fieldEnterPasswordForLogInOnPayPalPage;
    private SelenideElement buttonSubmitPasswordForLogInOnPayPalPage;
    private SelenideElement buttonSubmitOnShippingAdressTabOnPayPalPage;

    public PayPalPage() {
        this.buttonLogInOnPayPalPage = $("[class=\"btn full ng-binding\"]");
        this.fieldEnterMailForLogInOnPayPalPage = $("#email");
        this.buttonSubmitMailForLogInOnPayPalPage = $("#btnNext");
        this.fieldEnterPasswordForLogInOnPayPalPage = $("#password");
        this.buttonSubmitPasswordForLogInOnPayPalPage = $("#btnLogin");
        this.buttonSubmitOnShippingAdressTabOnPayPalPage = $("#button");
    }


    public PayPalPage makeApayOnPayPalPage(String payPalMail, String payPalPass) {
        System.out.println("\nPush login button on paypal page");
        buttonLogInOnPayPalPage.shouldBe(Condition.visible).click();

        System.out.println("\nEnter and submit login on paypal page");
        fieldEnterMailForLogInOnPayPalPage.sendKeys(payPalMail);
        buttonSubmitMailForLogInOnPayPalPage.click();

        System.out.println("\nEnter and submit password on paypal page");
        fieldEnterPasswordForLogInOnPayPalPage.setValue(payPalPass);
        buttonSubmitPasswordForLogInOnPayPalPage.click();

        System.out.println("\nSubmit shipping address on paypal page");
        buttonSubmitOnShippingAdressTabOnPayPalPage.click();

        return new PayPalPage();

    }



    public PayPalPage makePurchaseByPayPalAndAssertPricePayPalPage(String varPayPalMailForLogIn
            , String varPayPalPasswordForLogIn, String varPriceFromCheckoutPage) {



        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> handles = getWebDriver().getWindowHandles();
        List<String> tabs = new ArrayList<>(handles);
        switchTo().window(tabs.get(1));

        makeApayOnPayPalPage(varPayPalMailForLogIn, varPayPalPasswordForLogIn);


        switchTo().window(tabs.get(0));


        new PersonalCabinetPage().goToPersonalCabinetAndAssertTotalPrice(varPriceFromCheckoutPage);

        return new PayPalPage();




    }
}
