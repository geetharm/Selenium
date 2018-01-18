package org.geetha.testng.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindByTest {
	@BeforeTest
	public void setUpGeckoDriver() {
		System.setProperty("webdriver.gecko.driver", "E:\\Geetha\\Selenium\\geckodriver.exe");
	}

	@Test(enabled = false)
	public void f() {
		WebDriver driver = new FirefoxDriver();

		driver.get("http://www.facebook.com");
		System.out.println(driver.findElement(By.id("email")).getTagName());
		driver.close();
	}

	@Test(enabled = true)
	public void f1() {
		WebDriver driver = new FirefoxDriver();
		String alertMessage = "";

		driver.get("http://jsbin.com/usidix/1");
		driver.findElement(By.cssSelector("input[value=\"Go!\"]")).click();

		alertMessage = driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		driver.close();
	}

	@Test(enabled = false)
	// Explicit wait
	public void f2() {
		WebDriver driver = new FirefoxDriver();
		WebDriverWait myWait = new WebDriverWait(driver, 3);

		driver.get("http://www.facebook.com");
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		driver.findElement(By.id("email")).sendKeys("tutorial");
	}

	@Test(enabled = false)
	public void f3() {
		WebDriver driver = new FirefoxDriver();
		WebDriverWait myWait = new WebDriverWait(driver, 5);

		driver.get("http://testng.org/doc/index.html");
		// driver.switchTo().frame("Frame Test Suite Information");
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Download")));
		driver.findElement(By.linkText("Download")).click();
		driver.close();
	}

	@Test(enabled = false)
	public void f4() {
		WebDriver driver = new FirefoxDriver();

		driver.get("http://www.facebook.com");

		WebElement element = driver.findElement(By.xpath("//div[contains(text(), 'free')]"));
		Assert.assertEquals(element.isDisplayed(), true);
		System.out.println(element.toString());
		driver.close();
	}

	@AfterClass
	public void Close() {
		//System.exit(0);
	}
}
