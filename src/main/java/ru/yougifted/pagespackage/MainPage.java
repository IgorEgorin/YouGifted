package ru.yougifted.pagespackage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public SelenideElement youGiftedLogoOnMainPage() {
        return $("[class=\"header-logo\"]");
    }

    private SelenideElement logInButtonHeaderMainPage() {
        return $("[href=\"/login\"]");
    }

    public MainPage clickOnRegistrationButtonInHeaderOnMainPage() {
        $("[href=\"/register\"]").click();
        return new MainPage();
    }

    private SelenideElement newLifeFirstStageImgOnMainPage() {
        return $("[class=\"packages-item-button\"] [href=\"/packages/newlife\"]",1);
    }

    public MainPage newLifeFirstStageImgOnMainPageAndClick() {
        newLifeFirstStageImgOnMainPage().click();
        return new MainPage();
    }

    public void clickLogInButtonHeaderMainPage() {
        logInButtonHeaderMainPage().click();
    }

    public void openNewTabOnMainPage() {
        youGiftedLogoOnMainPage().sendKeys(Keys.LEFT_CONTROL + "T");
    }
}
