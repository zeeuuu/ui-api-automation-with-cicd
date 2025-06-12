package automationTest.web.webPages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static automationTest.helper.Utility.driver;
import static automationTest.helper.Utility.generateUsername;

public class AuthPage {
    By username_signup = By.id("sign-username");
    By password_signup = By.id("sign-password");
    By signup_button = By.xpath("//button[text()='Sign up']");
    By username_login = By.id("loginusername");
    By password_login = By.id("loginpassword");
    By login_button = By.xpath("//button[text()='Log in']");

    public void generateRandomUsername() {
        String username = generateUsername();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(username_signup));
        element.sendKeys(username);
    }

    public void usernameSignup(String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(username_signup));
        element.sendKeys(username);
    }

    public void passwordSignup(String password) {
        driver.findElement(password_signup).sendKeys(password);
    }

    public void clickButtonSignup() {
        driver.findElement(signup_button).click();
    }

    public void usernameLogin(String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(username_login));
        element.sendKeys(username);
    }

    public void passwordLogin(String password) {
        driver.findElement(password_login).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(login_button).click();
    }

    public void alertMessage(String message) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText();

        assertEquals(message, actualMessage);
        alert.accept();
    }
}
