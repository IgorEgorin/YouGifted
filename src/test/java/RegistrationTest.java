import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yougifted.helperpackage.CsvDataProvider;
import ru.yougifted.helperpackage.Precondition;

import java.util.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class RegistrationTest extends Precondition {

    @Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class)
    public void creatingNewUserAndThenLogIn(Map<String, String> testData) throws Exception {


        String varUrlTempMailService = "https://dropmail.me/ru/";

        String varName = testData.get("nameFromCsv");
        String varSurName = testData.get("surnameFromCsv");
        String varPhone = "+79996655664";

//        String varName = "Александр";
//        String varSurName = "Иванов";


        mainPage.clickOnRegistrationButtonInHeaderOnMainPage();
        registrationPage.ClickOnLinkUserAgreement();

        Set<String> handles = getWebDriver().getWindowHandles();
        List<String> tabs = new ArrayList<>(handles);
        switchTo().window(tabs.get(1));
        Selenide.open(varUrlTempMailService);
        String varMailFromTempPage = dropMailPage.getCopyMailAdressFromDropMailPage();

        switchTo().window(tabs.get(0));
        registrationPage.enterDataNameSurnamePhoneMailAndSubmitOnRegistrationPage(varName, varSurName,
                varMailFromTempPage, varPhone);


        tabEditProfile.logOutButtonPersonalCabinetClick();

        switchTo().window(tabs.get(1));

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

        logInPage.enterNewMailAndPassAfterRecoveryAndSubmit(varMailFromTempPage,passwordFromMail);

        personalCabinetPage.editProfileButtonInPersonalCabinetClick();

        Assert.assertTrue(personalCabinetPage.getAttributeNameFieldPersonalCabinet().equals(varName)
                ,"\nName in field does not correct");

        Assert.assertTrue(personalCabinetPage.getAttributeSurnameFieldPersonalCabinet().equals(varSurName)
                ,"\nSurname in field does not correct");

        Assert.assertTrue(personalCabinetPage.getAttributeMailFieldPersonalCabinet().equals(varMailFromTempPage)
                ,"\nMail in field does not correct");


    }



}
