package projekat;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
Settings.setSettings();
        WebDriver driver=Settings.getDriver();
        HomePage.hoverOverWomanButton(driver);
        HomePage.clickSummerDressWoman(driver);
    driver.navigate().back();
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    HomePage.hoverOverDressButton(driver);
    HomePage.clickSummerDressDress(driver);
driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
SummerDresses.clickSecondDress(driver);
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
SummerDresses.clickToIncreaseItem(driver);
SummerDresses.sizeDress(driver);
SummerDresses.dressColorWhite(driver);
SummerDresses.addToShoppingCart(driver);
Thread.sleep(2000);


    }

}
