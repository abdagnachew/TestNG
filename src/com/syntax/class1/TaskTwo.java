package com.syntax.class1;

import org.testng.annotations.*;

public class TaskTwo {
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before class executes.");
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
		System.out.println("This is Test One annotation");
	
	}

	@Test
	public void testTwo() {
		System.out.println("Test Two Annotation");
	}

	@Test
	public void testThree() {
		System.out.println("Test Three annotation");
	}

}
