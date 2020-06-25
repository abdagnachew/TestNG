package com.syntax.class4;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.ConfigsReader;
import com.utils.ExcelUtility;

public class HW extends CommonMethods {
	
	
	@Test(dataProvider = "userDataFromExcel")
	public void test (String firstName, String lastName, String username, String password) {
		System.out.println(firstName+ " " + lastName + " " +username+ " "+ password);
		//login to HRMS
		login.login(ConfigsReader.getProperty("username"),ConfigsReader.getProperty("password"));
		
		//navigate to Add Employee
		dashboard.navigateToAddEmployee();
		wait(1);
		sendText(addEmp.firstName, firstName);
		sendText(addEmp.lastName, lastName);
		String expectedEmpID=addEmp.employeeId.getAttribute("value"); 
		
		click(addEmp.checkboxLoginDetails);
		sendText(addEmp.username, username);
		sendText(addEmp.password, password);
		sendText(addEmp.confirmPassword, password);
		wait(1);
		jsClick(addEmp.saveBtn);
		

		// validation
		waitForVisibility(pdetails.lblPersonalDetails);
		String actualEmpId = pdetails.employeeId.getAttribute("value");
		Assert.assertEquals(actualEmpId, expectedEmpID, "Employee ID did not match!");

		// take screenshot
		takeScreenshot(firstName + "_" + lastName);
	}
	
	@DataProvider(name = "userData")
	public Object [] [] getData(){
		Object [][] data = {
				{"Raj", "Capoor", "raj1234567819", "AmirKhan_@123"},
				{"John", "Smith", "john123", "AmirKhan_@123"},
				{"Mary", "Ann", "mary123", "AmirKhan_@123"},
				{"Rohani", "Sakhi", "rohani123456789", "AmirKhan_@123"},
		};
		return data;
	}
	
	@DataProvider(name ="userDataFromExcel")
	public Object [][] getData2(){
		return ExcelUtility.excelIntoArray(System.getProperty("user.dir") + "/testData/ExcelTestData.xlsx", "Emp");

		
	}
	

}
