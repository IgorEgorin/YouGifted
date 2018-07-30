package ru.yougifted.pagespackage;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class PaymentSuccessPage {

    private SelenideElement linkgoToPersonalCabinetonPaymentSuccessPage() {
        return $("[class=\"center\"]");
    }

    public void linkgoToPersonalCabinetOnPaymentSuccessPageClick() {
        linkgoToPersonalCabinetonPaymentSuccessPage().click();
    }
}
