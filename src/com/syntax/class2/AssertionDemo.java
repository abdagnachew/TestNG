package com.syntax.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class AssertionDemo extends CommonMethods {
	// This is also called Hard Assert

	// AssertionError is handled within TestNG
	// Even if one Test Case fails, the others will executed

	@Test
	public void titleValidation() {
		String expectedTitle = "Human Management System";
		String actualTitle = driver.getTitle();

		// 1st way
		// Assert.assertEquals(actualTitle, expectedTitle);

		// 2nd way, You are giving a msg
		Assert.assertEquals(actualTitle, expectedTitle, "Title does not match");

		// if the (hard) assertion fails
		// the statements after assertion will not be executed.
		System.out.println("Text after assertion");
	}

	@Test(priority = 2, dependsOnMethods = { "titleValidation" })
	public void logoValidation() {
		boolean logoDisplayed = login.logo.isDisplayed();

		// 1st way
		// Assert.assertEquals(logoDisplayed, true, "Logo is not displayed");

		// 2nd way
		Assert.assertTrue(logoDisplayed, "Logo is not displayed");
	}

	@Test(priority = 3, dependsOnMethods = { "logoValidation" })
	public void loginValidation() {
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		boolean validateLogin = dashboard.welcome.isDisplayed();
		Assert.assertTrue(validateLogin);
	}

	@Test
	public void addE() {
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		dashboard.navigateToAddEmployee();
		wait(4);

		sendText(addEmp.firstName, ConfigsReader.getProperty("employeeFirstname"));
		sendText(addEmp.lastName, ConfigsReader.getProperty("employeeLastname"));
		sendText(addEmp.addPhoto, ConfigsReader.getProperty("filePath"));

		sendText(addEmp.employeeId, ConfigsReader.getProperty("id"));

		waitForClickability(addEmp.saveBtn);

		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Employee List")).click();

		wait(2);

		WebElement verification = driver.findElement(By.xpath("//*[@id=\"empsearch_employee_name_empName\"]"));
		sendText(verification, ConfigsReader.getProperty("employeeFirstname"));
		driver.findElement(By.id("searchBtn")).click();
		
		

		

	}

}
