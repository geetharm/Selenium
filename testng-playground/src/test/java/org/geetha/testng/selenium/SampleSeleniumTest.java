package org.geetha.testng.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SampleSeleniumTest {
	@BeforeClass
	public void setupGeckoDriver() {
		System.setProperty("webdriver.gecko.driver","E:\\Geetha\\Selenium\\geckodriver.exe");		
	}
	
	@Test (enabled = true)
 	public void testWebsite() {
		// declaration and instantiation of objects/variables
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http:google.com";
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = "";

		driver.manage().window().maximize();
		// launch Firefox and direct it to the Base URL
		driver.get(baseUrl);

		// get the actual value of the title
		actualTitle = driver.getTitle();

        /*
         * compare the actual title of the page witht the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }

        // close Firefox
		driver.close();
		
		//driver.quit();
	    // exit the program explicitly
        System.exit(0);
	}
}
