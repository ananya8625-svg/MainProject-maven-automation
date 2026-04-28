package Bank_Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Baseclass.baseClass;

public class bankLogin extends baseClass {
	 
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	 @Test
	    public void loginTest() {
		 wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Bank Project"))).click();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("uid")));
	     driver.findElement(By.name("uid")).sendKeys("mngr657275");
	     
	     wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
	     driver.findElement(By.name("password")).sendKeys("zabAbUd");
	     wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	     driver.findElement(By.name("btnReset")).click();
	        System.out.println("Reset Done");
	        
	        driver.findElement(By.name("uid")).sendKeys("mngr657275");
	        driver.findElement(By.name("password")).sendKeys("zabAbUd");

	        wait.until(ExpectedConditions.elementToBeClickable(By.name("btnLogin"))).click();
	        
	        if (driver.getTitle().contains("Bank Manager")) {
	            System.out.println("Login Successful");
	        } else {
	            System.out.println("Login Failed");
	        }
	    }
	}
