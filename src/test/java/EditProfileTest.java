import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yougifted.helperpackage.Precondition;

import static com.codeborne.selenide.Selenide.$;

public class EditProfileTest extends Precondition {


//    @Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class)
//    public void editingAllFieldsOnTabMyDataInPersonalCabinet(Map<String, String> testData) throws Exception {
//
//        String variableMailForLogInIntoPersonalCabinet = "Egorov@ccc.ccc";
//        String variablePasswordForLogInIntoPersonalCabinet = "0000";
//
//        String varName = testData.get("namePerCab");
//        String varSurname = testData.get("surnamePerCab");
//        String varMail = testData.get("mailPerCab");
//        String varPhone = testData.get("phonePerCab");
//        String varBirth = testData.get("birthPerCab");
//        String varHeight = testData.get("heightPerCab");
//        String varMaleOrFemale = testData.get("genderPerCab");
//        String varActivity = testData.get("activityPerCab");
//        String varNewAndConfPassword = testData.get("newAndConfPassPerCab");
//
//        String amountOfRIGHTarrowClickInsideReturnCalendar = testData.get("AmountOfClickOnRightArrow");
//
//        logInPage.enterDataOnLogInPageAndPressSubmit(variableMailForLogInIntoPersonalCabinet
//                ,variablePasswordForLogInIntoPersonalCabinet);
//
//        personalCabinet.editProfileButtonInPersonalCabinetClick()
//                .setNewDataOnEditTabOnPersonalCabinetPage(name,);

//        Thread.sleep(10000);

    @Test
    public void editNameTest() {

        String variableName = "Василий";
        String variableDefaultName = "Владимир";

        logInPage.logInLikeTestUser().editProfileButtonInPersonalCabinetClick()
                .nameFieldPersonalCabinet().setValue(variableName);

        personalCabinet.saveChangesButtonPersonalCabinetClick();

        System.out.println("Assert that new name exist in field after saving\n");

        Assert.assertTrue(variableName.equals(personalCabinet.getAttributeNameFieldPersonalCabinet())
                , "\nNew name is:" + " " + variableName + "\nName inside field is:"
                        + " " + personalCabinet.getAttributeNameFieldPersonalCabinet());


        personalCabinet.logOutButtonPersonalCabinetClick().logInLikeTestUser()
                .editProfileButtonInPersonalCabinetClick();

        System.out.println("Assert that new name exist in field after logout\n");

        Assert.assertTrue(variableName.equals(personalCabinet.getAttributeNameFieldPersonalCabinet())
                , "\nNew name is:" + " " + variableName + "\nName inside field is:"
                        + " " + personalCabinet.getAttributeNameFieldPersonalCabinet());

        System.out.println("Set default name in name field\n");

        logInPage.setDefaultNameOnTabMyDataPersonalCabinet(variableDefaultName)
                .saveChangesButtonPersonalCabinetClick().logOutButtonPersonalCabinetClick();

    }

    @Test
    public void editSurnameTest() {

        String variableSurname = "Николаев";
        String variableDefaultSurname = "Егоров";

        logInPage.logInLikeTestUser().editProfileButtonInPersonalCabinetClick()
                .surnameFieldPersonalCabinet().setValue(variableSurname);

        personalCabinet.saveChangesButtonPersonalCabinetClick();

        System.out.println("Assert that new surname exist in field after saving\n");

        Assert.assertTrue(variableSurname.equals(personalCabinet.getAttributeSurnameFieldPersonalCabinet())
                , "\nNew surname is:" + " " + variableSurname + "\nSurname inside field is:"
                        + " " + personalCabinet.getAttributeSurnameFieldPersonalCabinet());


        personalCabinet.logOutButtonPersonalCabinetClick().logInLikeTestUser()
                .editProfileButtonInPersonalCabinetClick();

        System.out.println("Assert that new surname exist in field after logout\n");

        Assert.assertTrue(variableSurname.equals(personalCabinet.getAttributeSurnameFieldPersonalCabinet())
                , "\nNew surname is:" + " " + variableSurname + "\nSurname inside field is:"
                        + " " + personalCabinet.getAttributeSurnameFieldPersonalCabinet());

        System.out.println("Set default surname in surname field\n");

        logInPage.setDefaultSurnameOnTabMyDataPersonalCabinet(variableDefaultSurname)
                .saveChangesButtonPersonalCabinetClick().logOutButtonPersonalCabinetClick();

    }

    @Test
    public void editMailTest() {

        String variableMail = "ThisIsNewMail1@gmaii.ccom";
        String variableDefaultMail = "310718@ccc.ccc";

        logInPage.logInLikeTestUser().editProfileButtonInPersonalCabinetClick()
                .mailFieldPersonalCabinet().setValue(variableMail);

        personalCabinet.saveChangesButtonPersonalCabinetClick();

        System.out.println("Assert that new mail exist in field after saving\n");

        Assert.assertTrue(variableMail.equals(personalCabinet.getAttributeMailFieldPersonalCabinet())
                , "\nNew mail is:" + " " + variableMail + "\nMail inside field is:"
                        + " " + personalCabinet.getAttributeMailFieldPersonalCabinet());

        personalCabinet.logOutButtonPersonalCabinetClick().logInWithNewMail(variableMail)
                .editProfileButtonInPersonalCabinetClick();

        System.out.println("Assert that new mail exist in field after logout\n");

        Assert.assertTrue(variableMail.equals(personalCabinet.getAttributeMailFieldPersonalCabinet())
                , "\nNew mail is:" + " " + variableMail + "\nMail inside field is:"
                        + " " + personalCabinet.getAttributeMailFieldPersonalCabinet());

        System.out.println("Set default mail in field\n");

        logInPage.setDefaultMailOnTabMyDataPersonalCabinet(variableDefaultMail)
                .saveChangesButtonPersonalCabinetClick().logOutButtonPersonalCabinetClick();
    }

    @Test
    public void editPhoneTest() {

        String variablePhone = "7(999)000-00-00";
        String variableDefaultPhone = "7(999)000-11-11";

        logInPage.logInLikeTestUser().editProfileButtonInPersonalCabinetClick()
                .phoneFieldPersonalCabinet().setValue(variablePhone);

        personalCabinet.saveChangesButtonPersonalCabinetClick();

        System.out.println("AssertTrueEquals that new phone exist in field after saving\n");

        Assert.assertTrue(variablePhone.equals(personalCabinet.getAttributePhoneFieldPersonalCabinet())
                , "\nNew phone is:" + " " + variablePhone + "\nPhone inside field is:"
                        + " " + personalCabinet.getAttributePhoneFieldPersonalCabinet());

        personalCabinet.logOutButtonPersonalCabinetClick().logInLikeTestUser()
                .editProfileButtonInPersonalCabinetClick();

        System.out.println("Assert that new phone exist in field after logout\n");

        Assert.assertTrue(variablePhone.equals(personalCabinet.getAttributePhoneFieldPersonalCabinet())
                , "\nNew phone is:" + " " + variablePhone + "\nPhone inside field is:"
                        + " " + personalCabinet.getAttributePhoneFieldPersonalCabinet());

        System.out.println("Set default phone in field\n");

        logInPage.setDefaultPhoneOnTabMyDataPersonalCabinet(variableDefaultPhone)
                .saveChangesButtonPersonalCabinetClick().logOutButtonPersonalCabinetClick();

    }

    @Test
    public void editBirthTest() {

        String variableBirth = "12.03.1972";
        String variableDefaultBirth = "20.05.1980";

        logInPage.logInLikeTestUser().editProfileButtonInPersonalCabinetClick()
                .birthDataFieldPersonalCabinet().setValue(variableBirth);

        personalCabinet.saveChangesButtonPersonalCabinetClick();

        System.out.println("AssertTrueEquals that new data of birth exist in field after saving\n");

        Assert.assertTrue(variableBirth.equals(personalCabinet.getAttributeBirthFieldPersonalCabinet())
                , "\nNew data of birth is:" + " " + variableBirth + "\nData of birth inside field is:"
                        + " " + personalCabinet.getAttributeBirthFieldPersonalCabinet());

        personalCabinet.logOutButtonPersonalCabinetClick().logInLikeTestUser()
                .editProfileButtonInPersonalCabinetClick();

        System.out.println("Assert that new data of birth exist in field after logout\n");

        Assert.assertTrue(variableBirth.equals(personalCabinet.getAttributeBirthFieldPersonalCabinet())
                , "\nNew data of birth is:" + " " + variableBirth + "\nData of birth inside field is:"
                        + " " + personalCabinet.getAttributeBirthFieldPersonalCabinet());

        System.out.println("Set default data of birth in field\n");

        logInPage.setDefaultBirthOnTabMyDataPersonalCabinet(variableDefaultBirth)
                .saveChangesButtonPersonalCabinetClick().logOutButtonPersonalCabinetClick();

    }


    @Test
    public void editHeightTest() {

        String variableHeight = "173";
        String variableDefaultHeight = "187";

        logInPage.logInLikeTestUser().editProfileButtonInPersonalCabinetClick()
                .heightFieldPersonalCabinet().setValue(variableHeight);

        personalCabinet.saveChangesButtonPersonalCabinetClick();

        System.out.println("AssertTrueEquals that new height exist in field after saving\n");

        Assert.assertTrue(variableHeight.equals(personalCabinet.getAttributeHeightFieldPersonalCabinet())
                , "\nNew height is:" + " " + variableHeight + "\nHeight inside field is:"
                        + " " + personalCabinet.getAttributeHeightFieldPersonalCabinet());

        personalCabinet.logOutButtonPersonalCabinetClick().logInLikeTestUser()
                .editProfileButtonInPersonalCabinetClick();

        System.out.println("Assert that new height exist in field after logout\n");

        Assert.assertTrue(variableHeight.equals(personalCabinet.getAttributeHeightFieldPersonalCabinet())
                , "\nNew height is:" + " " + variableHeight + "\nHeight inside field is:"
                        + " " + personalCabinet.getAttributeHeightFieldPersonalCabinet());

        System.out.println("Set default height in field\n");

        logInPage.setDefaultHeightOnTabMyDataPersonalCabinet(variableDefaultHeight)
                .saveChangesButtonPersonalCabinetClick().logOutButtonPersonalCabinetClick();
    }

    @Test
    public void setFemaleGenderTest() {

        String varAttributeInsideSavingForm = "Женский";

        logInPage.logInLikeTestUser().editProfileButtonInPersonalCabinetClick()
                .setFemaleGenderPersonalCabinet();

        personalCabinet.saveChangesButtonPersonalCabinetClick();

        System.out.println("AssertTrueEquals that female gender exist in list after saving\n");

        Assert.assertTrue(personalCabinet.getSavingAttributeOfGender().equals(varAttributeInsideSavingForm),
                "\nSaving gender word in list is:" + " " + personalCabinet.getSavingAttributeOfGender() +
                        "\nExpected variable is:" + " " + varAttributeInsideSavingForm);

        personalCabinet.logOutButtonPersonalCabinetClick().logInLikeTestUser()
                .editProfileButtonInPersonalCabinetClick();

        System.out.println("AssertTrueEquals that female gender exist in list after logout\n");

        Assert.assertTrue(personalCabinet.getSavingAttributeOfGender().equals(varAttributeInsideSavingForm),
                "\nSaving gender word in list is:" + " " + personalCabinet.getSavingAttributeOfGender() +
                        "\nExpected variable is:" + " " + varAttributeInsideSavingForm);

        System.out.println("Set default male gender in field\n");

        personalCabinet.setMaleGenderPersonalCabinet();
        personalCabinet.saveChangesButtonPersonalCabinetClick().logOutButtonPersonalCabinetClick();

    }

    @Test
    public void setNotSpecifiedGenderTest() {

        String varAttributeInsideSavingForm = "Не задан";

        logInPage.logInLikeTestUser().editProfileButtonInPersonalCabinetClick()
                .setNotSpecifiedGenderInPersonalCabinet();

        personalCabinet.saveChangesButtonPersonalCabinetClick();

        System.out.println("AssertTrueEquals that not specified gender exist in list after saving\n");

        Assert.assertTrue(personalCabinet.getSavingAttributeOfGender().equals(varAttributeInsideSavingForm),
                "\nSaving gender word in list is:" + " " + personalCabinet.getSavingAttributeOfGender() +
                        "\nExpected variable is:" + " " + varAttributeInsideSavingForm);

        personalCabinet.logOutButtonPersonalCabinetClick().logInLikeTestUser()
                .editProfileButtonInPersonalCabinetClick();

        System.out.println("AssertTrueEquals that not specified gender exist in list after logout\n");

        Assert.assertTrue(personalCabinet.getSavingAttributeOfGender().equals(varAttributeInsideSavingForm),
                "\nSaving gender word in list is:" + " " + personalCabinet.getSavingAttributeOfGender() +
                        "\nExpected variable is:" + " " + varAttributeInsideSavingForm);

        System.out.println("Set default male gender in field\n");

        personalCabinet.setMaleGenderPersonalCabinet();
        personalCabinet.saveChangesButtonPersonalCabinetClick().logOutButtonPersonalCabinetClick();
    }

    @Test
    public void setNewPhotoTest() {

        String varPathToNewPhoto = "C:\\Users\\Юзер\\IdeaProjects\\YouGifted\\src\\main\\resources\\VariablePhoto.png";
        String varPathToDefaultPhoto = "C:\\Users\\Юзер\\IdeaProjects\\YouGifted\\src\\main\\resources\\DefaultPhoto.jpeg";

        logInPage.logInLikeTestUser()
                .editProfileButtonInPersonalCabinetClick();

        String varSRCofPhotoBeforeLoad = personalCabinet.getPathToSRCinPersonalCabinet();

        personalCabinet
                .addPhotoInsidePersonalCabinetViaPath(varPathToNewPhoto)
                .saveChangesButtonPersonalCabinetClick();

        System.out.println("AssertFalseEquals that src path has difference before " +
                "and after upload photo when saving button has already pushed\n");

        Assert.assertFalse(varSRCofPhotoBeforeLoad.equals(personalCabinet.getPathToSRCinPersonalCabinet()),
                "\nSrc before load is:" + " " + varSRCofPhotoBeforeLoad +
                        "\nSrc after load is:" + " " + personalCabinet.getPathToSRCinPersonalCabinet());

        System.out.println("Before load:\n" + varSRCofPhotoBeforeLoad);

        System.out.println("After load:\n" + personalCabinet.getPathToSRCinPersonalCabinet());

        personalCabinet.logOutButtonPersonalCabinetClick().logInLikeTestUser()
                .editProfileButtonInPersonalCabinetClick();

        System.out.println("AssertFalseEquals that new photo exist in profile after logout\n");

        Assert.assertFalse(varSRCofPhotoBeforeLoad.equals(personalCabinet.getPathToSRCinPersonalCabinet()),
                "\nSrc before load is:" + " " + varSRCofPhotoBeforeLoad +
                        "\nSrc after load is:" + " " + personalCabinet.getPathToSRCinPersonalCabinet());

        System.out.println("Set default photo\n");

        personalCabinet
                .addPhotoInsidePersonalCabinetViaPath(varPathToDefaultPhoto)
                .saveChangesButtonPersonalCabinetClick();

    }

}


