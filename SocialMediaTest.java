package projekat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.ArrayList;
public class SocialMediaTest {
    private WebDriver wb;
    private String dressTarget = "http://automationpractice.com/index.php?id_category=11&controller=category";
    private String openURL1;
    private String openURL2;
    private String faceTarget = "https://www.facebook.com/groups/525066904174158/";
    private String twitterTarget = "https://twitter.com/seleniumfrmwrk";
    private String youtubeTarget = "https://www.youtube.com/channel/UCHl59sI3SRjQ-qPcTrgt0tA";
    private String gPlusTarget = "https://accounts.google.com/signin/v2/identifier?passive=1209600&osid=1&continue=https%3A%2F%2Fplus.google.com%2F111979135243110831526%2Fposts&followup=https%3A%2F%2Fplus.google.com%2F111979135243110831526%2Fposts&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
    private Object Home;
    private Object WebElement;
    @BeforeClass
    public void testHomePreClass() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        wb = new ChromeDriver();
        wb.manage().window().maximize();
        wb.get(String.valueOf(Home.equals(wb)));
        Thread.sleep(1500);
    }
    @AfterClass
    public void driverQuit() {
        wb.quit();
    }
@org.testng.annotations.Test
    public void homeTestSummerDresses() throws InterruptedException {
        System.out.println("Begin homeTestSummerDresses Test");
        System.out.println("Go to womens sommer dresses via Women>Summer Dresses");
        System.out.println("Test if opened page is correct");
        boolean women = Home.equals(WebElement);
        boolean dress = Home.equals(WebElement);
        Actions action = new Actions(wb);
        action.moveToElement((org.openqa.selenium.WebElement) WebElement).build().perform();
        Thread.sleep(1500);
        openURL1 = wb.getCurrentUrl().toString();
        Assert.assertEquals(openURL1, dressTarget);
    }
    @org.testng.annotations.Test
    public void homeTestSummerDressesPath2() throws InterruptedException {
        System.out.println("Begin homeTestSummerDresses Path 2 Test");
        System.out.println("Go to womens sommer dresses via Dresses>Summer Dresses");
        System.out.println("Test if opened page is correct");
        Actions akcija = new Actions(wb);
        org.openqa.selenium.WebElement dresses = null;
        akcija.moveToElement(dresses).build().perform();
        Thread.sleep(1500);
        openURL2 = wb.getCurrentUrl().toString();
        Assert.assertEquals(openURL2, dressTarget);
    }
    @org.testng.annotations.Test
    public void homeTestComparePaths() throws InterruptedException {
        System.out.println("Begin homeTestComparePaths Test");
        System.out.println("Compare URL's from previous two tests");
        Assert.assertEquals(openURL2, openURL1);

    }

    @org.testng.annotations.Test
    public void homeTestSocialMedia() throws InterruptedException {
        System.out.println("Begin homeTestSocialMedis Test");
        System.out.println("Check if Facebook, Twitter, Youtube and GooglePlus links work");
        WebDriver wb = null;
        wb.get((String) Home);
        Thread.sleep(1500);

        SoftAssert sa1 = new SoftAssert();

        boolean facebook = Home.equals(WebElement);
        Thread.sleep(1000);

        ArrayList<String> linkF = new ArrayList<String>(wb.getWindowHandles());
        wb.switchTo().window(linkF.get(1));
        System.out.println(wb.getCurrentUrl().toString());

        sa1.assertEquals(wb.getCurrentUrl().toString(), faceTarget);

        Thread.sleep(1000);
        wb.close();
        wb.switchTo().window(linkF.get(0));
        boolean twitter = Home.equals(wb);
        ArrayList<String> linkT = new ArrayList<String>(wb.getWindowHandles());
        wb.switchTo().window(linkT.get(1));
        System.out.println(wb.getCurrentUrl().toString());

        sa1.assertEquals(wb.getCurrentUrl().toString(), twitterTarget);

        Thread.sleep(1000);
        wb.close();
        wb.switchTo().window(linkF.get(0));

        boolean youtube = Home.equals(wb);
        Thread.sleep(1000);
        ArrayList<String> linkY = new ArrayList<String>(wb.getWindowHandles());
        wb.switchTo().window(linkY.get(1));
        System.out.println(wb.getCurrentUrl().toString());

        sa1.assertEquals(wb.getCurrentUrl().toString(), youtubeTarget);

        Thread.sleep(1000);
        wb.close();
        wb.switchTo().window(linkF.get(0));

        boolean gPlus = Home.equals(wb);
        ArrayList<String> linkG = new ArrayList<String>(wb.getWindowHandles());
        wb.switchTo().window(linkG.get(1));
        System.out.println(wb.getCurrentUrl().toString());

        sa1.assertEquals(wb.getCurrentUrl().toString(), gPlusTarget);
        Thread.sleep(1000);
        wb.close();
        wb.switchTo().window(linkF.get(0));

        sa1.assertAll();

    }

    @Test

    public void homeTestContactUs() throws InterruptedException {
        System.out.println("Begin homeTestContactUs Test");
        System.out.println("Go to ContactUs page via two different links");
        System.out.println("Test if opened pages through both links are the same");

        WebDriver wd = null;
        wd.get((String) Home);
        Thread.sleep(1500);

        SoftAssert sa1 = new SoftAssert();

        boolean contactPath1 = Home.equals(wd);
        Thread.sleep(1500);
        String URL1 = wd.getCurrentUrl();

        sa1.assertEquals(ContactUs.url, URL1);

        wd.navigate().back();
        Thread.sleep(1500);

        boolean contactPath2 = Home.equals(wb);
        String URL2 = wd.getCurrentUrl();

        sa1.assertEquals(ContactUs.url, URL2);

        wd.navigate().back();
        Thread.sleep(1500);

        sa1.assertEquals(URL1, URL2);

        sa1.assertAll();

    }

}

