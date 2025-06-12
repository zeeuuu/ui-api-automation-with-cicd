package automationTest.helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;
import java.util.Random;

public class Utility {
    public static WebDriver driver;

    public static void startDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    public static void stopDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static String generateUsername() {
        String[] prefixes = {"zee", "guest", "xolo"};
        Random random = new Random();
        String username = prefixes[random.nextInt(prefixes.length)] + random.nextInt(10000);
        return username;
    }

    public static String generateRandomEmail() {
        int randomNumber = new Random().nextInt(10000);
        return "xolo"+randomNumber+"@dummyapy.com";
    }

    public static File getJSONSchemaFile(String JSONFile) {
        return new File("src/test/java/automationTest/helper/JSONSchemaData/" + JSONFile);
    }
}
