package Screens;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SecondSimpleTest {
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
    By outputCard = By.xpath("//span[@data-qa-node='payer-card']");
    By inputCard = By.xpath("//span[@data-qa-node='receiver-card']");
    By summ = By.xpath("//div[@data-qa-node='payer-amount']");
    String cardN1 = "4444 3333 2222 1111";
    String cardN2 = "4111 1111 1111 1111";
    String data = "12/24";
    String cvv = "123";
    String name1 = "SINZI";
    String surname1 = "IKARY";
    String name2 = "AIANAMI";
    String surname2 = "RAY";
    String amountMoney = "10";

        private WebDriver driver;
        @Before
        public void setUp(){
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get("https://next.privat24.ua/money-transfer/card");
        }
        @After
        public void tearDown(){
            driver.quit();
        }
   @Test
    public void checkTopUpMinSum() throws InterruptedException {
       driver.findElement(cardNumberOut).sendKeys(cardN1);
       driver.findElement(expireData).sendKeys(data);
       driver.findElement(cvvCode).sendKeys(cvv);

       driver.findElement(name01).sendKeys(name1);
       driver.findElement(surname01).sendKeys(surname1);

       driver.findElement(cardNumberIn).sendKeys(cardN2);

       driver.findElement(name02).sendKeys(name2);
       driver.findElement(surname02).sendKeys(surname2);

       driver.findElement(amount).sendKeys(amountMoney);
       driver.findElement(currency).click();
       driver.findElement(usd).click();
       driver.findElement(sendButton).submit();
       Thread.sleep(2000);
       Assert.assertEquals(cardN1, driver.findElement(outputCard).getText());
       Assert.assertEquals(cardN2, driver.findElement(inputCard).getText());
       Assert.assertEquals(amountMoney + " USD", driver.findElement(summ).getText());


    }


}
