package org.geetha.testng.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ActionsTest {
	
	private WebDriver driver;
	
	@BeforeClass
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "E:\\Geetha\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://toolsqa.com/selenium-webdriver/mouse-hover-action/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testHoverMouse() {
	
		List<WebElement> eleList = driver.findElements(By.xpath("//section/div[@class = 'widget-title']//following-sibling::ul/li/a/span"));

		WebElement ele = eleList.get(0);
//		for(WebElement ele : eleList){
			System.out.println(ele.getText());
			Actions action = new Actions(driver);
			action.moveToElement(ele).build();
			
			String bgColor = ele.getCssValue("background-color");
			System.out.println("Before hover:" + bgColor);
			action.perform();
			bgColor = ele.getCssValue("background-color");
			System.out.println("After hover:" + bgColor);
//		}
	}
	
	@AfterClass
	public void close(){
		//driver.close();
	}
}