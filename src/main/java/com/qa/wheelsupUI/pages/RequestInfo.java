package com.qa.wheelsupUI.pages;

import com.github.javafaker.Faker;
import com.qa.wheelsupUI.base.BasePage;
import com.qa.wheelsupUI.utils.ElementUtil;
import com.qa.wheelsupUI.utils.JavaScriptUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class RequestInfo extends BasePage {

    WebDriver driver;
    ElementUtil elementUtil;
    JavaScriptUtil javaScriptUtil;

    By email = By.id("Email-clone");
    By phoneNum = By.id("Phone-clone");
    By companyName = By.id("Company__c-clone");
    By address = By.id("Address-clone");
    By city = By.id("City-clone");
    By zipCode = By.id("PostalCode-clone");
    By state = By.id("State-clone");
    By country = By.id("Country-clone");
    By pselect= By.xpath("//p[contains(text(),'Please select one')]");
    By oneToFive = By.xpath("//p[contains(text(),'1-5')]");
    By petsYes = By.xpath("//span[contains(text(),'Yes')]");
    By secondHomeNo = By.xpath("//p[contains(text(),'No')]");
    By secondHomeState = By.id("Second_Home_State__c-clone");
    By commercial = By.xpath("//span[contains(text(),'Commercial')]");
    By coreMember = By.xpath("//span[contains(text(),'Wheels Up Core Membership')]");
    By searchEngine = By.xpath("//p[contains(text(),'Search Engine')]");
    By close = By.xpath("/html/body/app-root/div/div/app-page/div[1]/app-modal-header/div/div/div/div/div[2]/div/i");

    public RequestInfo(WebDriver driver) {
         this.driver = driver;
         elementUtil= new ElementUtil(driver);
         javaScriptUtil = new JavaScriptUtil(driver);

    }
    public String validateAndPrintUrl(){

       if (driver.getCurrentUrl().contains("request-info"))
        return  driver.getCurrentUrl();
       else
           return "Wrong title";
    }
    public void fillOutTheFormAndClose() throws InterruptedException {
        Faker faker = new Faker();
        Thread.sleep(1000);
        elementUtil.doSendKeys(email,"abcgfd@gmail.com");
        Thread.sleep(1000);
        String pn = faker.phoneNumber().toString();
        elementUtil.doSendKeys(phoneNum,pn);
        Thread.sleep(1000);
        String comName = faker.company().toString();
        elementUtil.doSendKeys(companyName,comName);
        Thread.sleep(1000);
        elementUtil.doSendKeys(address,"123 new st");
        Thread.sleep(1000);
        elementUtil.doSendKeys(city,"Priceton");
        Thread.sleep(1000);
        elementUtil.doSendKeys(zipCode,"09876");
        Thread.sleep(1000);
        elementUtil.doSendKeys(state,"NJ");
        Thread.sleep(1000);
        elementUtil.doSendKeys(country,"United States");
        Thread.sleep(1000);
        javaScriptUtil.clickElementByJS(driver.findElement(oneToFive));
        Thread.sleep(1000);
        javaScriptUtil.clickElementByJS(driver.findElement(petsYes));
        Thread.sleep(1000);
        javaScriptUtil.clickElementByJS(driver.findElement(secondHomeNo));
        Thread.sleep(1000);
        javaScriptUtil.clickElementByJS(driver.findElement(commercial));
        Thread.sleep(1000);
        javaScriptUtil.clickElementByJS(driver.findElement(coreMember));
        Thread.sleep(1000);
        javaScriptUtil.clickElementByJS(driver.findElement(searchEngine));
        Thread.sleep(1000);
        elementUtil.doClick(close);
        Thread.sleep(1000);

    }

}
