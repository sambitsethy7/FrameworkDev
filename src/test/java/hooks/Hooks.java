package hooks;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilities.DriverFactory;

public class Hooks {
    private static ExtentReports extent;
    private static ExtentTest test;
    private WebDriver driver;

    @BeforeAll
    public static void setupExtent() {
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        test = extent.createTest(scenario.getName());
        driver = DriverFactory.initializeDriver();
        System.out.println("Browser launched for scenario: " + scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                if (driver != null) {
                    byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                    scenario.attach(screenshot, "image/png", "Failure Screenshot");
                    test.fail("Test failed. Screenshot attached.");
                } else {
                    test.fail("Test failed, but screenshot was not captured because driver was null.");
                }
            } else {
                test.pass("Test passed.");
            }
        } catch (Exception e) {
            test.fail("Exception in @After hook: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DriverFactory.quitDriver();  // ✅ Always quit the driver
            System.out.println("Browser closed after scenario: " + scenario.getName());
        }
    }

    @AfterAll
    public static void tearDownExtent() {
        extent.flush();
        System.out.println("Extent report flushed.");
    }
}
