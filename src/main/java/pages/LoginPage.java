package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    By usernameField = By.name("username");
    By passwordField = By.name("password");
    By loginButton = By.xpath("//button[@type='submit']");
    By loginText = By.xpath("//h5");
    By forgotPasswordLink = By.xpath("//div[contains(@class,'forgot')]//p");
    By errorMessage = By.xpath("//div//p[text()='Invalid credentials']");
    By resetPasswordButton = By.xpath("//button[text()=' Reset Password ']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void verifyAllComponents() {
        driver.findElement(loginText).isDisplayed();
        driver.findElement(forgotPasswordLink).isEnabled();
        driver.findElement(forgotPasswordLink).isDisplayed();
    }

    public String getErrorMessage() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return errorElement.getText();
    }

    public void clickForgetYourPassword() throws Exception {
        driver.findElement(forgotPasswordLink).click();
    }

    public void verifyRedirectionToResetPasswordPage() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(resetPasswordButton));
        driver.findElement(resetPasswordButton).isDisplayed();
    }
}
