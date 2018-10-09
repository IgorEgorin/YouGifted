package ru.yougifted.pagespackage;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class TabMyTestTasks {

    private SelenideElement tabMyTestTaskLink() {
        return $("[href=\"/personal/results\"]");
    }

    public TabMyTestTasks tabMyTestTaskLinkClick() {
        tabMyTestTaskLink().click();
        return new TabMyTestTasks();
    }

    private TabMyTestTasks editPushUpAmmountBtnTabMyTestTaskClick() {
        $("[class=\"test-result-button\"]",0).click();
        return new TabMyTestTasks();
    }

    private TabMyTestTasks editSquatAmmountBtnTabMyTestTaskClick() {
        $("[class=\"test-result-button\"]",1).click();
        return new TabMyTestTasks();
    }

    private TabMyTestTasks editPlanckAmmountBtnTabMyTestTaskClick() {
        $("[class=\"test-result-button\"]",2).click();
        return new TabMyTestTasks();
    }

    private TabMyTestTasks ammountPushUpRepsTabMyTestTaskClick(String s) {
        $("[role=\"form\"] [type=\"number\"]",0).sendKeys(s);
        return new TabMyTestTasks();
    }

    private TabMyTestTasks ammountSquatRepsTabMyTestTaskClick(String s) {
        $("[role=\"form\"] [type=\"number\"]",1).sendKeys(s);
        return new TabMyTestTasks();
    }

    private TabMyTestTasks minutePlanckRepsTabMyTestTaskClick(String s) {
        $("[role=\"form\"] [type=\"number\"]",2).sendKeys(s);
        return new TabMyTestTasks();
    }

    private TabMyTestTasks secondPlanckRepsTabMyTestTaskClick(String s) {
        $("[role=\"form\"] [type=\"number\"]",3).sendKeys(s);
        return new TabMyTestTasks();
    }

    private TabMyTestTasks videoFieldPushUpRepsTabMyTestTask(String s) {
        $("[class=\"js-field-video form-control\"]",0).sendKeys(s);
        return new TabMyTestTasks();
    }

    private TabMyTestTasks videoFieldSquatRepsTabMyTestTask(String s) {
        $("[class=\"js-field-video form-control\"]",1).sendKeys(s);
        return new TabMyTestTasks();
    }

    private TabMyTestTasks videoFieldPlanckRepsTabMyTestTask(String s) {
        $("[class=\"js-field-video form-control\"]",2).sendKeys(s);
        return new TabMyTestTasks();
    }

    public String hrefLinkExistInsidePushUpFormTabMyTestTask() {
        return $("[class=\"test-result-link\"]", 0).val("href").getValue();
        }


    private TabMyTestTasks buttonSavePushUpRepsTabMyTestTask() {
        $("[class=\"button js-save-test-count\"]").click();
        return new TabMyTestTasks();
    }

    private TabMyTestTasks buttonSaveSquatRepsTabMyTestTask() {
        $("[class=\"button js-save-test-count\"]",1).click();
        return new TabMyTestTasks();
    }

    private TabMyTestTasks buttonSavePlanckRepsTabMyTestTask() {
        $("[class=\"button js-save-test-sec\"]").click();
        return new TabMyTestTasks();
    }

    public String ammountOfPushUpField() {
        return $("[class=\"js-value-count\"]",0).getText();
    }

    public String ammountOfSquatField() {
        return $("[class=\"js-value-count\"]",1).getText();
    }

    public String ammountOfPlanckMinuteField() {
        return $("[class=\"js-value-min\"]").getText();
    }

    public String ammountOfPlanckSecondField() {
        return $("[class=\"js-value-sec\"]").getText();
    }

    public TabMyTestTasks pushUpLinkAboveDiagramClick() {
        $("[for=\"tab1\"]").click();
        return new TabMyTestTasks();
    }

    public TabMyTestTasks squatLinkAboveDiagramClick() {
        $("[for=\"tab2\"]").click();
        return new TabMyTestTasks();
    }

    public TabMyTestTasks planckLinkAboveDiagramClick() {
        $("[for=\"tab3\"]").click();
        return new TabMyTestTasks();
    }

    public TabMyTestTasks enterAmmountPushUpAndVideoLinkAndSave(String ammount, String video) {
        tabMyTestTaskLinkClick();
        editPushUpAmmountBtnTabMyTestTaskClick().ammountPushUpRepsTabMyTestTaskClick(ammount)
                .videoFieldPushUpRepsTabMyTestTask(video).buttonSavePushUpRepsTabMyTestTask();
        return new TabMyTestTasks();
    }

    public TabMyTestTasks enterAmmountSquatAndVideoLinkAndSave(String ammount, String video) {
        tabMyTestTaskLinkClick();
        editSquatAmmountBtnTabMyTestTaskClick().ammountSquatRepsTabMyTestTaskClick(ammount)
                .videoFieldSquatRepsTabMyTestTask(video).buttonSaveSquatRepsTabMyTestTask();
        return new TabMyTestTasks();
    }

    public TabMyTestTasks enterTimePlanckAndVideoLinkAndSave(String min, String sec, String link) {
        tabMyTestTaskLinkClick();
        editPlanckAmmountBtnTabMyTestTaskClick().minutePlanckRepsTabMyTestTaskClick(min)
                .secondPlanckRepsTabMyTestTaskClick(sec).videoFieldPlanckRepsTabMyTestTask(link)
                .buttonSavePlanckRepsTabMyTestTask();
        return new TabMyTestTasks();
    }

}
