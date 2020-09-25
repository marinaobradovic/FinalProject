package projekat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
private static String womanButtonPath="//a[@class='sf-with-ul'][contains(text(),'Women')]";
    private static String summerDressPath="//li[@class='sfHover']//a[contains(text(),'Summer Dresses')]";
    private static String dressButtonPath="//body[@id='index']/div[@id='page']/div[@class='header-container']/header[@id='header']/div/div[@class='container']/div[@class='row']/div[@id='block_top_menu']/ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[2]/a[1]";
    private static String summerDressSecondPath="//li[@class='sfHover']//a[contains(text(),'Summer Dresses')]";
public static WebElement findWomanButton(WebDriver driver) {
    return driver.findElement(By.xpath(womanButtonPath));
}
public static void hoverOverWomanButton(WebDriver driver){
    hoverOverButton(driver,findWomanButton(driver),15);
}
public static void clickSummerDressWoman(WebDriver driver){
    driver.findElement(By.xpath(summerDressPath)).click();
}
public static WebElement findDressesButton(WebDriver driver){
    return driver.findElement(By.xpath(dressButtonPath));
}
    public static void hoverOverDressButton(WebDriver driver) {
    hoverOverButton(driver, findDressesButton(driver), 15);
    }
    public static void clickSummerDressDress(WebDriver driver){
        driver.findElement(By.xpath(summerDressSecondPath)).click();
}
public static void hoverOverButton(WebDriver driver,WebElement element,int timeToWait){
      WebElement newElement=element;
        Actions action=new Actions(driver);
        action.moveToElement(newElement).clickAndHold().build().perform();
        WebDriverWait wait= new WebDriverWait(driver,timeToWait);
        wait.until(ExpectedConditions.elementToBeClickable(newElement));
  }
}

