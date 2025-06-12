package automationTest.web.webPages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static automationTest.helper.Utility.driver;

public class HomePage {
    By welcome = By.id("nameofuser");
    By home_menu = By.xpath("(//a[@class='nav-link'])[1]");
    By phone_category = By.xpath("//a[@id='itemc' and text()='Phones']");
    By laptop_category = By.xpath("//a[@id='itemc' and text()='Laptops']");
    By monitor_category = By.xpath("//a[@id='itemc' and text()='Monitors']");
    By addToCart = By.xpath("//a[text()='Add to cart']");

    By productSection(String product) {
        return By.xpath("//a[@class='hrefch' and text()='"+product+"']");
    }

    public void validateHomepage(String message) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(welcome));

        WebElement welcomeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(welcome));
        String actualMessage = welcomeElement.getText();
        assertEquals(message, actualMessage);
    }

    public void clickPhonesCategory() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement category = wait.until(ExpectedConditions.elementToBeClickable(phone_category));
            category.click();
        } catch (Exception e) {
            System.out.println("Failed to click Phones Categories: "+e.getMessage());
        }
    }

    public void clickLaptopsCategory() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement category = wait.until(ExpectedConditions.elementToBeClickable(laptop_category));
            category.click();
        } catch (Exception e) {
            System.out.println("Failed to click element Laptops Categories: "+e.getMessage());
        }
    }

    public void clickMonitorsCategory() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement category = wait.until(ExpectedConditions.elementToBeClickable(monitor_category));
            category.click();
        } catch (Exception e) {
            System.out.println("Failed to click element Monitor Categories: "+e.getMessage());
        }
    }

    public void openProductDetails(String product) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        By locator = productSection(product);

        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            if (!element.isDisplayed()) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
                Thread.sleep(500);
            }
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();

        } catch (StaleElementReferenceException e) {
            try {
                WebElement element = driver.findElement(locator);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
                wait.until(ExpectedConditions.elementToBeClickable(locator)).click();

            } catch (Exception ex) {
                System.out.println("Failed to click product after Stale Reference.");
            }
        } catch (Exception e) {
            System.out.println("Failed to click product: " + e.getMessage());
        }
    }

    public void addToCartItem(){
        driver.findElement(addToCart).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        driver.findElement(home_menu).click();
    }
}
