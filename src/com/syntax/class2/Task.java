package com.syntax.class2;

import org.testng.Assert; 
import org.testng.annotations.*;

import com.pages.DashboardPageElements;
import com.pages.LoginPage;
import com.pages.LoginPageElements;
import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class Task extends CommonMethods {
	@BeforeMethod
	public void openApp() {
		setUp();

	}

	@AfterMethod
	public void closeApp() {
		tearDown();

	}

	@Test
	public void logoValid() {
		LoginPageElements login = new LoginPageElements();
		boolean logoDisplay = login.logo.isDisplayed();

		Assert.assertTrue(logoDisplay, "Logo is not displayed");
		LoginPage login1 = new LoginPage();
		sendText(login1.username, ConfigsReader.getProperty("username"));
		sendText(login1.password, ConfigsReader.getProperty("password"));
		click(login1.loginBtn);
		DashboardPageElements w = new DashboardPageElements();
		boolean msgDisplayed= w.welcome.isDisplayed();
		Assert.assertTrue(msgDisplayed, "Should pass");
	}

}
