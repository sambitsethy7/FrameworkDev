package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.DriverFactory;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;

    @Given("user is on the OrangeHRM login page")
    public void user_is_on_login_page() {
        driver = DriverFactory.initializeDriver();
        loginPage = new LoginPage(driver);
    }

    @When("user enters username and password")
    public void user_enters_credentials() {
        loginPage.enterUsername(ConfigReader.getProperty("username"));
        loginPage.enterPassword(ConfigReader.getProperty("password"));
    }

    @And("user clicks the login button")
    public void user_clicks_login_button() {
        loginPage.clickLogin();
    }

    @Then("user should see the OrangeHRM dashboard")
    public void user_should_see_dashboard() {
        String expectedUrl = "dashboard";
        boolean isDashboard = driver.getCurrentUrl().contains(expectedUrl);
//        assert isDashboard : "User is not on dashboard.";
        Assert.assertTrue(isDashboard);
    }

    @Then("verify all components present in login page")
    public void verifyAllComponentsPresentInLoginPage() throws Exception {
        loginPage.verifyAllComponents();
        String expectedTitle = "OrangeHRM";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @When("user enters invalid {string} and {string}")
    public void userEntersInvalidUsernameAndPassword(String username, String password) throws Exception {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @Then("verify the error message displayed")
    public void verifyTheErrorMessageDisplayed() throws Exception {
        String actualMessage = loginPage.getErrorMessage();
        String expectedMessage = "Invalid credentials";
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @When("user clicks on Forget your password button")
    public void userClicksOnForgetYourPasswordButton() throws Exception {
        loginPage.clickForgetYourPassword();
    }

    @Then("user redirects to reset password page")
    public void userRedirectsToResetPasswordPage() throws Exception {
        loginPage.verifyRedirectionToResetPasswordPage();
    }

    @Then("user verifies the components present in reset password page")
    public void userVerifiesTheComponentsPresentInResetPasswordPage() throws Exception {
        loginPage.verifyComponentsPresentInResetPasswordPage();
    }

    @Then("i verify all links present in login page")
    public void iVerifyAllLinksPresentInLoginPage() throws Exception {
        loginPage.verifyAllLinks();
    }

    @Then("i verify all images present in login page")
    public void iVerifyAllImagesPresentInLoginPage() throws Exception {
        loginPage.verifyAllImages();
    }

    @Then("i verify the username and password mentioned in login page")
    public void iVerifyTheUsernameAndPasswordMentionedInLoginPage() throws Exception {
        loginPage.verifyUserNameAndPassword();
    }

    @Then("i verify the error displayed in username and password field")
    public void iVerifyTheErrorDisplayedInUsernameAndPasswordField() throws Exception {
        loginPage.verifyErrorMessageDisplayedInUsernameAndPasswordField();
    }
}
