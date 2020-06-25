package com.syntax.class2;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import com.pages.DashboardPageElements;
import com.pages.LoginPageElements;
import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class SoftAssertDemo extends CommonMethods {
//	Open Application
//	Verify logo is displayed
//	Enter valid credentials
//	Verify user successfully logged in
//	by verifying welcome message\
	
	@BeforeMethod
	public void openBrowser() {
		setUp();
	}
	
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

	@Test
	public void logoAndWelcomeValidation() {
		LoginPageElements login = new LoginPageElements();
		DashboardPageElements dashboard = new DashboardPageElements();

		// Logo assertion
		boolean logoDisplayed = login.logo.isDisplayed();

		// i can fail on purpose
		// logoDisplayed=false;
		// Assert.assertTrue(logoDisplayed, "Logo is not displayed");

		SoftAssert soft = new SoftAssert();
		soft.assertTrue(logoDisplayed);

		System.out.println("After first soft assertation.");

		// Logging in
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);

		
		// check dashboard
boolean msgDisplayed= dashboard.welcome.isDisplayed();
//Assert.assertTrue(msgDisplayed, "MSG is not diaplayed");
soft.assertTrue(msgDisplayed, "Msg not displayed");

//this will c eck if all soft assertions passed or failed
soft.assertAll();

//this should not show after checking assertAll
// Execution stops after assertAll

System.out.println("After assertion is completel finished");
	

	}
}