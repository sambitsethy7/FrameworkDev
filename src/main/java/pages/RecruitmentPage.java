package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecruitmentPage {

    WebDriver driver;

    public RecruitmentPage(WebDriver driver) {
        this.driver = driver;
    }

    By pageHeader = By.xpath("//h6[text()='Recruitment']");
    By labelCandidates = By.xpath("//nav[contains(@aria-label,'Topbar')]//a[text()='Candidates']");
    By labelVacancies = By.xpath("//nav[contains(@aria-label,'Topbar')]//a[text()='Vacancies']");
    By labelCandidatesCardHeader = By.xpath("//h5[text()='Candidates']");
    By labelJobTitle = By.xpath("//label[text()='Job Title']");
    By labelVacancy = By.xpath("//label[text()='Vacancy']");
    By labelHiringManager = By.xpath("//label[text()='Hiring Manager']");
    By labelStatus = By.xpath("//label[text()='Status']");
    By labelCandidateName = By.xpath("//label[text()='Candidate Name']");
    By labelKeywords = By.xpath("//label[text()='Keywords']");
    By labelDateOfApplication = By.xpath("//label[text()='Date of Application']");
    By labelMethodOfApplication = By.xpath("//label[text()='Method of Application']");

    By resetBtn = By.xpath("//button[text()=' Reset ']");
    By searchBtn = By.xpath("//button[text()=' Search ']");
    By addBtn = By.xpath("//button[text()=' Add ']");

    public void verifyTheComponentsPresentInRecruitmentPage() throws Exception {
        driver.findElement(pageHeader).isDisplayed();
        driver.findElement(labelCandidates).isDisplayed();
        driver.findElement(labelVacancies).isDisplayed();
        driver.findElement(labelCandidatesCardHeader).isDisplayed();
        driver.findElement(labelJobTitle).isDisplayed();
        driver.findElement(labelVacancy).isDisplayed();
        driver.findElement(labelHiringManager).isDisplayed();
        driver.findElement(labelStatus).isDisplayed();
        driver.findElement(labelCandidateName).isDisplayed();
        driver.findElement(labelKeywords).isDisplayed();
        driver.findElement(labelDateOfApplication).isDisplayed();
        driver.findElement(labelMethodOfApplication).isDisplayed();
        driver.findElement(resetBtn).isDisplayed();
        driver.findElement(resetBtn).isEnabled();
        driver.findElement(searchBtn).isDisplayed();
        driver.findElement(searchBtn).isEnabled();
        driver.findElement(addBtn).isDisplayed();
        driver.findElement(addBtn).isEnabled();
    }
}
