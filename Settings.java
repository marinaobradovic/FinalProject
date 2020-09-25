package projekat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;

public class Settings {
    private static String url="http://automationpractice.com/index.php";
    private static String chromeDriver="/Users/marina/Desktop/testiranje/chromedriver";
private static WebDriver driver;
    public static void setSettings(){
    System.setProperty("webdriver.chrome.driver", chromeDriver);
    driver= new ChromeDriver();
    driver.get(url);
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
}
    public static WebDriver getDriver() {
        return driver;
    }
}
