package com.syntax.class2;

import org.openqa.selenium.support.ui.ExpectedConditions; 
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import com.pages.LoginPageElements;
import com.utils.CommonMethods;
import com.utils.Constants;
import com.utils.ConfigsReader;

public class HW extends CommonMethods {

	@BeforeMethod
	public void openBrowserNavigate() {
		setUp();

	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}
	// 1st way
		// @Test(dependsOnMethods = "invalidLogin" )
		// 2nd way
		// @Test(dependsOnMethods = { "invalidLogin" })
		// depending on multiple methods
		// @Test(dependsOnMethods = { "invalidLogin", "method2", "method3" })
	@Test(priority =2, dependsOnMethods = "invalidLogin")
	public void validLogin() {
		// WebElement username = driver.findElement(By.id("txtUsername"));

		//// 1st way
		// username.sendKeys(ConfigsReader.getPropoerty("username"))

		// 2nd way
		// sendText(username, ConfigsReader.getProperty("username"));

		// 3rd way using POM and Page Factory
		LoginPageElements login = new LoginPageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));

		sendText(login.username, ConfigsReader.getProperty("password"));

		// 1st way
		WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME);
		wait.until(ExpectedConditions.elementToBeClickable(login.loginBtn));
		login.loginBtn.click();

		// 2nd way
//		waitForClickability(login.loginBtn);
//		login.loginBtn.click();

		// 3rd way
		click(login.loginBtn);

		
		//DashboardPageElements dashboard = new DashboardPageElements();

		boolean displayed = login.logo.isDisplayed();

		if (displayed) {
			System.out.println("Logo is displayed");

		} else {
			System.out.println("Logo is not displayed");
		}
		
		// 1st way
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		wait(1);

	}

	// @Test means Test Case = Scenario = Test Method
	// Case 1: if this method is commented it will not run
	// Depending Method will throw an exception if commented on true
	// @Test (priority =3, enabled = true)

	// Case 2: if the test method is disabled, it will not run
	// Depending method will throw an exception
	// @Test(priority = 3, enabled = false)
	
	// Case 3: if this test method fails, it will run but fail
		// Depending method will not execute

		// Case 4: if this test method passes, it will run and pass
		// Depending method will execute


	@Test(priority = 3)
	public void invalidLogin() throws Exception {
		LoginPageElements login = new LoginPageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		click(login.loginBtn);

		String expectedText = "Password cannot be empty";
		String actualText = login.errorMsg.getText();

		boolean errorDisplayed = login.errorMsg.isDisplayed();

		if (errorDisplayed) {
			System.out.println("Error Msg is Displayed");

			if (expectedText.equals(actualText)) {
				System.out.println("Msg is correct");
			} else {
				System.out.println("Msg is notcorrect");
			}
		} else {
			System.out.println("Error msg is not Displayed");
		}
		wait(3);

			
			// When the test fails an an Exception is thrown,
			//throw new Exception();

		}
	}


