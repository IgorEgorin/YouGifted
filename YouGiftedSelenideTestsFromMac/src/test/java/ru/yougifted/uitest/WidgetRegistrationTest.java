package ru.yougifted.uitest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.testng.Assert;
import ru.yougifted.helperpackage.PreconditionJunit;

import java.util.ArrayList;
import java.util.List;

@RunWith(Parameterized.class)
public class WidgetRegistrationTest extends PreconditionJunit {


    private String varAgeQuiz = "24";
    private String varNutrHeight = "178";
    private String varNutrWeight = "66";
    private String varNutrLevAct = "3";




    @Parameterized.Parameter
    public String varTypeOfLoginAndAuth;

    @Parameterized.Parameters
    public static List<String> data() {
        List<String> lists = new ArrayList<>();
        lists.add("YouGiftedForm");
//        lists.add("VK"); 03102018 VK and Facebook havenot done from developer side
//        lists.add("Facebook");
        return lists;
    }



    @Test
    public void registrationViaTrainingProgramQuiz() throws Exception{


        System.out.println("\nStart to fill widget training program");

        quizPage.selectMaleFlexibilityCreateNewAccount(varAgeQuiz);

        System.out.println("\nRegistrate using" + " " + varTypeOfLoginAndAuth);

        socialNetworksPage.chooseTypeOfRegistrWidgetTrainnigProg(varTypeOfLoginAndAuth);


        System.out.println("\nAssert. Personal cabinet is opened (Log out button is displayed)");

        Assert.assertTrue(tabEditProfile.logOutButtonPersonalCabinet().exists()
                ,"LogOut button does not exist");

        tabEditProfile.logOutButtonPersonalCabinetClick();

        System.out.println("\nPush log out button\n");

    }


    @Test
    public void registrationViaNutritionProgramQuiz() throws Exception{


        System.out.println("\nStart to fill widget nutrition program");

        quizPage.completeTestNutritionProg(varAgeQuiz, varNutrHeight, varNutrWeight, varNutrLevAct);


        System.out.println("\nRegistrate using" + " " + varTypeOfLoginAndAuth);

        socialNetworksPage.chooseTypeOfRegistrWidgetNutritionProg(varTypeOfLoginAndAuth);


        System.out.println("\nAssert. Personal cabinet is opened (Log out button is displayed)");

        Assert.assertTrue(tabEditProfile.logOutButtonPersonalCabinet().exists()
                ,"LogOut button does not exist");

        tabEditProfile.logOutButtonPersonalCabinetClick();

        System.out.println("\nPush log out button\n");

    }


}
