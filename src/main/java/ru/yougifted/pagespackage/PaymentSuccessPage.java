package ru.yougifted.pagespackage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class PaymentSuccessPage {

    private SelenideElement linkgoToPersonalCabinetonPaymentSuccessPage() {
        return $("[href=\"/personal/payed\"]");
    }

    public void linkgoToPersonalCabinetOnPaymentSuccessPageClick() {
        linkgoToPersonalCabinetonPaymentSuccessPage().shouldBe(Condition.visible).click();
    }
}
