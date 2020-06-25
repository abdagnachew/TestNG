package com.utils;

import com.pages.AddEmployeePageElements; 
import com.pages.DashboardPageElements;
import com.pages.LoginPage;
import com.pages.LoginPageElements;
import com.pages.PersonalDetailsPageElements;
import com.pages.SearchPageElements;

//initializes all pages class and stores references in static varibales
//that will called/used in test classes
public class PageInitializer extends BaseClass{

	public static LoginPageElements login;
	public static AddEmployeePageElements addEmp;
	public static DashboardPageElements dashboard;
	public static PersonalDetailsPageElements pdetails;
	public static LoginPage login2;
	public static SearchPageElements spElements;
	
	public static void initialize() {
		
		login=new LoginPageElements();
		dashboard=new DashboardPageElements();
		addEmp=new AddEmployeePageElements();
		pdetails=new PersonalDetailsPageElements();
		login2=new LoginPage();
	}
}