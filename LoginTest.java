import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        Path page = Paths.get("webapp", "index.html").toAbsolutePath();
        driver.get(page.toUri().toString());
    }

    @Test
    public void validLoginShouldShowSuccessMessage() throws Exception {
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Selenium@123");
        driver.findElement(By.id("loginBtn")).click();

        WebElement message = driver.findElement(By.id("message"));
        assertTrue(message.isDisplayed());
        assertEquals("Login successful!", message.getText());

        saveScreenshot("successful-login.png");
    }

    @Test
    public void invalidLoginShouldShowErrorMessage() throws Exception {
        driver.findElement(By.id("username")).sendKeys("wronguser");
        driver.findElement(By.id("password")).sendKeys("wrongpass");
        driver.findElement(By.id("loginBtn")).click();

        WebElement message = driver.findElement(By.id("message"));
        assertTrue(message.isDisplayed());
        assertEquals("Invalid username or password!", message.getText());

        saveScreenshot("invalid-login.png");
    }

    private void saveScreenshot(String fileName) throws Exception {
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destination = new File("screenshots", fileName);
        if (destination.getParentFile() != null) {
            destination.getParentFile().mkdirs();
        }
        FileHandler.copy(source, destination);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}