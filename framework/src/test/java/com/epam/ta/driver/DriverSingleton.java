package com.epam.ta.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {

    private static WebDriver driver;


    private DriverSingleton(){}

    public static WebDriver getDriver(){
        if (null == driver){
            switch (System.getProperty("browser")){
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
                default: {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
            }
            //driver.manage().window().maximize();
            driver.manage().window().setSize(new Dimension(1920,1080));
            driver.manage().window().setSize(new Dimension(Integer.parseInt("w"),Integer.parseInt("h")));

        }
        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}
