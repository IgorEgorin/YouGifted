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

    @AfterClass
    public void quit() {
        Selenide.close();
    }
//
//    private WebDriver driver;
//    public static final String USERNAME = "Alex23232222";
//    public static final String ACCESS_KEY = "87a870b9-e730-42ca-adea-50dd3f7fd374";
//    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
//
//
//    @BeforeMethod()
//    protected void setUpMethod() throws Exception {
//        DesiredCapabilities caps = DesiredCapabilities.edge();
//        caps.setCapability("platform", "Windows 10");
//        caps.setCapability("version", "16.16299");
//        caps.setCapability("screenResolution", "1280x1024");
//
//        driver = new RemoteWebDriver(new URL(URL), caps);
//        driver.navigate().to("https://yandex.ru/");
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        WebDriverRunner.setWebDriver(driver);
//
//    }
//
//    @AfterMethod()
//    public void quit() {
//        Selenide.close();
//    }
}