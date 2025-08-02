import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Demo {

    public WebDriver driver;


    @BeforeClass
    public void beforeClass() {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the ChromeDriver
        driver = new FirefoxDriver();

        // Navigate to a website
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }
        @Test
    public void test1() {
        //System.out.println("test 1");

            WebElement text = driver.findElement(By.xpath("//span[text()='Products']"));

            String originalText = "Products";
            String expectedText = text.getText();
            Assert.assertEquals(originalText,expectedText);
    }

    @AfterClass
    public void afterClass() {
        // Close the WebDriver instance
        driver.quit();
    }
}
