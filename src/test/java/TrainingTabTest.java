import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yougifted.helperpackage.Precondition;

import java.util.Date;

import static com.codeborne.selenide.Selenide.$;

public class TrainingTabTest extends Precondition {

    @Test
    public void testName() throws Exception {
        //00000000082018

        String varName = "Александр";
        String varSurname = "Владимиров";
        String varPhone = "+79997777777";
        String varMail = new Date().getTime() + "@csc.csc";

        mainPage.clickOnRegistrationButtonInHeaderOnMainPage();

        registrationPage.enterDataNameSurnamePhoneMailAndSubmitOnRegistrationPage(
                varName, varSurname, varMail, varPhone);



        System.out.println("\nCheck that Done button is red");


        Thread.sleep(5555555);
        Assert.assertTrue(tabTraining.checkColorButtonDoneRedAndEnableToPushOnTabTraining().exists()
                ,"Red button does not found");

//        Thread.sleep(500000);

        tabTraining.buttonDoneTabTrainingClick();

        Selenide.refresh();

        System.out.println("\nReload page");

        System.out.println("\nCheck that Done button is grey and it disable to push");

        Assert.assertTrue(tabTraining.checkColorButtonDoneGreyAndDisableToPushTabTraining().exists());

        System.out.println("\nCheck text under grey button that today you have already finished your exercises");

        System.out.println("\nText under grey button is:\n" + tabTraining.tabTrainingTextTodayYouAreCompletedYourTraining());

//        Assert.assertTrue(tabTraining.tabTrainingTextTodayYouAreCompletedYourTraining());


    }

}
