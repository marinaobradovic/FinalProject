package projekat;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Random;

public class ReadWrite {
    private static int rowNo = 0;
    private static int columnNo = 0;
    private static Workbook wb;
    private static Sheet sheet;

    public ReadWrite(String sheetName) {
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet(sheetName);
        this.wb = wb;
        this.sheet = sheet;
    }

    public static Workbook getWB() {
        return wb;
    }
    public Row createRow(int rowNo) {
        Row row = sheet.createRow(rowNo);
        return row;
    }
    public static String generateName(int length) {
        int leftLimit = 97; // 'a'
        int rightLimit = 122; // 'z'
        int targetStringLength = length;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + random.nextInt(rightLimit - leftLimit + 1);
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();

    }

    public static String generateNumber(int length) {

        //Generate random number
        int leftLimit = 48; // '0'
        int rightLimit = 57; // '9'
        int targetStringLength = length;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + random.nextInt(rightLimit - leftLimit + 1);
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();

    }

    public static String generateMessage(int length) {
        int leftLimit = 97; // 'a'
        int rightLimit = 122; // 'z'
        int space = 32; //space
        int targetStringLength = length;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + random.nextInt(rightLimit - leftLimit + 1);
            if (randomLimitedInt % 3 == 0) {
                buffer.append((char) space);  //if random number divisible by 3 add a space.
            }
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();

    }

    public static String generateSubject() {

        //Randomly select Subject matter for ContactUs form
        Random random = new Random();

        switch (random.nextInt(2)) {
            case 0:
                return "Webmaster";
            case 1:
                return "Customer service";
            default:
                return "Webmaster";
        }


    }

    public static String generateEmail() {

        //Generate random email adresss using random name generator and random extension.
        Random random = new Random();
        int number = random.nextInt(3);
        switch (number) {
            case 0:
                return generateName(8) + "@" + generateName(8) + ".com";
            case 1:
                return generateName(8) + "@" + generateName(8) + ".org";
            case 2:
                return generateName(8) + "@" + generateName(8) + ".net";
            default:
                return generateName(8) + "@" + generateName(8) + ".com";

        }


    }

    public static String generateFile() {

        //Randomly choose one of 3 filepaths
        Random random = new Random();
        int number = random.nextInt(3);
        switch (number) {
            case 0:
                return "C:\\Users\\nedaz\\IdeaProjects\\FinalniProjekat\\zilence.jpg";
            case 1:
                return "C:\\Users\\nedaz\\IdeaProjects\\FinalniProjekat\\milence.jpg";
            case 2:
                return "C:\\Users\\nedaz\\IdeaProjects\\FinalniProjekat\\pilence.jpg";
            default:
                return "C:\\Users\\nedaz\\IdeaProjects\\FinalniProjekat\\zilence.jpg";

        }


    }


}

