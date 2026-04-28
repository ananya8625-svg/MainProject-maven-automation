package Agile_Project;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Practice.ExcelUtility;
import Baseclass.baseClass;

public class agileProject extends baseClass {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    // LOGIN
    public void login() {

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Agile Project"))).click();

        String path = System.getProperty("user.dir") + "/src/test/resources/testdata.xlsx";

        String username = ExcelUtility.getData(path, 1, 0);
        String password = ExcelUtility.getData(path, 1, 1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("uid")));
        driver.findElement(By.name("uid")).sendKeys(username);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("btnReset")).click();
        System.out.println("Reset Done");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("uid")));
        driver.findElement(By.name("uid")).sendKeys(username);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        driver.findElement(By.name("password")).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(By.name("btnLogin"))).click();

        // Validation
        if (driver.getTitle().contains("Guru99")) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Login Failed");
        }
    }

    // MINI STATEMENT
    public void miniStatement() {

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Mini Statement"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("accountno")));
        driver.findElement(By.name("accountno")).sendKeys("12345");
        driver.findElement(By.name("res")).click();
        System.out.println("Reset the field successfully");
        
        driver.findElement(By.name("accountno")).sendKeys("12345");
        driver.findElement(By.name("AccSubmit")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));

        System.out.println("Mini Statement Displayed");

        driver.navigate().back();
    }

    // LOGOUT
    public void logout() {

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Log out"))).click();

        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            System.out.println("No alert");
        }

        System.out.println("Logout Successful");
    }
} 	