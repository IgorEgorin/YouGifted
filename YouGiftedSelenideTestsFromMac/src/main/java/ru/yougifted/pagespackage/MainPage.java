package ru.yougifted.pagespackage;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {


    private SelenideElement takePriceFooterMainPageOneMonth;
    private SelenideElement footerMainPageSubscribeOneMonth;

    private SelenideElement linkSplitPackage;
    private SelenideElement buttonBuySplitPackage;
    private SelenideElement priceSplitPackage;

    private SelenideElement openAllProgramsOnMainPage;


    public MainPage() {
        this.takePriceFooterMainPageOneMonth = $("[class=\"subscribe-item-price\"]",0);
        this.footerMainPageSubscribeOneMonth = $("[href=\"/checkout?tariffs[]=1\"]",0);

        this.linkSplitPackage = $("[src=\"/storage/app/packages/package-10@2x.jpg\"]",1);
        this.buttonBuySplitPackage =
                $("[class=\"price-item-button price-item-button--pink\"] [href=\"/checkout?tariffs[]=19\"]");
        this.priceSplitPackage = $("[class=\"price-item-new\"]");

        this.openAllProgramsOnMainPage = $("[class=\"js-packages-load button\"]");
    }

    public String textPriceFooterMainPageOneMonth() {
        return takePriceFooterMainPageOneMonth.getText()
                .replaceAll(" р.", "");
    }

    public SelenideElement scrollToFooterMainPageSubscribeOneMonth() {
        return footerMainPageSubscribeOneMonth.scrollTo();
    }


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


    public MainPage clickLinkSplitPackage() {
        linkSplitPackage.click();
        return new MainPage();
    }

    public MainPage clickButtonBuySplitPackage() {
        buttonBuySplitPackage.click();
        return new MainPage();

    }

    public MainPage clickOnButtonOpenAllTrainingProgramsOnMainPage() {
        openAllProgramsOnMainPage.click();
        return new MainPage();

    }



    public String priceSplitPackage() {
        return priceSplitPackage.getText();
    }

}
