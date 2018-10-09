package ru.yougifted.uitest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.testng.Assert;
import ru.yougifted.helperpackage.PreconditionJunit;

import java.util.ArrayList;
import java.util.List;

@RunWith(Parameterized.class)
public class BuySubscribeAndPackageSplitThenRegAndAuthPaypal extends PreconditionJunit {


    private String varPayPalMailForLogIn = "buyer-test@yougifted.ru";
    private String varPayPalPasswordForLogIn = "admin123";



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
    public void RegistrationAndBuySubscribeViaPaypal() throws Exception {


        System.out.println("\nOpen main page");


        System.out.println("\nScroll to subscription in footer");

        mainPage.scrollToFooterMainPageSubscribeOneMonth();

        System.out.println("\nSave one month price from main page to clipboard");


        String varPriceFromFooterMainPageOneMonth = mainPage.textPriceFooterMainPageOneMonth();


        System.out.println("\nChoose one month subscription and go to checkout page");


        mainPage.scrollToFooterMainPageSubscribeOneMonth().click();


        System.out.println("\nAssert. Total price from main page equals price on checkout page");

        Assert.assertTrue(varPriceFromFooterMainPageOneMonth.equals(checkOutPage
                        .getTotalPriceFromCheckOutPage()),
                "\nPrice per month on Main page is:" + " " + varPriceFromFooterMainPageOneMonth +
                        "\nPrice per month on Checkout page is:" + " " + checkOutPage
                        .getTotalPriceFromCheckOutPage());


        System.out.println("\nEnter registration data using" + " " + varTypeOfLoginAndAuth);


        checkOutPage.chooseTypeOfRegistration(varTypeOfLoginAndAuth);

        checkOutPage.choosePaymentViaPaypalAndSubmit();


        payPalPage.makePurchaseByPayPalAndAssertPricePayPalPage(varPayPalMailForLogIn,
                varPayPalPasswordForLogIn
                ,varPriceFromFooterMainPageOneMonth );




    }

    @Test
    public void AuthorizationAndBuySubscribeViaPaypal() throws Exception {


        System.out.println("\nOpen main page");


        System.out.println("\nScroll to subscription in footer");

        mainPage.scrollToFooterMainPageSubscribeOneMonth();

        System.out.println("\nSave one month price from main page to clipboard");


        String varPriceFromFooterMainPageOneMonth = mainPage.textPriceFooterMainPageOneMonth();


        System.out.println("\nChoose one month subscription and go to checkout page");


        mainPage.scrollToFooterMainPageSubscribeOneMonth().click();


        System.out.println("\nAssert. Total price from main page equals price on checkout page");

        Assert.assertTrue(varPriceFromFooterMainPageOneMonth.equals(checkOutPage
                        .getTotalPriceFromCheckOutPage()),
                "\nPrice per month on Main page is:" + " " + varPriceFromFooterMainPageOneMonth +
                        "\nPrice per month on Checkout page is:" + " " + checkOutPage
                        .getTotalPriceFromCheckOutPage());


        System.out.println("\nClick on link HAVE YOU HAD AN ACCOUNT?");

        checkOutPage.clickLinkHaveYouAlreadyHadAnAccount();


        System.out.println("\nEnter authorization data using" + " " + varTypeOfLoginAndAuth);


        checkOutPage.chooseTypeOfAuthorization(varTypeOfLoginAndAuth);

        Thread.sleep(5000);

        checkOutPage.choosePaymentViaPaypalAndSubmit();


        payPalPage.makePurchaseByPayPalAndAssertPricePayPalPage(varPayPalMailForLogIn,
                varPayPalPasswordForLogIn
                ,varPriceFromFooterMainPageOneMonth );
    }


    @Test
    public void RegistrationAndBuyPackageSplitViaPaypal() {


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

        checkOutPage.choosePaymentViaPaypalAndSubmit();


        payPalPage.makePurchaseByPayPalAndAssertPricePayPalPage(varPayPalMailForLogIn,
                varPayPalPasswordForLogIn
                ,varPricePackage );

    }



    @Test
    public void AuthorizationAndBuyPackageSplitViaPaypal() {


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


        System.out.println("\nEnter authorization data using" + " " + varTypeOfLoginAndAuth);


        checkOutPage.chooseTypeOfAuthorization(varTypeOfLoginAndAuth);



        if(checkOutPage.linkThisPackageIsAlreadyBoughtCheckOutPage.isDisplayed())
        {

            checkOutPage.ifPackageWasBoughtGoToPersonalCabinetAndAssertNamePackage();

        }   else {

            checkOutPage.choosePaymentViaPaypalAndSubmit();

            payPalPage.makePurchaseByPayPalAndAssertPricePayPalPage(varPayPalMailForLogIn,
                    varPayPalPasswordForLogIn
                    ,varPricePackage );


        }



    }
}
