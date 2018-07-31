package ru.yougifted.helperpackage;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Precondition extends InstanceForAllPages {


    @BeforeMethod
    protected void setUpMethod() {

        ChromeDriverManager.getInstance().setup();
        Configuration.browser = "Chrome";
        Configuration.timeout = 10000;
        Selenide.open("http://yg640.testing.place/");


    }

    @AfterMethod
    public void quit() {
        Selenide.close();
    }
}