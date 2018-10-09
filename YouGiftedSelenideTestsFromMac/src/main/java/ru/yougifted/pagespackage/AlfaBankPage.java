package ru.yougifted.pagespackage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

public class AlfaBankPage {


    private SelenideElement fieldCardNumberAlfaBankPage;
    private SelenideElement fieldClientNameAlfaBankPage;
    private SelenideElement fieldExpiredDataAlfaBankPage;
    private SelenideElement fieldCVVAlfaBankPage;
    private SelenideElement buttonSubmitAlfaBankPage;


    public AlfaBankPage() {
        this.fieldCardNumberAlfaBankPage = $("#ccnumber");
        this.fieldClientNameAlfaBankPage = $("#iTEXT");
        this.fieldExpiredDataAlfaBankPage = $("#expired");
        this.fieldCVVAlfaBankPage = $("#iCVC");
        this.buttonSubmitAlfaBankPage = $("#amount");

    }

    public String getTotalPriceTextAlfaBankPage() {
        return buttonSubmitAlfaBankPage.shouldBe(Condition.visible).getText().replaceAll(" ","" );
    }


    public AlfaBankPage alfaBankPageEnterCardNumberOwnerExpiredCvv(String card, String owner,
                                                                   String expired, String cvv) {
        fieldCardNumberAlfaBankPage.sendKeys(card);
        fieldClientNameAlfaBankPage.sendKeys(owner);
        fieldExpiredDataAlfaBankPage.sendKeys(expired);
        fieldCVVAlfaBankPage.sendKeys(cvv);
        return new AlfaBankPage();
    }

    public AlfaBankPage clickButtonSubmitAlfaBankPage() {
        buttonSubmitAlfaBankPage.click();
        return new AlfaBankPage();
    }


    public AlfaBankPage makePurchaseAssertTotalPrice(String varCardNumber, String varOwnerName
            , String varExpiredData, String  varCvv ,String varSmsPassword
            , String varPriceFromCheckoutPage) {

        System.out.println("\nSubmit registration data and go to alfa bank page");


        System.out.println("\nEnter credit card data on alfa bank page");

        alfaBankPageEnterCardNumberOwnerExpiredCvv(varCardNumber
                , varOwnerName, varExpiredData, varCvv);


        System.out.println("\nAssert. Price from main page equals price on alfa bank page");

        Assert.assertTrue(varPriceFromCheckoutPage.equals(getTotalPriceTextAlfaBankPage())
                ,"\nPrice from main page is:" + " " + varPriceFromCheckoutPage
                        + "\nPrice on alfa bank page is:" + " " + getTotalPriceTextAlfaBankPage());


        System.out.println("\nClick on submit button and go to sms page");

        clickButtonSubmitAlfaBankPage();

        Assert.assertTrue(varPriceFromCheckoutPage.equals(new PaymentSmsPage().getPriceFromSmsPage())
                ,"\nPrice from main page is:" + " " + varPriceFromCheckoutPage
                        + "\nPrice on sms bank page is:" + " " + new PaymentSmsPage().getPriceFromSmsPage());


        System.out.println("\nEnter credit card data,submit and go to personal cabinet page");

        new PaymentSmsPage().enterPasswordOnSmsPageAndSubmit(varSmsPassword);



        new PersonalCabinetPage().goToPersonalCabinetAndAssertTotalPrice(varPriceFromCheckoutPage);


        return new AlfaBankPage();
    }

}
