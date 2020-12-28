package com.epam.ta.page;

import com.epam.ta.service.ObtainingValidData;
import com.epam.ta.waits.TimeOut;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CatalogOfHeadphones extends AbstractPage {
    public static String FIRST_CATALOG_URL = "https://mobistore.by/naushniki";

    public CatalogOfHeadphones(WebDriver driver) {
        super(driver);
    }

    private final By selectFirstHeadphonesLocator = By.xpath("//div[@id='products-table']/div/div[1]//form//div[@class='product__offer__right']/input");

    private final By catalogNameFirstProductLocator = By.xpath("//div[@id='products-table']/div/div[1]//a[@class='product-name']/span");

    private final By catalogNameSecondProductLocator = By.xpath("//div[@id='products-table']/div/div[2]//a[@class='product-name']/span");

    private final By goToCartLocator = By.xpath("//div[@role='dialog']/div[3]/div[2]/button");

    private final By addFirstProductToCompareLocator = By.xpath("//div[@id='products-table']/div/div[1]/div/div[2]/div[2]/div/label/span");

    private final By addSecondProductToCompareLocator = By.xpath("//div[@id='products-table']/div/div[2]/div/div[2]/div[2]/div/label/span");

    private final By goToComparisonLocator = By.xpath("//a[@id='compare-items']");

    private final By quantityLocator = By.xpath("//a[@id='compare-items']");


    public String catalogNameFirstProduct() {
        WebElement nameOf = driver.findElement(catalogNameFirstProductLocator);
        logger.info("Name of product from catalog was taken");
        return nameOf.getText();
    }

    public String catalogNameSecondProduct() {
        WebElement nameOf = driver.findElement(catalogNameSecondProductLocator);
        logger.info("Name of product from catalog was taken");
        return nameOf.getText();
    }

    public CatalogOfHeadphones clickToFirstProduct() {
        WebElement selectFirstHeadphones = driver.findElement(selectFirstHeadphonesLocator);
        selectFirstHeadphones.click();
        return this;
    }


    public CartPage goToCart() {
        WebElement linkToCartImmediately = driver.findElement(goToCartLocator);
        linkToCartImmediately.click();
        return new CartPage(driver);
    }

    public CatalogOfHeadphones addFirstProductToCompare() {
        WebElement buttonAddToCompare = driver.findElement(addFirstProductToCompareLocator);
        buttonAddToCompare.click();
        return this;
    }

    public CatalogOfHeadphones addSecondProductToCompare() {
        WebElement buttonAddToCompare = driver.findElement(addSecondProductToCompareLocator);
        buttonAddToCompare.click();
        return this;
    }

    public CatalogOfHeadphones goToComparison() {
        WebElement buttonGoToCompare = driver.findElement(goToComparisonLocator);
        buttonGoToCompare.click();
        return this;
    }

    public Integer quantity() {
        WebElement quantityOf = driver.findElement(quantityLocator);
        return ObtainingValidData.quantity(quantityOf.getText());
    }

    @Override
    public CatalogOfHeadphones openPage() {
        driver.navigate().to(FIRST_CATALOG_URL);
        TimeOut.waitForPageLoaded(driver);
        return this;
    }

}
