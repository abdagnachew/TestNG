package com.test;

import org.testng.annotations.Test; 
//import org.testng.asserts.SoftAssert;
import org.testng.asserts.SoftAssert;

import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class Story1 extends CommonMethods {

	@Test
	public void addEmployeePage() {

		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		dashboard.navigateToAddEmployee();
		wait(4);

		sendText(addEmp.firstName, ConfigsReader.getProperty("employeeFirstname"));
		sendText(addEmp.lastName, ConfigsReader.getProperty("employeeLastname"));
		sendText(addEmp.addPhoto, ConfigsReader.getProperty("filePath"));
		sendText(addEmp.employeeId, ConfigsReader.getProperty("id"));
		
		click(addEmp.saveBtn);
		

			
		SoftAssert soft = new SoftAssert();
		boolean verifyDisplayFirst = pdetails.firstnameGroup.isDisplayed();

		soft.assertTrue(verifyDisplayFirst);
		wait(3);
		
		boolean verifyDisplayLast = pdetails.lastnameGroup.isDisplayed();
		soft.assertTrue(verifyDisplayLast, "LName  shown");
		wait(3);
		
		boolean verifyDisplayPhoto = pdetails.profilePictureGroup.isDisplayed();
		soft.assertTrue(verifyDisplayPhoto, "Name  shown");
		wait(3);
		

		boolean verifyDisplayID = pdetails.employeeId.isDisplayed();
		soft.assertTrue(verifyDisplayID, "ID  shown");
		wait(3);

		soft.assertAll();
		}
	}


