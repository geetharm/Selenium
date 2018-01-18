package org.geetha.testng.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class calendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "E:\\Geetha\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("https://www.path2usa.com/travel-companions");
		
		driver.findElement(By.xpath(".//input[@name='travel_date']")).click();
		
		while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']"))
				.getText().contains("April 2018")){
			driver.findElement(By.cssSelector("[class='datepicker-days'] [class='next']")).click();
		}

		List<WebElement> dates = driver.findElements(By.className("day"));
		
		for(WebElement date : dates) {
			if(date.getText().equals("23")){
				date.click();
				break;
			}
		}
	}
}
