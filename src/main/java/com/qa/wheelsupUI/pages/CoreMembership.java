package com.qa.wheelsupUI.pages;

import com.qa.wheelsupUI.base.BasePage;
import com.qa.wheelsupUI.utils.ElementUtil;
import com.qa.wheelsupUI.utils.JavaScriptUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CoreMembership extends BasePage {

    WebDriver driver;
    ElementUtil elementUtil;
    JavaScriptUtil javaScriptUtil;
    RequestInfo requestInfo;

    By privateAviation = By.xpath("//h1[contains(text(),'Private aviation ')]");
    By sharedFlights = By.xpath("//h3[contains(text(),'SHARED FLIGHTS')]");
    By shuttleFlights = By.xpath("//h3[contains(text(),'SHUTTLE FLIGHTS')]");
    By hotFlights = By.xpath("//h3[contains(text(),'HOT FLIGHTS')]");
    By learnMore = By.xpath("//h1[contains(text(),'Learn more today')]");
    By firstName = By.id("FirstName-clone");
    By lastName = By.id("LastName-clone");
    By cntinue = By.xpath("//a[contains(text(),' CONTINUE ')]");

    public CoreMembership(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
        javaScriptUtil = new JavaScriptUtil(driver);
    }
    public void scrollPrivateAviationSocialAviation(){
        elementUtil.waitForElementPresent(privateAviation);
        WebElement pA = driver.findElement(privateAviation);
        javaScriptUtil.scrollIntoView(pA);
    }
    public void printFlights(){
        elementUtil.waitForElementPresent(sharedFlights);
        System.out.println(elementUtil.doGetText(sharedFlights));
        System.out.println(elementUtil.doGetText(shuttleFlights));
        System.out.println(elementUtil.doGetText(hotFlights));
    }
    public RequestInfo learnMoreRequest() throws InterruptedException {
        WebElement lm = driver.findElement(learnMore);
        javaScriptUtil.scrollIntoView(lm);
        Thread.sleep(1000);
        elementUtil.doSendKeys(firstName,"Gmz");
        elementUtil.doSendKeys(lastName,"Beren");
        Thread.sleep(1000);
        javaScriptUtil.clickElementByJS(driver.findElement(cntinue));
        Thread.sleep(1000);
        return requestInfo;
    }
}

