package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import utilities.ConfigReader;
import utilities.DriverFactory;

import java.util.Arrays;
import java.util.List;

public class DashboardSteps {
    WebDriver driver = DriverFactory.getDriver();
    DashboardPage dashboardPage = new DashboardPage(driver);

    @Then("verify the options present in user dropdown")
    public void verifyTheOptionsPresentInUserDropdown() throws Exception {
        List<String> expectedOptions = Arrays.asList("About Support Change Password Logout");
        List<String> actualOptions = dashboardPage.verifyOptionsPresentInUserDropdown();
        Assert.assertEquals(expectedOptions, actualOptions);
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

    @When("user enters {string} in the search box")
    public void userEntersInTheSearchBox(String text) throws Exception {
        dashboardPage.entersTextInSearchBox(text);
    }

    @Then("{string} option should be visible")
    public void optionShouldBeVisible(String value) throws Exception {
        dashboardPage.verifyVisibleOption(value);
    }

    @Then("user should see correct navigation menu options")
    public void userShouldSeeCorrectNavigationMenuOptions() throws Exception {
        List<String> expectedItems = ConfigReader.getExpectedMenuItems();
        List<String> actualItems = dashboardPage.getLeftNavigationItems();
        Assert.assertEquals("Menu items do not match!", expectedItems, actualItems);
    }
}
