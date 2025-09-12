package stepDefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.RecruitmentPage;
import utilities.DriverFactory;

public class RecruitmentSteps {
    WebDriver driver = DriverFactory.getDriver();
    RecruitmentPage recruitmentPage = new RecruitmentPage(driver);

    @Then("user verifies the components present in Recruitment page")
    public void userVerifiesTheComponentsPresentInRecruitmentPage() throws Exception {
        recruitmentPage.verifyTheComponentsPresentInRecruitmentPage();
    }
}
