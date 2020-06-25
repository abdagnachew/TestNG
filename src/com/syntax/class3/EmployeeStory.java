package com.syntax.class3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class EmployeeStory extends CommonMethods {

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
		
		List<WebElement> EmpInfo= driver.findElements(By.xpath("//*[@id=\"resultTable\"]/tbody/tr"));
		for (WebElement EmpI : EmpInfo) {
			String verify=EmpI.getText();
					System.out.println("Employee name = " + verify);
			
		}
	}
}
