package Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {
	public static FileOutputStream optFile;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet = null;
	public static XSSFCell cell = null;

	public static XSSFRow row = null;
	//public static String exFilePath1 = "C:\\Users\\Yeswa\\Downloads\\HolidaySchedules(Main Project)\\src\\main\\resources\\DataSets\\VersionHistory_Output.xlsx";
	public static String exFilePath =System.getProperty("user.dir")+"\\src\\main\\resources\\DataSets\\VersionHistory_Output.xlsx";

	
	
	public static void storeData(String[] Headings, String[] data) {

		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("histroy");
		row = ExcelWrite.sheet.createRow(1);
		for (int i = 1; i <= Headings.length; i++) {
			cell = row.createCell(i);

			cell.setCellValue(Headings[i - 1]);
		}
		row = ExcelWrite.sheet.createRow(2);
		for (int i = 1; i <= data.length; i++) {
			cell = row.createCell(i);

			cell.setCellValue(data[i - 1]);
		}
		try {

			optFile = new FileOutputStream(new File(exFilePath));
			workbook.write(optFile);
			optFile.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}
