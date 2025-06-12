package automationTest.web.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static automationTest.helper.Utility.driver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutPage {
    By cart_menu = By.xpath("//a[text()='Cart']");
    By delete_button = By.xpath("(//a[text()='Delete'])[1]");
    By placeOrder_button = By.xpath("//button[text()='Place Order']");
    By purchase_button = By.xpath("//button[text()='Purchase']");
    By text_message = By.xpath("//h2[text()='Thank you for your purchase!']");
    By completed_button = By.xpath("//button[text()='OK']");

    By input(String field) {
        return By.xpath("(//input[@type='text' and @id='"+field+"'])");
    }

    public void clickCartMenu() {
        driver.findElement(cart_menu).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement deleteBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(delete_button));
        assertTrue(deleteBtn.isDisplayed());
    }

    public void clickPlaceOrder() {
        driver.findElement(placeOrder_button).click();
    }

    public void inputData(String field, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(input(field)));
        element.sendKeys(value);
    }

    public void clickPurchaseButton() {
        driver.findElement(purchase_button).click();
    }

    public void validateMessage(String message) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String actualMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(text_message)).getText();
        assertEquals(message, actualMessage);
        driver.findElement(completed_button).click();
    }
}
