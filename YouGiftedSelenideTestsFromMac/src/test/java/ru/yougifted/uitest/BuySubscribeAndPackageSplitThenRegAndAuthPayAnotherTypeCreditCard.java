package ru.yougifted.uitest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.testng.Assert;
import ru.yougifted.helperpackage.PreconditionJunit;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RunWith(Parameterized.class)
public class BuySubscribeAndPackageSplitThenRegAndAuthPayAnotherTypeCreditCard extends PreconditionJunit {



    @Parameterized.Parameter
    public String varTypeOfLoginAndAuth;

    @Parameterized.Parameters
    public static List<String> data() {
        List<String> lists = new ArrayList<>();
        lists.add("YouGiftedForm");
//        lists.add("VK"); 03102018 VK works only on 111. 111 has had another design
//        lists.add("Facebook");
        return lists;
    }


    @Test
    public void RegistrationAndBuySubscribeByAnotherTypeCreditCard() throws Exception {



        System.out.println("\nOpen main page");

        System.out.println("\nScroll to subscription in footer");

        mainPage.scrollToFooterMainPageSubscribeOneMonth();

        System.out.println("\nSave one month price from main page to clipboard");


        String varPriceFromFooterMainPageOneMonth = mainPage.textPriceFooterMainPageOneMonth();


        System.out.println("\nChoose one month subscription and go to checkout page");


        mainPage.scrollToFooterMainPageSubscribeOneMonth().click();


        System.out.println("\nAssert. Total price from main page equals price on check out page");

        Assert.assertTrue(varPriceFromFooterMainPageOneMonth.equals(checkOutPage
                        .getTotalPriceFromCheckOutPage()),
                "\nPrice per month on Main page is:" + " " + varPriceFromFooterMainPageOneMonth +
                        "\nPrice per month on Checkout page is:" + " " + checkOutPage
                        .getTotalPriceFromCheckOutPage());


        System.out.println("\nEnter registration data using" + " " + varTypeOfLoginAndAuth);


        checkOutPage.chooseTypeOfRegistration(varTypeOfLoginAndAuth);


        System.out.println("\nChoose ANOTHER TYPE OF PAYMENT on checkout page and go to max kassa page");

        checkOutPage.chooseAnotherPaymentTypeAndSubmit();


        maxKassa.makePurchaseByAnotherTypeCreditCardAndAssertPriceInsidePersonalCabinet(varPriceFromFooterMainPageOneMonth);



    }



    @Test
    public void AuthorizationAndBuySubscribeByAnotherTypeCreditCard() throws Exception {


        System.out.println("\nOpen main page");

        System.out.println("\nScroll to subscription in footer");

        mainPage.scrollToFooterMainPageSubscribeOneMonth();

        System.out.println("\nSave one month price from main page to clipboard");


        String varPriceFromFooterMainPageOneMonth = mainPage.textPriceFooterMainPageOneMonth();


        System.out.println("\nChoose one month subscription and go to checkout page");


        mainPage.scrollToFooterMainPageSubscribeOneMonth().click();


        System.out.println("\nAssert. Total price from main page equals price on check out page");

        Assert.assertTrue(varPriceFromFooterMainPageOneMonth.equals(checkOutPage
                        .getTotalPriceFromCheckOutPage()),
                "\nPrice per month on Main page is:" + " " + varPriceFromFooterMainPageOneMonth +
                        "\nPrice per month on Checkout page is:" + " " + checkOutPage
                        .getTotalPriceFromCheckOutPage());


        System.out.println("\nClick on link HAVE YOU HAD AN ACCOUNT?");

        checkOutPage.clickLinkHaveYouAlreadyHadAnAccount();


        System.out.println("\nEnter login data using" + " " + varTypeOfLoginAndAuth);


        checkOutPage.chooseTypeOfAuthorization(varTypeOfLoginAndAuth);



        System.out.println("\nChoose ANOTHER TYPE OF PAYMENT on checkout page and go to max kassa page");


        checkOutPage.chooseAnotherPaymentTypeAndSubmit();

        maxKassa.makePurchaseByAnotherTypeCreditCardAndAssertPriceInsidePersonalCabinet(varPriceFromFooterMainPageOneMonth);


    }

    @Test
    public void RegistrationAndBuyPackageSplitByAnotherTypeCreditCard() throws Exception {

        System.out.println("\nClick on package 'Split'");
        mainPage.clickOnButtonOpenAllTrainingProgramsOnMainPage()
                .clickLinkSplitPackage();


        System.out.println("\nSave price to clipboard");
        String varPricePackage = mainPage.priceSplitPackage();

        System.out.println("\nClick button 'Buy' on package 'Split'");
        mainPage.clickButtonBuySplitPackage();

        System.out.println("\nGo to checkout page");


        System.out.println("\nAssert. Total price from package page equals price on checkout page");

        Assert.assertTrue(varPricePackage.equals(checkOutPage
                        .getTotalPriceFromCheckOutPage()),
                "\nPrice per month on Main page is:" + " " + varPricePackage +
                        "\nPrice per month on Checkout page is:" + " " + checkOutPage
                        .getTotalPriceFromCheckOutPage());


        System.out.println("\nEnter registration data using" + " " + varTypeOfLoginAndAuth);

        checkOutPage.chooseTypeOfRegistration(varTypeOfLoginAndAuth);


        System.out.println("\nChoose ANOTHER TYPE OF PAYMENT on checkout page and go to max kassa page");


        checkOutPage.chooseAnotherPaymentTypeAndSubmit();

        maxKassa.makePurchaseByAnotherTypeCreditCardAndAssertPriceInsidePersonalCabinet(varPricePackage);


    }



    @Test
    public void AuthorizationAndBuyPackageSplitByAnotherTypeCreditCard() throws Exception {

        System.out.println("\nClick on package 'Split'");
        mainPage.clickOnButtonOpenAllTrainingProgramsOnMainPage()
                .clickLinkSplitPackage();


        System.out.println("\nSave price to clipboard");
        String varPricePackage = mainPage.priceSplitPackage();

        System.out.println("\nClick button 'Buy' on package 'Split'");
        mainPage.clickButtonBuySplitPackage();

        System.out.println("\nGo to checkout page");


        System.out.println("\nAssert. Total price from package page equals price on checkout page");

        Assert.assertTrue(varPricePackage.equals(checkOutPage
                        .getTotalPriceFromCheckOutPage()),
                "\nPrice per month on Main page is:" + " " + varPricePackage +
                        "\nPrice per month on Checkout page is:" + " " + checkOutPage
                        .getTotalPriceFromCheckOutPage());


        System.out.println("\nClick on link HAVE YOU HAD AN ACCOUNT?");

        checkOutPage.clickLinkHaveYouAlreadyHadAnAccount();


        checkOutPage.chooseTypeOfAuthorization(varTypeOfLoginAndAuth);

        if(checkOutPage.linkThisPackageIsAlreadyBoughtCheckOutPage.isDisplayed())
        {

            checkOutPage.ifPackageWasBoughtGoToPersonalCabinetAndAssertNamePackage();

        }   else {

            checkOutPage.chooseAnotherPaymentTypeAndSubmit();

            maxKassa.makePurchaseByAnotherTypeCreditCardAndAssertPriceInsidePersonalCabinet(varPricePackage);


        }

    }

}
