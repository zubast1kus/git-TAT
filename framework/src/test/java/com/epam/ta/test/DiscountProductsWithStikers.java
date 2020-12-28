package com.epam.ta.test;

import com.epam.ta.page.DiscountProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DiscountProductsWithStikers extends CommonConditions {

    @Test
    public void isStikersDisplayed() {
        boolean stickersDisplayed = new DiscountProductsPage(driver)
                .openPage()
                .goToSale()
                .IsElementDisplayed();
        Assert.assertTrue(stickersDisplayed);

    }
}
