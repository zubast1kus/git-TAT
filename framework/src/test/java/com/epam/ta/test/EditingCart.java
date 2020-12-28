package com.epam.ta.test;

import com.epam.ta.page.CartPage;
import com.epam.ta.page.CatalogOfHeadphones;
import com.epam.ta.page.CatalogPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditingCart extends CommonConditions {
    @Test
    public void editCart() {

        Integer priceFromCart = new CatalogOfHeadphones(driver)
                .openPage()
                .clickToFirstProduct()
                .goToCart()
                .price();
        CartPage cartPageAfterIncreasing = new CartPage(driver)
                .increaseTheQuantityOfGoodsByOne();
        CartPage cartPageAfterDecreasing = new CartPage(driver)
                .decreaseTheQuantityOfGoodsByOne();
        Integer priceFromCartAfterDecreasing = new CartPage(driver)
                .price();
        Assert.assertEquals(priceFromCart, priceFromCartAfterDecreasing);

    }
}
