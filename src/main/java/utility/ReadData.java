package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData // ReadData class is created for dynamic coding/soft coding
{
	public static String readPropertyFile(String Value) throws IOException // reads data from TestData.config.properties file
	{
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream("C:\\Users\\pramo\\eclipse-workspace\\Project_Selenium_29Batch\\TestData\\config.properties");
		prop.load(file);
		return prop.getProperty(Value);
	}
	public static String readExcel(int rowNum, int colNum) throws 
EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\pramo\\eclipse-workspace\\Project_Selenium_29Batch\\TestData\\Book1.xlsx");
		Sheet es = WorkbookFactory.create(file).getSheet("Sheet1");
		String value = es.getRow(rowNum).getCell(colNum).getStringCellValue();
		return value;
	}
}	
