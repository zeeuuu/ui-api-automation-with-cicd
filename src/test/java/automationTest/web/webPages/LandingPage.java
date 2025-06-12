package automationTest.web.webPages;

import org.openqa.selenium.By;

import static automationTest.helper.Utility.driver;

public class LandingPage {
    By signup_menu = By.id("signin2");
    By login_menu = By.id("login2");

    public void openWebsite() {
        driver.get("https://www.demoblaze.com/");
    }

    public void clickSignupMenu() {
        driver.findElement(signup_menu).click();
    }

    public void clickLoginMenu() {
        driver.findElement(login_menu).click();
    }
}
