package com.javatest;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.MessageFormat;
import java.time.Duration;

public class BookingTest {
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
    public void SearchLodging_WhenLoggedOut_ShouldFindPropertyCard() {
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
    public void NegativeNewsletterSubscription_WhenLoggedOut_ShouldGetInvalidMessage(){
        basePage = new BasePage(driver);
        String expectedString = "Error:\n" + "Please enter a valid email address.";

        basePage.inputNewsletterSubscription("test@test");
        basePage.clickNewsletterButton();
        String actualString = basePage.GetInvalidMessage();

        Assert.assertEquals(MessageFormat.format("{0} is not equal {1}", expectedString, actualString),expectedString, actualString);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
