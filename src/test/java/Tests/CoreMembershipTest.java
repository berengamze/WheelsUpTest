package Tests;

import com.qa.wheelsupUI.base.BasePage;
import com.qa.wheelsupUI.pages.CoreMembership;
import com.qa.wheelsupUI.pages.Home;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.Properties;

import static org.testng.Assert.*;

public class CoreMembershipTest {
    WebDriver driver;
    BasePage basePage;
    Properties prop;
    Home home;
    CoreMembership coreMembership;

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

    }

    @Test(priority = 1)
    public void testScrollPrivateAviationSocialAviation() {
        coreMembership.scrollPrivateAviationSocialAviation();
    }

    @Test(priority = 2)
    public void testPrintFlights() {
        coreMembership.printFlights();
    }

    @Test(priority = 3)
    public void testLearnMoreRequest() throws InterruptedException {
        coreMembership.learnMoreRequest();
    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}