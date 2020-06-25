package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.BaseClass;
import com.utils.CommonMethods;

public class SearchPageElements extends CommonMethods {

	@FindBy(linkText = "Employee List")
	public WebElement ES;

	@FindBy(xpath = "//form[@id='search_form']//following::label[1]")
	public WebElement verifyLabel;

	@FindBy(xpath = "//form[@id='search_form']//following-sibling::input[2]")
	public WebElement empNameclear;

	@FindBy(xpath = ("//*[@id=\"empsearch_employee_name_empName\"]"))
	public WebElement nameSearch2;
	
	@FindBy(xpath = "//a[@id='menu_pim_viewPimModule']")
	public WebElement PIM;

	@FindBy(id = "searchBtn")
	public WebElement clickSearch;

	@FindBy(id = "empsearch_id")
	public WebElement inputempID;

	@FindBy(xpath = "//label[@for='empsearch_employee_name']")
	public WebElement labelFind;
	

	public SearchPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}


	public void navigateToSearchEmp() {
		click(nameSearch2);
	}

	public void typeName() {
		click(nameSearch2);
		empNameclear.clear();
	}

}
