package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class DashboardPage {
    private static final Logger log = LoggerFactory.getLogger(DashboardPage.class);
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

    //Left nav elements
    By adminOption = By.xpath("//ul[1]//li//span[text()='Admin']");


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
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
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

    public void clickAdmin() throws Exception {
        driver.findElement(adminOption).click();
    }

    public String verifyRecordsFound() throws Exception {
        String actual = driver.findElement(recordsFound).getText();
        return actual;
    }
}
