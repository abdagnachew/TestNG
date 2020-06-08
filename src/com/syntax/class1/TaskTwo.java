package com.syntax.class1;

import org.testng.annotations.*;

public class TaskTwo {
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("This is before Class");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("This is after Class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This is before Method");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("This is after Method");
	}
	
	@Test
	public void testOne() {
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
	}

	@Test
	public void testTwo() {
		System.out.println("Test Case 2");
	}

	@Test
	public void testThree() {
		System.out.println("Test Case 3");
	}

}
