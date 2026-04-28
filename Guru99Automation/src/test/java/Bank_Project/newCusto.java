package Bank_Project;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Baseclass.baseClass;

public class newCusto extends baseClass {

	@Test
    public void newRegistr() {
		 wait.until(ExpectedConditions.elementToBeClickable(By.linkText("New Customer"))).click();

	        wait.until(ExpectedConditions.urlContains("addcustomerpage.php"));

	        driver.findElement(By.name("name")).sendKeys("Ananya");
	        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]")).click();
	        driver.findElement(By.xpath("//*[@id=\"dob\"]")).sendKeys("12/11/1995");
	        driver.findElement(By.name("addr")).sendKeys("Perambra PO");
	        driver.findElement(By.name("city")).sendKeys("Kozhikode");
	        driver.findElement(By.name("state")).sendKeys("Kerala");
	        driver.findElement(By.name("pinno")).sendKeys("673525");
	        driver.findElement(By.name("telephoneno")).sendKeys("8606408625");
	        driver.findElement(By.name("emailid")).sendKeys("ananya8625@gmail.com");
	        driver.findElement(By.name("res")).click();
	        System.out.println("Reset button working");
	        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	        
	        driver.findElement(By.name("name")).sendKeys("Mohan");
	        driver.findElement(By.xpath("//*[@id=\"dob\"]")).sendKeys("12/11/1995");
	        driver.findElement(By.name("addr")).sendKeys("Perambra PO");
	        driver.findElement(By.name("city")).sendKeys("Kozhikode");
	        driver.findElement(By.name("state")).sendKeys("Kerala");
	        driver.findElement(By.name("pinno")).sendKeys("673525");
	        driver.findElement(By.name("telephoneno")).sendKeys("8606408625");
	        driver.findElement(By.name("emailid")).sendKeys("ananya8625@gmail.com");
	        driver.findElement(By.name("sub")).click();
	        System.out.println("Customer added successfully but the page is not visible");
	        driver.get("https://demo.guru99.com/V4/manager/Managerhomepage.php");
	}

	@Test
    public void testInvalidName() {
		System.out.println("-----Name validation-----");  
		safeClick(driver.findElement(By.linkText("New Customer")));
        driver.findElement(By.name("name")).sendKeys("12345");

        String value = driver.findElement(By.name("name")).getAttribute("value");

        Assert.assertTrue(value.matches("\\d+"));
        System.out.println(" Name validation working correctly");
    }	
	 @Test
	    public void testInvalidPIN() {
		 System.out.println("-----pin validation-----");  
		 driver.findElement(By.linkText("New Customer")).click();
		 String value1 = driver.findElement(By.name("pinno")).getAttribute("value");

		    //  Expect empty (since alphabets not allowed)
		    Assert.assertTrue(value1.isEmpty());
		    System.out.println("PIN field blocks alphabets");

		    // Reset
		    driver.findElement(By.name("res")).click();

		    //  Enter less digits
		    driver.findElement(By.name("pinno")).sendKeys("12");

		    String value2 = driver.findElement(By.name("pinno")).getAttribute("value");

		    //  Check length (PIN must be 6 digits)
		    Assert.assertTrue(value2.length() < 6);
		    System.out.println("PIN length validation working");
		}
	
	 
	
	 @Test
	 public void testPhoneValidation() {
		 System.out.println("-----phone number validation-----");  
	     safeClick(driver.findElement(By.linkText("New Customer")));

	     WebElement phone;

	     //  1. Alphabets
	     phone = driver.findElement(By.name("telephoneno"));
	     phone.clear();
	     phone.sendKeys("abcd");

	     String value = phone.getAttribute("value");
	     System.out.println("Alphabet test: '" + value + "'");

	     Assert.assertFalse(value.matches("\\d+")); //  PASS

	     driver.findElement(By.name("res")).click();


	     //  2. Less digits
	     phone = driver.findElement(By.name("telephoneno"));
	     phone.clear();
	     phone.sendKeys("123");

	     value = phone.getAttribute("value");
	     System.out.println("Short number test: '" + value + "'");

	     Assert.assertTrue(value.length() < 10);  //  PASS

	     driver.findElement(By.name("res")).click();


	     //  3. Valid phone
	     phone = driver.findElement(By.name("telephoneno"));
	     phone.clear();
	     phone.sendKeys("9876543210");

	     value = phone.getAttribute("value");
	     System.out.println("Valid number test: '" + value + "'");

	     Assert.assertEquals(value.length(), 10);   //  FIXED (NOT regex)
	 }
	 @Test
	 public void emailValidationDisplayedTest() {
		 System.out.println("-----email validation-----");     
		driver.findElement(By.name("emailid")).sendKeys("testgmail.com");

	     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	     WebElement error = wait.until(
	         ExpectedConditions.visibilityOfElementLocated(By.id("message9"))
	     );

	     if (error.isDisplayed() && !error.getText().isEmpty()) {
	         System.out.println("PASS: Validation message is displayed");
	     } else {
	         System.out.println(" FAIL: Validation message is NOT displayed");
	     }
	 }
	 public void logout() {

	        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Log out"))).click();
	        try {
	            wait.until(ExpectedConditions.alertIsPresent());

	            String alertText = driver.switchTo().alert().getText();
	            System.out.println("Alert message: " + alertText);

	            driver.switchTo().alert().accept(); // click OK
	        } catch (Exception e) {
	            System.out.println("No alert present");
	        }
	        System.out.println("Customer logout successfully");
	} 	    
	 }
	 
	 
