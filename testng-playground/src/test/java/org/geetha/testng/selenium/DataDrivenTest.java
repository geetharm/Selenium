package org.geetha.testng.selenium;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest {

	WebDriver driver;

	@BeforeClass( enabled = false)
	public void setUpGeckoDriver() {
		System.setProperty("webdriver.gecko.driver", "E:\\Geetha\\Selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.facebook.com");
	}
	
	@BeforeClass()
	public void setUpChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "E:\\Geetha\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.facebook.com");
	}
	

	@Test(dataProvider = "input")
	public void testFirefox(String uName, String pWord) {
		System.out.println(uName +"  :   " + pWord );
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(uName);
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).sendKeys(pWord);
	}

	@DataProvider(name = "input")
	public Object[][] inputFeed() throws Exception {

		XSSFSheet ExcelWSheet;
		XSSFWorkbook ExcelWBook;
		XSSFRow ExcelWRow;

		try {
			// Open the Excel file

			FileInputStream ExcelFile = new FileInputStream(
					"E:\\Geetha\\Selenium\\testng-playground\\Credentials.xlsx");

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");
			ExcelWRow = ExcelWSheet.getRow(ExcelWSheet.getFirstRowNum());

			int rowCount = ExcelWSheet.getLastRowNum() - ExcelWSheet.getFirstRowNum();
			int colCount = ExcelWRow.getLastCellNum();
			
			rowCount += 1;
			Object[][] faceBookData = new Object[rowCount][colCount];

			for (int i = 0; i < rowCount; ++i) {
				ExcelWRow = ExcelWSheet.getRow(i);
				for (int j = 0; j < colCount; ++j) {
					faceBookData[i][j] = ExcelWRow.getCell(j).getStringCellValue();
					System.out.println(ExcelWRow.getCell(j).getStringCellValue());
				}
			}
			return faceBookData;
		} catch (Exception e) {
			throw (e);
		}
	}
	
	@AfterClass
	public void exit(){
		driver.close();
	}
}
