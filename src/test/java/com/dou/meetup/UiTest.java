package com.dou.meetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UiTest {
	
	private WebDriver driver;

	@Parameters("url")
	@BeforeMethod
	public void setup(String url) {
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(groups = "integration")
	public void testWebappTitle() {
		
	}
	
	@Test(groups = "integration")
	public void testInitialMessage() {
		
	}
}
