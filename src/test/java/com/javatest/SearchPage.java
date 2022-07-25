package com.javatest;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchPage {

    public WebDriver driver;

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindAll({@FindBy(xpath = "//*[contains(@data-testid, 'address')]")})
    private List<WebElement> propertyCardAddresses;

    @FindAll({@FindBy(xpath = "//*[contains(@data-testid, 'price-for-x-nights')]")})
    private List<WebElement> propertyCardNights;

    public List<WebElement> getAddressList() {
        return propertyCardAddresses;
    }

    public List<WebElement> getNightsList() {
        return propertyCardNights;
    }

}
