package ru.yougifted.pagespackage;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class PersonalCabinetPage {

//    private SelenideElement manGenderFieldPersonalCabinet;
//    private SelenideElement womenGenderFieldPersonalCabinet;
//
//    public PersonalCabinetPage() {
//        this.manGenderFieldPersonalCabinet = manGenderFieldPersonalCabinet;
//        this.womenGenderFieldPersonalCabinet = womenGenderFieldPersonalCabinet;
//    }

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


    private SelenideElement nameFieldPersonalCabinet() {
        return $("#accountform_name");
    }

    private SelenideElement surnameFieldPersonalCabinet() {
        return $("#accountform_surname");
    }

    private SelenideElement mailFieldPersonalCabinet() {
        return $("#accountform_email");
    }

    private SelenideElement phoneFieldPersonalCabinet() {
        return $("#accountform_iu_telephone");
    }

    private SelenideElement birthDataFieldPersonalCabinet() {
        return $("#accountform_dob");
    }

    private SelenideElement heightFieldPersonalCabinet() {
        return $("#accountform_height");
    }

    private SelenideElement genderTablePersonalCabinet() {
        return $("#iu_gender");
    }

    private SelenideElement manGenderFieldPersonalCabinet() {
        return $("[value=\"male\"]");
    }

    private SelenideElement womenGenderPersonalCabinet() {
        return $("[value=\"female\"]");
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

    private SelenideElement logOutButtonPersonalCabinet() {
        return $("[class=\"button sing-in button-wrapper__button\"]");
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
        typeOfActivity(lvlOfActivity)
        changePasswordPersonalCabinet().click();
        newPasswordFieldPersonalCabinet().sendKeys(newAndConfPassword);
        confirmPasswordFieldPersonalCabinet().sendKeys(newAndConfPassword);
        saveChangesButtonPersonalCabinet().click();
        return new PersonalCabinetPage();
    }
}
