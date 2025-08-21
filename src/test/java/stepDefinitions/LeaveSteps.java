package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LeavePage;
import utilities.DriverFactory;

import java.util.*;


public class LeaveSteps {
    WebDriver driver = DriverFactory.getDriver();
    LeavePage leavePage = new LeavePage(driver);

    @Then("user verifies the landing page of Leave")
    public void userVerifiesTheLandingPageOfLeave() throws Exception {
        leavePage.verifyLandingPageOfLeave();
    }

    @When("user clicks on Entitlements dropdown")
    public void userClicksOnEntitlementsDropdown() throws Exception {
        leavePage.clickEntitlementsDropdown();
    }

    @Then("user verifies the value present in Entitlements dropdown")
    public void userVerifiesTheValuePresentInEntitlementsDropdown() throws Exception {
        List<String> actualItems = Arrays.asList("Add Entitlements", "Employee Entitlements", "My Entitlements");
        List<String> expectedItems = leavePage.verifiesValueInEntitlementsDropdown();
        Assert.assertEquals(expectedItems, actualItems);
    }

    @When("user clicks on Reports dropdown")
    public void userClicksOnReportsDropdown() throws Exception {
        leavePage.clickReportsDropdown();
    }

    @Then("user verifies the value present in Reports dropdown")
    public void userVerifiesTheValuePresentInReportsDropdown() throws Exception {
        List<String> actualItems = Arrays.asList("Leave Entitlements and Usage Report", "My Leave Entitlements and Usage Report");
        List<String> expectedItems = leavePage.verifiesValueInReportsDropdown();
        Assert.assertEquals(expectedItems, actualItems);
    }

    @When("user clicks on Configure dropdown")
    public void userClicksOnConfigureDropdown() throws Exception {
        leavePage.clickConfigureDropdown();
    }

    @Then("user verifies the value present in Configure dropdown")
    public void userVerifiesTheValuePresentInConfigureDropdown() throws Exception {
        List<String> actualItems = Arrays.asList("Leave Period", "Leave Types", "Work Week", "Holidays");
        List<String> expectedItems = leavePage.verifiesValueInConfigureDropdown();
        Assert.assertEquals(expectedItems, actualItems);
    }

    @Then("user verifies the values of table header")
    public void userVerifiesTheValuesOfTableHeader() throws Exception {
        List<String> actualItems = Arrays.asList("Date", "Employee Name", "Leave Type", "Leave Balance (Days)", "Number of Days", "Status", "Comments", "Actions");
        List<String> expectedItems = leavePage.verifiesValueOfTableHeader();
        Assert.assertEquals(expectedItems, actualItems);
    }
}
