package Abizer;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTest {
    private WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "D:\\Devops\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test(priority = 1)
    public void testFORopen() {
        // Navigate to the specified URL
        driver.get("http://127.0.0.1:5500/index.html");
    }

    @Test(priority = 2)
    public void testFORregistration() {
        // Find the 'userRegistration' element and click on it
        WebElement next = driver.findElement(By.xpath("/html/body/a[1]"));
        next.click();

        // Enter valid details for registration
        WebElement userName = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        userName.sendKeys("AdminUTI");
//
        WebElement reg = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/button[1]"));
        reg.click();
    }
    @Test(priority = 3)
    public void testUserRegistration() {
        // Assuming the registration process was successful, check for a success message or element
        WebElement successMessage = driver.findElement(By.xpath("//div[@class='success-message']"));
        
        // Assert that the success message is displayed
        Assert.assertTrue(successMessage.isDisplayed(), "User registration was not successful.");

        // You can add additional assertions or verifications here based on your application's behavior.
    }
    

    @AfterTest
    public void afterTest() {
        // Close the browser after the test execution
        //driver.quit();
    }
}
