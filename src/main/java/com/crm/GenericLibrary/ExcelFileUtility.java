package com.crm.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author owner
 *
 */

public class ExcelFileUtility
{
	/**
	 * 
	 * @param Sheetname
	 * @param rowNum
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromExcel(String Sheetname, int rowNum,int cellNum) throws Throwable
	{
		
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheetname);
		Row ro = sh.getRow(rowNum);
		Cell cel = ro.getCell(cellNum);
		String value = cel.getStringCellValue();
		return value;
	}
	/**
	 * 
	 * @param Sheetname
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */
	 public void writeDataFromExcel(String Sheetname, int rowNum, int cellNum, String value) throws Throwable
	 {
		
		 FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(Sheetname);
			Row ro = sh.getRow(rowNum);	 
			Cell cel = ro.createCell(cellNum);
			cel.setCellValue(value);
			FileOutputStream fos=new FileOutputStream(IPathConstants.ExcelPath);
			wb.write(fos);
			
	 }
	 /**
	  * 
	  * @param Sheetname
	  * @return
	 * @throws Throwable 
	 * @throws EncryptedDocumentException 
	  */
			
			public int getRowCount(String Sheetname) throws EncryptedDocumentException, Throwable
			{
				FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
				Workbook wb = WorkbookFactory.create(fis);
				Sheet sh = wb.getSheet(Sheetname);
				int row = sh.getLastRowNum();
				return row;
			}
			
			
			/**
			 * This method will read multiple data from excel sheet with the help of sheetname
			 * and return 2 dimensional object [][]
			 * @param SheetName
			 * @return
			 * @throws Throwable
			 */
			public Object[][] readmultipleDataFromExcel(String SheetName) throws Throwable
			{
				FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
				Workbook wb = WorkbookFactory.create(fis);
				Sheet sh = wb.getSheet(SheetName);
				int lastRow = sh.getLastRowNum();
				int lastCell = sh.getRow(0).getLastCellNum();
				
				Object[][] data = new Object[lastRow][lastCell];
				
				for(int i = 0;i<lastRow;i++)
				{
					for(int j=0;j<lastCell;j++)
					{
						data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
					}
				}
				
				return data;
			
			}
					
	 

}
