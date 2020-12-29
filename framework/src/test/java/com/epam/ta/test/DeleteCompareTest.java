package com.epam.ta.test;

import com.epam.ta.page.CatalogOfHeadphones;
import com.epam.ta.page.ComparePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteCompareTest extends CommonConditions{

    @Test
    public void deleteCompareProduct(){
        CatalogOfHeadphones catalogOfHeadphones = new CatalogOfHeadphones(driver)
                .openPage()
                .addFirstProductToCompare()
                .addSecondProductToCompare()
                .goToComparison();
        ComparePage comparePage = new ComparePage(driver)
                .deleteProduct();
        Integer quantityOfProduct = new  ComparePage(driver)
                .quantity();
        Integer expectedResult = 1;
        Assert.assertEquals(quantityOfProduct, expectedResult);

        ComparePage comparePageDeleteAll = new ComparePage(driver)
                .deleteAllProduct();
        Assert.assertTrue(driver.getCurrentUrl().contains(ComparePage.COMPARE_URL));
    }
}
