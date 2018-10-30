package com.dou.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleHomePage {
	
	private WebDriver driver;
	private WebDriverWait wait;

	public GoogleHomePage(WebDriver d) {
		driver = d;
		wait = new WebDriverWait(driver, 15);
	}
	
	public void typeSearch(String text) {
		wait.until(ExpectedConditions.elementToBeClickable(
				By.cssSelector("input[type=\"text\"]"))).sendKeys(text);
	}
	
	public void clickSearch() {
		driver.findElement(By.cssSelector("input[type=\"submit\"]:nth-child(1)")).click();
	}
}
