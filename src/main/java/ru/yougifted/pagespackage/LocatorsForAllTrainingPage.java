package ru.yougifted.pagespackage;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LocatorsForAllTrainingPage {

    public SelenideElement priceTwelveMonthSubscriptionOnTrainingPage() {
        return $("[class=\"price-subscribe-value\"]",2);
    }

    private SelenideElement buttonBuyASubscriptionOnTrainingPage() {
        return $("#sub_checkout_link");
    }


    public LocatorsForAllTrainingPage clickOnTwelveMonthSubscription() {
        priceTwelveMonthSubscriptionOnTrainingPage().click();
        return new LocatorsForAllTrainingPage();
    }

    public LocatorsForAllTrainingPage buttonBuyASubscriptionOnTrainingPageClick() {
        buttonBuyASubscriptionOnTrainingPage().click();
        return new LocatorsForAllTrainingPage();
    }


}
