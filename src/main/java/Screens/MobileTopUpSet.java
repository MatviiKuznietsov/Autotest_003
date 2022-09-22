package Screens;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MobileTopUpSet {
    private WebDriver driver;

    String cardN1 = "4444 3333 2222 1111";
    String cardN2 = "4111 1111 1111 1111";
    String data = "12/24";
    String cvv = "123";
    String name1 = "SINZI";
    String surname1 = "IKARY";
    String amountMoney = "10";
    String name2 = "AIANAMI";
    String surname2 = "RAY";

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
        MobileTopUpScreen mobileTopUpScreen = new MobileTopUpScreen(driver);
        mobileTopUpScreen.navigate();
        mobileTopUpScreen.fillCardNumber1(cardN1);
        mobileTopUpScreen.fillData(data);
        mobileTopUpScreen.fillCVV(cvv);
        mobileTopUpScreen.fillName1(name1);
        mobileTopUpScreen.fillSurname1(surname1);
        mobileTopUpScreen.fillCardNumber2(cardN2);
        mobileTopUpScreen.fillName2(name2);
        mobileTopUpScreen.fillSurname2(surname2);
        mobileTopUpScreen.fillSumm(amountMoney);
        mobileTopUpScreen.clickCurrency();
        mobileTopUpScreen.clickUsd();
        mobileTopUpScreen.clickSend();
        Thread.sleep(3000);
        CardModal cardModal = new CardModal((driver));
        Assert.assertEquals(cardN1, cardModal.getTestCard1Value());
        Assert.assertEquals(cardN2, cardModal.getTestCard2Value());
        Assert.assertEquals(amountMoney + " USD", cardModal.getTestCardSumm());

    }
}
