package ru.yougifted.helperpackage;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;

public class PreconditionJunit extends InstanceForAllPages{


    @Before
    public void setUpMethod() {

        
        ChromeDriverManager.getInstance().setup();
        Configuration.browser = "Chrome";
        Configuration.timeout = 25000;
        Selenide.open("http://yg640.testing.place/");


    }

    @After
    public void quit() {
        Selenide.close();
    }
}
