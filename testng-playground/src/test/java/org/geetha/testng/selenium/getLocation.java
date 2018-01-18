package org.geetha.testng.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class getLocation {

	WebDriver driver;

	@BeforeClass
	public void setUp(){
//		System.setProperty("webdriver.chrome.driver", "E:\\Geetha\\Selenium\\chromedriver.exe");
//		driver = new ChromeDriver();
		System.setProperty("webdriver.gecko.driver", "E:\\Geetha\\Selenium\\geckodriver.exe");
		driver = new FirefoxDriver();

	}
	
	@Test (enabled = false)
	public void locateEle() {
		driver.get("http://www.phptravels.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='s2id_autogen8']/a/span[1]")));
		driver.findElement(By.xpath("//div[@id='s2id_autogen8']/a/span[1]")).click();
		driver.findElement(By.xpath("//li[@class='text-center']/a/span")).click();
	}

	
	@Test
	public void actionMouse() {
		driver.get("https://www.amazon.com/");
		WebElement ele = driver.findElement(By.id("twotabsearchtextbox"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).click().build().perform();
		action.keyDown(ele, Keys.SHIFT).sendKeys("kids dress").build().perform();
	}
	@AfterClass
	public void close() {
		//driver.close();
	}
}
