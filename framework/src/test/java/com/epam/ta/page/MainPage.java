package com.epam.ta.page;

import com.epam.ta.waits.TimeOut;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends AbstractPage {
    public static String MAIN_URL = "https://mobistore.by/";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private final By clickToCatalogButtonLocator = By.xpath("//div[@id='navbar']/ul[1]/li[1]/a");

    private final By signInLocator = By.id("login");

    private final By loginLabelLocator = By.id("dropdownMenuUser");

    private final By requiredProductLocator = By.xpath("//div[@id='search']//input");

    private final By searchResultButtonLocator = By.xpath("//div[@id='search']//button");

    public MainPage clickToCatalogButton() {
        WebElement linkToCatalog = driver.findElement(clickToCatalogButtonLocator);
        linkToCatalog.click();
        return this;
    }

    public MainPage signIn() {
        WebElement signInButton = driver.findElement(signInLocator);
        signInButton.click();
        return this;
    }

    public String loginLabel() {
        WebElement loginLabelName = driver.findElement(loginLabelLocator);
        return loginLabelName.getText();
    }

    public MainPage loginLabelButton() {
        WebElement loginButton = driver.findElement(loginLabelLocator);
        loginButton.click();
        return this;
    }

    public MainPage requiredProduct() {
        WebElement product = driver.findElement(requiredProductLocator);
        product.sendKeys("Samsung Galaxy Buds Live");
        return this;
    }

    public MainPage searchResultButton() {
        WebElement searchButton = driver.findElement(searchResultButtonLocator);
        searchButton.click();
        return this;
    }

    @Override
    public MainPage openPage() {
        driver.navigate().to(MAIN_URL);
        TimeOut.waitForPageLoaded(driver);
        return this;
    }

}
