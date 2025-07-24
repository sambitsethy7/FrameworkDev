package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;


public class DashboardPage {
    WebDriver driver;
    LoginPage loginPage;

    By userDropdown = By.xpath("//li[contains(@class,'dropdown')]");
    By userDropdownMenu = By.xpath("//ul[@class='oxd-dropdown-menu']");
    By logoutOption = By.linkText("Logout");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.loginPage = new LoginPage(driver);
    }

    public void verifyOptionsPresentInUserDropdown() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement userMenu = wait.until(ExpectedConditions.elementToBeClickable(userDropdown));
        userMenu.click();
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(userDropdownMenu));
        List<String> actualOptions = options.stream().map(WebElement::getText).toList();
        List<String> expectedOptions = Arrays.asList("About", "Support", "Change Password", "Logout");

        if (actualOptions.equals(expectedOptions)) {
            System.out.println("Dropdown options are correct" + actualOptions);
        } else {
            System.out.println("Dropdown options are incorrect" + actualOptions);
        }
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
}
