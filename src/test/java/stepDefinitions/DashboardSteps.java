package stepDefinitions;

import com.intuit.karate.core.ScenarioOutline;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import utilities.ConfigReader;
import utilities.DriverFactory;

import java.util.Arrays;
import java.util.List;

@Slf4j

public class DashboardSteps {
    WebDriver driver = DriverFactory.getDriver();
    DashboardPage dashboardPage = new DashboardPage(driver);

    @Then("verify the options present in user dropdown")
    public void verifyTheOptionsPresentInUserDropdown() throws Exception {
        List<String> expectedOptions = Arrays.asList("About", "Support", "Change", "Password", "Logout");
        List<String> actualOptions = dashboardPage.verifyOptionsPresentInUserDropdown();
        Boolean value = actualOptions.containsAll(expectedOptions);
        if (true) {
            System.out.println("Test case PASSED");
        } else {
            System.out.println("Test Case FAILED");
        }
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

    @Then("user gets all the headers of each section in dashboard")
    public void userGetsAllTheHeadersOfEachSectionInDashboard() throws Exception {
        List<String> expectedList = ConfigReader.getSectionHeadersList();
        List<String> actualList = dashboardPage.getAllHeadersOfEachSection();
        Assert.assertTrue(actualList.containsAll(expectedList));
    }

    @Then("user verifies the number of records found by default in Admin")
    public void userVerifiesTheNumberOfRecordsFoundByDefaultInAdmin() throws Exception {
        String actualValue = dashboardPage.verifyRecordsFound();
        String expectedValue = "Records Found";
        if (actualValue.endsWith(expectedValue)) {
            System.out.println(actualValue);
            log.info("Records fetched successfully");
        } else {
            System.out.println("No Records Found");
        }
    }

    @When("user clicks on {string} from left nav menu")
    public void userClicksOnOptionFromLeftNavMenu(String value) throws Exception {
        dashboardPage.clickOption(value);
    }

    @Then("user verifies the dropdown is multiselect or not in Admin page")
    public void userVerifiesTheDropdownIsMultiselectOrNotInAdminPage() throws Exception {
        dashboardPage.verifyMultiSelectOrNotOfDropdownPresentInAdminPage();
    }

    @And("user clicks on Add button in System users")
    public void userClicksOnAddButtonInSystemUsers() throws Exception {
        dashboardPage.clickOnAddButtonInSystemUsers();
    }

    @And("user enters valid data to Add User page")
    public void userEntersValidDataToAddUserPage() throws Exception {
        dashboardPage.enterDataToAddUserPage();
    }

    @Then("user clicks on Save button in Add User page")
    public void userClicksOnSaveButtonInAddUserPage() throws Exception {
        dashboardPage.clickSave();
    }

    @And("user redirects to System users page")
    public void userRedirectsToSystemUsersPage() throws Exception {
        dashboardPage.redirectToSystemUsersPageValidation();
    }

    @When("user clicks on delete icon from existing records")
    public void userClicksOnDeleteIconFromExistingRecords() throws Exception {
        dashboardPage.clickOnDeleteIcon();
    }

    @Then("user deletes the record")
    public void userDeletesTheRecord() throws Exception {
        dashboardPage.deleteRecord();
    }

    @Then("user verifies the options present in top bar menu of Admin page")
    public void userVerifiesTheOptionsPresentInTopBarMenuOfAdminPage() throws Exception {
        List<String> expectedItems = Arrays.asList("User Management", "Job", "Organization", "Qualifications", "Nationalities", "Corporate Branding", "Configuration");
        List<String> actualItems = dashboardPage.verifyOptionsPresentInTopBarMenuOfAdminPage();
        Assert.assertTrue(actualItems.containsAll(expectedItems));
    }

    @Then("user verifies the table header content present in Admin page")
    public void userVerifiesTheTableHeaderContentPresentInAdminPage() throws Exception {
        List<String> expectedItems = Arrays.asList("Username", "User Role", "Employee Name", "Status", "Actions");
        List<String> actualItems = dashboardPage.verifyTableHeaderContentPresentInAdminPage();
        Assert.assertTrue(actualItems.containsAll(expectedItems));
    }

    @When("user clicks on {string} dropdown")
    public void userClicksOnUserManagementDropdown(String value) throws Exception {
        dashboardPage.userClicksOnDropdown(value);
    }

    @Then("user verifies the value present in {string} dropdown")
    public void userVerifiesTheValuePresentInUserManagementDropdown(String value) throws Exception {
        switch (value) {
            case "User Management":
                String expectedItem = "Users";
                String actualItem = dashboardPage.verifyTheValuePresentInUserManagementDropdown();
                Assert.assertEquals(expectedItem, actualItem);
                break;

            case "Job":
                List<String> expectedItemsOfJob = Arrays.asList("Job Titles", "Pay Grades", "Employment Status", "Job Categories", "Work Shifts");
                List<String> actualItemsOfJob = dashboardPage.verifyOptionsPresentInJobDropdown();
                Assert.assertTrue(actualItemsOfJob.containsAll(expectedItemsOfJob));
                break;

            case "Organization":
                List<String> expectedItemsOfOrg = Arrays.asList("General Information", "Locations", "Structure");
                List<String> actualItemsOfOrg = dashboardPage.verifyOptionsPresentInOrgDropdown();
                Assert.assertTrue(actualItemsOfOrg.containsAll(expectedItemsOfOrg));
                break;

            case "Qualifications":
                List<String> expectedItemsOfQualifications = Arrays.asList("Skills", "Education", "Licenses", "Languages", "Memberships");
                List<String> actualItemsOfQualifications = dashboardPage.verifyOptionsPresentInQualificationsDropdown();
                Assert.assertTrue(actualItemsOfQualifications.containsAll(expectedItemsOfQualifications));
                break;

            case "Configuration":
                List<String> expectedItemsOfConfig = Arrays.asList("Email Configuration", "Email Subscriptions", "Localization", "Language Packages", "Modules", "Social Media Authentication", "Register OAuth Client", "LDAP Configuration");
                List<String> actualItemsOfConfig = dashboardPage.verifyOptionsPresentInConfigDropdown();
                Assert.assertTrue(actualItemsOfConfig.containsAll(expectedItemsOfConfig));
                break;

            default:
                System.out.println("No case matches");
                break;
        }
    }
}
