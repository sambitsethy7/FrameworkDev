package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {
    @Getter
    private static WebDriver driver;

    public static WebDriver initializeDriver() {
        if (driver == null) {
            String browser = ConfigReader.getProperty("browser");
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;

                default:
                    throw new IllegalArgumentException("Browser \"" + browser + "\" is not supported.");
            }
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(ConfigReader.getProperty("implicitWait"))));
        }
        driver.get(ConfigReader.getProperty("url"));
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
