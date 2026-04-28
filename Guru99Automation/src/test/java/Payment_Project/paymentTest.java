package Payment_Project;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Baseclass.baseClass;

public class paymentTest extends baseClass {
  @Test
  public void menuCheck() {
	  System.out.println("------checking all options present or not---------");	
	  	driver.findElement(By.linkText("Payment Gateway Project")).click();      
	  	 String actualTitle = driver.getTitle();
	        Assert.assertTrue(actualTitle.contains("Payment Gateway"));
	        System.out.println("Title Verified");
	  	    // Step 2: Verify "Generate Card Number"
	  	
	        WebElement generateCard = driver.findElement(By.linkText("Generate Card Number"));
	        Assert.assertTrue(generateCard.isDisplayed(), "Generate Card Number NOT displayed");

	        // Step 3: Verify "Check Credit Card Limit"
	        WebElement checkLimit = driver.findElement(By.linkText("Check Credit Card Limit"));
	        Assert.assertTrue(checkLimit.isDisplayed(), "Check Credit Card Limit NOT displayed");

	        // Step 4: Verify "Buy Now" button (Payment section)
	        WebElement buyNow = driver.findElement(By.xpath("//input[@value='Buy Now']"));
	        Assert.assertTrue(buyNow.isDisplayed(), "Buy Now button NOT displayed");

	        System.out.println("All navbar options are displayed successfully ");   
	    }
  @Test
  public void generateCard() {
	  System.out.println("------Generate card number---------");	  
	  driver.findElement(By.linkText("Generate Card Number")).click();
	// Get all window handles
	  Set<String> windows = driver.getWindowHandles();

	  // Switch to new window
	  for (String win : windows) {
	      driver.switchTo().window(win);
	  }
	// Card Number
	  String cardNumber = wait.until(
			    ExpectedConditions.visibilityOfElementLocated(
			        By.xpath("(//h4[@style])[1]")
			    )
			).getText();

			String cvv = driver.findElement(By.xpath("(//h4[@style])[2]")).getText();
			String expiry = driver.findElement(By.xpath("(//h4[@style])[3]")).getText();

			System.out.println( cardNumber);
			System.out.println( cvv);
			System.out.println(expiry);
			driver.findElement(By.linkText("Cart")).click();
  }
  public void creditCard() {
		 System.out.println("-----Credit card-------");	
		 driver.findElement(By.linkText("Check Credit Card Limit")).click();
		 driver.findElement(By.xpath("//*[@id=\"card_nmuber\"]")).sendKeys("5874123698542578");
		 driver.findElement(By.xpath("//*[@id=\"three\"]/div/form/div/div[6]/input")).click();
		 System.out.println("Credit card details shown");
		 driver.findElement(By.xpath("//*[@id=\"three\"]/div/ul/li/a")).click();
  }
  @Test
  public void verifyDropdownClickable() throws Exception {
	  System.out.println("------Cart--------");
      // Handle popup (if present)
      try {
          WebElement popup = driver.findElement(By.xpath("//input[@type='email']"));
          if (popup.isDisplayed()) {
              popup.sendKeys(Keys.ESCAPE);
              System.out.println("Popup closed");
          }
      } catch (Exception e) {
          System.out.println("No popup present");
      }

      // Dropdown
      WebElement dropdown = wait.until(
              ExpectedConditions.elementToBeClickable(By.name("quantity"))
      );

      Assert.assertTrue(dropdown.isDisplayed());
      Assert.assertTrue(dropdown.isEnabled());

      Select select = new Select(dropdown);

      // Validate dropdown values
      List<String> expected = Arrays.asList("1","2","3","4","5","6","7","8","9");
      List<String> actual = new ArrayList<>();

      for (WebElement option : select.getOptions()) {
          actual.add(option.getText());
      }

      Assert.assertEquals(actual, expected);

      // Select quantity
      select.selectByVisibleText("3");
      int quantity = Integer.parseInt(select.getFirstSelectedOption().getText());
      System.out.println("Selected Quantity: " + quantity);

      // Get price
      String priceText = driver.findElement(By.xpath("//h3")).getText();
      int price = Integer.parseInt(priceText.replaceAll("[^0-9]", ""));
      System.out.println("Price per item: " + price);

      // Click Buy Now
      WebElement buyNowBtn = wait.until(
              ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Buy Now']"))
      );

      ((JavascriptExecutor) driver)
              .executeScript("arguments[0].scrollIntoView(true);", buyNowBtn);

      Thread.sleep(1000);

      try {
          buyNowBtn.click();
      } catch (Exception e) {
          ((JavascriptExecutor) driver)
                  .executeScript("arguments[0].click();", buyNowBtn);
      }

      System.out.println("Buy Now button clicked");

      // Wait for navigation
      wait.until(ExpectedConditions.urlContains("process_purchasetoy"));
      System.out.println("Navigated to payment page");
      WebElement paymentAmount = driver.findElement(By.xpath("//*[@id=\"three\"]/div/form/div[1]/div/font[2]"));

      // Get and print price
      String priceText1 = paymentAmount.getText();
      System.out.println("Price is: " + priceText1);
     
    }
  public void paymentPage() {
	  System.out.println("--------payment page--------");
	  driver.findElement(By.name("card_nmuber")).sendKeys("4111111111111111");
      driver.findElement(By.name("month")).sendKeys("12");
      driver.findElement(By.name("year")).sendKeys("2028");
      driver.findElement(By.name("cvv_code")).sendKeys("123");

      // Step 9: Click Pay
      driver.findElement(By.name("submit")).click();
      WebElement successMsg = wait.until(
              ExpectedConditions.visibilityOfElementLocated(
                  By.xpath("//h2[contains(text(),'Payment successfull')]"))
          );
      String message = successMsg.getText();
      System.out.println("Message: " + message);

      Assert.assertTrue(message.contains("Payment successfull"));
      String text = driver.findElement(By.tagName("body")).getText();

      String orderId = text.replaceAll("[^0-9]", ""); // keeps only numbers

      System.out.println("Order ID = " + orderId);
      //System.out.println(pageText);
      System.out.println("Payment page worked successfully ");
      driver.findElement(By.xpath("//*[@id=\"three\"]/div/div/ul/li/a")).click();
  
  }
  @Test
  public void validateEmptyFieldMessage() {

      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

      System.out.println("----- EMPTY FIELD VALIDATION STARTED -----");

      // Step 1: Click Pay/Submit without entering data
      driver.findElement(By.xpath("//*[@id=\"three\"]/div/form/div/div[8]/ul/li/input")).click();
      driver.findElement(By.name("submit")).click();
      
      WebElement monthDropdown = driver.findElement(By.name("month"));

      // Step 3: Get HTML5 validation message using JavaScript
      JavascriptExecutor js = (JavascriptExecutor) driver;

      String message = (String) js.executeScript(
              "return arguments[0].validationMessage;",
              monthDropdown
      );

      // Step 4: Print message
      System.out.println("Validation Message: " + message);

      // Step 5: Verify message
      Assert.assertTrue(message.contains("select") || message.contains("item"),
              "Validation message not displayed properly");

      System.out.println("Empty field validation successfull");
      
      }
  @Test
  public void validateCardNumber() {
	  System.out.println("----- CARD NUMBER VALIDATION  -----");
	  WebElement card = driver.findElement(By.id("card_nmuber"));
      card.sendKeys("12345678");   // 8 digits only

      // Expiry month/year
      driver.findElement(By.id("month")).sendKeys("12");
      driver.findElement(By.id("year")).sendKeys("2028");

      // CVV
      driver.findElement(By.id("cvv_code")).sendKeys("123");

      // Click Pay
      driver.findElement(By.name("submit")).click();

      // Validation check (depends on UI behavior)
      Alert alert = driver.switchTo().alert();
      String text = alert.getText();

      System.out.println(text);

      Assert.assertTrue(text.contains("16 digits"));

      alert.accept();
      System.out.println("Validation is working for card number");
      driver.navigate().back();
  
  }
  @Test
  
  
  public void validateInvalidCVV() {

      System.out.println("-------checking CVV number-------");

      driver.get("https://demo.guru99.com/payment-gateway/index.php");

      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

      // Step 1: Select quantity
      WebElement quantity = wait.until(
              ExpectedConditions.visibilityOfElementLocated(By.name("quantity"))
      );
      new Select(quantity).selectByVisibleText("1");

      // Step 2: Click Buy Now (Cart page)
      WebElement buyNow = wait.until(
              ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Buy Now']"))
      );
      buyNow.click();

      // Step 3: Wait for Payment Page
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("card_nmuber")));

      // Step 4: Enter details
      driver.findElement(By.name("card_nmuber")).sendKeys("4111111111111111");
      new Select(driver.findElement(By.name("month"))).selectByVisibleText("12");
      new Select(driver.findElement(By.name("year"))).selectByVisibleText("2028");

      //  Invalid CVV (less than 3 digits)
      driver.findElement(By.name("cvv_code")).sendKeys("12");

      driver.findElement(By.name("submit")).click();

      // Step 5: Validate result
      try {
          Alert alert = wait.until(ExpectedConditions.alertIsPresent());
          System.out.println("Validation working: " + alert.getText());
          alert.accept();
      } catch (Exception e) {
          System.out.println("BUG: CVV < 3 digits accepted");
      }

      System.out.println("Test completed successfully");
  }

//	 
 }
  
  

      
  
    

     
  

  
