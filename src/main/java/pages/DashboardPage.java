package pages;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class DashboardPage {
    WebDriver driver;
    LoginPage loginPage;

    By userDropdown = By.xpath("//li[contains(@class,'dropdown')]");
    By userDropdownMenu = By.xpath("//ul[@class='oxd-dropdown-menu']");
    By logoutOption = By.linkText("Logout");
    By searchBox = By.xpath("//input[@placeholder='Search']");
    By optionValue = By.xpath("//a[contains(@class,'menu-item')]//span");
    By leftMenuItems = By.xpath("//a[contains(@class,'menu-item')]");
    By sectionHeaders = By.xpath("//div[contains(@class,'widget-name')]");
    By recordsFound = By.xpath("//div[contains(@class,'paper')]//following-sibling::div[1]//span");

    //Admin page components
    By userRoleDropdown = By.xpath("(//div[contains(@class,'select-text--after')]//i)[1]");
    By statusDropdown = By.xpath("(//div[contains(@class,'select-text--after')]//i)[2]");
    By addButton = By.xpath("//button[text()=' Add ']");
    By employeeName = By.xpath("//input[contains(@placeholder,'Type')]");
    By usernameTextField = By.xpath("//label[text()='Username']/parent::div//following-sibling::div//input");
    By passwordTextField = By.xpath("//label[text()='Password']/parent::div//following-sibling::div//input");
    By confirmPasswordTextField = By.xpath("//label[text()='Confirm Password']/parent::div//following-sibling::div//input");
    By saveButton = By.xpath("//button[@type='submit']");
    By deleteButton = By.xpath("(//button//i[contains(@class,'trash')])[last()]");
    By yesDeletePopUp = By.xpath("//div[contains(@class,'modal-footer')]//button[2]");
    By userManagementDropdown = By.xpath("//span[text()='User Management ']//following-sibling::ul//li//a");
    By helpButton = By.xpath("//button[@title='Help']");
    By searchFieldInNewTab = By.xpath("//input[@id='query']");

    //PIM page components
    By employmentStatusDropdown = By.xpath("//label[text()='Employment Status']/..//following-sibling::div//i");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.loginPage = new LoginPage(driver);
    }

    public List<String> verifyOptionsPresentInUserDropdown() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement userMenu = wait.until(ExpectedConditions.elementToBeClickable(userDropdown));
        userMenu.click();
        Thread.sleep(1000);
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(userDropdownMenu));
        List<String> actualOptions = new ArrayList<>();
        for (WebElement option : options) {
            String text = option.getText();
            actualOptions.add(text);
        }
//        List<String> actualOptions = options.stream().map(e -> e.getText().trim().replace("\n", " ")).toList();
        return actualOptions;
    }

    public void clickLogout() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutOption));
        driver.findElement(logoutOption).click();
    }

    public void verifyAllImages() throws Exception {
        loginPage.verifyAllImages();
    }

    public void verifyAllLinks() throws Exception {
        loginPage.verifyAllLinks();
    }

    public void entersTextInSearchBox(String text) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        driver.findElement(searchBox).isDisplayed();
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(text);
    }

    public void verifyVisibleOption(String value) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
        String actualValue = driver.findElement(optionValue).getText();
        if (actualValue.equals(value)) {
            System.out.println("Search is valid with " + actualValue);
        } else {
            System.out.println("Searched value is not found " + actualValue);
        }
    }

    public List<String> getLeftNavigationItems() throws Exception {
        List<WebElement> items = driver.findElements(leftMenuItems);
        List<String> actualMenu = new ArrayList<>();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (WebElement item : items) {
            js.executeScript("arguments[0].scrollIntoView(true);", item);
            actualMenu.add(item.getText().trim());
        }
        return actualMenu;
    }

    public List<String> getAllHeadersOfEachSection() throws Exception {
        List<WebElement> headers = driver.findElements(sectionHeaders);
        List<String> actualList = new ArrayList<>();
        for (WebElement header : headers) {
            actualList.add(header.getText());
        }
        log.info("All headers are fetched");
        return actualList;
    }

    public String verifyRecordsFound() throws Exception {
        return driver.findElement(recordsFound).getText();
    }

    public void clickOption(String value) throws Exception {
        driver.findElement(By.xpath("//ul[1]//li//span[text()='" + value + "']")).click();
        log.info(value + " is clicked successfully");
    }

    public void verifyMultiSelectOrNotOfDropdownPresentInAdminPage() throws Exception {
        String classAttributeOfUserRole = driver.findElement(userRoleDropdown).getAttribute("class");
        if (classAttributeOfUserRole.contains("multiselect") || classAttributeOfUserRole.contains("multi") || classAttributeOfUserRole.contains("multiple")) {
            log.info("User Role is a multiselect dropdown");
        } else {
            log.info("User Role is a single value select dropdown");
        }
        String classAttributeOfStatus = driver.findElement(statusDropdown).getAttribute("class");
        if (classAttributeOfStatus.contains("multiselect") || classAttributeOfStatus.contains("multi") || classAttributeOfStatus.contains("multiple")) {
            log.info("Status is a multiselect dropdown");
        } else {
            log.info("Status is a single value select dropdown");
        }
    }

    public void clickOnAddButtonInSystemUsers() throws Exception {
        driver.findElement(addButton).isDisplayed();
        driver.findElement(addButton).click();
    }

    public void enterDataToAddUserPage() throws Exception {
        driver.findElement(userRoleDropdown).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='Admin'])[3]"))).click();
        driver.findElement(employeeName).sendKeys("test");
        Thread.sleep(10000);
        List<WebElement> suggestions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@role='listbox']")));
        if (!suggestions.isEmpty()) {
            suggestions.get(0).click();
            log.info("value from autosuggestive dropdown is clicked");
        } else {
            log.info("No suggestions found");
        }
        driver.findElement(statusDropdown).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Enabled']"))).click();
        driver.findElement(usernameTextField).sendKeys(RandomStringUtils.randomAlphabetic(8));
        driver.findElement(passwordTextField).sendKeys("Test@123");
        driver.findElement(confirmPasswordTextField).sendKeys("Test@123");
        log.info("All details has been entered successfully");
    }

    public void clickSave() throws Exception {
        driver.findElement(saveButton).click();
    }

    public void redirectToSystemUsersPageValidation() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(addButton));
        if (driver.getCurrentUrl().endsWith("viewSystemUsers")) {
            System.out.println("Redirection to System Users Page is done");
        } else {
            log.info("Redirection failed");
        }
    }

    public void clickOnDeleteIcon() throws Exception {
        driver.findElement(deleteButton).isDisplayed();
        driver.findElement(deleteButton).click();
        log.info("Delete button is clicked");
    }

    public void deleteRecord() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(yesDeletePopUp));
        driver.findElement(yesDeletePopUp).click();
        log.info("Record is deleted successfully");
    }

    public List<String> verifyOptionsPresentInTopBarMenuOfAdminPage() throws Exception {
        List<WebElement> topBarMenuOptions = driver.findElements(By.xpath("//div[contains(@class,'topbar')]//nav//ul//li"));
        List<String> actualTopBarMenuItems = new ArrayList<>();
        for (WebElement topBarMenuOption : topBarMenuOptions) {
            actualTopBarMenuItems.add(topBarMenuOption.getText());
        }
        log.info("Actual menu items are fetched successfully");
        return actualTopBarMenuItems;
    }

    public List<String> verifyTableHeaderContentPresentInAdminPage() throws Exception {
        List<WebElement> tableHeaderContents = driver.findElements(By.xpath("//div[@role='columnheader']"));
        List<String> actualTableHeaderContents = new ArrayList<>();
        for (int i = 1; i < tableHeaderContents.size(); i++) {
            actualTableHeaderContents.add(tableHeaderContents.get(i).getText());
        }
        log.info("Actual table header contents are fetched successfully");
        return actualTableHeaderContents;
    }

    public void userClicksOnDropdown(String value) throws Exception {
        driver.findElement(By.xpath("//li//span[text()='" + value + " ']")).click();
    }

    public String verifyTheValuePresentInUserManagementDropdown() throws Exception {
        String actualText = driver.findElement(userManagementDropdown).getText();
        log.info("Actual text from User Management dropdown is fetched");
        return actualText;
    }

    public List<String> verifyOptionsPresentInJobDropdown() throws Exception {
        List<WebElement> actualItems = driver.findElements(By.xpath("//span[text()='Job ']//following-sibling::ul//li//a"));
        List<String> options = new ArrayList<>();
        for (WebElement actualItem : actualItems) {
            options.add(actualItem.getText());
        }
        log.info("Actual text from Job dropdown is fetched");
        return options;
    }

    public List<String> verifyOptionsPresentInOrgDropdown() throws Exception {
        List<WebElement> actualItems = driver.findElements(By.xpath("//span[text()='Organization ']//following-sibling::ul//li//a"));
        List<String> options = new ArrayList<>();
        for (WebElement actualItem : actualItems) {
            options.add(actualItem.getText());
        }
        log.info("Actual text from Organization dropdown is fetched");
        return options;
    }

    public List<String> verifyOptionsPresentInQualificationsDropdown() throws Exception {
        List<WebElement> actualItems = driver.findElements(By.xpath("//span[text()='Qualifications ']//following-sibling::ul//li//a"));
        List<String> options = new ArrayList<>();
        for (WebElement actualItem : actualItems) {
            options.add(actualItem.getText());
        }
        log.info("Actual text from Qualifications dropdown is fetched");
        return options;
    }

    public List<String> verifyOptionsPresentInConfigDropdown() throws Exception {
        List<WebElement> actualItems = driver.findElements(By.xpath("//span[text()='Configuration ']//following-sibling::ul//li//a"));
        List<String> options = new ArrayList<>();
        for (WebElement actualItem : actualItems) {
            options.add(actualItem.getText());
        }
        log.info("Actual text from Configuration dropdown is fetched");
        return options;
    }

    public void userClicksOnHelpButtonInAdminPage() throws Exception {
        driver.findElement(helpButton).click();
    }


    public void userVerifiesTheRedirectionToNewTabAndVerifyItsComponents() throws Exception {
        String originalWindow = driver.getWindowHandle();
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.numberOfWindowsToBe(2));
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        if (driver.getTitle().equals("How to Add a User Account – OrangeHRM")) {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(searchFieldInNewTab));
            driver.findElement(searchFieldInNewTab).isDisplayed();
            log.info("New tab has opened successfully after clicking Help and Search box is displayed");
        } else {
            log.info("Test failed and Incorrect page opened");
        }
        driver.switchTo().window(originalWindow);
    }

    public void userClickOnEmploymentStatus() throws Exception {
        driver.findElement(employmentStatusDropdown).click();
        log.info("Employment status dropdown is clicked");
    }
}
