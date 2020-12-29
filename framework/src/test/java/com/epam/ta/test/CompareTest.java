package com.epam.ta.test;

import com.epam.ta.page.CatalogOfHeadphones;
import com.epam.ta.page.ComparePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompareTest extends CommonConditions {
    @Test
    public void compareTwoElementsExist() {
        CatalogOfHeadphones catalogOfHeadphones = new CatalogOfHeadphones(driver)
                .openPage()
                .addFirstProductToCompare()
                .addSecondProductToCompare();

        String nameOfFirstProductFromCatalog = new CatalogOfHeadphones(driver)
                .catalogNameFirstProduct();
        String nameOfSecondProductFromCatalog = new CatalogOfHeadphones(driver)
                .catalogNameSecondProduct();
        CatalogOfHeadphones comparePageOpened = new CatalogOfHeadphones(driver)
                .goToComparison();

        String nameOfFirstProductFromCompare = new ComparePage(driver)
                .nameOfFirstProduct();
        String nameOfSecondProductFromCompare = new ComparePage(driver)
                .nameOfSecondProduct();

        Assert.assertEquals(nameOfFirstProductFromCatalog, nameOfFirstProductFromCompare);
        Assert.assertEquals(nameOfSecondProductFromCatalog, nameOfSecondProductFromCompare);
    }

}
