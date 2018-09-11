package ru.yougifted.uitest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.testng.Assert;
import ru.yougifted.helperpackage.PreconditionJunit;

import java.util.ArrayList;
import java.util.List;


@RunWith(Parameterized.class)
public class BuySubscribeAndPackageSplitThenRegAndAuthPayAlfaBank extends PreconditionJunit {



    private String varCardNumber = "4111111111111111";
    private String varOwnerName = "Alexsander Ivanov";
    private String varExpiredData = "1219";
    private String varCvv = "123";
    private String varSmsPassword = "12345678";




    @Parameterized.Parameter
    public String varTypeOfLoginAndAuth;

    @Parameterized.Parameters
    public static List<String> data() {
        List<String> lists = new ArrayList<>();
//        lists.add("YouGiftedForm");
        lists.add("VK");
//        lists.add("Facebook");
        return lists;
    }





    @Test
    public void RegistrationAndBuySubscribeViaAlfaBankCreditCard() throws Exception {




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


        alfaBankPage.makePurchaseAssertTotalPrice(varCardNumber, varOwnerName, varExpiredData, varCvv,
                varSmsPassword, varPriceFromFooterMainPageOneMonth);


    }


    @Test
    public void AuthorizationAndBuySubscribeViaAlfaBankCreditCard() throws Exception {



        System.out.println("\nOpen main page");

        System.out.println("\nScroll to subscription in footer");

        mainPage.scrollToFooterMainPageSubscribeOneMonth();


        System.out.println("\nSave one month price from main page to clipboard");

        String varPriceFromFooterMainPageOneMonth = mainPage.textPriceFooterMainPageOneMonth();


        System.out.println("\nChoose one month subscription and go to checkout page");


        mainPage.scrollToFooterMainPageSubscribeOneMonth().click();



        Assert.assertTrue(varPriceFromFooterMainPageOneMonth.equals(checkOutPage
                        .getTotalPriceFromCheckOutPage()),
                "\nPrice per month on Main page is:" + " " + varPriceFromFooterMainPageOneMonth +
                        "\nPrice per month on Checkout page is:" + " " + checkOutPage
                        .getTotalPriceFromCheckOutPage());


        System.out.println("\nClick on tab HAVE YOU HAD AN ACCOUNT?");

        checkOutPage.clickLinkHaveYouAlreadyHadAnAccount();


        System.out.println("\nEnter login data using" + " " + varTypeOfLoginAndAuth);



        checkOutPage.chooseTypeOfAuthorization(varTypeOfLoginAndAuth);

        alfaBankPage.makePurchaseAssertTotalPrice(varCardNumber, varOwnerName, varExpiredData, varCvv
                , varPriceFromFooterMainPageOneMonth, varSmsPassword);


    }


    @Test
    public void RegistrationAndPackageSplitViaAlfaBankCreditCard() throws Exception {



        System.out.println("\nClick on package 'Split'");
        mainPage.clickLinkSplitPackage();


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

        alfaBankPage.makePurchaseAssertTotalPrice(varCardNumber,varOwnerName
                , varExpiredData,varCvv ,varSmsPassword
                ,varPricePackage );

    }



    @Test
    public void AuthorizationAndBuyPackageSplitViaAlfaBankCreditCard() throws Exception {

        System.out.println("\nClick on package 'Split'");
        mainPage.clickLinkSplitPackage();


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


        System.out.println("\nClick on tab HAVE YOU HAD AN ACCOUNT?");

        checkOutPage.clickLinkHaveYouAlreadyHadAnAccount();


        System.out.println("\nEnter login data using" + " " + varTypeOfLoginAndAuth);

        checkOutPage.chooseTypeOfAuthorization(varTypeOfLoginAndAuth);

        if(checkOutPage.linkThisPackageIsAlreadyBoughtCheckOutPage.isDisplayed())
        {

            checkOutPage.ifPackageWasBoughtGoToPersonalCabinetAndAssertNamePackage();

        }   else {

            alfaBankPage.makePurchaseAssertTotalPrice(varCardNumber,varOwnerName
                    , varExpiredData,varCvv ,varSmsPassword
                    ,varPricePackage );

        }

    }

}
