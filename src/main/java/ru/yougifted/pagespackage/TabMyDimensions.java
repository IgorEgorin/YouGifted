package ru.yougifted.pagespackage;

import static com.codeborne.selenide.Selenide.$;

public class TabMyDimensions {

    private TabMyDimensions buttonEditOnTabMyDimensionsClick() {
        $("[class=\"button edit-button col-xs-6 col-sm-6 col-md-6 col-lg-6\"]").click();
        return new TabMyDimensions();
    }

    public TabMyDimensions tabMyDimensionsClick() {
        $("[href=\"/personal/data\"]").click();
        return new TabMyDimensions();
    }

    private TabMyDimensions buttonSaveOnTabMyDimensionsClick() {
        $("[type=\"submit\"]").click();
        return new TabMyDimensions();
    }

    public String weightFieldInResultTableOnTabMyDimensions() {
        return $("[class=\"info__array\"]",0)
                .getText().replaceAll(".00 кг","");
    }

    public String waistFieldInResultTableOnTabMyDimensions() {
        return $("[class=\"info__array\"]",1)
                .getText().replaceAll(".00 см","");
    }


    public String hipCircumferenceFieldInResultTableOnTabMyDimensions() {
        return $("[class=\"info__array\"]",2)
                .getText().replaceAll(".00 см","");
    }


    public String chestGirthFieldInResultTableOnTabMyDimensions() {
        return $("[class=\"info__array\"]",3)
                .getText().replaceAll(".00 см","");
    }


    public String leftArmFieldInResultTableOnTabMyDimensions() {
        return $("[class=\"info__array\"]",4)
                .getText().replaceAll(".00 см","");
    }


    public String rightArmFieldInResultTableOnTabMyDimensions() {
        return $("[class=\"info__array\"]",5)
                .getText().replaceAll(".00 см","");
    }


    public String leftLegFieldInResultTableOnTabMyDimensions() {
        return $("[class=\"info__array\"]",6)
                .getText().replaceAll(".00 см","");
    }


    public String rightLegFieldInResultTableOnTabMyDimensions() {
        return $("[class=\"info__array\"]",7)
                .getText().replaceAll(".00 см","");
    }

    public TabMyDimensions enterAndSaveWeightOnTabMyDimensionsClick(String s) {
        tabMyDimensionsClick();
        buttonEditOnTabMyDimensionsClick();
        $("#bodyform_weight").setValue(s);
        buttonSaveOnTabMyDimensionsClick();
        return new TabMyDimensions();
    }

    public TabMyTestTasks linkWeightAboveDiagramClickMyDimensionsClick() {
        $("[for=\"tab1\"]").click();
        return new TabMyTestTasks();
    }

    public TabMyTestTasks infoIconNearWeightMyDimensionsClick() {
        $("[class=\"info-icon info-icon_padd\"]",0).click();
        return new TabMyTestTasks();
    }

    public TabMyDimensions enterAndSaveWeightWaistHipcircumferenceChestgirthLeftarmRightarmLeftlegRightleg(
            String weight,String waist,String hipcircumference,String chestgirth,String leftarm,String rightarm
            ,String leftleg,String rightleg) {
        tabMyDimensionsClick();
        buttonEditOnTabMyDimensionsClick();
        $("#bodyform_weight").setValue(weight);
        $("#bodyform_waist").setValue(waist);
        $("#bodyform_hip").setValue(hipcircumference);
        $("#bodyform_chest").setValue(chestgirth);
        $("#bodyform_left_hand").setValue(leftarm);
        $("#bodyform_right_hand").setValue(rightarm);
        $("#bodyform_left_leg").setValue(leftleg);
        $("#bodyform_right_leg").setValue(rightleg);
        buttonSaveOnTabMyDimensionsClick();
        return new TabMyDimensions();
    }



}
