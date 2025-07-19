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
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failure Screenshot");
            test.fail("Test failed. Screenshot attached.");
        } else {
            test.pass("Test passed.");
        }
        DriverFactory.quitDriver();
    }

    @AfterAll
    public static void tearDownExtent() {
        extent.flush();
    }
}
