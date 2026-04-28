package Mainproject;

import java.sql.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import Baseclass.baseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Selenium  extends baseClass {
	//WebDriver driver;


//	public void setup() {
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://demo.guru99.com/test/newtours/");
//	}

	
	public void testDropdown() throws InterruptedException {
		 WebDriver driver = baseClass.driver;
		System.out.println("---------Radio and check box demo----------");
		driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[1]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Radio & Checkbox Demo")).click();
		Thread.sleep(2000);
		//Validate URL
		String currentUrl1 = driver.getCurrentUrl();
		System.out.println(currentUrl1);
		Assert.assertTrue(currentUrl1.contains("radio"));
		driver.findElement(By.id("vfb-7-2")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("vfb-6-2")).click();
		System.out.println("Radio button worked successfully");
		driver.navigate().back();
		
		System.out.println("---------Accessing Link----------");
		driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[1]/a")).click(); 
		Thread.sleep(2000);
		driver.findElement(By.linkText("Accessing Link")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/a[1]")).click();
		String currentUrl2 = driver.getCurrentUrl();
		System.out.println(currentUrl2);
		Assert.assertTrue(currentUrl2.contains("google"));
		driver.navigate().back();
		driver.findElement(By.xpath("/html/body/a[2]")).click();
		String currentUrl3 = driver.getCurrentUrl();
		System.out.println(currentUrl3);
		Assert.assertTrue(currentUrl3.contains("facebook"));
		System.out.println("Accessing link worked successfully");
		driver.navigate().back();
		
		System.out.println("---------Ajax Demo----------");
		driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[1]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Ajax Demo")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("yes")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("buttoncheck")).click();
		driver.findElement(By.xpath("/html/body/div[2]/form/p[2]/input[1]")).click();
		driver.findElement(By.id("no")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("buttoncheck")).click();
		System.out.println("Ajax worked successfully");


		System.out.println("---------Inside & Outside Block Level Tag----------");
		driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[1]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Inside & Outside Block Level Tag")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/p[1]/a")).click();
		String currentUrl4 = driver.getCurrentUrl();
		System.out.println(currentUrl4);
		Assert.assertTrue(currentUrl4.contains("google"));
		driver.navigate().back();
		driver.findElement(By.xpath("/html/body/a/div/span")).click();
		String currentUrl5 = driver.getCurrentUrl();
		System.out.println(currentUrl5);
		Assert.assertTrue(currentUrl5.contains("facebook"));
		System.out.println("Inside and outside worked successfully");
		driver.navigate().back();
		
		System.out.println("---------Delete Customer Form----------");
		driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[1]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Delete Customer Form")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys("Ananya");
		driver.findElement(By.name("submit")).click();
		Alert a = driver.switchTo().alert();
		String s = a.getText();
		System.out.println(s);
		Thread.sleep(2000);
		a.accept();
		Alert b = driver.switchTo().alert();
		String s1 = b.getText();
		System.out.println(s1);
		Thread.sleep(2000);
		b.accept();
		Thread.sleep(2000);
		System.out.println("Deleted");
//////			 // cancel
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys("Malu");
		driver.findElement(By.name("submit")).click();
		Alert a1 = driver.switchTo().alert();
		String s2 = a1.getText();
		System.out.println(s2);
		Thread.sleep(2000);
		a1.dismiss();
		System.out.println("Delete option cancelled");
//////			//Reset
		driver.findElement(By.name("res")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		driver.navigate().back();
		System.out.println("reseted");
//////			
//////	    //6th option selection
		driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[1]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Yahoo")).click();
		Thread.sleep(2000);
		driver.navigate().back();
////
////	    //7th option selection
		driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[1]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Tooltip")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("download_now")).click();
		driver.navigate().back();

		// 8th option selection File upload
		driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[1]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("File Upload")).click();
		driver.findElement(By.id("uploadfile_0")).sendKeys("C:\\Users\\user\\Downloads\\SQL Scenario1.docx");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("submitbutton")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement res1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("res")));
		System.out.println("Case 1: " + res1.getText());
////		//without clicking terms and condition
			driver.navigate().refresh();
			driver.findElement(By.id("uploadfile_0")).sendKeys("C:\\Users\\user\\Downloads\\SQL Scenario1.docx");
			driver.findElement(By.id("submitbutton")).click();
			WebElement res2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("res")));
			System.out.println("Case 2: " + res2.getText());
////		//Without uploading file
			driver.navigate().refresh();
			driver.findElement(By.id("submitbutton")).click();
			WebElement res3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("res")));
			System.out.println("Case 3: " + res3.getText());
	
		//9th option Login
		driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[1]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("email")).sendKeys("ananya8625@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("123");
		driver.findElement(By.id("SubmitLogin")).click();
			
		//Social Icon
		driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[1]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Social Icon")).click();
		driver.findElement(By.xpath("//*[@id=\"page\"]/div[2]/div/a[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"weekly-update\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("ananya8625@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"submitBtn\"]")).click();
		System.out.println("Thank you for subscribing");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("ananya8625@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("ananya8625@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"submitBtn\"]")).click();
		System.out.println("Social Icon closed");
		driver.navigate().back();
		 
//		Selenium Auto IT
		 WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
//
		 WebElement element = wait4.until(ExpectedConditions.elementToBeClickable(
		     By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[1]/a")
		 ));

		 element.click();
		 driver.findElement(By.linkText("Selenium Auto IT")).click();
		 System.out.println("------------Verifying Nav bar menus-----------");
		 try {
//	            // Verify Home
	            WebElement home = driver.findElement(By.xpath("//a[normalize-space()='Home']"));
	            System.out.println("Home displayed: " + home.isDisplayed());
//
//	            // Verify Testing
	            WebElement testing = driver.findElement(By.xpath("//a[normalize-space()='Testing']"));
	            System.out.println("Testing displayed: " + testing.isDisplayed());
	            
	            WebElement sap = driver.findElement(By.xpath("//a[normalize-space()='SAP']"));
	            System.out.println("SAP displayed: " + sap.isDisplayed());

	            // Verify Web
	            WebElement web = driver.findElement(By.xpath("//a[normalize-space()='Web']"));
	            System.out.println("Web displayed: " + web.isDisplayed());
////
//	            // Verify Must Learn
	            WebElement mustLearn = driver.findElement(By.xpath("//a[contains(normalize-space(),'Must Learn!')]"));
	            System.out.println("Must Learn displayed: " + mustLearn.isDisplayed());
//	            
//	            // Verify Must Learn
	            WebElement liveProject = driver.findElement(By.xpath("//a[contains(normalize-space(),'Live Projects')]"));
	            System.out.println("Live project displayed: " + liveProject.isDisplayed());
//	            
	            WebElement bigdata = driver.findElement(By.xpath("//a[contains(normalize-space(),'Big Data')]"));
	            System.out.println("Bidg data displayed: " + bigdata.isDisplayed());
	            
	            WebElement blog = driver.findElement(By.xpath("//a[contains(normalize-space(),'Blog')]"));
	            System.out.println("Blog displayed: " + blog.isDisplayed());
////	            
//
	        } catch (Exception e) {
	            System.out.println("Element not found: " + e.getMessage());
	        }
		 
		 driver.findElement(By.id("getjob")).click();
		 System.out.println("----------Form Filling-----------");
		 driver.findElement(By.xpath("//*[@id=\"input_3\"]")).sendKeys("Ananya");
		 driver.findElement(By.xpath("//*[@id=\"input_4\"]")).sendKeys("ananya8625@gmail.com");
		 driver.findElement(By.xpath("//*[@id=\"input_5\"]")).sendKeys("Automation");
		 driver.findElement(By.xpath("//*[@id=\"input_6\"]")).sendKeys("Selenium");
		 WebElement checkbox = driver.findElement(By.name("q7_clickTo7[]"));

		// scroll to element (important)
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);

		// click using JS (bypass overlay)
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
		 driver.findElement(By.id("input_8")).sendKeys("C:\\Users\\user\\Downloads\\vishnuCV-1 (3).pdf");
		 WebElement submitBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		 this.safeClick(submitBtn);
		 driver.switchTo().defaultContent();
////
		 WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		 wait1.until(ExpectedConditions.titleContains("Thank"));
		String title=driver.getTitle();
		
		 System.out.println("Page Title is: " + title);

		 if (title.contains("Thank")) {
			    System.out.println("Form submitted successfully, Thank you Page displayed");
			}
		 else {
			 System.out.println("No page found");
		 }
		 driver.navigate().back();
       //Scroller bar
		
		 WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		 By menuLocator = By.xpath("//*[@id='navbar-brand-centered']/ul/li[1]/a");
		 WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(menuLocator));
		// element1.click();
		 String menuText = element1.getText();
		 element1.click();
		 driver.findElement(By.linkText("Scrollbar Demo")).click();
		 System.out.println("----------Scroll bar----------");
		// WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		 JavascriptExecutor js = (JavascriptExecutor) driver;

		 js.executeScript("window.scrollBy(0,1000)");

		// Re-locate element
		WebElement vb = wait.until(ExpectedConditions.elementToBeClickable(
		    By.linkText("VBScript")
		));

		// Use element
		//System.out.println("Text: " + vb.getText());
		vb.click();
//				// Validate
////		String text = element1.getText();
////		element1.click();
//
		System.out.println("Clicked: " + menuText);
		System.out.println("Scroll bar page completed");
		//System.out.println("Scroll bar page completed");
		wait.until(ExpectedConditions.titleContains("VBScript"));
		String title1=driver.getTitle();
		
		 //System.out.println("Page Title is: " + title);

		 if (title.contains("VBScript")) {
			    System.out.println("Scrolled and clicked successfully");
			}
		 else {
			 System.out.println("No page found");
		 }
		 driver.navigate().back(); 
		System.out.println("------------File upload menu-----------");
		 WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
//		 //
		 		 WebElement element2 = wait3.until(ExpectedConditions.elementToBeClickable(
		 		     By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[1]/a")
		 		 ));

		 		 element2.click();
		 		 driver.findElement(By.linkText("File Upload using Sikuli Demo")).click();
		 		 //System.out.println("------------Verifying Nav bar menus-----------");
		 		driver.findElement(By.id("photoimg")).sendKeys("C:\\Users\\user\\Downloads\\SQL Scenario1.docx");
		 		try {
		 		    WebElement msg = wait.until(
		 		        ExpectedConditions.visibilityOfElementLocated(
		 		            By.xpath("//*[contains(text(),'File Upload Successful')]")
		 		        )
		 		    );

		 		    System.out.println(" File uploaded successfully");

		 		} catch (Exception e) {
		 		    System.out.println(" File upload failed");
		 		}
		 		driver.navigate().back();
		 		System.out.println("------------Drag and Drop----------");

		 	// Create Actions object 
		 	Actions action = new Actions(driver);

		 	// Click menu
		 	WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(
		 	    By.xpath("//*[@id='navbar-brand-centered']/ul/li[1]/a")
		 	));
		 	menu.click();
//
		 	// Navigate to Drag & Drop page
		 	driver.findElement(By.linkText("Drag and Drop Action")).click();

		 	// Wait for elements
		 	WebElement bank = wait.until(ExpectedConditions.visibilityOfElementLocated(
		 	    By.xpath("//*[@id='credit2']/a")
		 	));
		 	WebElement debitAccount = driver.findElement(By.xpath("//*[@id='bank']/li"));

		 	action.dragAndDrop(bank, debitAccount).perform();

		 	// SALES  Credit
		 	WebElement sales = driver.findElement(By.xpath("//*[@id='credit1']/a"));
		 	WebElement creditAccount = driver.findElement(By.xpath("//*[@id='loan']/li"));

		 	action.dragAndDrop(sales, creditAccount).perform();
//
		 	// 500  Debit
		 	WebElement amount1 = driver.findElement(By.xpath("//*[@id='fourth']/a"));
		 	WebElement debitAmount = driver.findElement(By.xpath("//*[@id='amt7']/li"));

		 	action.dragAndDrop(amount1, debitAmount).perform();

		 	// 500  Credit
		 	WebElement amount2 = driver.findElement(By.xpath("//*[@id='fourth']/a"));
		 	WebElement creditAmount = driver.findElement(By.xpath("//*[@id='amt8']/li"));

		 	action.dragAndDrop(amount2, creditAmount).perform();


		 	//  Verify "Perfect!"
		 	WebElement message = wait.until(
		 	    ExpectedConditions.visibilityOfElementLocated(
		 	        By.xpath("//a[contains(text(),'Perfect')]")
		 	    )
		 	);

		 	String text = message.getText();
		 	System.out.println("Message: " + text);
//
		 	Assert.assertEquals(text, "Perfect!");

		 	System.out.println(" Drag and Drop successful");
		 	
		 	driver.navigate().back();
	 		System.out.println("------------Selenium DatePicker Demo----------");
	 		WebElement menu1 = wait.until(ExpectedConditions.elementToBeClickable(
			 	    By.xpath("//*[@id='navbar-brand-centered']/ul/li[1]/a")
			 	));
			 	menu1.click();

			 	// Navigate to Drag & Drop page
			 	driver.findElement(By.linkText("Selenium DatePicker Demo")).click();
			 	WebElement input = driver.findElement(By.name("bdaytime"));
			 	 

			        //  JavaScript to set date + time
//			        
			        js.executeScript("arguments[0].value='1995-04-19T20:10';", input);

			        // Submit
			        driver.findElement(By.xpath("//input[@type='submit']")).click();

			        // Wait for result
			        WebElement body = wait.until(ExpectedConditions.visibilityOfElementLocated(
			                By.tagName("body")));

			        // Print result
			        String text1 = body.getText();

			     //  Extract only required lines
			     String[] lines = text1.split("\n");

			     for (String line : lines) {
			         if (line.contains("Your Birth Date") || line.contains("Your Birth Time")) {
			             System.out.println(line);
			         }
			     }

			 	
//	@AfterMethod
//	public void close() {
//		driver.quit();
//	}

}}
	