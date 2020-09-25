package projekat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class YellowDress {

    public static String urlSearchResultsPage = "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=yellow&submit_search=";

    public static String numberOfResultsClassName = "heading-counter";
    private Object Home;
    private YellowDress SearchResultsPage;

    public YellowDress(WebDriver driver, Object home, YellowDress searchResultsPage) {
        Home = home;
        SearchResultsPage = searchResultsPage;
    }

    public static WebElement getNumberOfResultsClassName(WebDriver wd) {
        return wd.findElement(By.className(numberOfResultsClassName));
    }
 @Test
public void zadatak5() throws InterruptedException
        { boolean zuta = false;
            WebDriver d = null;
            Home.notifyAll();
        Home.notifyAll();
        Thread.sleep(4000);
        String numberOfResults = SearchResultsPage.getNumberOfResultsClassName(d).getText();
            Assert sa = null;
            sa.assertEquals(numberOfResults, "3 results have been found.");
        List<WebElement> rezultati = d.findElements(By.className("color_to_pick_list"));
        for(int i = 0; i<rezultati.size(); i++)
        { List<WebElement> rezultatiZuta =rezultati.get(i).findElements(By.className("color_pick"));
        for (int j = 0; j<rezultatiZuta.size();j++)
        { if(rezultatiZuta.get(j).getAttribute("style").contains("background: #F1C40F;"))
        ; zuta=true; } }

        sa.assertEquals(zuta, true); }
}
