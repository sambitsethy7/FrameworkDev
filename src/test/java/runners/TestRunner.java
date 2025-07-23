package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions", "hooks"},
        tags = "@Smoke",
        plugin = {"pretty", "json:target/cucumber-reports/CucumberTestReport.json"},
        monochrome = true
)
public class TestRunner {
}
