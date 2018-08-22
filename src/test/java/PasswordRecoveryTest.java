import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;
import ru.yougifted.helperpackage.Precondition;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class PasswordRecoveryTest extends Precondition {

    @Test
    public void passwordRecovery() throws Exception{

        String varUrlTempMailService = "https://temp-mail.org/ru/";

        String varNewPasswordOnRecoveryPage = "0000aabb";

        String varName = "Александр";
        String varSurName = "Иванов";
        String varPhone = "+79996655664";


        mainPage.clickOnRegistrationButtonInHeaderOnMainPage();
        registrationPage.ClickOnLinkUserAgreement();

        Set<String> handles = getWebDriver().getWindowHandles();
        List<String> tabs = new ArrayList<>(handles);
        switchTo().window(tabs.get(1));
        Selenide.open(varUrlTempMailService);
        String varMailFromTempPage = tempMailPage.getCopyTextMail();

        switchTo().window(tabs.get(0));
        registrationPage.enterDataNameSurnamePhoneMailAndSubmitOnRegistrationPage(varName, varSurName,
                varMailFromTempPage, varPhone);


        tabEditProfile.logOutButtonPersonalCabinetClick();

        mainPage.clickLogInButtonHeaderMainPage();

        logInPage.linkForgetPasswordClick().enterRecoveryPageMailField(varMailFromTempPage).
                clickButtonRecoveryPageResetPassword();

        switchTo().window(tabs.get(1));

        tempMailPage.clickSecondtLetterDropMail().clickResetLinkDropMail();



        Set<String> handlesAfterOpenRecoveryLink = getWebDriver().getWindowHandles();
        List<String> tabsAfterOpenRecoveryLink = new ArrayList<>(handlesAfterOpenRecoveryLink);



        switchTo().window(tabsAfterOpenRecoveryLink.get(2));

        logInPage.fieldEnterNewPasswordOnRecoveryPageAndSubmit(varNewPasswordOnRecoveryPage)
                .clickLinkGoToLogInPageThroughRecoveryPage();

        logInPage.enterNewMailAndPassAfterRecoveryAndSubmit(varMailFromTempPage,
                varNewPasswordOnRecoveryPage);

        tabEditProfile.logOutButtonPersonalCabinetClick();

    }
}
