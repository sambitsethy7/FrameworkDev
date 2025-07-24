package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import java.util.stream.Collectors;



public class DashboardPage {
    WebDriver driver;
    LoginPage loginPage;

    By userDropdown = By.xpath("//li[contains(@class,'dropdown')]");
    By userDropdownMenu = By.xpath("//ul[@class='oxd-dropdown-menu']");
    By logoutOption = By.linkText("Logout");
    By searchBox = By.xpath("//input[@placeholder='Search']");
    By optionValue = By.xpath("//a[contains(@class,'menu-item')]//span");
    By leftMenuItems = By.xpath("//a[contains(@class,'menu-item')]");

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
        List<String> actualOptions = options.stream().map(e -> e.getText().trim().replace("\n", " ")).toList();
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
}
