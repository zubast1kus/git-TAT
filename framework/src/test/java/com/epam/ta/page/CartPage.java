package com.epam.ta.page;

import com.epam.ta.service.ObtainingValidData;
import com.epam.ta.waits.TimeOut;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends AbstractPage {
    public static String CART_URL = "https://mobistore.by/cart";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private final By buttonPlusLocator = By.xpath("//button[@class='cart-amount__plus']");

    private final By cartNameLocator = By.xpath("//div[@class='cart-product-name-text']");

    private final By buttonMinusLocator = By.xpath("//button[@class='cart-amount__minus']");

    private final By priceLocator = By.xpath("//div[@class='cart-price-text']");

    private final By deleteProductLocator = By.xpath("//a[@class='remove-cart']");

    private final By isEmptyLocator = By.xpath("//h3[contains(text(), 'Корзина пуста')]");

    public String cartName() {
        WebElement nameOf = driver.findElement(cartNameLocator);
        logger.info("Name of product from cart was taken");
        return nameOf.getText();
    }

    public CartPage increaseTheQuantityOfGoodsByOne() {
        WebElement buttonPlus = driver.findElement(buttonPlusLocator);
        buttonPlus.click();
        return this;
    }

    public CartPage decreaseTheQuantityOfGoodsByOne() {
        WebElement buttonMinus = driver.findElement(buttonMinusLocator);
        buttonMinus.click();
        return this;
    }

    public Integer price() {
        WebElement valueOf = driver.findElement(priceLocator);
        return ObtainingValidData.castString(valueOf.getText());
    }

    public CartPage deleteProduct() {
        WebElement buttonDelete = driver.findElement(deleteProductLocator);
        buttonDelete.click();
        return this;
    }

    public String isEmpty() {
        WebElement fieldIsEmpty = driver.findElement(isEmptyLocator);
        return fieldIsEmpty.getText();
    }


    @Override
    public CartPage openPage() {
        driver.navigate().to(CART_URL);
        TimeOut.waitForPageLoaded(driver);
        return this;
    }
}
