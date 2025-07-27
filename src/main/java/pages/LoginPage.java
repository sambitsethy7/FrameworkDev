package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class LoginPage {
    WebDriver driver;

    By usernameField = By.name("username");
    By passwordField = By.name("password");
    By loginButton = By.xpath("//button[@type='submit']");
    By loginText = By.xpath("//h5");
    By forgotPasswordLink = By.xpath("//div[contains(@class,'forgot')]//p");
    By errorMessage = By.xpath("//div//p[text()='Invalid credentials']");
    By resetPasswordButton = By.xpath("//button[text()=' Reset Password ']");
    By resetPasswordText = By.xpath("//h6[text()='Reset Password']");
    By resetPasswordHelperText = By.xpath("//p[contains(@class,'text')]/p");
    By usernameIcon = By.xpath("//i");
    By usernameLabel = By.xpath("//label[text()='Username']");
    By cancelButton = By.xpath("//button[contains(@class,'cancel')]");

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
        driver.findElement(loginButton).submit();
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(resetPasswordButton));
        driver.findElement(resetPasswordButton).isDisplayed();
    }

    public void verifyComponentsPresentInResetPasswordPage() throws Exception {
        System.out.println(driver.findElement(resetPasswordText).getText());
        driver.findElement(resetPasswordText).isDisplayed();
        System.out.println(driver.findElement(resetPasswordHelperText).getText());
        driver.findElement(resetPasswordHelperText).isDisplayed();
        driver.findElement(usernameIcon).isDisplayed();
        driver.findElement(usernameLabel).isDisplayed();
        driver.findElement(usernameField).isDisplayed();
        driver.findElement(cancelButton).isDisplayed();
    }

    public void verifyAllLinks() throws Exception {
        List<WebElement> links = driver.findElements(By.tagName("a"));

        for (WebElement link : links) {
            String url = link.getAttribute("href");
            if (url == null || url.isEmpty()) {
                System.out.println("URL is empty or not configured for element: " + link.getText());
                continue;
            }
            try {
                HttpURLConnection connection = (HttpURLConnection) (new URL(url).openConnection());
                connection.setRequestMethod("HEAD");
                connection.connect();
                int responseCode = connection.getResponseCode();
                if (responseCode >= 400) {
                    System.out.println(url + " is a broken link with response code: " + responseCode);
                } else {
                    System.out.println(url + " is a valid link with response code: " + responseCode);
                }
            } catch (Exception e) {
                System.out.println(url + " caused an exception " + e.getMessage());
            }
        }
    }

    public void verifyAllImages() throws Exception {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
//        List<WebElement> imagesList = driver.findElements(By.tagName("img"));
//        System.out.println("Total images : " + imagesList.size());
//
//        for (WebElement imgElement : imagesList) {
//            String imgURl = imgElement.getAttribute("src");
//            try {
//                HttpURLConnection connection = (HttpURLConnection) (new URL(imgURl).openConnection());
//                connection.setRequestMethod("HEAD");
//                connection.connect();
//                int responseCode = connection.getResponseCode();
//                if (responseCode >= 400) {
//                    System.out.println(imgURl + " is a broken image. Response code: " + responseCode);
//                } else {
//                    System.out.println(imgURl + " is a valid image. Response code: " + responseCode);
//                }
//            } catch (Exception e) {
//                System.out.println(imgURl + " caused an exception: " + e.getMessage());
//            }
//        }
        // Scroll to bottom to trigger lazy load
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);");
        Thread.sleep(2000);

        List<WebElement> imagesList = driver.findElements(By.tagName("img"));
        System.out.println("Total images: " + imagesList.size());

        List<String> imgUrls = new ArrayList<>();
        for (WebElement imgElement : imagesList) {
            imgUrls.add(imgElement.getAttribute("src"));  // capture src while element is fresh
        }

        for (String imgUrl : imgUrls) {
            try {
                HttpURLConnection connection = (HttpURLConnection) (new URL(imgUrl).openConnection());
                connection.setRequestMethod("HEAD");
                connection.connect();
                int responseCode = connection.getResponseCode();
                if (responseCode >= 400) {
                    System.out.println(imgUrl + " is a broken image. Response code: " + responseCode);
                } else {
                    System.out.println(imgUrl + " is a valid image. Response code: " + responseCode);
                }
            } catch (Exception e) {
                System.out.println(imgUrl + " caused an exception: " + e.getMessage());
            }
        }
    }
}
