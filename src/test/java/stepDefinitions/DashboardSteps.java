package stepDefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import utilities.DriverFactory;

public class DashboardSteps {
    WebDriver driver = DriverFactory.getDriver();
    DashboardPage dashboardPage = new DashboardPage(driver);

    @Then("verify the options present in user dropdown")
    public void verifyTheOptionsPresentInUserDropdown() throws Exception {
        dashboardPage.verifyOptionsPresentInUserDropdown();
    }

    @Then("user clicks on logout option")
    public void userClicksOnLogoutOption() throws Exception {
        dashboardPage.clickLogout();
    }

    @Then("i verify all images present in dashboard page")
    public void iVerifyAllImagesPresentInDashboardPage() throws Exception {
        dashboardPage.verifyAllImages();
    }

    @Then("i verify all links present in dashboard page")
    public void iVerifyAllLinksPresentInDashboardPage() throws Exception {
        dashboardPage.verifyAllLinks();
    }
}
