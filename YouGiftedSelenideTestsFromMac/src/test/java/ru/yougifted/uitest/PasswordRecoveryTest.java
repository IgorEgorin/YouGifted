package ru.yougifted.uitest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yougifted.helperpackage.PreconditionTestNG;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class PasswordRecoveryTest extends PreconditionTestNG {

    @Test
    public void passwordRecovery() throws Exception{

        String varUrlTempMailService = "https://dropmail.me/ru/";

        String varNewPasswordOnRecoveryPage = "0000aabb";

        String varName = "Александр";
        String varSurName = "Иванов";
        String varPhone = "+79"+String.valueOf(new Random().nextInt(1234567890));


        mainPage.clickOnRegistrationButtonInHeaderOnMainPage();

        System.out.println("\nGo to registration page\n");

        registrationPage.clickOnLinkUserAgreement();

        System.out.println("\nOpen second tab\n");

        Set<String> handles = getWebDriver().getWindowHandles();
        List<String> tabs = new ArrayList<>(handles);
        switchTo().window(tabs.get(1));
        Selenide.open(varUrlTempMailService);

        System.out.println("\nOpen temp mail page\n");

        String varMailFromTempPage = dropMailPage.getCopyMailAdressFromDropMailPage();

        System.out.println("\nCopy temp mail address\n");

        switchTo().window(tabs.get(0));

        System.out.println("\nSwitch to registration page\n");

        registrationPage.enterDataNameSurnamePhoneMailAndSubmitOnRegistrationPage(varName, varSurName,
                varMailFromTempPage, varPhone);

        System.out.println("\nOpen personal cabinet page\n");

        tabEditProfile.logOutButtonPersonalCabinetClick();

        System.out.println("\nPush log out button\n");

        mainPage.clickLogInButtonHeaderMainPage();

        System.out.println("\nOpen log in page\n");

        logInPage.linkForgetPasswordClick()
                .enterRecoveryPageMailField(varMailFromTempPage)
                .clickButtonRecoveryPageResetPassword();

        System.out.println("\nClick on link FORGET A PASSWORD, paste mail address and push submit button\n");

        switchTo().window(tabs.get(1));

        System.out.println("\nSwitch to temp mail page\n");

        dropMailPage.clickLinkFromRecoveryDropMailPage();

        System.out.println("\nClick on recovery link on temp mail page\n");

        Set<String> handlesAfterOpenRecoveryLink = getWebDriver().getWindowHandles();
        List<String> tabsAfterOpenRecoveryLink = new ArrayList<>(handlesAfterOpenRecoveryLink);

        switchTo().window(tabsAfterOpenRecoveryLink.get(2));


        logInPage.fieldEnterNewPasswordOnRecoveryPageAndSubmit(varNewPasswordOnRecoveryPage)
                .clickLinkGoToLogInPageThroughRecoveryPage();


        System.out.println("\nEnter new password on recovery page and submit\n");

        logInPage.enterMailAndPassAndSubmit(varMailFromTempPage
                , varNewPasswordOnRecoveryPage);

        System.out.println("\nGo to log in page, enter mail and new recovery password" +
                ", click submit button\n");

        tabEditProfile.logOutButtonPersonalCabinet().shouldBe(Condition.exist);



        System.out.println("\nAssert. Personal cabinet is opened (Log out button is displayed)\n");

        Assert.assertTrue(tabEditProfile.logOutButtonPersonalCabinet().exists()
                ,"LogOut button does not exist");

        tabEditProfile.logOutButtonPersonalCabinetClick();

        System.out.println("\nPush log out button\n");

    }
}
