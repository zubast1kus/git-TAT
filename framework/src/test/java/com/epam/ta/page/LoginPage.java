package com.epam.ta.page;

import com.epam.ta.service.TestDataReader;
import com.epam.ta.waits.TimeOut;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends AbstractPage {
    public static String LOG_IN = "https://mobistore.by/user/login";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By enterEmailLocator = By.id("email");

    private final By enterPasswordLocator = By.id("password");

    private final By signInLocator = By.name("login");


    public LoginPage enterEmail() {
        WebElement email = driver.findElement(enterEmailLocator);
        email.sendKeys(TestDataReader.getTestData("testdata.user.email"));
        return this;
    }

    public LoginPage enterPassword() {
        WebElement password = driver.findElement(enterPasswordLocator);
        password.sendKeys(TestDataReader.getTestData("testdata.user.password"));
        return this;
    }

    public LoginPage signIn() {
        WebElement logInButton = driver.findElement(signInLocator);
        logInButton.click();
        return this;
    }

    @Override
    public LoginPage openPage() {
        driver.navigate().to(LOG_IN);
        TimeOut.waitForPageLoaded(driver);
        return this;
    }
}
