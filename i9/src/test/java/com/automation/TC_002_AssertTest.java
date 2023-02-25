package com.automation;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_002_AssertTest {

	
	@Test(priority = 1)
	public void addEmployee() {
		System.out.println("AddEmployee");
		Assert.assertTrue(true);
	}
	
	@Test(priority = 2,dependsOnMethods = "addEmployee")
	public void editEmployee() {
		System.out.println("EditEmployee");
	}
	
	@Test(priority = 3,dependsOnMethods = "addEmployee")
	public void deleteEmployee() {
		System.out.println("DeleteEmployee");
	}
}
