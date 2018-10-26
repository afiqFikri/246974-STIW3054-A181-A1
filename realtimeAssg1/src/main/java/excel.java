import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class excel {

    public static  void main (String[]args){
        scrap exl = new scrap();
        List<String>list = exl.getArrayList();

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet( " Trivia table");
        int rowNum = 0;

        for (int i = 0; i <48; i++) {
            Row row1 = spreadsheet.createRow(rowNum++);
            int cellindex = 0;
            row1.createCell(1);
            row1.createCell(cellindex++).setCellValue(list.get(i));
            row1.createCell(2);
            row1.createCell(cellindex++).setCellValue(list.get(i+1));
            i= i + 1;
        }
        try{
            FileOutputStream out = new FileOutputStream(
                    new File("E:\\UUM\\Trivia table.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("System has success created excel.");
        }catch (FileNotFoundException e){
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}