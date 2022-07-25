package com.javatest;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LodgingCheckTest {
    public static BasePage basePage;
    public static SearchPage searchPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfProperties.getProperty("testpage"));
    }

    @Test
    public void searchLodgingTest() {
        basePage = new BasePage(driver);
        searchPage = new SearchPage(driver);
        basePage.inputDestination("New York");
        basePage.clickCalendarInput();
        basePage.clickDecreaseAdultsButton();
        basePage.clickSearchButton();

        for (int i = 0; i < searchPage.getAddressList().size(); i++) {
            Assert.assertTrue("Property card don't contain \"New York\"", (searchPage.getAddressList().get(i).getText().contains("New York")));
        }

        for (int i = 0; i < searchPage.getNightsList().size(); i++) {
            Assert.assertTrue("Property card don't contain \"29 nights\"", (searchPage.getNightsList().get(i).getText().contains("29 nights")));
        }
    }
    @Test
    public void someTest(){

    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
