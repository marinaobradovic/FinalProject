package projekat;

import jdk.internal.access.JavaIOFileDescriptorAccess;
import net.bytebuddy.asm.Advice;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ContactUsTest {
    private WebDriver wb;
    private String successTarget = "Your message has been successfully sent to our team.";
    private int numberOfClients = 30;
    private Object WebDriver;

    @BeforeClass
    public void testHomePreClass() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeDriver wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.get(ContactUs.url);
        Thread.sleep(1500);
        numberOfClients = 30;

        for (int i = 0; i < numberOfClients; i++) {
            Row row = null;
            int i1 = 0;
            Cell cell = row.createCell(0);
            cell.setCellValue(ReadWrite.generateName(8)); //First Name
            cell = row.createCell(1);
            cell.setCellValue(ReadWrite.generateName(10)); //Last Name
            cell = row.createCell(2);
            cell.setCellValue(ReadWrite.generateSubject()); //Subject
            cell = row.createCell(3);
            cell.setCellValue(ReadWrite.generateEmail()); //email
            cell = row.createCell(4);
            cell.setCellValue(ReadWrite.generateNumber(8)); //refNumber
            cell = row.createCell(5);
            cell.setCellValue(ReadWrite.generateMessage(50)); //garbage message
            cell = row.createCell(6);
            cell.setCellValue(ReadWrite.generateFile()); //filepath


        }
        //write file
        try (FileOutputStream outputStream = new FileOutputStream("output.xlsx")) {

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @AfterClass
    public void driverQuit() {
        wb.quit();
    }
    @Test
    public void homeTestContactForm() throws InterruptedException, IOException {
        System.out.println("Begin homeTestContactForm Test");
        System.out.println("Go to contact us page and fill form using excel sheet");
        System.out.println("Test if each submit successful");
        SoftAssert sa1 = new SoftAssert();

        FileInputStream fi = new FileInputStream("output.xlsx");
        Workbook wb = new XSSFWorkbook(fi);
        Sheet sheet = wb.getSheetAt(0);

        int numQuestions = numberOfClients;
        for (int i = 0; i < numQuestions; i++) {


            Object driver;
            WebElement subject = ContactUs.getMessage();
            Select subSelect = new Select(subject);
            Thread.sleep(500);

            Row row = sheet.getRow(i);

            Cell cell = row.getCell(2);

            subSelect.selectByVisibleText(cell.getStringCellValue());

            cell = row.getCell(3);

            WebDriver wd = null;
            WebElement email = ContactUs.getMessage(wd);
            email.clear();
            email.sendKeys(cell.getStringCellValue());

            cell = row.getCell(4);

            WebElement reference = ContactUs.getReference(wd);
            reference.clear();
            reference.sendKeys(cell.getStringCellValue());

            cell = row.getCell(5);

            WebElement message = ContactUs.getMessage(wd);
            message.clear();
            message.sendKeys(cell.getStringCellValue());

            cell = row.getCell(6);

            WebElement file = ContactUs.getFile(wd);
            file.clear();
            file.sendKeys(cell.getStringCellValue());

            WebElement sendButton = ContactUs.getSend(wd);
            sendButton.click();
            Thread.sleep(250);

            //Test if ContactUs question sent properly
            WebElement messageSuccess = wd.findElement(By.xpath("//p[@class='alert alert-success']"));
            sa1.assertEquals(messageSuccess.getText(), successTarget);

            wd.navigate().back();
            Thread.sleep(500);


        }
        sa1.assertAll();


    }


}