package com.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinitions {

	private WebDriver driver = null;
	
	@Before
	public void openbrowser() {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(5));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@BeforeStep
	public void login() {
		driver.findElement(By.name("username")).sendKeys("Admin");

		driver.findElement(By.name("password")).sendKeys("admin123");

		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@When("addEmployee")
	public void add_employee() {
		System.out.println("AddEmployee");
	  
	}
	
	@When("editEmployee")
	public void edit_employee() {
		System.out.println("EditEmployee");
	}

	@When("deleteEmployee")
	public void delete_employee() {
		System.out.println("DeleteEmployee");
	}

	@AfterStep
	public void logout() throws Exception {
		driver.findElement(By.xpath("//img[@alt='profile picture']")).click();

		Thread.sleep(2000);

		driver.findElement(By.linkText("Logout")).click();
	}

	@After
	public void closebrowser() {
		driver.quit();
	}

}
