package ru.yougifted.pagespackage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TabTraining {

    public TabTraining tabTrainingClick() {
        $("[href=\"/personal/training\"]").click();
        return new TabTraining();
    }

    public TabTraining buttonDoneTabTrainingClick() {
        $("#base-done-button").click();
        return new TabTraining();
    }

    public SelenideElement checkColorButtonDoneRedAndEnableToPushOnTabTraining() {
        return $("[data-undone=\"1\"]",0);
    }

    public SelenideElement checkColorButtonDoneGreyAndDisableToPushTabTraining() {
        return $("[class=\"button button-traning button-traning__noabsolute\"][disabled]",0);
    }

    public String tabTrainingTextTodayYouAreCompletedYourTraining() {
        return $("[style=\"margin-bottom: 1em\"]").getText();
    }

    public TabTraining clickOnDayTwoOnTabTraining() {
        $(By.xpath("//a[@href and contains (text(), '2')]")).click();
        return new TabTraining();
    }

    public TabTraining clickLikeButtonOnTabTraining() {
        $("[class=\"like-icon\"]",0).click();
        return new TabTraining();
    }

    public TabTraining checkLikeButtonBlueColorOnTabTraining() {
        $("[class=\"like-icon pressed\"]",0);
        return new TabTraining();
    }

    public TabTraining clickDislikeButtonOnTabTraining() {
        $("[class=\"dislike-icon\"]").click();
        return new TabTraining();
    }

    public TabTraining checkDislikeButtonRedColorOnTabTraining() {
        $("[class=\"dislike-icon pressed\"]");
        return new TabTraining();
    }


    public TabTraining clickAddToFavoritesButtonOnTabTraining() {
        $("[class=\"favorite-icon\"]",0).click();
        return new TabTraining();
    }

    public TabTraining checkAddToFavoritesYellowColorButtonOnTabTraining() {
        $("[src=\"http://yg640.testing.place/themes/yougifted/assets/be-better/img/star2.png\"]",0);
        return new TabTraining();
    }



}
