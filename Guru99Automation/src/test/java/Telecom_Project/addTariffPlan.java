package Telecom_Project;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import Baseclass.baseClass;

public class addTariffPlan extends baseClass {

	@Test
    public void add() {

        // Click Add Tariff Plan
        driver.findElement(By.linkText("Add Tariff Plan")).click();
        driver.findElement(By.id("rental1")).sendKeys("500");
        driver.findElement(By.id("local_minutes")).sendKeys("1000");
        driver.findElement(By.id("inter_minutes")).sendKeys("500");
        driver.findElement(By.id("sms_pack")).sendKeys("100");
        driver.findElement(By.id("minutes_charges")).sendKeys("1");
        driver.findElement(By.id("inter_charges")).sendKeys("2");
        driver.findElement(By.id("sms_charges")).sendKeys("1");
        driver.findElement(By.name("submit")).click();
        WebElement successMsg = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.tagName("h2"))
        );

        String actualText = successMsg.getText();
        String expectedText = "Congratulation you add Tariff Plan";

        // IF condition check
        if (actualText.equals(expectedText)) {
            System.out.println(" Form submitted successfully");
        } else {
            System.out.println("Form submission failed");
            System.out.println("Actual message: " + actualText);
            
        }
        driver.navigate().back();
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/form/div/div[36]/ul/li[2]/input")).click();
        System.out.println("Reset button working currectly");
        
}
	@Test
	public void emptyFieldValidation() {

	    //driver.findElement(By.linkText("Add Tariff Plan")).click();

	    // Click submit without data
	    driver.findElement(By.name("submit")).click();

	    try {
	        // Wait for alert
	        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

	        String alertText = alert.getText();
	        System.out.println("Alert message: " + alertText);

	        if (alertText.contains("please fill all fields")) {
	            System.out.println("Validation working for empty fields");
	        } else {
	            System.out.println(" Unexpected alert message");
	        }

	        alert.accept(); // VERY IMPORTANT

	    } catch (Exception e) {
	        System.out.println(" No alert present");
	    }
	}
	
	@Test
	public void invalidInputValidation() {

	    //driver.findElement(By.linkText("Add Tariff Plan")).click();

	    driver.findElement(By.id("rental1")).sendKeys("abc");
	    driver.findElement(By.name("submit")).click();
	    Alert alert = wait.until(ExpectedConditions.alertIsPresent());

	    String alertText = alert.getText();
	    System.out.println("Alert message: " + alertText);

	    if (alertText.contains("please fill all fields")) {
	        System.out.println(" Alert validation working");
	    } else {
	        System.out.println(" Unexpected alert message");
	    }

	    alert.accept();
}
	@Test
	public void negativeValueTest() {

	    driver.findElement(By.id("rental1")).sendKeys("-100");
	    driver.findElement(By.name("submit")).click();

	    Alert alert = wait.until(ExpectedConditions.alertIsPresent());

	    System.out.println("Alert message for negative value: " + alert.getText());

	    alert.accept();
	}

}
