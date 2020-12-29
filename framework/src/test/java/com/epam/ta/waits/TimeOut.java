package com.epam.ta.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TimeOut {
    private static final int WAIT_TIMEOUT_SECONDS = 10;

    public static void waitForPageLoaded(WebDriver driver) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(waitForLoad());
    }

    public static ExpectedCondition<Boolean> waitForLoad() {
        return driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
    }

    public static WebElement checkClickable(By element, WebDriver driver) {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(element));
    }

}
