package ru.yougifted.pagespackage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

public class QuizPage {

    private SelenideElement trainProgTableOnMainPage;
    private SelenideElement trainProgSelectMaleGenderOnQuizPage;
    private SelenideElement trainProgFieldEnterAgeOnQuizPage;
    private SelenideElement trainProgSubmitQuizPage;
    private SelenideElement trainProgSubmitAfterLevelOfActivityQuizPage;
    private SelenideElement trainProgLevelOfActivityThreeQuizPage;
    private SelenideElement trainProgGoalIncreaseFlexibilityQuizPage;
    private SelenideElement trainProgFieldNameQuizPage;
    private SelenideElement trainProgFieldPhoneQuizPage;
    private SelenideElement trainProgFieldMailQuizPage;
    private SelenideElement trainProgCaptchaQuizPage;
    private SelenideElement trainProgChkBoxIagreeQuizPage;
    private SelenideElement trainProgRegistrationSubmitButtonQuizPage;


    private SelenideElement nutritionProgTableOnMainPage;
    private SelenideElement nutritionProgSelectMaleGenderOnQuizPage;
    private SelenideElement nutritionProgFieldEnterAgeOnQuizPage;
    private SelenideElement nutritionProgNextAgeQuizPage;
    private SelenideElement nutritionProgFieldEnterHeightOnQuizPage;
    private SelenideElement nutritionProgNextHeightQuizPage;
    private SelenideElement nutritionProgFieldEnterWeightOnQuizPage;
    private SelenideElement nutritionProgNextWeightQuizPage;
    private SelenideElement nutritionProgNextLevOfActQuizPage;


    private SelenideElement nutritionProgFieldName;
    private SelenideElement nutritionProgFieldSurname;
    private SelenideElement nutritionProgFieldMail;
    private SelenideElement nutritionProgCaptcha;
    private SelenideElement nutritionProgSubmitForm;




    public QuizPage() {
        this.trainProgTableOnMainPage = $("[class=\"widget-step active\"]");
        this.trainProgSelectMaleGenderOnQuizPage = trainProgTableOnMainPage
                .$("[class=\"widget-gender-icon widget-gender-icon--male\"]");
        this.trainProgFieldEnterAgeOnQuizPage = trainProgTableOnMainPage
                .$("#widget-age");
        this.trainProgSubmitQuizPage = trainProgTableOnMainPage
                .$("[class=\"widget-age-button widget-age-item\"]");
        this.trainProgSubmitAfterLevelOfActivityQuizPage =
                $("[class=\"widget-step active\"] [href=\"javascript:void(0)\"]");
        this.trainProgLevelOfActivityThreeQuizPage = trainProgTableOnMainPage.
                $("[class=\"widget-level-icon widget-level-icon-3\"]");
        this.trainProgGoalIncreaseFlexibilityQuizPage = trainProgTableOnMainPage.
                $("[class=\"widget-target-icon widget-target-icon-3\"]");
        this.trainProgFieldNameQuizPage = trainProgTableOnMainPage.$(byName("name"));
        this.trainProgFieldPhoneQuizPage = trainProgTableOnMainPage.$(byName("phone"));
        this.trainProgFieldMailQuizPage = trainProgTableOnMainPage.$(byName("email"));
        this.trainProgCaptchaQuizPage = $("#Recaptcha4");
        this.trainProgChkBoxIagreeQuizPage = $("[class=\"widget-checkbox\"]");
        this.trainProgRegistrationSubmitButtonQuizPage = $("[class=\"widget-register-button\"]");
        this.nutritionProgTableOnMainPage = $("#stepsForm");

        this.nutritionProgSelectMaleGenderOnQuizPage =
                nutritionProgTableOnMainPage.$("[class=\"form-icon form-icon-man\"]");

        this.nutritionProgFieldEnterAgeOnQuizPage =
                nutritionProgTableOnMainPage.$("#age");

        this.nutritionProgNextAgeQuizPage = nutritionProgTableOnMainPage.
                $(By.xpath("//div[@class=\"form-age-button form-button\"]/a"));

        this.nutritionProgFieldEnterHeightOnQuizPage =
                nutritionProgTableOnMainPage.$("#growth");

        this.nutritionProgNextHeightQuizPage = nutritionProgTableOnMainPage.
                $(By.xpath("//div[@class=\"form-growth-button form-button\"]/a"));

        this.nutritionProgFieldEnterWeightOnQuizPage =
                nutritionProgTableOnMainPage.$("#weight");


        this.nutritionProgNextWeightQuizPage = nutritionProgTableOnMainPage.
                $(By.xpath("//div[@class=\"form-weight-button form-button\"]/a"));

        this.nutritionProgNextLevOfActQuizPage = nutritionProgTableOnMainPage.
                $(By.xpath("//div[@class=\"form-active-button form-button\"]/a"));

        this.nutritionProgFieldName =
                nutritionProgTableOnMainPage.$(byName("name"));

        this.nutritionProgFieldSurname =
                nutritionProgTableOnMainPage.$(byName("surname"));

        this.nutritionProgFieldMail =
                nutritionProgTableOnMainPage.$(byName("email"));

        this.nutritionProgCaptcha =
                nutritionProgTableOnMainPage.$("#Recaptcha1");

        this.nutritionProgSubmitForm =
                nutritionProgTableOnMainPage.$("#stepsForm-submit");
    }


    public QuizPage registredViaYGclient(String quizName, String quizPhone,
                                         String quizMail) {

        System.out.println("\nClick on captcha");
        trainProgCaptchaQuizPage.click();

        System.out.println("\nEnter name:" + " " + quizName);
        trainProgFieldNameQuizPage.sendKeys(quizName);
        System.out.println("\nEnter phone:" + " " + quizPhone);
        trainProgFieldPhoneQuizPage.setValue(quizPhone);

        System.out.println("\nEnter mail:" + " " + quizMail);
        trainProgFieldMailQuizPage.sendKeys(quizMail);
        System.out.println("\nClick on checkbox 'I agree with conditions'");
        trainProgChkBoxIagreeQuizPage.click();
        System.out.println("\nClick on submit button");
        trainProgRegistrationSubmitButtonQuizPage.click();

        return new QuizPage();
    }


    public QuizPage selectMaleFlexibilityCreateNewAccount(String age) {

        System.out.println("\nSelect male gender");
        trainProgSelectMaleGenderOnQuizPage.click();
        System.out.println("\nEnter age:" + " " + age);
        trainProgFieldEnterAgeOnQuizPage.setValue(age);
        System.out.println("\nSubmit age");
        trainProgSubmitQuizPage.click();

        System.out.println("\nSelect and submit three level of activity");
        trainProgLevelOfActivityThreeQuizPage.click();
        System.out.println("\nSelect goal - 'Increasing of flexibility'");
        trainProgGoalIncreaseFlexibilityQuizPage.click();
        System.out.println("\nSubmit a goal");
        trainProgSubmitAfterLevelOfActivityQuizPage.click();


        return new QuizPage();
    }



    public QuizPage nutritionWidgetRegistrUsingYGpage(
            String nutrName, String nutrSurname, String nutrMail){


        System.out.println("\nClick on captcha");
        nutritionProgCaptcha.click();

        System.out.println("\nEnter name:" + " " + nutrName);
        nutritionProgFieldName.sendKeys(nutrName);

        System.out.println("\nEnter surname:" + " " + nutrSurname);
        nutritionProgFieldSurname.sendKeys(nutrSurname);

        System.out.println("\nEnter mail:" + " " + nutrMail);
        nutritionProgFieldMail.sendKeys(nutrMail);

        System.out.println("\nSubmit form");
        nutritionProgSubmitForm.click();
        return new QuizPage();
    }



    private QuizPage trainProgSelectLevelOfAct (String nutrLevAct) {
        switch (nutrLevAct) {
            case "1":
                $("[data-value=\"1\"]").click();
                break;
            case "2":
                $("[data-value=\"2\"]").click();
                break;
            case "3":
                $("[data-value=\"3\"]").click();
                break;
            case "4":
                $("[data-value=\"4\"]").click();
                break;

        }
        return new QuizPage();
    }


    public QuizPage completeTestNutritionProg(String nutrAge, String nutrHeight, String nutrWeight
            ,String nutrLevAct) {

        System.out.println("\nSelect male gender");
        nutritionProgSelectMaleGenderOnQuizPage.click();


        System.out.println("\nEnter age:" + " " + nutrAge);
        nutritionProgFieldEnterAgeOnQuizPage.sendKeys(nutrAge);
        nutritionProgNextAgeQuizPage.click();

        System.out.println("\nEnter height:" + " " + nutrHeight);
        nutritionProgFieldEnterHeightOnQuizPage.sendKeys(nutrHeight);
        nutritionProgNextHeightQuizPage.click();


        System.out.println("\nEnter weight:" + " " + nutrWeight);
        nutritionProgFieldEnterWeightOnQuizPage.sendKeys(nutrWeight);
        nutritionProgNextWeightQuizPage.click();


        System.out.println("\nSelect level of activity:" + " " + nutrLevAct);
        trainProgSelectLevelOfAct(nutrLevAct);
        nutritionProgNextLevOfActQuizPage.click();


        return new QuizPage();
    }


    public QuizPage completeTestTrainingProgram(String age) {

        System.out.println("\nSelect male gender");
        trainProgSelectMaleGenderOnQuizPage.click();
        System.out.println("\nEnter age:" + " " + age);
        trainProgFieldEnterAgeOnQuizPage.setValue(age);
        System.out.println("\nSubmit age");
        trainProgSubmitQuizPage.click();

        System.out.println("\nSelect and submit three level of activity");
        trainProgLevelOfActivityThreeQuizPage.click();
        System.out.println("\nSelect goal - 'Increasing of flexibility'");
        trainProgGoalIncreaseFlexibilityQuizPage.click();
        System.out.println("\nSubmit a goal");
        trainProgSubmitAfterLevelOfActivityQuizPage.click();


        return new QuizPage();
    }

}
