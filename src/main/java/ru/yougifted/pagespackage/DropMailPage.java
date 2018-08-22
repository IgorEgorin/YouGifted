package ru.yougifted.pagespackage;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class DropMailPage {

    private SelenideElement copyMailAdressFromDropMailPage;

    public DropMailPage( ) {
        this.copyMailAdressFromDropMailPage = $("[class=\"email\"]");
    }

    public String getCopyMailAdressFromDropMailPage() {
        return copyMailAdressFromDropMailPage.getText();
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
