package com.epam.ta.page;

import com.epam.ta.waits.TimeOut;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CatalogPage extends AbstractPage {
    public static String BASE_URL = "https://mobistore.by/catalog-main";

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    private final By clickToHeadphonesButtonLocator = By.xpath("//div[@id='cat-id-70']/div[1]/a");

    public CatalogPage clickToHeadphonesButton() {
        WebElement selectCategoryHeadphones = driver.findElement(clickToHeadphonesButtonLocator);
        selectCategoryHeadphones.click();
        return this;
    }

    @Override
    public CatalogPage openPage() {
        driver.navigate().to(BASE_URL);
        TimeOut.waitForPageLoaded(driver);
        return this;
    }


}
