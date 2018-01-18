package org.geetha.testng.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RadioButtonsTest {

	@BeforeClass(alwaysRun=true)
	public void setUpGeckoDriver() {
		System.setProperty("webdriver.gecko.driver", "E:\\Geetha\\Selenium\\geckodriver.exe");
	}

	@Test(enabled = false, groups = "check")
	public void fIsSelected() {
		WebDriver driver = new FirefoxDriver();
		// Launch the URL
		driver.get("http://toolsqa.wpengine.com/automation-practice-form");

		List<WebElement> radioButtons = driver.findElements(By.name("sex"));

		if (radioButtons.get(0).isSelected()) {
			radioButtons.get(1).click();
		} else {
			radioButtons.get(0).click();
		}

		driver.close();
	}

	@Test (enabled = false, groups = "test1")
	public void fCheckBoxes() {
		WebDriver driver = new FirefoxDriver();
		// Launch the URL
		driver.get("http://toolsqa.wpengine.com/automation-practice-form");

		List<WebElement> checkBoxes = driver.findElements(By.name("tool"));

		for (int i = 0; i < checkBoxes.size(); ++i) {
			String iString = checkBoxes.get(i).getAttribute("value");

			System.out.println(iString);
			if (iString.equalsIgnoreCase("toolsqa")) {
				checkBoxes.get(i).click();
				break;
			}
		}

		driver.close();
	}

	@Test (enabled = false, groups = "test1")
	public void fCheckBoxesWithCSS() {

		WebDriver driver = new FirefoxDriver();
		WebElement element;
		// Launch the URL
		driver.get("http://toolsqa.wpengine.com/automation-practice-form");

		try {
			 element = driver.findElement(By.cssSelector("input[value='Tools QA']"));
		} catch (NoSuchElementException e) {
			driver.close();
			System.out.println("No Such Element");
			return;
		}

		element.click();
		driver.close();
	}
	
	@Test (enabled = true, groups = "check")
	public void f1() {
		WebDriver driver = new FirefoxDriver();

		// Launch the URL
		driver.get("http://toolsqa.wpengine.com/automation-practice-form");

		List<WebElement> radioButtons = driver.findElements(By.name("sex"));

		if (radioButtons.get(0).isSelected()) {
			radioButtons.get(1).click();
		} else {
			radioButtons.get(0).click();
		}

		WebElement element = driver.findElement(By.id("exp-2"));
		element.click();

		List<WebElement> checkBoxes = driver.findElements(By.name("profession"));
		
		for(int i = 0; i < checkBoxes.size(); ++i) {
			
			WebElement element1 = checkBoxes.get(i); 
			if(element1.getAttribute("value").equalsIgnoreCase("Automation Tester")) {
				element1.click();
				break;
			}
		}

		WebElement element2 = driver.findElement(By.cssSelector("input[value= 'Selenium IDE']"));
		element2.click();

		driver.close();
	}
}
