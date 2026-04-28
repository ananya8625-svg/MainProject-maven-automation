package Telecom_Project;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Baseclass.baseClass;

public class payBilling extends baseClass {
	 WebDriver driver;
	    WebDriverWait wait;
	    public payBilling(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
	    }
	@Test
	public void customerId() {
		System.out.println("-------Add Pay Bill-------");
		driver.findElement(By.linkText("Telecom Project")).click();
        driver.findElement(By.linkText("Pay Billing")).click();
        WebElement submitBtn = driver.findElement(By.name("submit"));
        try {
	        // Wait for alert
	        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

	        String alertText = alert.getText();
	        System.out.println("Alert message: " + alertText);

	        if (alertText.contains("please correct value input")) {
	            System.out.println("Validation working for empty fields");
	        } else {
	            System.out.println(" Unexpected alert message");
	        }

	        alert.accept(); // VERY IMPORTANT

	    } catch (Exception e) {
	        System.out.println(" No alert present");
	    }
        if (submitBtn.isDisplayed() && submitBtn.isEnabled()) {
            System.out.println(" Submit button is clickable");
        } else {
            System.out.println(" Submit button NOT clickable");
        }
	}
	@Test
	
	public void invalidCustomerIdTest() {

	    //  ALWAYS NAVIGATE (Important)
	    driver.findElement(By.linkText("Telecom Project")).click();
	    driver.findElement(By.linkText("Pay Billing")).click();

	    WebElement custId = driver.findElement(By.id("customer_id"));

	    custId.sendKeys("abc");

	    driver.findElement(By.name("submit")).click();

	    try {
	        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

	        String alertText = alert.getText();
	        System.out.println("Alert message: " + alertText);

	        //  Message may vary
	        if (alertText.toLowerCase().contains("correct") ||
	            alertText.toLowerCase().contains("invalid")) {

	            System.out.println(" Validation working for invalid inputs");
	        } else {
	            System.out.println(" Unexpected alert message");
	        }

	        alert.accept();

	    } catch (Exception e) {
	        System.out.println(" No alert present");
	    }
	    driver.navigate().refresh();
	}
	@Test
	
	public void validCustomerIdTest() {

//	    driver.findElement(By.linkText("Telecom Project")).click();
//	    driver.findElement(By.linkText("Pay Billing")).click();

	    //  DEBUG
	    System.out.println("Using Customer ID: " + add_Customer.customerId);

	    driver.findElement(By.id("customer_id"))
        .sendKeys(add_Customer.customerId);

  driver.findElement(By.name("submit")).click();

  try {
      wait.until(ExpectedConditions.alertIsPresent());
      System.out.println(" Alert appeared");
  } catch (Exception e) {
      System.out.println(" Billing successful - Bill displayed");
  }
	}
	

}
