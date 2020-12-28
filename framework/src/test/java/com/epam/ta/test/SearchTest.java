package com.epam.ta.test;

import com.epam.ta.page.MainPage;
import com.epam.ta.page.SearchPage;
import com.epam.ta.service.TestDataReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends CommonConditions {
    @Test
    public void searchResultTest() {
        final String NAME_PRODUCT_PROPERTY = "testdata.product";
        final String searchProduct = TestDataReader.getTestData(NAME_PRODUCT_PROPERTY);

        MainPage mainPage = new MainPage(driver)
                .openPage()
                .requiredProduct()
                .searchResultButton();
        String requiredProduct = new SearchPage(driver)
                .searchNameFirstProduct();
        Assert.assertEquals(requiredProduct, searchProduct);

    }

}
