package utils;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    private static WebDriver driver;

    public static void setup() {
        if (driver == null) {  // Ensure driver is initialized only once
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000)); // 3 seconds implicit wait
        }
    }

    public static void teardown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static WebDriver getDriver() { 
        if (driver == null) {
            setup();  // Ensure setup is called before returning driver
        }
        return driver;
    }
}
