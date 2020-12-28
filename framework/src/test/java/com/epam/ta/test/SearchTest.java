package com.epam.ta.test;

import com.epam.ta.page.MainPage;
import com.epam.ta.page.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends CommonConditions {
    @Test
    public void searchResultTest(){
        final String searchProduct = "Samsung Galaxy Buds Live";

        MainPage mainPage = new MainPage(driver)
                .openPage()
                .requiredProduct()
                .searchResultButton();
        String requiredProduct = new SearchPage(driver)
                .searchNameFirstProduct();
        Assert.assertEquals(requiredProduct, searchProduct);

    }

}
