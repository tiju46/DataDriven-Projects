package com.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.utility.NewExcelLibrary;
	

public class BaseClass {
	public WebDriver driver;
	NewExcelLibrary obj = new NewExcelLibrary("/Users/addauser/eclipse-workspace/DataDriven/TestData/Data.xlsx");
	
	@BeforeMethod
	public  void setup() {  
		 System.setProperty("webdriver.chrome.driver", 
		 System.getProperty("user.dir")+"/ChromeDriver/chromedriver");
		 driver=new ChromeDriver();  
         driver.navigate().to("https://opensource-demo.orangehrmlive.com/");  
       //Scroll down the webpage by 5000 pixels  
     //JavascriptExecutor js = (JavascriptExecutor)driver;  
     //js.executeScript("scrollBy(0, 5000)");        
 } 
	@DataProvider(name="Credentials")
	public Object[][] getData() {
		Object[][] data = new Object[3][2];
		data[0][0] = "admin";
		data[0][1] = "admin123";
		
		data[1][0] = "admin1";
		data[1][1] = "admin123";
		
		data[2][0] = "admin2";
		data[2][1] = "admin123";
		
		return data;
		
	}
	@DataProvider(name = "Credentials1")
	public Object[][] readExceldata() {
		int rows = obj.getRowCount("TestSheet");
		int column = obj.getColumnCount("TestSheet");
		Object[][] data = new Object[rows][column];
		for (int i =0; i < rows; i++) {
			for (int j =0; j < column; j++) {
				data[i][j] = obj.getCellData("TestSheet", j, i+1);
			}
		}
		return data;
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
