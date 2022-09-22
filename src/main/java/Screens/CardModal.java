package Screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CardModal {

    By outputCard = By.xpath("//span[@data-qa-node='payer-card']");
    By inputCard = By.xpath("//span[@data-qa-node='receiver-card']");
    By summ = By.xpath("//div[@data-qa-node='payer-amount']");
    private static WebDriver driver;
    public CardModal (WebDriver driver){
        this.driver = driver;
    }
    public String  getTestCard1Value(){
        return driver.findElement(outputCard).getText();
    }
    public String  getTestCard2Value(){
        return driver.findElement(inputCard).getText();
    }
    public String  getTestCardSumm(){
        return driver.findElement(summ).getText();
    }
}
