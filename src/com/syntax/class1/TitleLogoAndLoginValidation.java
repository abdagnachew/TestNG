package com.syntax.class1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class TitleLogoAndLoginValidation extends CommonMethods {

	/*
	 * before: open browser, navigate to the website 1. Test Case: Title Validation
	 * after: quit the browser
	 * 
	 * before: open browser, navigate to the website 2. Test Case: Logo Validation
	 * after: quit the browser
	 * 
	 * before: open browser, navigate to the website 3. Test Case Valid Login after:
	 * quit the browser
	 */

	@BeforeMethod
	public void opennavigateWebsite() {
		setUp();
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

	@Test
	public void titleValidation() throws InterruptedException {
		String expected = "Human Management System";
		String actual = driver.getTitle();

		if (expected.equals(actual)) {
			System.out.println("Test Case Passed");
		} else {
			System.out.println("Test Case Failed");
		}
		Thread.sleep(3000);
	}

	@Test
	public void verifyLogo() throws InterruptedException {
		boolean hrLogo = driver.findElement(By.xpath("//div[@id='divLogo']/img")).isDisplayed();

		if (hrLogo) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
		Thread.sleep(3000);
	}

	@Test
	public void validateLogin() throws InterruptedException {
		WebElement username = driver.findElement(By.id("txtUsername"));
		sendText(username, ConfigsReader.getProperty("username"));

		WebElement password = driver.findElement(By.id("txtPassword"));
		sendText(password, ConfigsReader.getProperty("password"));
		click(driver.findElement(By.id("btnLogin")));

		boolean loginSuccess = driver.findElement(By.id("welcome")).isDisplayed();

		if (loginSuccess) {
			System.out.println("Login Successful");
		} else {
			System.out.println("Login Failed");

		}
		Thread.sleep(3000);

	}

	@Test
	public void addEmployee() throws InterruptedException {
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/pim/viewEmployeeList");
		Thread.sleep(1000);
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/pim/addEmployee");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("//input[@id='firstName']")).sendKeys("Abe");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("//input[@id='lastName']")).sendKeys("Dee");
		Thread.sleep(2000);
		click(driver.findElement(By.cssSelector("input[id='btnSave']")));

		Thread.sleep(1000);
	}
}
