package org.geetha.testng.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class YahooPaypal {
	
	@BeforeTest
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "E:\\Geetha\\Selenium\\chromedriver.exe");

		//System.setProperty("webdriver.gecko.driver", "E:\\Geetha\\Selenium\\geckodriver.exe");
	}

	@Test
	public void openPage(){
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();		
		driver.get("https://finance.yahoo.com/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement ele = driver.findElement(By.tagName("input"));
		
		//ele.clear();
		ele.sendKeys("pypl");
		
		driver.findElement(By.id("search-button")).click();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//String value = driver.findElement(By.xpath("//*[@id=\"quote-header-info\"]/div[2]/div[1]/div[1]")).getText();
		
		WebElement ele1 = driver.findElement(By.xpath("//*[@id=\"quote-header-info\"]/div[3]/div[1]/div/span[1]"));

		String value = ele1.getText();
		
		System.out.println(value);
		try{
			Assert.assertEquals(value, "41.00");
		} catch (Exception e){
			System.out.println(e);
		}
				
		driver.close();
	}
}

