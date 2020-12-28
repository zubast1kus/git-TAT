package com.epam.ta.page;

import com.epam.ta.waits.TimeOut;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends AbstractPage {
    public static String SEARCH_URL = "https://mobistore.by/search";

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    private final By searchNameFirstProductLocator = By.xpath("//div[@id='products-table']/div/div[1]//a[@class='product-name']/span");

    public String searchNameFirstProduct() {
        WebElement nameOf = driver.findElement(searchNameFirstProductLocator);
        return nameOf.getText();
    }

    @Override
    public SearchPage openPage() {
        driver.navigate().to(SEARCH_URL);
        TimeOut.waitForPageLoaded(driver);
        return this;
    }
}
