package com.dou.training;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dou.training.pages.GoogleHomePage;
import com.dou.training.pages.GoogleResultsPage;
import com.dou.training.pages.LinkedResultPage;

public class PageObjectTest {

	private WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.get("http://www.google.com");
	}

	@Test
	public void testImprovedBasicFlow() {

		// Google Home Page
		GoogleHomePage homePage = new GoogleHomePage(driver);
		homePage.typeSearch("honey badger wiki");
		homePage.clickSearch();

		// Google Results Page
		GoogleResultsPage resultsPage = new GoogleResultsPage(driver);
		resultsPage.clickResultByPartialText("Wikipedia");

		// Wiki Result Page
		LinkedResultPage resultPage = new LinkedResultPage(driver);

		// wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a.mw-wiki-logo")));

		Assert.assertTrue(resultPage.getTitle().contains("Wikipedia"), "Title didn't include 'Wikipedia'");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
