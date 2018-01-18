package org.geetha.testng.selenium;

import java.util.List;
import java.util.Locale.Category;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DealsChromeTest {

	private WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "E:\\Geetha\\Selenium\\chromedriver.exe");

		driver = new ChromeDriver();

		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
	}

	@Test (enabled = false)
	public void findHeaderImg() {
		
		driver.get("http://www.paypal.com/deals/");
		driver.findElement(By.xpath("//*[@id=\"featuredOffers\"]/div/div[2]/div/a")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		List<WebElement> element = driver.findElements(By.xpath("//div[@class = 'heading']//following-sibling::div/div/div/p[1]"));
		
		for(int i = 0; i < element.size(); ++i) {
			System.out.println(element.get(i).getText());
		}

		Assert.assertEquals(12, element.size());
	}

	@Test (enabled = false)
	public void getCouponCode(){

		List<WebElement> element;

		element = driver.findElements(By.xpath("//div[@class = 'heading']//following-sibling::div/div/div/a"));

		for(int i = 0; i < 1; ++i) {
			System.out.println(element.get(i).getText());
			element.get(i).click();
			
			String value = driver.findElement(By.className("couponWrapper")).getText();
			//String value = driver.findElement(By.xpath("//*[@id=\"document-body\"]/section/div[2]/div[1]/div/div[1]/div/div/span")).getText();
			System.out.println("Coupon Code    " + value);
		}		
	}
			
	@Test (enabled = false)
	public void getSelect(){
		
		driver.get("http://demo.guru99.com/selenium/newtours/register.php");
		
		Select drpCountry = new Select(driver.findElement(By.name("country")));
		
		drpCountry.selectByVisibleText("ANTARCTICA");
		
		//driver.get(http://jsbin.com/osebed/2);
		//Select fruits = new Select(driver.findElement(By.id("fruits")));
		//fruits.selectByVisibleText("Banana");
		//fruits.selectByIndex(1);
	}
	
	@Test (enabled = true)
	public void selectCategory(){
		
		driver.get("https://www.paypal.com/deals/?view=results");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Select category = new Select(driver.findElement(By.className("steps-intent__select")));
		
		Select category = new Select(driver.findElement(By.xpath("//*[@id = 'filterCategory']")));

		System.out.println("Is Multiple option: " + category.isMultiple());
		//category.selectByVisibleText("Entertainment (18)");
		category.selectByIndex(2);

		List<WebElement> element = driver.findElements(By.xpath("//div[@class = 'heading']//following-sibling::div/div/div/p[1]"));

		for(int i = 0; i < element.size(); ++i) {
			System.out.println(element.get(i).getText());
		}
	}

	@AfterClass
	public void Close() {
		//driver.close();
		// System.exit(0);
	}
}
