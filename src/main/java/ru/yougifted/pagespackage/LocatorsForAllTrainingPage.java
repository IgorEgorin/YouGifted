package ru.yougifted.pagespackage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LocatorsForAllTrainingPage {

    private SelenideElement choiceTwelveMonthSubscriptionOnTrainingPage() {
        return $(By.xpath("//div[@class='price-subscribe-duration' and contains (text(), \"12\")]"));
    }

    private SelenideElement buttonBuyASubscriptionOnTrainingPage() {
        return $("#sub_checkout_link");
    }


    public LocatorsForAllTrainingPage clickOnTwelveMonthSubscription() {
        choiceTwelveMonthSubscriptionOnTrainingPage().click();
        return new LocatorsForAllTrainingPage();
    }

    public LocatorsForAllTrainingPage buttonBuyASubscriptionOnTrainingPageClick() {
        buttonBuyASubscriptionOnTrainingPage().click();
        return new LocatorsForAllTrainingPage();
    }


}
