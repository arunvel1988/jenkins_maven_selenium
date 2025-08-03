// File: Demo.java
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Demo {

    public WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        // Setup FirefoxDriver using WebDriverManager
        WebDriverManager.firefoxdriver().setup();

        // Set Firefox to headless mode
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true); // or: options.addArguments("--headless");

        // Create a new instance of the FirefoxDriver with options
        driver = new FirefoxDriver(options);

        // Navigate to the website and perform login
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @Test
    public void test1() {
        // Verify that the Products page loaded
        WebElement text = driver.findElement(By.xpath("//span[text()='Products']"));
        String expectedText = "Products";
        String actualText = text.getText();
        Assert.assertEquals(actualText, expectedText);
    }

    @AfterClass
    public void afterClass() {
        // Close the browser and WebDriver
        if (driver != null) {
            driver.quit();
        }
    }
}
