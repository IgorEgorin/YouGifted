package ru.yougifted.pagespackage;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.*;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SocialNetworksPage {


    private String varAgeQuiz = "24";
    private String varNameQuiz = "Александр";
    private String varNutritionSurname = "Иванов";
    private String varPhoneQuiz = "+79"+String.valueOf(new Random().nextInt(1234567890));
    private String varTrainProgMailQuiz = new Date().getTime() + "@gmaill.com";



    private String varMailForLoginVKandFacebook = "a78egorin@yandex.ru";
    private String varPasswordForLoginVKandFacebook = "0000aaBBc1";


    private String varNutrHeight = "178";
    private String varNutrWeight = "66";
    private String varNutrLevAct = "3";



    private SelenideElement facebookFieldMail;
    private SelenideElement facebookFieldPassword;
    private SelenideElement facebookSubmit;
    private SelenideElement vkFieldMail;
    private SelenideElement vkFieldPassword;
    private SelenideElement vkSubmit;
    private SelenideElement widgetTrainingProgActivateSocialNetworkPanel;
    private SelenideElement widgetTrainingProgLinkVK;
    private SelenideElement widgetTrainingProgLinkFacebook;



    public SocialNetworksPage() {
        this.facebookFieldMail = $("#email");
        this.facebookFieldPassword = $("#pass");
        this.facebookSubmit = $("[type=\"submit\"]");


        this.vkFieldMail = $(byName("email"));
        this.vkFieldPassword = $(byName("pass"));
        this.vkSubmit = $("#install_allow");


        this.widgetTrainingProgActivateSocialNetworkPanel = $("[data-register=\"2\"]",0);
        this.widgetTrainingProgLinkVK = $("[onclick=\"vkLoginRecommended();\"]");
        this.widgetTrainingProgLinkFacebook = $("[onclick=\"fbLoginRecommended();\"]");


    }

    public SocialNetworksPage logInViaFacebook(String faceMail, String facePass) {

        System.out.println("\nEnter login (Mail) on facebook tab");
        facebookFieldMail.sendKeys(faceMail);

        System.out.println("\nEnter password on facebook tab");
        facebookFieldPassword.sendKeys(facePass);

        System.out.println("\nSubmit form on facebook tab");
        facebookSubmit.click();

        return new SocialNetworksPage();
    }


    public SocialNetworksPage logInViaVK(String vkMail, String vkPass) {

        System.out.println("\nEnter login (Mail) on vk tab");
        vkFieldMail.sendKeys(vkMail);

        System.out.println("\nEnter password on vk tab");
        vkFieldPassword.sendKeys(vkPass);

        System.out.println("\nSubmit form on vk tab");
        vkSubmit.click();

        return new SocialNetworksPage();
    }


    private SocialNetworksPage trainingProgActivateSocialNetworkPanelAndClickVKlink() {
        widgetTrainingProgActivateSocialNetworkPanel.click();
        widgetTrainingProgLinkVK.click();
        return new SocialNetworksPage();
    }

    private SocialNetworksPage trainingProgActivateSocialNetworkPanelAndClickFacebookLink() {
        widgetTrainingProgActivateSocialNetworkPanel.click();
        widgetTrainingProgLinkFacebook.click();
        return new SocialNetworksPage();
    }




    public SocialNetworksPage chooseTypeOfRegistrWidgetTrainnigProg(String s) {
        switch (s) {
            case "YouGiftedForm":
                new QuizPage().registredViaYGclient(varNameQuiz, varPhoneQuiz
                        ,varTrainProgMailQuiz );

                break;
            case "VK":

                Selenide.open("http://yg111.testing.place/");
                new QuizPage().selectMaleFlexibilityCreateNewAccount(varAgeQuiz);

                System.out.println("\nClick on" + " " + s + "link");
                trainingProgActivateSocialNetworkPanelAndClickVKlink();
                caseVK(s);
                break;

            case "Facebook":

                System.out.println("\nClick on" + " " +  s + "link");

                trainingProgActivateSocialNetworkPanelAndClickFacebookLink();
                caseFacebook(s);
                break;

        }
        return new SocialNetworksPage();

    }


    public SocialNetworksPage chooseTypeOfRegistrWidgetNutritionProg(String s) {
        switch (s) {
            case "YouGiftedForm":
                new QuizPage().nutritionWidgetRegistrUsingYGpage(varNameQuiz,
                        varNutritionSurname, varTrainProgMailQuiz);

                break;
            case "VK":

                Selenide.open("http://yg111.testing.place/");
                new QuizPage().completeTestNutritionProg(
                        varAgeQuiz, varNutrHeight, varNutrWeight, varNutrLevAct);

                System.out.println("\nClick on" + " " + s + "link");
                new RegistrationPage().clickVKLinkOnAuthorizationPage();

                caseVK(s);
                break;

            case "Facebook":

                //03.10.2018 Auth and registration via Facebook havenot done

                System.out.println("\nClick on" + " " +  s + "link");

                new RegistrationPage().clickFacebookLinkOnAuthorizationPage();
                caseFacebook(s);
                break;

        }
        return new SocialNetworksPage();

    }


    public void caseVK(String s) {


        Set<String> handlesVK = getWebDriver().getWindowHandles();
        List<String> tabsVK = new ArrayList<>(handlesVK);
        switchTo().window(tabsVK.get(1));

        System.out.println("\nLogin via" + " " + s);

        new SocialNetworksPage().logInViaVK(varMailForLoginVKandFacebook
                , varPasswordForLoginVKandFacebook);

        System.out.println("\nLogin via" + " " + s + " " + "is done");
        switchTo().window(tabsVK.get(0));

    }


    public void caseFacebook(String s) {


        Set<String> handlesFacebook = getWebDriver().getWindowHandles();
        List<String> tabsFB = new ArrayList<>(handlesFacebook);
        switchTo().window(tabsFB.get(1));

        System.out.println("\nLogin via" + " " + s);

        new SocialNetworksPage().logInViaFacebook(varMailForLoginVKandFacebook
                , varPasswordForLoginVKandFacebook);

        System.out.println("\nLogin via" + " " + s + " " + "is done");
        switchTo().window(tabsFB.get(0));
    }

}
