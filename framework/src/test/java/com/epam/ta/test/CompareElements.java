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

    }
}
