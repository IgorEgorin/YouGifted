import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yougifted.helperpackage.Precondition;

import java.util.Date;

public class PaymentTest extends Precondition {

    @Test
    public void successPay() throws Exception{
        mainPage.newLifeFirstStageImgOnMainPageAndClick();
        locatorsForAllTrainingPage.clickOnTwelveMonthSubscription()
                .buttonBuyASubscriptionOnTrainingPageClick();

        String variablePricePerMonthOnCheckOutPage = checkOutPage.pricePerMonthOnCheckOutPage();

        checkOutPage.enterDataUnregisterClient("Вася", "Егоров"
                , new Date().getTime() + "@scsc.csc"
                ,"+7999111").chooseAnotherPaymentTypeAndSubmit();

        Assert.assertTrue(variablePricePerMonthOnCheckOutPage.equals(maxKassa
                        .priceTitleOnSelectTypeOfPaymentOnMaxKassa()),"Price on CheckOutPage is:" + " "
                + variablePricePerMonthOnCheckOutPage
                + "\nPrice title on select type of payment on MaxKassaPage is:" + " "
                +maxKassa.priceTitleOnSelectTypeOfPaymentOnMaxKassa());

        maxKassa.payViaBankCardOnMaxKassaClick();
        Assert.assertTrue(variablePricePerMonthOnCheckOutPage.equals(maxKassa.priceTitleOnPayAbillOnMaxKassa())
                ,"Price on CheckOutPage is:" + " "
                        + variablePricePerMonthOnCheckOutPage
                        + "\nPrice title on pay a bill on MaxKassaPage is:" + " "
                        +maxKassa.priceTitleOnPayAbillOnMaxKassa());

        maxKassa.makeSuccessPayAndGoToSite();
        paymentSuccessPage.linkgoToPersonalCabinetOnPaymentSuccessPageClick();

        Assert.assertTrue(variablePricePerMonthOnCheckOutPage.equals(personalCabinet
                .threeColumnTotalPriceOnHistoryPageTableInTabMyOrdersInPersonalCabinet())
                , "Price on CheckOutPage is:" + " "
                + variablePricePerMonthOnCheckOutPage
                +"\nPrice in tab My orders inside Personal cabinet is:" + " "
                + personalCabinet.threeColumnTotalPriceOnHistoryPageTableInTabMyOrdersInPersonalCabinet());

    }
}
