package Telecom_Project;

import java.time.Duration;


import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;

import Baseclass.baseClass;


@Test
public class add_Customer extends baseClass {
	public static String customerId;
    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public add_Customer(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    @Test
    public void verifyOptions() {
        System.out.println("-----verifying options present or not-------");

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Telecom Project"))).click();

        if(driver.findElements(By.linkText("Add Customer")).size() > 0)
            System.out.println("Add Customer is Present");
        else
            System.out.println("Add Customer NOT Present");

        if(driver.findElements(By.linkText("Add Tariff Plan")).size() > 0)
            System.out.println("Add Tariff Plan is Present");

        if(driver.findElements(By.linkText("Add Tariff Plan to Customer")).size() > 0)
            System.out.println("Add Tariff Plan to Customer is Present");

        if(driver.findElements(By.linkText("Pay Billing")).size() > 0)
            System.out.println("Pay Billing is Present");
    }
    @Test
    public void addCustomer() {
        System.out.println("-----Add Customer-------");

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add Customer"))).click();

        WebElement radio = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Done']"))
        );

        radio.click();

        driver.findElement(By.id("fname")).sendKeys("Ananya");
        driver.findElement(By.id("lname")).sendKeys("C");
        driver.findElement(By.id("email")).sendKeys("test@gmail.com");
        driver.findElement(By.name("addr")).sendKeys("Kerala");
        driver.findElement(By.id("telephoneno")).sendKeys("9876543210");

        driver.findElement(By.name("submit")).click();

        String message = driver.findElement(By.tagName("h3")).getText();
        System.out.println("Result: " + message);

        add_Customer.customerId = driver.findElement(
        	    By.xpath("//td[@align='center']/h3")
        	).getText();

        	System.out.println("Stored Customer ID: " + add_Customer.customerId);

        driver.navigate().back();
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/form/div/div[9]/ul/li[2]/input")).click();
        System.out.println("Reset Button is working");
    }
    @Test
    
    public void submitWithoutMandatoryFields() {

        System.out.println("-----Submitting empty form-----");

        driver.findElement(By.name("submit")).click();

        // Wait for validation message OR check page state
        List<WebElement> errors = driver.findElements(
                By.xpath("//*[contains(text(),'must') or contains(text(),'blank') or contains(text(),'required')]")
        );

        if (errors.size() > 0) {
            System.out.println("Validation message shown: " + errors.get(0).getText());
        } else {
            System.out.println("No validation message found");
        }

        System.out.println("Current URL: " + driver.getCurrentUrl());
    }
    public void openAddCustomerPage() {

        driver.get("https://demo.guru99.com/telecom/");

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Telecom Project"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add Customer"))).click();
    }
    public void printAllValidationMessages() {

        List<WebElement> errors = driver.findElements(
                By.xpath("//*[contains(text(),'must') or contains(text(),'required') or contains(text(),'valid') or contains(text(),'blank') or contains(text(),'allowed') ]")
        );

        if (errors.size() > 0) {

            System.out.println("----- Validation Messages -----");

            for (WebElement e : errors) {
                System.out.println("Error: " + e.getText());
            }

        } else {
            System.out.println("No validation messages found");
        }
    }
    @Test
    public void validateAllFieldsWithNegativeData() {

        System.out.println("----- Negative Validation for All Fields -----");

        openAddCustomerPage();

        // --- Fill ALL fields with invalid data ---
        driver.findElement(By.id("fname")).sendKeys("12345");        // invalid
        driver.findElement(By.id("lname")).sendKeys("99999");         // invalid
        driver.findElement(By.id("email")).sendKeys("abc@");         // invalid
        driver.findElement(By.name("addr")).sendKeys("");            // empty
        driver.findElement(By.id("telephoneno")).sendKeys("abc123"); // invalid

        driver.findElement(By.name("submit")).click();
        printAllValidationMessages();

        System.out.println(" All field negative validation completed");
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Telecom Project"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add Customer"))).click();
}}