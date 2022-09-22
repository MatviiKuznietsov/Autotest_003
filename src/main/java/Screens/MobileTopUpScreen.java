package Screens;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MobileTopUpScreen {
    By cardNumberOut = By.xpath("//input[@data-qa-node='numberdebitSource']");
    By expireData = By.xpath("//input[@data-qa-node='expiredebitSource']");
    By cvvCode = By.xpath("//input[@data-qa-node='cvvdebitSource']");
    By name01 = By.xpath("//input[@data-qa-node='firstNamedebitSource']");
    By surname01 = By.xpath("//input[@data-qa-node='lastNamedebitSource']");
    By cardNumberIn = By.xpath("//input[@data-qa-node='numberreceiver']");
    By name02 = By.xpath("//input[@data-qa-node='firstNamereceiver']");
    By surname02 = By.xpath("//input[@data-qa-node='lastNamereceiver']");
    By amount = By.xpath("//input[@data-qa-node='amount']");
    By currency = By.xpath("//button[@data-qa-node='currency']");
    By usd = By.xpath("//button[@data-qa-value='USD']");
    By uah = By.xpath("//button[@data-qa-value='UAH']");
    By sendButton = By.xpath("//button[@class='sc-VigVT hcHAAV']");
    // Checking elements

    By inputCard = By.xpath("//span[@data-qa-node='receiver-card']");
    By summ = By.xpath("//div[@data-qa-node='payer-amount']");

    String mobileTopUpUrl = "https://next.privat24.ua/money-transfer/card";
    private static WebDriver driver;
    public MobileTopUpScreen (WebDriver driver){
        this.driver = driver;
    }
    public void navigate (){
        driver.get(mobileTopUpUrl);
    }
    public void fillCardNumber1(String cardN1){
        driver.findElement(cardNumberOut).sendKeys(cardN1);
    }
    public void fillData(String data){
        driver.findElement(expireData).sendKeys(data);
    }
    public void fillCVV(String cvv) {
        driver.findElement(cvvCode).sendKeys(cvv);
    }
    public void fillName1(String name1) {driver.findElement(name01).sendKeys(name1);}
    public void fillSurname1(String surname1) {driver.findElement(surname01).sendKeys(surname1);}
    public void fillCardNumber2(String cardN2){
        driver.findElement(cardNumberIn).sendKeys(cardN2);
    }
    public void fillName2(String name2) {driver.findElement(name02).sendKeys(name2);}
    public void fillSurname2(String surname2) {driver.findElement(surname02).sendKeys(surname2);}
    public void fillSumm(String amountMoney){
        driver.findElement(amount).sendKeys(amountMoney);
    }
    public void clickCurrency(){
        driver.findElement(currency).click();
    }
    public void clickUsd(){
        driver.findElement(usd).click();
    }
    public void clickSend(){
        driver.findElement(sendButton).click();
    }


}
