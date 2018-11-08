package com.dou.meetup;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ApiTest {
	
	@Parameters({"url", "port"})
	@BeforeTest(alwaysRun = true)
	public void setUp(String url, String port) {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8090;
	}
	
	
	@Test(groups = "integration")
	public void testInitialPage() {
		
		when().
			get("/").
		then().
			statusCode(200).
			contentType(ContentType.TEXT);
		
	}
}
