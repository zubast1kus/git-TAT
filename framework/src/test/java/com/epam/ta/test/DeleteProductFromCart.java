package com.epam.ta.test;

import com.epam.ta.page.CartPage;
import com.epam.ta.page.CatalogOfHeadphones;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteProductFromCart extends CommonConditions {
    @Test
    public void editCart() {

        CartPage addProductToCart = new CatalogOfHeadphones(driver)
                .openPage()
                .clickToFirstProduct()
                .goToCart();
        CartPage delete = new CartPage(driver)
                .deleteProduct();
        String emptyCart = new CartPage(driver)
                .isEmpty();
        String expectedResult = "Корзина пуста";
        Assert.assertEquals(emptyCart, expectedResult);
    }
}
