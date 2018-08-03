import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yougifted.helperpackage.CsvDataProvider;
import ru.yougifted.helperpackage.Precondition;

import java.util.Map;

public class MyDimensionsTabTest extends Precondition {

    @Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class)
    public void editClientDimensions(Map<String, String> testData) throws Exception {

        String varWeight = testData.get("weight");
        String varWaist = testData.get("waist");
        String varHipcircumference = testData.get("hipcircumference");
        String varChestgirth = testData.get("chestgirth");
        String varLeftarm = testData.get("leftarm");
        String varRightarm = testData.get("rightarm");
        String varLeftleg = testData.get("leftleg");
        String varRightleg = testData.get("rightleg");


        logInPage.logInLikeTestUser();

        tabMyDimensions.enterAndSaveWeightWaistHipcircumferenceChestgirthLeftarmRightarmLeftlegRightleg(
                varWeight,varWaist,varHipcircumference,varChestgirth,varLeftarm,varRightarm,varLeftleg,varRightleg);




        Selenide.refresh();


        System.out.println("\nAssertTrueEquals that test variable is the same as data in weight field after save and refresh");
        System.out.println("Variable weight is:\n" + varWeight);
        System.out.println("Weight from field after save and refresh is:\n"
                 +tabMyDimensions.weightFieldInResultTableOnTabMyDimensions());

        Assert.assertTrue(varWeight.equals(tabMyDimensions.weightFieldInResultTableOnTabMyDimensions()),
                "\nTest variable is:" + " " + varWeight +
                    "\nData in weight field is:" + " " + tabMyDimensions.weightFieldInResultTableOnTabMyDimensions());







        System.out.println("\nAssertTrueEquals that test variable is the same as data in waist field after save and refresh");
        System.out.println("Variable waist is:\n" + varWaist);
        System.out.println("Waist from field after save and refresh is:\n"
                +tabMyDimensions.waistFieldInResultTableOnTabMyDimensions());

        Assert.assertTrue(varWaist.equals(tabMyDimensions.waistFieldInResultTableOnTabMyDimensions()),
                "\nTest variable is:" + " " + varWaist +
                        "\nData in waist field is:" + " " + tabMyDimensions.waistFieldInResultTableOnTabMyDimensions());






        System.out.println("\nAssertTrueEquals that test variable is the same as data in hip circumference field after save and refresh");
        System.out.println("Variable Hip circumference is:\n" + varHipcircumference);
        System.out.println("Hip circumference from field after save and refresh is:\n"
                +tabMyDimensions.hipCircumferenceFieldInResultTableOnTabMyDimensions());

        Assert.assertTrue(varHipcircumference.equals(tabMyDimensions.hipCircumferenceFieldInResultTableOnTabMyDimensions()),
                "\nTest variable is:" + " " + varHipcircumference +
                        "\nData in hip circumference field is:" + " " + tabMyDimensions
                        .hipCircumferenceFieldInResultTableOnTabMyDimensions());








        System.out.println("\nAssertTrueEquals that test variable is the same as data in chest girth field after save and refresh");
        System.out.println("Variable chest girth is:\n" + varChestgirth);
        System.out.println("Chest girth from field after save and refresh is:\n"
                +tabMyDimensions.chestGirthFieldInResultTableOnTabMyDimensions());

        Assert.assertTrue(varChestgirth.equals(tabMyDimensions.chestGirthFieldInResultTableOnTabMyDimensions()),
                "\nTest variable is:" + " " + varChestgirth +
                        "\nData in chest girth field is:" + " " + tabMyDimensions
                        .chestGirthFieldInResultTableOnTabMyDimensions());







        System.out.println("\nAssertTrueEquals that test variable is the same as data in left arm field after save and refresh");
        System.out.println("Variable left arm is:\n" + varLeftarm);
        System.out.println("Left arm from field after save and refresh is:\n"
                +tabMyDimensions.leftArmFieldInResultTableOnTabMyDimensions());

        Assert.assertTrue(varLeftarm.equals(tabMyDimensions.leftArmFieldInResultTableOnTabMyDimensions()),
                "\nTest variable is:" + " " + varLeftarm +
                        "\nData in left arm field is:" + " " + tabMyDimensions
                        .leftArmFieldInResultTableOnTabMyDimensions());




        System.out.println("\nAssertTrueEquals that test variable is the same as data in right arm field after save and refresh");
        System.out.println("Variable right arm is:\n" + varRightarm);
        System.out.println("Right arm from field after save and refresh is:\n"
                +tabMyDimensions.rightArmFieldInResultTableOnTabMyDimensions());

        Assert.assertTrue(varRightarm.equals(tabMyDimensions.rightArmFieldInResultTableOnTabMyDimensions()),
                "\nTest variable is:" + " " + varRightarm +
                        "\nData in right arm field is:" + " " + tabMyDimensions
                        .rightArmFieldInResultTableOnTabMyDimensions());




        System.out.println("\nAssertTrueEquals that test variable is the same as data in left leg field after save and refresh");
        System.out.println("Variable left leg is:\n" + varLeftleg);
        System.out.println("Left leg from field after save and refresh is:\n"
                +tabMyDimensions.leftLegFieldInResultTableOnTabMyDimensions());

        Assert.assertTrue(varLeftleg.equals(tabMyDimensions.leftLegFieldInResultTableOnTabMyDimensions()),
                "\nTest variable is:" + " " + varLeftleg +
                        "\nData in left leg field is:" + " " + tabMyDimensions
                        .leftLegFieldInResultTableOnTabMyDimensions());







        System.out.println("\nAssertTrueEquals that test variable is the same as data in right leg field after save and refresh");
        System.out.println("Variable right leg is:\n" + varRightleg);
        System.out.println("Right leg from field after save and refresh is:\n"
                +tabMyDimensions.rightLegFieldInResultTableOnTabMyDimensions());

        Assert.assertTrue(varRightleg.equals(tabMyDimensions.rightLegFieldInResultTableOnTabMyDimensions()),
                "\nTest variable is:" + " " + varRightleg +
                        "\nData in right leg field is:" + " " + tabMyDimensions
                        .rightLegFieldInResultTableOnTabMyDimensions());



    }
}
