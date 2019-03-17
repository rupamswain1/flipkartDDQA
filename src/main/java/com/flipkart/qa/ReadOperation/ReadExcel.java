package com.flipkart.qa.ReadOperation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel 
{
	static List<Object> data=new ArrayList<>();
	public static List<Object> getData(String filePath) throws IOException
	{
		File file=new File(filePath);
		try {
			FileInputStream inputStream=new FileInputStream(file);
			
			Workbook workbook=null;
			String fileExtention=filePath.substring(filePath.indexOf("."));
			if(fileExtention.equalsIgnoreCase(".xlsx"))
			{
				workbook=new XSSFWorkbook(inputStream);
				
			}
			else if(fileExtention.equalsIgnoreCase(".xls"))
			{
				workbook=new HSSFWorkbook(inputStream);
			}
			
			Sheet sheet= workbook.getSheetAt(0);
			int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
			DataFormatter formatter=new DataFormatter();
			for(int i=1;i<=rowCount;i++)
			{
				Row row=sheet.getRow(i);
				
				List<String> rowData=new ArrayList<>();
				for(int j=0;j<row.getLastCellNum();j++)
				{
					
					rowData.add(formatter.formatCellValue(row.getCell(j)));
				}
				data.add(rowData);
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
		
	}
}
