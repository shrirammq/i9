package com.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_001_AddToCart {

	private WebDriver driver = null;

	@Parameters({ "Browser"})
	@BeforeTest
	public void openBrowser(@Optional("chrome") String browser) {

		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		}

		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(5));

		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));

		driver.manage().window().maximize();

		driver.get("https://www.saucedemo.com/");
	}

	@DataProvider(name="getTestData")
	public String[][] getTestData(){
		String[][] data = {
				{"standard_user","secret_sauce"},
				{"standard_user","secret_sauce"}
				
		};
		return data;
	}
	
	@Test(dataProvider ="getTestData" )
	public void addToCart(String userName,String password) throws Exception {

		driver.findElement(By.id("user-name")).sendKeys(userName);

		driver.findElement(By.id("password")).sendKeys(password);

		driver.findElement(By.id("login-button")).click();

		Thread.sleep(1000);

		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

		Thread.sleep(1000);

		driver.findElement(By.id("remove-sauce-labs-backpack")).click();

		Thread.sleep(1000);

		driver.findElement(By.id("react-burger-menu-btn")).click();

		Thread.sleep(1000);

		driver.findElement(By.id("logout_sidebar_link")).click();

	}

	@AfterTest
	public void closeBrowser() throws Exception {
		
		Thread.sleep(1000);

		driver.quit();
	}

}
