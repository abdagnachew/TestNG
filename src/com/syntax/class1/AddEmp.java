package com.syntax.class1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class AddEmp extends CommonMethods {
	

	@BeforeMethod
	public void openAndNavigate() {
		setUp();
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
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
		WebElement Employee = driver.findElement(By.xpath("//a[@id='menu_pim_addEmployee']"));
		Employee.click();
		Thread.sleep(1000);
		WebElement addEmp = driver.findElement(By.xpath("//input[@id='firstName']"));
		sendText(addEmp, "Ibrhim");
		Thread.sleep(2000);
		WebElement addLast = driver.findElement(By.xpath("//input[@id='lastName']"));
		sendText(addLast, "Doejet");
		Thread.sleep(2000);

		click(driver.findElement(By.id("btnSave")));

		Thread.sleep(1000);
	}
}
