package Tests;

import com.qa.wheelsupUI.base.BasePage;
import com.qa.wheelsupUI.pages.Home;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Properties;

public class HomePageTest {
    WebDriver driver;
    BasePage basePage;
    Properties prop;
    Home home;

    @BeforeTest
    public void setUp() throws InterruptedException {
        basePage = new BasePage();
        prop = basePage.init_properties();
        String browserName = prop.getProperty("browser");
        driver = basePage.init_driver(browserName);
        driver.get(prop.getProperty("url"));
        home = new Home(driver);
        Thread.sleep(3000);
    }
    @Test(priority = 1)
    @Description("Print Flying, Personalized")
    public void verifyFlyingPersonalizad(){
        System.out.println(home.FlyingPersonalized());
    }
    @Test(priority = 2,description = "print Discover the possibilities")
    public void verifyDiscoverThePossibilities(){
        System.out.println(home.DiscoverPossibilities());
    }
    @Test(priority = 3,description = "print contact informations")
    public void printContactUs(){
        home.PrintContactInfo();
    }
    @Test(priority = 4)
    public void goToCoreMembershipPage(){
        home.navigateToCoreMembership();
    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }


}
