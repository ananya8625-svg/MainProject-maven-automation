package Baseclass;

import java.time.Duration;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class baseClass {

	public static ChromeDriver driver;
	public static WebDriverWait wait;
	

	@BeforeClass
    public static void setup() {
    	ChromeOptions options=new ChromeOptions();
    	Map<String, Object> prefs=new HashMap<>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-infobars");
		options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/");
       
       
        //driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul/li[3]/a")).click();
      
    }
	public void handleAlertIfPresent() {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert: " + alert.getText());
            alert.accept();
        } catch (Exception e) {
            // No alert
        }
    }
	
	public void safeClick(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].scrollIntoView(true);", element);

            element.click();

        } catch (Exception e) {
            System.out.println("Normal click failed  using JS click");

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", element);
        }}

	 @AfterClass
    public static void close() {
       //driver.quit();
    }
}