package com.dou.meetup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UiTest {
	
	private WebDriver driver;

	@Parameters({"url", "port"})
	@BeforeMethod(alwaysRun = true)
	public void setup(String url, @Optional("") String port) {
		
		String appUrl = url;
		
		if (port != null && !port.isEmpty()) {
			appUrl += ":" + port;
		}
		
		driver = new ChromeDriver();
		driver.get(appUrl);
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
	
	@Test(groups = "integration", priority = 2)
	public void testWebappTitle() {
		
		System.out.println("testUiWebappTitle");
		
		Assert.assertEquals(driver.getTitle(), "");
	}
	
	@Test(groups = "integration", priority = 2)
	public void testInitialMessage() {
		
		System.out.println("testUiInitialMessage");
		
		Assert.assertEquals(driver.findElement(By.tagName("body")).getText(), 
				"Greetings from Spring Boot!");
	}
}
