import org.testng.annotations.Test;
import ru.yougifted.helperpackage.CsvDataProvider;
import ru.yougifted.helperpackage.Precondition;

import java.util.Map;

public class EditProfileTest extends Precondition {


    @Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class)
    public void editingAllFieldsOnTabMyDataInPersonalCabinet(Map<String, String> testData) throws Exception {

        String variableMailForLogInIntoPersonalCabinet = "Egorov@ccc.ccc";
        String variablePasswordForLogInIntoPersonalCabinet = "0000";

        String varName = testData.get("namePerCab");
        String varSurname = testData.get("surnamePerCab");
        String varMail = testData.get("mailPerCab");
        String varPhone = testData.get("phonePerCab");
        String varBirth = testData.get("birthPerCab");
        String varHeight = testData.get("heightPerCab");
        String varMaleOrFemale = testData.get("genderPerCab");
        String varActivity = testData.get("activityPerCab");
        String varNewAndConfPassword = testData.get("newAndConfPassPerCab");

//        String amountOfRIGHTarrowClickInsideReturnCalendar = testData.get("AmountOfClickOnRightArrow");

        logInPage.enterDataOnLogInPageAndPressSubmit(variableMailForLogInIntoPersonalCabinet
                ,variablePasswordForLogInIntoPersonalCabinet);

        personalCabinet.editProfileButtonInPersonalCabinetClick()
                .setNewDataOnEditTabOnPersonalCabinetPage(name,);



        Thread.sleep(10000);
    }
}
