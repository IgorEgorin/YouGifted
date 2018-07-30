package ru.yougifted.pagespackage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MaxKassaPage {

    private SelenideElement payViaBankCardOnMaxKassa() {
        return $("[alt=\"Visa\"]");
    }

    public void payViaBankCardOnMaxKassaClick() {
        payViaBankCardOnMaxKassa().click();
    }

    public String priceTitleOnSelectTypeOfPaymentOnMaxKassa() {
        return $(By.xpath("//div[@class=\"summ\"]/span")).getText().replaceAll(" ","")
                .replaceAll(".00руб.","");
    }

    private SelenideElement linkSendSuccessResultToSiteOnMaxKassa() {
        return $("[href=\"?state=demo_result\"]");
    }


    private SelenideElement linkGoToSuccessResultPageOnMaxKassa() {
        return $("[class=\"btn\"]",1);
    }


    public String priceTitleOnPayAbillOnMaxKassa() {
        return $("[class=\"info_val summ\"]").getText().replaceAll(" ","")
                .replaceAll(".00руб.","");
    }

    public void makeSuccessPayAndGoToSite() {
        linkSendSuccessResultToSiteOnMaxKassa().click();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        linkGoToSuccessResultPageOnMaxKassa().click();
    }
}
