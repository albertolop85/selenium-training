package com.dou.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleResultsPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public GoogleResultsPage(WebDriver d) {
		driver = d;
		wait = new WebDriverWait(driver, 15);
	}
	
	public void clickResultByPartialText(String text) {
		wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(text))).click();
	}
}
