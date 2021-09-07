package Tests;

import com.qa.wheelsupUI.base.BasePage;
import com.qa.wheelsupUI.pages.CoreMembership;
import com.qa.wheelsupUI.pages.Home;
import com.qa.wheelsupUI.pages.RequestInfo;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Properties;

public class RequestinfoPageTest {

    WebDriver driver;
    BasePage basePage;
    Properties prop;
    Home home;
    CoreMembership coreMembership;
    RequestInfo requestInfo;

    @BeforeTest
    public void setUp() throws InterruptedException {
        basePage = new BasePage();
        prop = basePage.init_properties();
        String browserName = prop.getProperty("browser");
        driver = basePage.init_driver(browserName);
        driver.get(prop.getProperty("url"));
        Thread.sleep(3000);
        home = new Home(driver);
        home.navigateToCoreMembership();
        coreMembership = new CoreMembership(driver);
        Thread.sleep(2000);
        requestInfo = new RequestInfo(driver);
        coreMembership.learnMoreRequest();
        Thread.sleep(2000);

    }

    @Test(priority = 1)
    public void validateUrl(){
        System.out.println("Current Url: "+ requestInfo.validateAndPrintUrl());
    }
    @Test(priority = 2)
    public void fillTheForm() throws InterruptedException {
        requestInfo.fillOutTheFormAndClose();

    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
