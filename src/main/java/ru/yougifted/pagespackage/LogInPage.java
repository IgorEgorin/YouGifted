package ru.yougifted.pagespackage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LogInPage {

    private SelenideElement enterMailOnLogInPage() {
        return $(By.name("login"));
    }

    private SelenideElement enterPasswordOnLogInPage() {
        return $(By.name("password"));
    }

    private SelenideElement submitButtonOnLogInPage() {
        return $("[type=\"submit\"]");
    }

    public PersonalCabinetPage enterDataOnLogInPageAndPressSubmit(String mail, String password) {
        new MainPage().clickLogInButtonHeaderMainPage();
        enterMailOnLogInPage().sendKeys(mail);
        enterPasswordOnLogInPage().sendKeys(password);
        submitButtonOnLogInPage().click();
        return new PersonalCabinetPage();
    }


}
