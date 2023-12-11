package com.demoapp.qa.utils;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.io.FileHandler;

import com.demoapp.qa.baseClass.BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilities extends BaseClass{
	
	public static final int IMP_WAIT_TIME = 20;
	
	public static final int PAGE_LOAD_TIME = 20;

	public static String TimeStamp() {
		
		String date = new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy").format(new Date());
		
		return date;
	}
	
	public static String generateEmailWithTimeStamp()
	{
		return "tester"+Utilities.TimeStamp()+"@gmail.com";
	}
	
	static XSSFWorkbook workBook;
	
	public static Object[][] readDataFromExcel(String sheetName)
	{
		Object[][] data = null;
				
		try {
			workBook = new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir")+"/src/main/resources/com/demoapp/qa/testData/DemoAppTestData.xlsx")));
			
			XSSFSheet sheet = workBook.getSheet(sheetName);
			
			int rows = sheet.getPhysicalNumberOfRows();
			
			int cols = sheet.getRow(0).getPhysicalNumberOfCells();
			
			 data = new Object[rows-1][cols];
			
			for(int i=1; i<rows; i++) {
				for(int j=0; j<cols; j++)
				{
					data[i-1][j] = getDataFromSheet(sheetName,i,j);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
	}
	
	public static String getDataFromSheet(String sheetName, int row, int col)
	{
		XSSFCell cell = workBook.getSheet(sheetName).getRow(row).getCell(col);
		
		String data = "";
		
		if(cell.getCellType()==CellType.STRING)
			data = cell.getStringCellValue();
		else if(cell.getCellType()==CellType.NUMERIC)
			data = String.valueOf((int)cell.getNumericCellValue());
		else if(cell.getCellType()==CellType.BLANK)
			data = "";
		
		return data;
			
	}
	
	public static void takeScreenShotInFileFormat(WebDriver driver)
	{	
		try {
			FileHandler.copy(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File(System.getProperty("user.dir")+"/Screenshots/screenshot"+TimeStamp()+".png"));
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String takeScreenShotInBase64(WebDriver driver)
	{
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
	}
	

}
