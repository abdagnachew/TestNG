package com.pages;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.BaseClass;

public class PersonalDetailsPageElements {

	@FindBy(id = "personal_cmbNation")
	public WebElement nationalityDD;

	@FindBy(name = "personal[optGender]")
	public List<WebElement> genderRadioGroup;

	@FindBy(xpath = "//div[@id='pdMainContainer']/div[1]/h1")
	public WebElement lblPersonalDetails;

	@FindBy(id = "personal_txtEmployeeId")
	public WebElement employeeId;
	
	@FindBy(xpath = "//input[@id='personal_txtEmpFirstName']")
	public WebElement firstnameGroup;
	
	@FindBy(xpath = "//input[@id='personal_txtEmpLastName']")
	public WebElement lastnameGroup;
	
	@FindBy(xpath = "//div[@id='profile-pic']//following-sibling::img")
	public WebElement profilePictureGroup;
	


	public PersonalDetailsPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
}