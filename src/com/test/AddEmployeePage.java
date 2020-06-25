package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class AddEmployeePage extends CommonMethods {

	@Test
	public void loginEmp() {

		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		dashboard.navigateToAddEmployee();
		wait(5);

		sendText(addEmp.firstName, ConfigsReader.getProperty("employeeFirstname"));
		sendText(addEmp.lastName, ConfigsReader.getProperty("employeeLastname"));
		sendText(addEmp.addPhoto, ConfigsReader.getProperty("filePath"));
		waitForClickability(addEmp.saveBtn);

		pdetails.firstnameGroup.isDisplayed();

		String expectedFirst = "Colin";
		String actualFirst = pdetails.firstnameGroup.getAttribute("value");
		Assert.assertEquals(actualFirst, expectedFirst);
		pdetails.employeeId.isDisplayed();
	}

}
