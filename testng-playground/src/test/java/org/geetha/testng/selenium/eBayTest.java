package org.geetha.testng.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class eBayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\Geetha\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ebay.com/");

		System.out.println(driver.findElements(By.tagName("a")).size());
		
		WebElement footer = driver.findElement(By.id("glbfooter"));
		int count = footer.findElements(By.tagName("a")).size();
		System.out.println("Links in the footer: " + count);
		
		WebElement col = footer.findElement(By.xpath(".//div[@id='gf-BIG']/table/tbody/tr/td[2]/ul"));
		int countCol = col.findElements(By.tagName("a")).size();
		System.out.println("Links in the column: " + countCol);

		for(int i = 0; i < countCol; ++i) {
			String text = col.findElements(By.tagName("a")).get(i).getText();
			if(text.contains("Site map")){
				col.findElements(By.tagName("a")).get(i).click();		
				break;
			}
		}

		Assert.assertEquals(driver.getTitle(), "Sitemap | eBay");
		
		WebElement actElement = driver.findElement(By.cssSelector("a.gh-eb-li-a"));
		Actions act = new Actions(driver);
		act.moveToElement(actElement).build().perform();
	}

}
