package ru.yougifted.pagespackage;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LocatorsForAllTabsInProfilePage {

    public SelenideElement youTubeLogo() {
        return $("#logo-icon-container");
    }
}
