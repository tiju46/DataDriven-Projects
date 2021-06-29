package com.testcases;

import com.base.BaseClass;
import java.sql.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataDrivenTest extends BaseClass {
	
	
	@Test(dataProvider = "Credentials1")
	public void loginTest(String username, String Password) {
		
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(Password);
		driver.findElement(By.id("btnLogin")).click();

		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		Assert.assertEquals(actualURL, expectedURL);
}
}
