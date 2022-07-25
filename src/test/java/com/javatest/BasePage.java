package com.javatest;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class BasePage {

    public WebDriver driver;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@class, 'sb-destination-label-sr')]")
    private WebElement destinationInputField;

    @FindBy(xpath = "//*[contains(@class, 'xp__dates xp__group')]")
    private WebElement calendarInput;

    @FindBy(xpath = "//*[contains(@class, 'bui-calendar__control bui-calendar__control--next')]")
    private WebElement calendarControlNext;

    @FindBy(xpath = "//*[contains(@data-date, '2022-12-01')]")
    private WebElement calendarFirstDate;

    @FindBy(xpath = "//*[contains(@data-date, '2022-12-30')]")
    private WebElement calendarSecondDate;

    @FindBy(xpath = "//*[contains(@class, 'xp__input-group xp__guests')]")
    private WebElement guestsInput;

    @FindBy(xpath = "//*[contains(@aria-label, 'Decrease number of Adults')]")
    private WebElement decreaseAdultsButton;

    @FindBy(xpath = "//*[contains(@class, 'xp__button')]")
    private WebElement SearchButton;


    public void inputDestination(String destination) {
        destinationInputField.sendKeys(destination);
    }

    private boolean isElementVisible(WebDriver driver, By by) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } finally {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        }
    }

    public void clickCalendarInput() {
        calendarInput.click();
        while (!isElementVisible(driver, By.xpath("//*[contains(@data-date, '2022-12-01')]"))) {
            calendarControlNext.click();
        }
        calendarFirstDate.click();
        calendarSecondDate.click();

    }

    public void clickDecreaseAdultsButton() {
        guestsInput.click();
        decreaseAdultsButton.click();
    }

    public void clickSearchButton() {
        SearchButton.click();
    }
}