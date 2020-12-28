package com.epam.ta.test;

import com.epam.ta.page.CartPage;
import com.epam.ta.page.CatalogOfHeadphones;
import com.epam.ta.page.CatalogPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditingCart extends CommonConditions {
    @Test
    public void editCart() {
        CatalogPage catalogPage = new CatalogPage(driver)
                .openPage()
                .clickToHeadphonesButton();
        Assert.assertTrue(driver.getCurrentUrl().contains(CatalogOfHeadphones.FIRST_CATALOG_URL));

        CatalogOfHeadphones catalogOfHeadphones = new CatalogOfHeadphones(driver)
                .openPage()
                .clickToFirstProduct()
                .goToCart();
        Integer priceFromCart = new CartPage(driver)
                .price();
        CartPage cartPageAfterIncreasing = new CartPage(driver)
                .increaseTheQuantityOfGoodsByOne();
        Integer priceFromCartAfterIncreasing = new CartPage(driver)
                .price();
        Integer priceSame = priceFromCartAfterIncreasing / 2;
        Assert.assertEquals(priceFromCart, priceSame);
        CartPage cartPageAfterDecreasing = new CartPage(driver)
                .decreaseTheQuantityOfGoodsByOne();
        Integer priceFromCartAfterDecreasing = new CartPage(driver)
                .price();
        Assert.assertEquals(priceFromCart, priceFromCartAfterDecreasing);
        CartPage delete = new CartPage(driver)
                .deleteProduct();
        String emptyCart = new CartPage(driver)
                .isEmpty();
        String expectedResult = "Корзина пуста";
        Assert.assertEquals(emptyCart, expectedResult);


    }
}
