package ru.yougifted.pagespackage;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

public class PaymentSmsPage {

    private SelenideElement priceFromSmsPage;
    private SelenideElement fieldPasswordSmsPage;
    private SelenideElement submitButtonSmsPage;


    public PaymentSmsPage() {
        this.priceFromSmsPage = $("[class=\"value\"]",1);
        this.fieldPasswordSmsPage = $(byName("password"));
        this.submitButtonSmsPage = $("[value=\"Submit\"]");
    }

    public PaymentSmsPage enterPasswordOnSmsPageAndSubmit(String passSmsPage) {
        fieldPasswordSmsPage.sendKeys(passSmsPage);
        submitButtonSmsPage.click();
        return new PaymentSmsPage();
    }

    public String getPriceFromSmsPage() {
        return priceFromSmsPage.getText().replace(" RUB", "").replace(",","" );
    }
}
