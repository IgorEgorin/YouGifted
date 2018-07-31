import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yougifted.helperpackage.Precondition;

import java.util.Date;

public class PaymentTwelveMonthTest extends Precondition {

    @Test
    public void successPay() throws Exception {

        mainPage.newLifeFirstStageImgOnMainPageAndClick();

        locatorsForAllTrainingPage.clickOnTwelveMonthSubscription();

        String variablePricePerMonthOnTrainingPage = locatorsForAllTrainingPage
                .priceTwelveMonthSubscriptionOnTrainingPage().getText();

        locatorsForAllTrainingPage.buttonBuyASubscriptionOnTrainingPageClick();

        Assert.assertTrue(variablePricePerMonthOnTrainingPage.equals(checkOutPage.pricePerMonthOnCheckOutPage()),
                "\nPrice per month on Training page is:" + " " + variablePricePerMonthOnTrainingPage +
                "\nPrice per month on CheckoutPage is:" + " " + checkOutPage.pricePerMonthOnCheckOutPage());


        checkOutPage.enterDataUnregisterClient("Вася", "Егоров"
                , new Date().getTime() + "@scsc.csc"
                ,"+7999111").chooseAnotherPaymentTypeAndSubmit();

        Assert.assertTrue(variablePricePerMonthOnTrainingPage.equals(maxKassa
                        .priceTitleOnSelectTypeOfPaymentOnMaxKassa()),"Price per month on Training page is:" + " "
                + variablePricePerMonthOnTrainingPage
                + "\nPrice title on select type of payment on MaxKassaPage is:" + " "
                +maxKassa.priceTitleOnSelectTypeOfPaymentOnMaxKassa());

        maxKassa.payViaBankCardOnMaxKassaClick();
        Assert.assertTrue(variablePricePerMonthOnTrainingPage.equals(maxKassa.priceTitleOnPayAbillOnMaxKassa())
                ,"Price per month on Training page is:" + " "
                        + variablePricePerMonthOnTrainingPage
                        + "\nPrice title on pay a bill on MaxKassaPage is:" + " "
                        +maxKassa.priceTitleOnPayAbillOnMaxKassa());

        maxKassa.makeSuccessPayAndGoToSite();
        paymentSuccessPage.linkgoToPersonalCabinetOnPaymentSuccessPageClick();

        Assert.assertTrue(variablePricePerMonthOnTrainingPage.equals(personalCabinet
                .threeColumnTotalPriceOnHistoryPageTableInTabMyOrdersInPersonalCabinet())
                , "Price per month on Training page is:" + " "
                + variablePricePerMonthOnTrainingPage
                +"\nPrice in tab My orders inside Personal cabinet is:" + " "
                + personalCabinet.threeColumnTotalPriceOnHistoryPageTableInTabMyOrdersInPersonalCabinet());

    }
}
