package by.bsu.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SignInWithValidDate {
    private static final String MAIN_PAGE = "https://mobistore.by/";
    private static WebDriver driver;

    @BeforeAll
    static void setUp() {
        String currentDir = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", currentDir + "\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }


    @Test
    void signInTest() {
        driver.get(MAIN_PAGE);
        WebElement signInButton = driver.findElement(By.id("login"));
        assertTrue(signInButton.isDisplayed());
        signInButton.click();

        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("password"));
        email.sendKeys("zubastiysteam@gmail.com");
        password.sendKeys("KirillSergevichOchenKrut");

        WebElement logInButton = driver.findElement(By.name("login"));
        logInButton.click();

        WebElement loginLabel = driver.findElement(By.id("dropdownMenuUser"));
        assertTrue(loginLabel.isDisplayed());
        String login = loginLabel.getText();
        loginLabel.click();

        WebElement profileButton = driver.findElement(By.partialLinkText("Личный кабинет"));
        assertTrue(profileButton.isDisplayed());
        profileButton.click();

        String nameOnProfilePage = driver.findElement(By.name("name")).getAttribute("value").trim();
        assertEquals(login, nameOnProfilePage);


    }
}
