package com.qa.wheelsupUI.pages;

import com.qa.wheelsupUI.base.BasePage;
import com.qa.wheelsupUI.utils.ElementUtil;
import com.qa.wheelsupUI.utils.JavaScriptUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home extends BasePage {
    WebDriver driver;
    ElementUtil elementUtil;
    JavaScriptUtil javaScriptUtil;
    CoreMembership coreMembershipPage;

    By flyingPersonalized = By.xpath("//h1[contains(text(),'Flying, Personalized.')]");
    By discoverPossibilities = By.xpath("//h1[contains(text(),'Discover The Possibilities')]");
    By phoneNumber = By.xpath("//a[contains(text(),'855-FLY-8760')]");
    By email = By.xpath("//a[contains(text(),' info@wheelsup.com ')]");
    By address = By.xpath("//span[@class='base-label']");
    By fly = By.xpath("//a[contains(text(),' Fly ')]");
    By coreMembership = By.xpath("//a[contains(text(),'CORE MEMBERSHIP')]");

    public Home(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
        javaScriptUtil = new JavaScriptUtil(driver);
    }
    public String FlyingPersonalized(){
        elementUtil.waitForElementPresent(flyingPersonalized);
        return elementUtil.doGetText(flyingPersonalized);
}
    public String DiscoverPossibilities(){WebElement discover = driver.findElement(discoverPossibilities);
    elementUtil.waitForElementPresent(discoverPossibilities);
    javaScriptUtil.scrollIntoView(discover);
    return elementUtil.doGetText(discoverPossibilities);}

    public void PrintContactInfo(){
        javaScriptUtil.scrollPageDown();
        System.out.println("Phone Number: "+elementUtil.doGetText(phoneNumber));
        System.out.println("Email: "+elementUtil.doGetText(email));
        System.out.println("address: "+elementUtil.doGetText(address));}

    public CoreMembership navigateToCoreMembership(){
        elementUtil.doClick(fly);
        elementUtil.doClick(coreMembership);
        return coreMembershipPage;
    }
}
