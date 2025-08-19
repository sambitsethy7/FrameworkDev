package stepDefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.LeavePage;
import utilities.DriverFactory;

public class LeaveSteps {
    WebDriver driver = DriverFactory.getDriver();
    LeavePage leavePage = new LeavePage(driver);

    @Then("user verifies the landing page of Leave")
    public void userVerifiesTheLandingPageOfLeave() throws Exception {
        leavePage.verifyLandingPageOfLeave();
    }
}
