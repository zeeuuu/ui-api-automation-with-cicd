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
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    public static void stopDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static String generateUsername() {
        String[] prefixes = {"zee", "guest", "xolo", "kai", "special"};
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            sb.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }

        String username = prefixes[random.nextInt(prefixes.length)] + sb.toString() + random.nextInt(10000);
        return username;
    }

    public static String generateRandomEmail() {
        String name = generateUsername();
        return name +"@dummyapy.com";
    }

    public static File getJSONSchemaFile(String JSONFile) {
        return new File("src/test/java/automationTest/helper/JSONSchemaData/" + JSONFile);
    }
}
