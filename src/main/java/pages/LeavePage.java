package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

@Slf4j
public class LeavePage {

    WebDriver driver;

    public LeavePage(WebDriver driver) {
        this.driver = driver;
    }

    By topHeader = By.xpath("//h6[text()='Leave']");
    By headerValue = By.xpath("//h5[text()='Leave List']");
    By fromDateLabel = By.xpath("//label[text()='From Date']");
    By toDateLabel = By.xpath("//label[text()='To Date']");
    By showLeaveWithStatusLabel = By.xpath("//label[text()='Show Leave with Status']");
    By leaveTypeLabel = By.xpath("//label[text()='Leave Type']");
    By employeeName = By.xpath("//label[text()='Employee Name']");
    By subUnitLabel = By.xpath("//label[text()='Sub Unit']");
    By includePastEmployeesLabel = By.xpath("//div[contains(@class,'leave')]//p[text()='Include Past Employees']");
    By resetButton = By.xpath("//button[@type='reset']");
    By searchButton = By.xpath("//button[text()=' Search ']");

    public void verifyLandingPageOfLeave() throws Exception {
        driver.findElement(topHeader).isDisplayed();
        List<WebElement> headerOps = driver.findElements(By.xpath("//div[contains(@class,'topbar-body')]//nav//ul//li"));
        for (WebElement headerOp : headerOps) {
            headerOp.isDisplayed();
        }
        driver.findElement(headerValue).isDisplayed();
        driver.findElement(fromDateLabel).isDisplayed();
        driver.findElement(toDateLabel).isDisplayed();
        driver.findElement(showLeaveWithStatusLabel).isDisplayed();
        driver.findElement(leaveTypeLabel).isDisplayed();
        driver.findElement(employeeName).isDisplayed();
        driver.findElement(subUnitLabel).isDisplayed();
        driver.findElement(includePastEmployeesLabel).isDisplayed();
        driver.findElement(resetButton).isDisplayed();
        driver.findElement(searchButton).isDisplayed();
        log.info("All components are displayed successfully");
    }
}
