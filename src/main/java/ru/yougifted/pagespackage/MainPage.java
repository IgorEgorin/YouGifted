package ru.yougifted.pagespackage;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private SelenideElement logInButtonHeaderMainPage() {
        return $("[href=\"/login\"]");
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
}
