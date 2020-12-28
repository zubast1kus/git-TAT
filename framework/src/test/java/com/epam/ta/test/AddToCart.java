package com.epam.ta.test;

import com.epam.ta.page.CartPage;
import com.epam.ta.page.CatalogOfHeadphones;
import com.epam.ta.page.CatalogPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCart extends CommonConditions {
    @Test
    public void addTheFirstProductFromHeadphones() {
        CatalogPage catalogPage = new CatalogPage(driver)
                .openPage()
                .clickToHeadphonesButton();
        Assert.assertTrue(driver.getCurrentUrl().contains(CatalogOfHeadphones.FIRST_CATALOG_URL));

        CatalogOfHeadphones catalogOfHeadphones = new CatalogOfHeadphones(driver)
                .openPage()
                .clickToFirstProduct()
                .goToCart();
        Assert.assertTrue(driver.getCurrentUrl().contains(CartPage.CART_URL));

        String nameOfFirstProduct = new CatalogOfHeadphones(driver)
                .openPage()
                .catalogNameFirstProduct();
        String nameOfSecondProduct = new CartPage(driver)
                .openPage()
                .cartName();
        Assert.assertEquals(nameOfFirstProduct, nameOfSecondProduct);


    }

}
