package com.dou.training.pages;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class LinkedResultPage {

	private WebDriver driver;
	//private WebDriverWait wait;

	public LinkedResultPage(WebDriver d) {
		driver = d;
		//wait = new WebDriverWait(driver, 15);
	}
	
	public String getTitle() {
		return driver.getPageSource();
	}
}
