package com.epam.ta.page;

import com.epam.ta.service.ObtainingValidData;
import com.epam.ta.waits.TimeOut;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ComparePage extends AbstractPage {
    public static String COMPARE_URL = "https://mobistore.by/compare/";

    public ComparePage(WebDriver driver) {
        super(driver);
    }

    private final By nameOfFirstProductLocator = By.xpath("//tr[1]/th[2]/span");

    private final By nameOfSecondProductLocator = By.xpath("//tr[1]/th[3]/span");

    private final By deleteProductLocator = By.xpath("//table[@id='compare']//th[2]/a[1]");

    private final By deleteAllProductLocator = By.xpath("//a[@class = 'del']");

    private final By quantityLocator = By.xpath("//a[@id='compare-items']");

    public String nameOfFirstProduct() {
        WebElement nameOf = driver.findElement(nameOfFirstProductLocator);
        return nameOf.getText();
    }

    public String nameOfSecondProduct() {
        WebElement nameOf = driver.findElement(nameOfSecondProductLocator);
        return nameOf.getText();
    }

    public ComparePage deleteProduct() {
        WebElement buttonDelete = driver.findElement(deleteProductLocator);
        buttonDelete.click();
        return this;

    }

    public ComparePage deleteAllProduct() {
        WebElement buttonDeleteAll = driver.findElement(deleteAllProductLocator);
        buttonDeleteAll.click();
        return this;

    }

    public Integer quantity() {
        WebElement quantityOf = driver.findElement(quantityLocator);
        return ObtainingValidData.quantity(quantityOf.getText());
    }


    @Override
    public ComparePage openPage() {
        driver.navigate().to(COMPARE_URL);
        TimeOut.waitForPageLoaded(driver);
        return this;
    }

}
