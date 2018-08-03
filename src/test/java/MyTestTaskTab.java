import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yougifted.helperpackage.Precondition;

import static com.codeborne.selenide.Selenide.$;

public class MyTestTaskTab extends Precondition {

    @Test
    public void editAmmountOfPushUp() throws Exception{

        String varAmmountPushUp = "8";
        String varVideoLinkPushUp = "https://vimeo.com/Push-up";
        String varDefaultAmmountPushUp = "2";
        String varDefaultVideoLinkPushUp = "https://Default.com/";

        logInPage.logInLikeTestUser();

        tabMyTestTasks.enterAmmountPushUpAndVideoLinkAndSave(varAmmountPushUp,varVideoLinkPushUp);

        Selenide.refresh();

        System.out.println("AssertTrueEquals that number of push ups does not change " +
                "after saving and refresh\n");

        Assert.assertTrue(varAmmountPushUp.equals(tabMyTestTasks.ammountOfPushUpField()),"" +
                "\nTest variable is:" + " " + varAmmountPushUp +
                "\nAmmount of pusp ups on tab is:" + " " + tabMyTestTasks.ammountOfPushUpField());

        System.out.println("Assert that push up video link is exist in html after saving and refresh\n");

        Assert.assertTrue($("[href=\""+varVideoLinkPushUp+"\"]").exists());

        tabEditProfile.
                logOutButtonPersonalCabinetClick().
                logInLikeTestUser();

        tabMyTestTasks
                .tabMyTestTaskLinkClick();

//        System.out.println("AssertTrueEquals that number of push ups does not change " +
//                "after logout\n");
//
//
//        Assert.assertTrue(varAmmountPushUp.equals(tabMyTestTasks.ammountOfPushUpField()),"" +
//                "\nTest variable is:" + " " + varAmmountPushUp +
//                "\nAmmount of pusp ups on tab is:" + " " + tabMyTestTasks.ammountOfPushUpField());
//
//
//        System.out.println("Assert that push up video link is exist in html after logout\n");
//
//        Assert.assertTrue($("[href=\""+varVideoLinkPushUp+"\"]").exists());
//
//        System.out.println("Test that pusp up link above diagram is clickable");
//
//        tabMyTestTasks.pushUpLinkAboveDiagramClick();

        System.out.println("\nSet default number and link in push up fields");

        tabMyTestTasks.enterAmmountPushUpAndVideoLinkAndSave(varDefaultAmmountPushUp,varDefaultVideoLinkPushUp);

        tabEditProfile.logOutButtonPersonalCabinetClick();


    }

    @Test
    public void editAmmountOfSquat() throws Exception{

        String varAmmountSquat = "12";
        String varVideoLinkSquat = "https://vimeo.com/Squat";
        String varDefaultAmmountSquat = "7";
        String varDefaultVideoLinkSquat = "https://DefaultSquat.com/";

        logInPage.logInLikeTestUser();

        tabMyTestTasks.enterAmmountSquatAndVideoLinkAndSave(varAmmountSquat, varVideoLinkSquat);

        Selenide.refresh();



        System.out.println("AssertTrueEquals that number of squat does not change " +
                "after saving and refresh\n");

        Assert.assertTrue(varAmmountSquat.equals(tabMyTestTasks.ammountOfSquatField()),"" +
                "\nTest variable is:" + " " + varAmmountSquat +
                "\nAmmount of squat on tab is:" + " " + tabMyTestTasks.ammountOfSquatField());

        System.out.println("Assert that squat video link is exist in html after saving and refresh\n");

        Assert.assertTrue($("[href=\""+varVideoLinkSquat+"\"]").exists());

        tabEditProfile.
                logOutButtonPersonalCabinetClick().
                logInLikeTestUser();

        tabMyTestTasks
                .tabMyTestTaskLinkClick();

//        System.out.println("AssertTrueEquals that number of squat does not change " +
//                "after logout\n");
//
//        Assert.assertTrue(varAmmountSquat.equals(tabMyTestTasks.ammountOfSquatField()),"" +
//                "\nTest variable is:" + " " + varAmmountSquat +
//                "\nAmmount of squat on tab is:" + " " + tabMyTestTasks.ammountOfSquatField());
//
//        System.out.println("Assert that squat video link is exist in html after logout\n");
//
//
//        Assert.assertTrue(
//                $("[href=\""+varVideoLinkSquat+"\"]").exists());
//
//
//        System.out.println("Test that squat link above diagram is clickable");
//
//        tabMyTestTasks.squatLinkAboveDiagramClick();


        System.out.println("\nSet default number and link in squat fields");

        tabMyTestTasks.enterAmmountSquatAndVideoLinkAndSave(varDefaultAmmountSquat,varDefaultVideoLinkSquat);

        tabEditProfile.logOutButtonPersonalCabinetClick();
    }

    @Test
    public void editAmmountOfPlanck() throws Exception{

        String varPlanckMin = "1";
        String varPlanckSec = "10";
        String varVideoLinkPlanck = "https://vimeo.com/Planck";
        String varDefaultPlanckMin = "2";
        String varDefaultPlanckSec = "20";
        String varDefaultVideoLinkPlanck = "https://DefaultPlanck/.com";

        logInPage.logInLikeTestUser();

        tabMyTestTasks.enterTimePlanckAndVideoLinkAndSave(varPlanckMin, varPlanckSec, varVideoLinkPlanck);

        Selenide.refresh();

        System.out.println("AssertTrueEquals that number of minutes does not change " +
                "after saving and refresh\n");

        Assert.assertTrue(varPlanckMin.equals(tabMyTestTasks.ammountOfPlanckMinuteField()),"" +
                "\nTest variable contains minutes:" + " " + varPlanckMin +
                "\nAmmount of minutes on tab is:" + " " + tabMyTestTasks.ammountOfPlanckMinuteField());

        System.out.println("AssertTrueEquals that number of seconds does not change " +
                "after saving and refresh\n");

        Assert.assertTrue(varPlanckSec.equals(tabMyTestTasks.ammountOfPlanckSecondField()),"" +
                "\nTest variable contains seconds:" + " " + varPlanckSec +
                "\nAmmount of seconds on tab is:" + " " + tabMyTestTasks.ammountOfPlanckSecondField());

        System.out.println("Assert that planck video link is exist in html after saving\n");

        Assert.assertTrue($("[href=\""+varVideoLinkPlanck+"\"]").exists());

        tabEditProfile.
                logOutButtonPersonalCabinetClick().
                logInLikeTestUser();

        tabMyTestTasks
                .tabMyTestTaskLinkClick();

//        System.out.println("AssertTrueEquals that number of minutes does not change " +
//                "after logout\n");
//
//        Assert.assertTrue(varPlanckMin.equals(tabMyTestTasks.ammountOfPlanckMinuteField()),"" +
//                "\nTest variable contains minutes:" + " " + varPlanckMin +
//                "\nAmmount of minutes on tab is:" + " " + tabMyTestTasks.ammountOfPlanckMinuteField());
//
//        System.out.println("AssertTrueEquals that number of seconds does not change " +
//                "after logout\n");
//
//        Assert.assertTrue(varPlanckSec.equals(tabMyTestTasks.ammountOfPlanckSecondField()),"" +
//                "\nTest variable contains seconds:" + " " + varPlanckSec +
//                "\nAmmount of seconds on tab is:" + " " + tabMyTestTasks.ammountOfPlanckSecondField());
//
//        System.out.println("Assert that planck video link is exist in html after logout\n");
//
//        Assert.assertTrue($("[href=\""+varVideoLinkPlanck+"\"]").exists());
//
//        System.out.println("Test that planck link above diagram is clickable");
//
//        tabMyTestTasks.planckLinkAboveDiagramClick();

        System.out.println("\nSet default number and link in planck fields");

        tabMyTestTasks.enterTimePlanckAndVideoLinkAndSave(varDefaultPlanckMin, varDefaultPlanckSec
                , varDefaultVideoLinkPlanck);

        tabEditProfile.logOutButtonPersonalCabinetClick();
    }

}
