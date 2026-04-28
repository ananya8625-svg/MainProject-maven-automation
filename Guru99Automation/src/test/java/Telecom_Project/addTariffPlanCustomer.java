package Telecom_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Baseclass.baseClass;

public class addTariffPlanCustomer extends baseClass {

	 WebDriver driver;

	    public addTariffPlanCustomer(WebDriver driver) {
	        this.driver = driver;
	    }
	    public void assignTariffPlan() {
	    	System.out.println("-------Add Tariff plan to Customer-------");
	    	driver.findElement(By.linkText("Telecom Project")).click();
	        driver.findElement(By.linkText("Add Tariff Plan to Customer")).click();
	        System.out.println("* Add customer :");
	        // Step 2: Enter Customer ID
	        driver.findElement(By.id("customer_id")).sendKeys("797544");

	        // Step 3: Submit
	        driver.findElement(By.name("submit")).click();

	        // Step 4: Select Tariff Plan
	        //driver.findElement(By.id("sele")).click();

	        // Step 5: Confirm
	        driver.findElement(By.name("submit")).click();

           
	        // Step 6: Validate success
	        String message = wait.until(
	        	    ExpectedConditions.visibilityOfElementLocated(By.tagName("h2"))
	        	).getText();

	        	System.out.println("Message: " + message);
	        
	        driver.findElement(By.xpath("//*[@id=\"main\"]/div/ul/li/a")).click();
}}
