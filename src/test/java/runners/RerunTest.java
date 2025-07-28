package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/failed_scenarios.txt",
        glue = {"stepDefinitions", "hooks"},
        plugin = {"pretty", "summary",
                "html:target/rerun-reports/html",
                "json:target/rerun-reports/cucumber.json"
        },
        monochrome = true
)
public class RerunTest {
}
