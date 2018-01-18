package org.geetha.testng.selenium;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class QaToolsTest {

	@BeforeTest
	public void setUpGeckoDriver() {
		System.setProperty("webdriver.gecko.driver", "E:\\Geetha\\Selenium\\geckodriver.exe");
	}

	@Test(enabled = true)
	public void f() {
		WebDriver driver = new FirefoxDriver();

		driver.get("http://toolsqa.wpengine.com/Automation-practice-form/");
		driver.findElement(By.name("firstname")).sendKeys("Lakshay");
		driver.findElement(By.name("lastname")).sendKeys("Sharma");
		driver.findElement(By.id("submit")).click();

		driver.close();
	}

	@Test(enabled = false)
	public void f1() {

		WebDriver driver = new FirefoxDriver();

		driver.get("http://toolsqa.wpengine.com/Automation-practice-form/");
		driver.findElement(By.partialLinkText("Partial")).click();
		System.out.println("Partial Link Test passed");

		System.out.println(driver.findElement(By.tagName("button")).toString());

		driver.findElement(By.linkText("Link Test")).click();
		System.out.println("Link Test passed");

		driver.close();
	}

	@Test (enabled = false)
	public void navigateCommands() {

		WebDriver driver = new FirefoxDriver();
		WebDriverWait myWait = new WebDriverWait(driver, 40);

		driver.get("http://www.DemoQA.com");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='menu-item-374']/a")).click();

		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name_3_firstname")));
		driver.navigate().back();
	
		driver.navigate().forward();
		driver.navigate().to("http://www.DemoQA.com");
		driver.navigate().refresh();

		driver.close();
	}
}
