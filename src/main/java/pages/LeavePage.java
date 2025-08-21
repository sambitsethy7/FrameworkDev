package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
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
    By entitlementsDropdown = By.xpath("//li//span[text()='Entitlements ']");
    By reportsDropdown = By.xpath("//li//span[text()='Reports ']");
    By configureDropdown = By.xpath("//li//span[text()='Configure ']");

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

    public void clickEntitlementsDropdown() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(entitlementsDropdown)).click();
        log.info("Entitlements dropdown is clicked");
    }

    public List<String> verifiesValueInEntitlementsDropdown() throws Exception {
        List<WebElement> options = driver.findElements(By.xpath("//ul[@role='menu']//li"));
        List<String> entitlementOptions = new ArrayList<>();
        for (WebElement option : options) {
            entitlementOptions.add(option.getText());
        }
        log.info("Values present in Entitlements dropdown are fetched");
        return entitlementOptions;
    }

    public void clickReportsDropdown() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(reportsDropdown)).click();
        log.info("Reports dropdown is clicked");
    }

    public List<String> verifiesValueInReportsDropdown() throws Exception {
        List<WebElement> options = driver.findElements(By.xpath("//ul[@role='menu']//li"));
        List<String> reportOptions = new ArrayList<>();
        for (WebElement option : options) {
            reportOptions.add(option.getText());
        }
        log.info("Values present in Reports dropdown are fetched");
        return reportOptions;
    }

    public void clickConfigureDropdown() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(configureDropdown)).click();
        log.info("Configure dropdown is clicked");
    }

    public List<String> verifiesValueInConfigureDropdown() throws Exception {
        List<WebElement> options = driver.findElements(By.xpath("//ul[@role='menu']//li"));
        List<String> configureOptions = new ArrayList<>();
        for (WebElement option : options) {
            configureOptions.add(option.getText());
        }
        log.info("Values from Configure dropdown are fetched");
        return configureOptions;
    }

    public List<String> verifiesValueOfTableHeader() throws Exception {
        List<WebElement> options = driver.findElements(By.xpath("//div[contains(@class,'table-header')]//div[@role='columnheader']"));
        List<String> tableHeaderValues = new ArrayList<>();
        for (int i = 1; i < options.size(); i++) {
            tableHeaderValues.add(options.get(i).getText());
        }
        log.info("Values from result table headers are fetched");
        return tableHeaderValues;
    }
}
