package com.epam.ta.page;

import com.epam.ta.waits.TimeOut;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Profile extends AbstractPage {
    public static String PROFILE_URL = "https://mobistore.by/user";

    public Profile(WebDriver driver) {
        super(driver);
    }

    public String name() {
        String nameOnProfilePage = driver.findElement(By.name("name")).getAttribute("value").trim();
        return nameOnProfilePage;
    }

    @Override
    public Profile openPage() {
        driver.navigate().to(PROFILE_URL);
        TimeOut.waitForPageLoaded(driver);
        return this;
    }
}
