package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions", "hooks"},
        tags = "@new",
        plugin = {"pretty",
                "json:target/cucumber-json/cucumber.json",
                "html:target/cucumber-reports/CucumberTestReport.html",
                "rerun:target/failed_scenarios.txt"},
        monochrome = true
)
public class TestRunner {
}
