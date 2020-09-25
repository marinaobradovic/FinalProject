package projekat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
public class SummerDresses {
    private static String boxSizeDress = "group_1";
    private static String addToCart = "//span[contains(text(),'Add to cart')]";
    private static String popUpWindowClassName = "cross";
    private static String dressColourWhiteID = "color_8";
    private static String clickSecondDress = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[2]/div[1]/div[1]/div[1]/a[1]";
    private static String increaseDressStock = "//a[@class='btn btn-default button-plus product_quantity_up']//span";

    public static WebElement findSecondDress(WebDriver driver) {
        return driver.findElement(By.xpath(clickSecondDress));
    }
    public static void clickSecondDress(WebDriver driver){
        findSecondDress(driver).click();
    }
    public static void clickToIncreaseItem(WebDriver driver){
        driver.findElement(By.xpath(increaseDressStock)).click();
    }
    public static void sizeDress(WebDriver driver){
        Select boxSize=new Select(driver.findElement(By.name(boxSizeDress)));
        boxSize.selectByVisibleText("M");
    }
    public static void dressColorWhite(WebDriver driver){
        driver.findElement(By.id(dressColourWhiteID)).click();
    }
    public static void addToShoppingCart(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath(addToCart)).click();
   Thread.sleep(1000);
   driver.findElement(By.className(popUpWindowClassName)).click();

    }

}
