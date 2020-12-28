package com.epam.ta.page;

import com.epam.ta.waits.TimeOut;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DiscountProductsPage extends AbstractPage {
    public static String DISCOUNT_URL = "https://mobistore.by/aktsii";

    public DiscountProductsPage(WebDriver driver) {
        super(driver);
    }

    private final By goToSaleLocator = By.xpath("//a[contains(text(), 'Товары по акции')]");

    private final By IsElementDisplayedLocator = By.xpath("//div[@class='products-table']//div[@class='product__stickers-area']");

    public DiscountProductsPage goToSale() {
        WebElement buttonSale = driver.findElement(goToSaleLocator);
        buttonSale.click();
        return this;
    }

    public boolean IsElementDisplayed() {
        if (driver.findElements(IsElementDisplayedLocator).size() >= 12) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public DiscountProductsPage openPage() {
        driver.navigate().to(DISCOUNT_URL);
        TimeOut.waitForPageLoaded(driver);
        return this;
    }
}
