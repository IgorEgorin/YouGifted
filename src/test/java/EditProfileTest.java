import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yougifted.helperpackage.CsvDataProvider;
import ru.yougifted.helperpackage.Precondition;

import java.util.Map;

public class EditProfileTest extends Precondition {

    @Test
    public void editNameTest() {
//04082018
        String variableName = "Василий";
        String variableDefaultName = "Владимир";

        logInPage.logInLikeTestUser().editProfileButtonInPersonalCabinetClick()
                .nameFieldPersonalCabinet().setValue(variableName);

        tabEditProfile.saveChangesButtonPersonalCabinetClick();

        Selenide.refresh();



        System.out.println("Assert that new name exist in field after saving and reloading page\n");

        Assert.assertTrue(variableName.equals(tabEditProfile.getAttributeNameFieldPersonalCabinet())
                , "\nNew name is:" + " " + variableName + "\nName inside field is:"
                        + " " + tabEditProfile.getAttributeNameFieldPersonalCabinet());


        tabEditProfile.logOutButtonPersonalCabinetClick().logInLikeTestUser()
                .editProfileButtonInPersonalCabinetClick();




//        System.out.println("Assert that new name exist in field after logout\n");
//
//        Assert.assertTrue(variableName.equals(tabEditProfile.getAttributeNameFieldPersonalCabinet())
//                , "\nNew name is:" + " " + variableName + "\nName inside field is:"
//                        + " " + tabEditProfile.getAttributeNameFieldPersonalCabinet());




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

        tabEditProfile.saveChangesButtonPersonalCabinetClick();


        Selenide.refresh();



        System.out.println("Assert that new surname exist in field after saving and reloading page\n");

        Assert.assertTrue(variableSurname.equals(tabEditProfile.getAttributeSurnameFieldPersonalCabinet())
                , "\nNew surname is:" + " " + variableSurname + "\nSurname inside field is:"
                        + " " + tabEditProfile.getAttributeSurnameFieldPersonalCabinet());


        tabEditProfile.logOutButtonPersonalCabinetClick().logInLikeTestUser()
                .editProfileButtonInPersonalCabinetClick();



//        System.out.println("Assert that new surname exist in field after logout\n");
//
//        Assert.assertTrue(variableSurname.equals(tabEditProfile.getAttributeSurnameFieldPersonalCabinet())
//                , "\nNew surname is:" + " " + variableSurname + "\nSurname inside field is:"
//                        + " " + tabEditProfile.getAttributeSurnameFieldPersonalCabinet());



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

        tabEditProfile.saveChangesButtonPersonalCabinetClick();


        Selenide.refresh();



        System.out.println("Assert that new mail exist in field after saving and reloading page\n");

        Assert.assertTrue(variableMail.equals(tabEditProfile.getAttributeMailFieldPersonalCabinet())
                , "\nNew mail is:" + " " + variableMail + "\nMail inside field is:"
                        + " " + tabEditProfile.getAttributeMailFieldPersonalCabinet());

        tabEditProfile.logOutButtonPersonalCabinetClick().logInWithNewMail(variableMail)
                .editProfileButtonInPersonalCabinetClick();



//        System.out.println("Assert that new mail exist in field after logout\n");
//
//        Assert.assertTrue(variableMail.equals(tabEditProfile.getAttributeMailFieldPersonalCabinet())
//                , "\nNew mail is:" + " " + variableMail + "\nMail inside field is:"
//                        + " " + tabEditProfile.getAttributeMailFieldPersonalCabinet());



        System.out.println("Set default mail in field\n");

        logInPage.setDefaultMailOnTabMyDataPersonalCabinet(variableDefaultMail)
                .saveChangesButtonPersonalCabinetClick().logOutButtonPersonalCabinetClick();
    }

    @Test
    public void editPhoneTest() {

        String variablePhone = "7(777)777-77-77";
        String variableDefaultPhone = "9(999)999-99-99";

        logInPage.logInLikeTestUser().editProfileButtonInPersonalCabinetClick()
                .phoneFieldPersonalCabinet().setValue(variablePhone);

        tabEditProfile.saveChangesButtonPersonalCabinetClick();


        Selenide.refresh();



        System.out.println("AssertTrueEquals that new phone exist in field after saving and reloading page\n");

        Assert.assertTrue(variablePhone.equals(tabEditProfile.getAttributePhoneFieldPersonalCabinet())
                , "\nNew phone is:" + " " + variablePhone + "\nPhone inside field is:"
                        + " " + tabEditProfile.getAttributePhoneFieldPersonalCabinet());

        tabEditProfile.logOutButtonPersonalCabinetClick().logInLikeTestUser()
                .editProfileButtonInPersonalCabinetClick();

//        System.out.println("Assert that new phone exist in field after logout\n");
//
//        Assert.assertTrue(variablePhone.equals(tabEditProfile.getAttributePhoneFieldPersonalCabinet())
//                , "\nNew phone is:" + " " + variablePhone + "\nPhone inside field is:"
//                        + " " + tabEditProfile.getAttributePhoneFieldPersonalCabinet());

        System.out.println("Set default phone in field\n");

        logInPage.setDefaultPhoneOnTabMyDataPersonalCabinet(variableDefaultPhone)
                .saveChangesButtonPersonalCabinetClick().logOutButtonPersonalCabinetClick();

    }

    @Test
    public void editBirthTest() throws Exception{

        String variableBirth = "11.11.1111";
        String variableDefaultBirth = "22.22.2222";

        logInPage.logInLikeTestUser().editProfileButtonInPersonalCabinetClick()
                .birthDataFieldPersonalCabinet().clear();

        logInPage.setBirthOnTabMyDataPersonalCabinet(variableBirth);

        tabEditProfile.saveChangesButtonPersonalCabinetClick();



        Selenide.refresh();



        System.out.println("AssertTrueEquals that new data of birth exist in field after saving and reloading page\n");

        Assert.assertTrue(variableBirth.equals(tabEditProfile.getAttributeBirthFieldPersonalCabinet())
                , "\nNew data of birth is:" + " " + variableBirth + "\nData of birth inside field is:"
                        + " " + tabEditProfile.getAttributeBirthFieldPersonalCabinet());

        tabEditProfile.logOutButtonPersonalCabinetClick().logInLikeTestUser()
                .editProfileButtonInPersonalCabinetClick();



//        System.out.println("Assert that new data of birth exist in field after logout\n");
//
//        Assert.assertTrue(variableBirth.equals(tabEditProfile.getAttributeBirthFieldPersonalCabinet())
//                , "\nNew data of birth is:" + " " + variableBirth + "\nData of birth inside field is:"
//                        + " " + tabEditProfile.getAttributeBirthFieldPersonalCabinet());



        System.out.println("Set default data of birth in field\n");

        logInPage.setBirthOnTabMyDataPersonalCabinet(variableDefaultBirth)
                .saveChangesButtonPersonalCabinetClick().logOutButtonPersonalCabinetClick();

    }


    @Test
    public void editHeightTest() {

        String variableHeight = "222";
        String variableDefaultHeight = "111";

        logInPage.logInLikeTestUser().editProfileButtonInPersonalCabinetClick()
                .heightFieldPersonalCabinet().setValue(variableHeight);

        tabEditProfile.saveChangesButtonPersonalCabinetClick();



        Selenide.refresh();



        System.out.println("AssertTrueEquals that new height exist in field after saving and reloading page\n");

        Assert.assertTrue(variableHeight.equals(tabEditProfile.getAttributeHeightFieldPersonalCabinet())
                , "\nNew height is:" + " " + variableHeight + "\nHeight inside field is:"
                        + " " + tabEditProfile.getAttributeHeightFieldPersonalCabinet());

        tabEditProfile.logOutButtonPersonalCabinetClick().logInLikeTestUser()
                .editProfileButtonInPersonalCabinetClick();




//        System.out.println("Assert that new height exist in field after logout\n");
//
//        Assert.assertTrue(variableHeight.equals(tabEditProfile.getAttributeHeightFieldPersonalCabinet())
//                , "\nNew height is:" + " " + variableHeight + "\nHeight inside field is:"
//                        + " " + tabEditProfile.getAttributeHeightFieldPersonalCabinet());




        System.out.println("Set default height in field\n");

        logInPage.setDefaultHeightOnTabMyDataPersonalCabinet(variableDefaultHeight)
                .saveChangesButtonPersonalCabinetClick().logOutButtonPersonalCabinetClick();
    }

    @Test
    public void setFemaleGenderTest() {

        String varAttributeInsideSavingForm = "Женский";

        logInPage.logInLikeTestUser().editProfileButtonInPersonalCabinetClick()
                .setFemaleGenderPersonalCabinet();

        tabEditProfile.saveChangesButtonPersonalCabinetClick();


        Selenide.refresh();



        System.out.println("AssertTrueEquals that female gender exist in list after saving and refresh\n");

        Assert.assertTrue(tabEditProfile.getSavingAttributeOfGender().equals(varAttributeInsideSavingForm),
                "\nSaving gender word in list is:" + " " + tabEditProfile.getSavingAttributeOfGender() +
                        "\nExpected variable is:" + " " + varAttributeInsideSavingForm);

        tabEditProfile.logOutButtonPersonalCabinetClick().logInLikeTestUser()
                .editProfileButtonInPersonalCabinetClick();




//        System.out.println("AssertTrueEquals that female gender exist in list after logout\n");
//
//        Assert.assertTrue(tabEditProfile.getSavingAttributeOfGender().equals(varAttributeInsideSavingForm),
//                "\nSaving gender word in list is:" + " " + tabEditProfile.getSavingAttributeOfGender() +
//                        "\nExpected variable is:" + " " + varAttributeInsideSavingForm);





        System.out.println("Set default male gender in field\n");

        tabEditProfile.setMaleGenderPersonalCabinet();
        tabEditProfile.saveChangesButtonPersonalCabinetClick().logOutButtonPersonalCabinetClick();

    }

    @Test
    public void setNotSpecifiedGenderTest() {

        String varAttributeInsideSavingForm = "Не задан";

        logInPage.logInLikeTestUser().editProfileButtonInPersonalCabinetClick()
                .setNotSpecifiedGenderInPersonalCabinet();

        tabEditProfile.saveChangesButtonPersonalCabinetClick();



        Selenide.refresh();



        System.out.println("AssertTrueEquals that not specified gender exist in list after saving and refresh\n");

        Assert.assertTrue(tabEditProfile.getSavingAttributeOfGender().equals(varAttributeInsideSavingForm),
                "\nSaving gender word in list is:" + " " + tabEditProfile.getSavingAttributeOfGender() +
                        "\nExpected variable is:" + " " + varAttributeInsideSavingForm);

        tabEditProfile.logOutButtonPersonalCabinetClick().logInLikeTestUser()
                .editProfileButtonInPersonalCabinetClick();



//        System.out.println("AssertTrueEquals that not specified gender exist in list after logout\n");
//
//        Assert.assertTrue(tabEditProfile.getSavingAttributeOfGender().equals(varAttributeInsideSavingForm),
//                "\nSaving gender word in list is:" + " " + tabEditProfile.getSavingAttributeOfGender() +
//                        "\nExpected variable is:" + " " + varAttributeInsideSavingForm);




        System.out.println("Set default male gender in field\n");

        tabEditProfile.setMaleGenderPersonalCabinet();
        tabEditProfile.saveChangesButtonPersonalCabinetClick().logOutButtonPersonalCabinetClick();
    }

    @Test
    public void setNewPhotoTest() {

        String varPathToNewPhoto = "C:\\Users\\Юзер\\IdeaProjects\\YouGifted\\src\\main\\resources\\VariablePhoto.png";
        String varPathToDefaultPhoto = "C:\\Users\\Юзер\\IdeaProjects\\YouGifted\\src\\main\\resources\\DefaultPhoto.jpeg";

        logInPage.logInLikeTestUser()
                .editProfileButtonInPersonalCabinetClick();

        String varSRCofPhotoBeforeLoad = tabEditProfile.getPathToSRCinPersonalCabinet();

        tabEditProfile
                .addPhotoInsidePersonalCabinetViaPath(varPathToNewPhoto)
                .saveChangesButtonPersonalCabinetClick();



        Selenide.refresh();



        System.out.println("AssertFalseEquals that src path has difference before " +
                "and after upload photo. Data is saved and page refresh\n");

        Assert.assertFalse(varSRCofPhotoBeforeLoad.equals(tabEditProfile.getPathToSRCinPersonalCabinet()),
                "\nSrc before load is:" + " " + varSRCofPhotoBeforeLoad +
                        "\nSrc after load is:" + " " + tabEditProfile.getPathToSRCinPersonalCabinet());

        System.out.println("Before load:\n" + varSRCofPhotoBeforeLoad);

        System.out.println("After load:\n" + tabEditProfile.getPathToSRCinPersonalCabinet());

        tabEditProfile.logOutButtonPersonalCabinetClick().logInLikeTestUser()
                .editProfileButtonInPersonalCabinetClick();




//        System.out.println("AssertFalseEquals that new photo exist in profile after logout\n");
//
//        Assert.assertFalse(varSRCofPhotoBeforeLoad.equals(tabEditProfile.getPathToSRCinPersonalCabinet()),
//                "\nSrc before load is:" + " " + varSRCofPhotoBeforeLoad +
//                        "\nSrc after load is:" + " " + tabEditProfile.getPathToSRCinPersonalCabinet());




        System.out.println("Set default photo\n");

        tabEditProfile
                .addPhotoInsidePersonalCabinetViaPath(varPathToDefaultPhoto)
                .saveChangesButtonPersonalCabinetClick();

    }

    @Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class)
    public void editLevelOfActivity(Map<String, String> testData) throws Exception {

        String varTypeOfActivity = testData.get("numberOfActivityLevel");

        logInPage.logInLikeTestUser().editProfileButtonInPersonalCabinetClick()
                .typeOfActivity(varTypeOfActivity);

        System.out.println("Choose type of activity in personal cabinet on tab my data");


        tabEditProfile.saveChangesButtonPersonalCabinetClick();



        Selenide.refresh();



        System.out.println("AssertTrueEquals that activity level is correct after saving and reload page\n");


        Assert.assertTrue(varTypeOfActivity.equals(tabEditProfile
                        .getAttributeLevelOfActivityPersonalCabinet()),
                "\nLevel activity before saving is:" + " " + varTypeOfActivity +
                        "\nLevel activity after saving is:" + " " + tabEditProfile
                        .getAttributeLevelOfActivityPersonalCabinet());

        tabEditProfile.logOutButtonPersonalCabinetClick().logInLikeTestUser()
                .editProfileButtonInPersonalCabinetClick();


//        System.out.println("AssertFalseEquals that new level of activity is existed in profile after logout\n");
//
//
//        Assert.assertTrue(varTypeOfActivity.equals(tabEditProfile
//                        .getAttributeLevelOfActivityPersonalCabinet()),
//                "\nLevel activity before saving is:" + " " + varTypeOfActivity +
//                        "\nLevel activity after logout is:" + " " + tabEditProfile
//                        .getAttributeLevelOfActivityPersonalCabinet());

        tabEditProfile.logOutButtonPersonalCabinetClick();
    }


    @Test
    public void editPassword() {

        String varNewPassword = "123ABab";
        String setDefaultPassword = "0000a";

        logInPage.logInLikeTestUser().editProfileButtonInPersonalCabinetClick();



        Selenide.refresh();



        System.out.println("Enter and save new password. Page is reloaded");

        tabEditProfile.enterAndConfirmNewPassword(varNewPassword)
                .saveChangesButtonPersonalCabinetClick().logOutButtonPersonalCabinetClick()
                .logInWithOldMailAndNewPassword(varNewPassword);

        System.out.println("Assert that login with new password is success. Log out button is displayed in" + " " +
                "personal cabinet");

        tabEditProfile.editProfileButtonInPersonalCabinetClick();

        Assert.assertTrue(tabEditProfile.logOutButtonPersonalCabinet().isDisplayed());

        System.out.println("Set default password");

        tabEditProfile.editProfileButtonInPersonalCabinetClick().enterAndConfirmNewPassword(setDefaultPassword).saveChangesButtonPersonalCabinetClick()
                .logOutButtonPersonalCabinetClick();

    }
}


