package ru.yougifted.pagespackage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
public class DropMailPage {

    private SelenideElement copyMailAdressFromDropMailPage;
    private SelenideElement linkFromRecoveryDropMailPage;


    public DropMailPage( ) {
        this.copyMailAdressFromDropMailPage = $("[class=\"email\"]");
        this.linkFromRecoveryDropMailPage = $(By.xpath("//pre[contains(text(), \"Здравствуйте \")]/a"));
    }

    public String getCopyMailAdressFromDropMailPage() {
        return copyMailAdressFromDropMailPage.getText();
    }

    public DropMailPage clickLinkFromRecoveryDropMailPage() {
        linkFromRecoveryDropMailPage.click();
        return new DropMailPage();
    }

    public String linkForLogInUseThisLink() {
        return $("[target=\"_blank\"]",4)
                .getText();
    }

    public String linkIfYouAlreadyBoughtSubsribe() {
        return $("[target=\"_blank\"]",5)
                .getText();
    }

}
