package ru.yougifted.pagespackage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

public class MaxKassaPage {

    private SelenideElement payViaBankCardOnMaxKassa() {
        return $("[alt=\"Visa\"]");
    }

    public void payViaBankCardOnMaxKassaClick() {
        payViaBankCardOnMaxKassa().click();
    }

    public String priceTitleOnSelectTypeOfPaymentOnMaxKassa() {
        return $(By.xpath("//div[@class=\"summ\"]/span")).getText().replaceAll(" ","")
                .replaceAll(".00руб.","");
    }

    private SelenideElement linkSendSuccessResultToSiteOnMaxKassa() {
        return $("[href=\"?state=demo_result\"]");
    }


    private SelenideElement linkGoToSuccessResultPageOnMaxKassa() {
        return $("[class=\"btn\"]",1);
    }


    public String priceTitleOnPayAbillOnMaxKassa() {
        return $("[class=\"info_val summ\"]").getText().replaceAll(" ","")
                .replaceAll(".00руб.","");
    }

    public void makeSuccessPayAndGoToSite() throws InterruptedException {
        linkSendSuccessResultToSiteOnMaxKassa().click();
        Thread.sleep(20000);
        linkGoToSuccessResultPageOnMaxKassa().click();
    }

    public MainPage makePurchaseByAnotherTypeCreditCardAndAssertPriceInsidePersonalCabinet(
            String varPricePackageCheckout) throws InterruptedException {


        System.out.println("\nAssert. Total price from main page equals price " +
                "on max kassa page when we choose a payment method (via qiwi wallet etc)");



        Assert.assertTrue(varPricePackageCheckout.equals(new MaxKassaPage()
                .priceTitleOnSelectTypeOfPaymentOnMaxKassa()),"\nPrice per month on main page is:" + " "
                + varPricePackageCheckout
                + "\nPrice title on select type of payment on MaxKassaPage is:" + " "
                +new MaxKassaPage().priceTitleOnSelectTypeOfPaymentOnMaxKassa());

        System.out.println("\nGo to payment of invoice tab on max kassa page");

        new MaxKassaPage().payViaBankCardOnMaxKassaClick();

        System.out.println("\nAssert. Total price from main page equals price " +
                "on tab PAYMENT OF INVOICE on max kassa page");

        Assert.assertTrue(varPricePackageCheckout.equals(new MaxKassaPage().priceTitleOnPayAbillOnMaxKassa())
                ,"Price per month on main page is:" + " "
                        + varPricePackageCheckout
                        + "\nPrice title on payment of invoice tab on MaxKassaPage is:" + " "
                        +new MaxKassaPage().priceTitleOnPayAbillOnMaxKassa());

        System.out.println("\nMake a payment (Push submit button) and go to personal cabinet page");


        new MaxKassaPage().makeSuccessPayAndGoToSite();

        new PersonalCabinetPage().goToPersonalCabinetAndAssertTotalPrice(varPricePackageCheckout);



        return new MainPage();
    }


}
