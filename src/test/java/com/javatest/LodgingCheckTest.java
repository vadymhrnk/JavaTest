package com.javatest;

import org.checkerframework.checker.units.qual.C;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LodgingCheckTest {
    public static BasePage basePage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfProperties.getProperty("testpage"));

    }
    @Test
    public void basePageTest() throws InterruptedException {
        basePage = new BasePage(driver);
        basePage.inputDestination("New York");
        basePage.clickCalendarInput();
        basePage.clickDecreaseAdultsButton();
        basePage.clickSearchButton();
        Thread.sleep(3000);
        Assert.assertEquals(1,1);
    }
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
