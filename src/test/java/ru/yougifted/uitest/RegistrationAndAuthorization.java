package ru.yougifted.uitest;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yougifted.helperpackage.CsvDataProvider;
import ru.yougifted.helperpackage.PreconditionTestNG;
import ru.yougifted.pagespackage.MainPage;

import java.util.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class RegistrationAndAuthorization extends PreconditionTestNG {






    @Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class)
    public void creatingNewUserAndThenLogInByYGpage(Map<String, String> testData) throws Exception {


        String varUrlTempMailService = "https://dropmail.me/ru/";

        String varName = testData.get("nameFromCsv");
        String varSurName = testData.get("surnameFromCsv");
        String varPhone = "+79"+String.valueOf(new Random().nextInt(1234567890));


        mainPage.clickOnRegistrationButtonInHeaderOnMainPage();

        System.out.println("\nGo to registration page\n");

        registrationPage.clickOnLinkUserAgreement();


        Set<String> handles = getWebDriver().getWindowHandles();
        List<String> tabs = new ArrayList<>(handles);
        switchTo().window(tabs.get(1));
        Selenide.open(varUrlTempMailService);

        System.out.println("\nSwitch to second tab and open temp mail page\n");


        String varMailFromTempPage = dropMailPage.getCopyMailAdressFromDropMailPage();

        System.out.println("\nCopy temp mail from temp page\n");

        switchTo().window(tabs.get(0));

        System.out.println("\nSwitch on first tab and enter data on registration page\n");

        registrationPage.enterDataNameSurnamePhoneMailAndSubmitOnRegistrationPage(varName, varSurName,
                varMailFromTempPage, varPhone);

        System.out.println("\nOpen user cabinet\n");

        tabEditProfile.logOutButtonPersonalCabinetClick();

        System.out.println("\nClose user cabinet\n");

        switchTo().window(tabs.get(1));

        System.out.println("\nSwitch to second tab and take a password from temp mail page\n");

        String passwordFromMail = $(By
                .xpath("//pre[contains(text(), \"Здравствуйте\")]")).getText()
                .replace("Здравствуйте, "+varName+"!\n\n"
                                +"Ваш Личный Кабинет на Yougifted активирован.\n" +
                                "\nДля входа используйте ссылку: "
                                +dropMailPage.linkForLogInUseThisLink()+"\n\nВаш логин: "
                        +varMailFromTempPage+"\n"+"Ваш пароль: "
                        ,"").replace("\nЕсли Вы уже купили подписку или пакеты тренировок, они станут доступны в разделе:"
                                ,"").replace(dropMailPage.linkIfYouAlreadyBoughtSubsribe(),"").
                replace("\n--","").replace("С уважением,","").
                replace("Администрация Yougifted.ru","");


        switchTo().window(tabs.get(0));

        System.out.println("\nSwitch on first tab\n");


        new MainPage().clickLogInButtonHeaderMainPage();


        System.out.println("\nGo to log in page\n");

        logInPage.enterMailAndPassAndSubmit(varMailFromTempPage,passwordFromMail);


        System.out.println("\nEnter mail and password from temp page\n");


        personalCabinetPage.editProfileButtonInPersonalCabinetClick();

        System.out.println("\nGo to edit profile tab inside personal cabinet\n");

        System.out.println("\nAssert. Name field equals variable from test method\n");

        Assert.assertTrue(personalCabinetPage.getAttributeNameFieldPersonalCabinet().equals(varName)
                ,"\nName in field does not correct");

        System.out.println("\nAssert. Surname field equals variable from test method\n");


        Assert.assertTrue(personalCabinetPage.getAttributeSurnameFieldPersonalCabinet().equals(varSurName)
                ,"\nSurname in field does not correct");

        System.out.println("\nAssert. Mail field equals mail from temp mail page\n");

        Assert.assertTrue(personalCabinetPage.getAttributeMailFieldPersonalCabinet().equals(varMailFromTempPage)
                ,"\nMail in field does not correct");


    }


    @Test
    public void newUserRegistrationByFacebook() throws Exception{


        System.out.println("\nOpen registration page");
        mainPage.clickOnRegistrationButtonInHeaderOnMainPage();


        System.out.println("\nOpen facebook tab");
        registrationPage.openFacebookTab();

        socialNetworksPage.caseFacebook("Facebook");

        assertLogOutButtonExist();

    }



    @Test
    public void newUserLogInUsingFacebook() throws Exception{


        System.out.println("\nOpen authorization page");
        mainPage.clickLogInButtonHeaderMainPage();

        System.out.println("\nOpen facebook tab");
        registrationPage.clickFacebookLinkOnAuthorizationPage();

        socialNetworksPage.caseFacebook("Facebook");

        assertLogOutButtonExist();

    }




    @Test
    public void newUserRegistrationByVkontakte() throws Exception{


        System.out.println("\nEnter URL 'http://yg111.testing.place/'");
        Selenide.open("http://yg111.testing.place/");

        System.out.println("\nOpen registration page");
        mainPage.clickOnRegistrationButtonInHeaderOnMainPage();


        System.out.println("\nOpen VK tab");
        registrationPage.openVKTab();

        socialNetworksPage.caseVK("VK");


        assertLogOutButtonExist();

    }


    @Test
    public void newUserLogInUsingVkontakte() throws Exception{


        System.out.println("\nEnter URL 'http://yg111.testing.place/'");
        Selenide.open("http://yg111.testing.place/");

        mainPage.clickLogInButtonHeaderMainPage();

        registrationPage.clickVKLinkOnAuthorizationPage();

        socialNetworksPage.caseVK("VK");

        assertLogOutButtonExist();

    }





    private void assertLogOutButtonExist() {

        System.out.println("\nOpen personal cabinet");

        System.out.println("\nAssert. Personal cabinet is opened (Log out button is displayed)");

        Assert.assertTrue(tabEditProfile.logOutButtonPersonalCabinet().exists()
                ,"LogOut button does not exist");

        tabEditProfile.logOutButtonPersonalCabinetClick();

        System.out.println("\nPush log out button\n");

    }



}
