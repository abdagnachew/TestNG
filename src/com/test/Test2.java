package com.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class Test2 extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
//			TC 2: Delete Employee
//			Open chrome browser
//			Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth”
//			Login into the application
//			Add Employee
//			Verify Employee has been added
//			Go to Employee List
//			Delete added Employee
//			Quit the browser

		setUp();
		WebElement username = driver.findElement(By.id("txtUsername"));
		sendText(username, "Admin");
		WebElement passWord = driver.findElement(By.id("txtPassword"));
		sendText(passWord, "Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();

		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Add Employee")).click();
		WebElement empFirstName = driver.findElement(By.id("firstName"));
		sendText(empFirstName, "Bobby");
		WebElement empMiddleName = driver.findElement(By.id("middleName"));
		sendText(empMiddleName, "Boshat");
		WebElement empLastName = driver.findElement(By.id("lastName"));
		sendText(empLastName, "Akca");

		WebElement empID = driver.findElement(By.id("employeeId"));
		sendText(empID, "01234569");

		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("btnAddAttachment")).click();
		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Employee List")).click();
		WebElement verification = driver.findElement(By.xpath("//*[@id=\"empsearch_employee_name_empName\"]"));
		sendText(verification, "Ali Kemal Tarlaci");
		driver.findElement(By.id("searchBtn")).click();

		List<WebElement> newEmpInfo = driver.findElements(By.xpath("//*[@id=\"resultTable\"]/tbody/tr"));
		for (WebElement info : newEmpInfo) {
			String verif = info.getText();
			System.out.println("new employee added, new employee name is " + verif);
		}

	}

}
