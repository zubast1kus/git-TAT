package com.epam.ta.test;

import com.epam.ta.page.CartPage;
import com.epam.ta.page.CatalogOfHeadphones;
import com.epam.ta.page.ComparePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompareElements extends CommonConditions {
    @Test
    public void compareTwoElements() {
        CatalogOfHeadphones catalogOfHeadphones = new CatalogOfHeadphones(driver)
                .openPage()
                .addFirstProductToCompare()
                .addSecondProductToCompare();
        Integer quantity = new CatalogOfHeadphones(driver)
                .quantity();
        Integer expectedResult = 2;
        Assert.assertEquals(quantity, expectedResult);

        String nameOfFirstProductFromCatalog = new CatalogOfHeadphones(driver)
                .catalogNameFirstProduct();
        String nameOfSecondProductFromCatalog = new CatalogOfHeadphones(driver)
                .catalogNameSecondProduct();

        CatalogOfHeadphones catalogOfHeadphones1 = new CatalogOfHeadphones(driver)
                .goToComparison();

        String nameOfFirstProductFromCompare = new ComparePage(driver)
                .nameOfFirstProduct();
        String nameOfSecondProductFromCompare = new ComparePage(driver)
                .nameOfSecondProduct();
        Assert.assertEquals(nameOfFirstProductFromCatalog, nameOfFirstProductFromCompare);
        Assert.assertEquals(nameOfSecondProductFromCatalog, nameOfSecondProductFromCompare);

        ComparePage comparePage = new ComparePage(driver)
                .deleteProduct();
        Integer quantityOfProduct = new  ComparePage(driver)
                .quantity();
        Integer expectedResult1 = 1;
        Assert.assertEquals(quantityOfProduct, expectedResult1);
        ComparePage comparePageDeleteAll = new ComparePage(driver)
                .deleteAllProduct();
        Assert.assertTrue(driver.getCurrentUrl().contains(ComparePage.COMPARE_URL));
    }
}
