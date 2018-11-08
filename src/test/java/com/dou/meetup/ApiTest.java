package com.dou.meetup;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ApiTest {
	
	@Parameters({"url", "port"})
	@BeforeTest(alwaysRun = true)
	public void setUp(String url, @Optional("") String port) {
		RestAssured.baseURI = url;
		RestAssured.port = new Integer(port);
	}
	
	@Test(groups = "integration", priority = 1)
	public void testInitialPage() {
		
		System.out.println("testApiInitialPage");
		
		when().
			get("/").
		then().
			statusCode(200).
			contentType(ContentType.TEXT);
	}
}
