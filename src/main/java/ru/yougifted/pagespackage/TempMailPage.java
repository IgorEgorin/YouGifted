package ru.yougifted.pagespackage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TempMailPage {

    private SelenideElement copyMailFromDropMail;
    private SelenideElement firstLetterDropMail;
    private SelenideElement secondLetterDropMail;
    private SelenideElement resetLinkDropMail;

    public TempMailPage() {
        this.copyMailFromDropMail = $("#mail");
        this.firstLetterDropMail = $("[class=\"glyphicon glyphicon-chevron-right\"]",0);
        this.secondLetterDropMail = $("[class=\"glyphicon glyphicon-chevron-right\"]",1);
        this.resetLinkDropMail = $(By.xpath("//p/a[@href]"));
    }

    public String getCopyTextMail()
    {
        return copyMailFromDropMail.getValue();
    }

    public TempMailPage clickFirstLetterDropMail() {
        firstLetterDropMail.click();
        return new TempMailPage();
    }

    public TempMailPage clickSecondtLetterDropMail() {
        secondLetterDropMail.click();
        return new TempMailPage();
    }

    public TempMailPage clickResetLinkDropMail() {
        resetLinkDropMail.click();
        return new TempMailPage();
    }
}
