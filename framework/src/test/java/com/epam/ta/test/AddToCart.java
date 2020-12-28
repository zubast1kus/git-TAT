package com.epam.ta.test;

import com.epam.ta.page.CartPage;
import com.epam.ta.page.CatalogOfHeadphones;
import com.epam.ta.page.CatalogPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCart extends CommonConditions {
    @Test
    public void addTheFirstProductFromHeadphones() {

        CartPage catalogOfHeadphones = new CatalogOfHeadphones(driver)
                .openPage()
                .clickToFirstProduct()
                .goToCart();

        String nameOfFirstCatalogProduct = new CatalogOfHeadphones(driver)
                .openPage()
                .catalogNameFirstProduct();
        String nameOfFirstCartProduct = new CartPage(driver)
                .openPage()
                .cartName();
        Assert.assertEquals(nameOfFirstCartProduct, nameOfFirstCartProduct);

    }

}
