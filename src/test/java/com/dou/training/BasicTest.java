package com.dou.training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicTest {

	@Test
	public void testBasicFlow() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		
		// Google Home Page
		wait.until(ExpectedConditions.elementToBeClickable(
				By.cssSelector("input[type=\"text\"]"))).sendKeys("honey badger wiki");
		driver.findElement(By.cssSelector("input[type=\"submit\"]:nth-child(1)")).click();
		
		// Google Results Page
		wait.until(ExpectedConditions.elementToBeClickable(
				By.partialLinkText("Wikipedia"))).click();
		
		// Wiki Result Page
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a.mw-wiki-logo")));
		String title = driver.getTitle();
		
		Assert.assertTrue(title.contains("Wikipedia"), "Title didn't include 'Wikipedia'");
		
		driver.quit();
	}
}
