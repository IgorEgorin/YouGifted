package ru.yougifted.pagespackage;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.$;

public class PersonalCabinetPage {

    private SelenideElement editProfileButton() {
        return $("[href=\"/account/edit\"]");
    }

    public String firstColumnOnHistoryPageTableInTabMyOrdersInPersonalCabinet() {
        return $("[class=\"no-hover\"]",0).getText();
    }

    public String threeColumnTotalPriceOnHistoryPageTableInTabMyOrdersInPersonalCabinet() {
        return $("[class=\"no-hover\"]",2).getText().replaceAll(",","")
                .replaceAll(" руб.","");
    }

    public PersonalCabinetPage editProfileButtonInPersonalCabinetClick() {
        editProfileButton().click();
        return new PersonalCabinetPage();
    }


    public SelenideElement nameFieldPersonalCabinet() {
        return $("#accountform_name");
    }

    public String getAttributeNameFieldPersonalCabinet() {
        return nameFieldPersonalCabinet().attr("value");
    }

    public String getAttributeSurnameFieldPersonalCabinet() {
        return surnameFieldPersonalCabinet().attr("value");
    }

    public String getAttributeMailFieldPersonalCabinet() {
        return mailFieldPersonalCabinet().attr("value");
    }

    public String getAttributePhoneFieldPersonalCabinet() {
        return phoneFieldPersonalCabinet().attr("value");
    }

    public String getAttributeBirthFieldPersonalCabinet() {
        return birthDataFieldPersonalCabinet().attr("value");
    }

    public String getAttributeHeightFieldPersonalCabinet() {
        return heightFieldPersonalCabinet().attr("value");
    }

    public SelenideElement surnameFieldPersonalCabinet() {
        return $("#accountform_surname");
    }

    public SelenideElement mailFieldPersonalCabinet() {
        return $("#accountform_email");
    }

    public SelenideElement phoneFieldPersonalCabinet() {
        return $("#accountform_iu_telephone");
    }

    public SelenideElement birthDataFieldPersonalCabinet() {
        return $("#accountform_dob");
    }

    public SelenideElement heightFieldPersonalCabinet() {
        return $("#accountform_height");
    }

    public LogInPage setFemaleGenderPersonalCabinet() {
        genderTablePersonalCabinet().click();
        womenGenderPersonalCabinet().click();
        return new LogInPage();
    }

    public LogInPage setMaleGenderPersonalCabinet() {
        genderTablePersonalCabinet().click();
        manGenderFieldPersonalCabinet().click();
        return new LogInPage();
    }

    public LogInPage setNotSpecifiedGenderInPersonalCabinet() {
        genderTablePersonalCabinet().click();
        notSpecifiedGenderPersonalCabinet().click();
        return new LogInPage();
    }

    public String getSavingAttributeOfGender() {
        return  $(By.xpath("//option[@selected]")).getText();
    }

    private SelenideElement genderTablePersonalCabinet() {
        return $(By.name("iu_gender"));
    }

    private SelenideElement manGenderFieldPersonalCabinet() {
        return $("[value=\"male\"]");
    }

    public SelenideElement womenGenderPersonalCabinet() {
        return $("[value=\"female\"]");
    }

    public SelenideElement notSpecifiedGenderPersonalCabinet() {
        return $("[value=\"unknown\"]");
    }

    private SelenideElement addPhotoButtonPersonalCabinet() {
        return $("#accountform_avatar");
    }

    public PersonalCabinetPage addPhotoInsidePersonalCabinetViaPath(String s) {
        addPhotoButtonPersonalCabinet().sendKeys(s);
        return new PersonalCabinetPage();
    }

    public String getPathToSRCinPersonalCabinet() {
        return $(By.xpath("//div[@class=\"account__photo\"]/img")).attr("src");
    }

    private SelenideElement changePasswordPersonalCabinet() {
        return $("[class=\"btn btn-primary\"]");
    }

    private SelenideElement newPasswordFieldPersonalCabinet() {
        return $("#accountform_password");
    }

    private SelenideElement confirmPasswordFieldPersonalCabinet() {
        return $("#accountform_password_confirmation");
    }

    private SelenideElement saveChangesButtonPersonalCabinet() {
        return $("[class=\"button edit-button col-xs-6 col-sm-6 col-md-6 col-lg-6\"]");
    }

    public PersonalCabinetPage saveChangesButtonPersonalCabinetClick() {
        saveChangesButtonPersonalCabinet().click();
        return new PersonalCabinetPage();
    }

    private SelenideElement logOutButtonPersonalCabinet() {
        return $("[class=\"button sing-in button-wrapper__button\"]");
    }

    public LogInPage logOutButtonPersonalCabinetClick() {
        logOutButtonPersonalCabinet().click();
        return new LogInPage();
    }

    private PersonalCabinetPage genderType(String gender) {
        if (gender.contains("male")){
            genderTablePersonalCabinet().click();
            manGenderFieldPersonalCabinet().click();
        }
        if (gender.contains("female")){
            genderTablePersonalCabinet().click();
            womenGenderPersonalCabinet().click();
        }
        return new PersonalCabinetPage();
    }

    private PersonalCabinetPage typeOfActivity(String fromOneToFour) {
        switch (fromOneToFour) {
            case "1":
                $("div[class^='slider-tick round']", 0).click();
                break;
            case "2":
                $("div[class^='slider-tick round']", 1).click();
                break;
            case "3":
                $("div[class^='slider-tick round']", 2).click();
                break;
            case "4":
                $("div[class^='slider-tick round']", 3).click();
                break;

        }
        return new PersonalCabinetPage();
    }

    public PersonalCabinetPage setNewDataOnEditTabOnPersonalCabinetPage(
            String name, String surname, String mail, String phone, String birth, String height,
            String gender, String lvlOfActivity, String newAndConfPassword) {

        nameFieldPersonalCabinet().sendKeys(name);
        surnameFieldPersonalCabinet().sendKeys(surname);
        mailFieldPersonalCabinet().sendKeys(mail);
        phoneFieldPersonalCabinet().sendKeys(phone);
        birthDataFieldPersonalCabinet().sendKeys(birth);
        heightFieldPersonalCabinet().sendKeys(height);
        genderType(gender);
        typeOfActivity(lvlOfActivity);
        changePasswordPersonalCabinet().click();
        newPasswordFieldPersonalCabinet().sendKeys(newAndConfPassword);
        confirmPasswordFieldPersonalCabinet().sendKeys(newAndConfPassword);
        saveChangesButtonPersonalCabinet().click();
        return new PersonalCabinetPage();
    }

    public PersonalCabinetPage createAndFullFillDataAboutNewUser(){
        return new PersonalCabinetPage();
    }
}
