package com.javatest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public WebDriver driver;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//*[contains(@class, 'sb-destination-label-sr')]")
    private WebElement destinationInputField;

    @FindBy(xpath = "//*[contains(@class, 'xp__dates xp__group')]")
    private WebElement calendarInput;

    @FindBy(xpath = "//*[contains(@class, 'bui-calendar__control bui-calendar__control--next')]")
    private WebElement calendarControlNext;


    public void inputDestination(String destination) {
        destinationInputField.sendKeys(destination);
    }

    public void clickLoginBtn() {
        calendarInput.click();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("1")));
    }
}
