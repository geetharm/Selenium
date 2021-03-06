package org.geetha.testng.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DealsTest {

	private WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "E:\\Geetha\\Selenium\\geckodriver.exe");

		driver = new FirefoxDriver();
		driver.get("http://www.paypal.com/deals/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void findHeaderImg() {

		//List<WebElement> element = driver.findElements(By.className("card__store pp-sans-small-medium"));
		//List<WebElement> element = driver.findElements(By.xpath(".//*[@id='featuredOffers']/div/div[1]/div/div/div/div[3]/div[2]/div/div/p[1]"));
		//List<WebElement> element = driver.findElements(By.cssSelector("div[class ='container']"));
		List<WebElement> element = driver.findElements(By.cssSelector("p>div[class = 'card__store.pp-sans-small-medium']"));
		for(int i = 0; i < element.size(); ++i) {
			System.out.println(element.get(i).getText());
		}
		Assert.assertEquals(2, element.size());
	}

	@Test(enabled = false)
	public void findHeroOffers() {

		WebDriverWait myWait = new WebDriverWait(driver, 30);

		List<WebElement> element = driver.findElements(By.xpath("//li[@class = 'offer heroOffer ng-scope']"));

		System.out.println(element.size());
		Assert.assertEquals(3, element.size());

		for (int i = 0; i < element.size(); ++i) {
			element.get(i).click();

			System.out.println(element.toString());
			myWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Back to Shop")));
			WebElement ele = driver.findElement(By.linkText("Back to Shop"));
			myWait.until(ExpectedConditions.elementToBeClickable(ele));
			driver.findElement(By.linkText("Back to Shop")).click();
		}
	}

	@Test (enabled = false)
	public void countTiles() {
		List<WebElement> element = driver.findElements(By.xpath("//li[@class = 'offer ng-scope']"));
		Assert.assertEquals(30, element.size());
		System.out.println("Number of tiles: " + element.size());
		driver.findElement(By.className("seeMore")).click();
		
		for(int i = 0; i < element.size(); ++i) {
			System.out.println(element.get(i).findElement(By.className("merchantName")).getText());
		}
	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		List<WebElement> ele = driver.findElements(By.xpath("//li[@class = 'offer ng-scope']"));
		System.out.println("Number of tiles: " + ele.size());
		Assert.assertEquals(60, ele.size());
		
		for(int i = 0; i < ele.size(); ++i) {
			System.out.println(ele.get(i).findElement(By.className("merchantName")).getText());
		}
	}

	@Test (enabled = false)
	public void saveDeal(){
		List<WebElement> element = driver.findElements(By.xpath("//li[@class = 'offer ng-scope']"));
		Assert.assertEquals(30, element.size());
		System.out.println("Number of tiles: " + element.size());

		element.get(1).click();
		//WebElement ele = element.get(0).findElement(By.cssSelector("button[class = 'save ng-scope']"));
		//System.out.println(ele.getTagName());
		//System.out.println(ele.getText());
		//ele.click();
	}
	
	@AfterClass
	public void Close() {
		// System.exit(0);
	}
}
