package Mainproject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import Baseclass.baseClass;

public class Insurance {

    // ================= COMMON UTIL =================

    public static void removeAds() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) baseClass.driver;

            js.executeScript(
                "document.querySelectorAll('.cb-box__inner-drag, .cb-box__inner-bg, iframe, .overlay, .modal')" +
                ".forEach(el => el.remove());"
            );

            System.out.println("Ads removed");
        } catch (Exception e) {
            System.out.println("No ads found");
        }
    }

    public static void jsClick(WebElement element) {
        ((JavascriptExecutor) baseClass.driver).executeScript("arguments[0].click();", element);
    }

    public static WebElement waitForClickable(By locator) {
        return new WebDriverWait(baseClass.driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement waitForVisible(By locator) {
        return new WebDriverWait(baseClass.driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // ================= REGISTER =================

    public static void Register() {
    	baseClass.driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul/li[3]/a")).click();
        try {
            removeAds();

            jsClick(waitForClickable(By.xpath("/html/body/div[3]/a")));

            new Select(waitForVisible(By.id("user_title"))).selectByVisibleText("Mrs");

            baseClass.driver.findElement(By.id("user_firstname")).sendKeys("Ananya");
            baseClass.driver.findElement(By.id("user_surname")).sendKeys("Vishnu");
            baseClass.driver.findElement(By.id("user_phone")).sendKeys("8606408625");

            new Select(baseClass.driver.findElement(By.id("user_dateofbirth_1i"))).selectByVisibleText("1995");
            new Select(baseClass.driver.findElement(By.id("user_dateofbirth_2i"))).selectByVisibleText("April");
            new Select(baseClass.driver.findElement(By.id("user_dateofbirth_3i"))).selectByVisibleText("19");

            baseClass.driver.findElement(By.id("licencetype_t")).click();

            new Select(baseClass.driver.findElement(By.id("user_licenceperiod"))).selectByVisibleText("5");
            new Select(baseClass.driver.findElement(By.id("user_occupation_id"))).selectByVisibleText("Architect");

            baseClass.driver.findElement(By.id("user_address_attributes_street"))
                    .sendKeys("Kozhikode");
            baseClass.driver.findElement(By.id("user_address_attributes_city"))
                    .sendKeys("Kozhikode");
            baseClass.driver.findElement(By.id("user_address_attributes_county"))
                    .sendKeys("India");
            baseClass.driver.findElement(By.id("user_address_attributes_postcode"))
                    .sendKeys("673525");

            baseClass.driver.findElement(By.id("user_user_detail_attributes_email"))
                    .sendKeys("ananya8625@gmail.com");
            baseClass.driver.findElement(By.id("user_user_detail_attributes_password"))
                    .sendKeys("123");
            baseClass.driver.findElement(By.id("user_user_detail_attributes_password_confirmation"))
                    .sendKeys("123");

            jsClick(waitForClickable(By.xpath("//input[@value='Create']")));

            Thread.sleep(2000);

            if (baseClass.driver.getTitle().contains("Login"))
                System.out.println("Registration Successful");
            else
                System.out.println("Registration Failed");

        } catch (Exception e) {
            System.out.println("Error in registration: " + e.getMessage());
        }
    }

    // ================= LOGIN =================

    public static void Login() {
        try {
        	baseClass.driver.get("https://demo.guru99.com/insurance/v1/index.php");
            removeAds();

            baseClass.driver.findElement(By.id("email")).sendKeys("ananya8625@gmail.com");
            baseClass.driver.findElement(By.id("password")).sendKeys("123");

            jsClick(waitForClickable(By.xpath("//input[@value='Log in']")));

            Thread.sleep(2000);

            if (baseClass.driver.getTitle().contains("Broker"))
                System.out.println("Login Successful");
            else
                System.out.println("Login Failed");

        } catch (Exception e) {
            System.out.println("Error in login: " + e.getMessage());
        }
    }

    // ================= REQUEST QUOTATION =================

    public static void requestQuotation() {
        try {
            removeAds();

            jsClick(waitForClickable(By.xpath("//a[text()='Request Quotation']")));

            removeAds();

            new Select(waitForVisible(By.id("quotation_breakdowncover")))
                    .selectByVisibleText("At home");

            removeAds();

            WebElement windscreen = waitForClickable(By.id("quotation_windscreenrepair_t"));
            jsClick(windscreen);

            baseClass.driver.findElement(By.id("quotation_incidents"))
                    .sendKeys("Accident");
            baseClass.driver.findElement(By.id("quotation_vehicle_attributes_registration"))
                    .sendKeys("KL10AB1234");
            baseClass.driver.findElement(By.id("quotation_vehicle_attributes_mileage"))
                    .sendKeys("20");
            baseClass.driver.findElement(By.id("quotation_vehicle_attributes_value"))
                    .sendKeys("500000");

            new Select(baseClass.driver.findElement(By.id("quotation_vehicle_attributes_parkinglocation")))
                    .selectByVisibleText("Public Place");

            new Select(baseClass.driver.findElement(By.id("quotation_vehicle_attributes_policystart_1i")))
                    .selectByVisibleText("2024");

            new Select(baseClass.driver.findElement(By.id("quotation_vehicle_attributes_policystart_2i")))
                    .selectByVisibleText("April");

            new Select(baseClass.driver.findElement(By.id("quotation_vehicle_attributes_policystart_3i")))
                    .selectByValue("10");

            removeAds();

            jsClick(waitForClickable(By.xpath("//input[@value='Calculate Premium']")));

            WebElement premium = waitForVisible(By.id("calculatedpremium"));
            System.out.println("Premium: " + premium.getText());

            removeAds();

            jsClick(waitForClickable(By.name("submit")));

            System.out.println("Quotation Saved");
         //  GO BACK TO DASHBOARD (IMPORTANT FIX)
            baseClass.driver.navigate().back();

            // Wait until tabs are visible again
            new WebDriverWait(baseClass.driver, Duration.ofSeconds(15))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-2")));

            System.out.println("Returned to dashboard");

        } catch (Exception e) {
            System.out.println("Error in quotation: " + e.getMessage());
        }
    }

    // ================= RETRIEVE =================

    public static void retrieveQuotation() {
        try {
            removeAds();

            jsClick(waitForClickable(By.xpath("//a[text()='Retrieve Quotation']")));

            baseClass.driver.findElement(By.name("id")).sendKeys("60395");

            jsClick(waitForClickable(By.xpath("//input[@value='Retrieve']")));

            WebElement table = waitForVisible(By.tagName("table"));

            List<WebElement> rows = table.findElements(By.tagName("tr"));

            System.out.println("===== QUOTATION =====");
            

            for (WebElement row : rows) {
                System.out.println(row.getText());
            }
         //  GO BACK TO DASHBOARD (VERY IMPORTANT)
            baseClass.driver.navigate().back();

            // Wait until tabs appear again
            new WebDriverWait(baseClass.driver, Duration.ofSeconds(15))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-2")));

            System.out.println("Returned to dashboard after retrieve");

        } catch (Exception e) {
            System.out.println("Error retrieving quotation: " + e.getMessage());
        }
    }

    // ================= EDIT PROFILE =================

    public static void editProfile() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) baseClass.driver;

            //  STEP 1: Remove ads
            removeAds();

            //  STEP 2: Click Edit Profile tab (use ID, not text)
            WebElement editTab = new WebDriverWait(baseClass.driver, Duration.ofSeconds(15))
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("ui-id-5")));

            js.executeScript("arguments[0].click();", editTab);
            System.out.println("Edit Profile tab opened");

            //  STEP 3: Wait for form to load
            new WebDriverWait(baseClass.driver, Duration.ofSeconds(15))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.id("user_firstname")));

            //  STEP 4: Remove ads again (important)
            removeAds();

            // STEP 5: Fill form (clear + send keys)
            WebElement fname = baseClass.driver.findElement(By.id("user_firstname"));
            fname.clear();
            fname.sendKeys("Ananya");

            WebElement lname = baseClass.driver.findElement(By.id("user_surname"));
            lname.clear();
            lname.sendKeys("Vishnu");

            WebElement phone = baseClass.driver.findElement(By.id("user_phone"));
            phone.clear();
            phone.sendKeys("9999999999");
            
            WebElement street=baseClass.driver.findElement(By.xpath("//*[@id=\"user_address_attributes_street\"]"));
            street.clear();
            street.sendKeys("Perambra");
            
            WebElement city=baseClass.driver.findElement(By.xpath("//*[@id=\"user_address_attributes_city\"]"));
            city.clear();
            city.sendKeys("Kozhikode");
            
            WebElement country=baseClass.driver.findElement(By.xpath("//*[@id=\"user_address_attributes_county\"]"));
            country.clear();
            country.sendKeys("India");
            
            WebElement postal=baseClass.driver.findElement(By.xpath("//*[@id=\"user_address_attributes_postcode\"]"));
            postal.clear();
            postal.sendKeys("673525");
            //  STEP 6: Scroll + click UPDATE button safely
         // STEP 6: Click UPDATE button (robust locator)

            WebElement updateBtn = new WebDriverWait(baseClass.driver, Duration.ofSeconds(15))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='submit']")));

            // Scroll to button
            ((JavascriptExecutor) baseClass.driver).executeScript("arguments[0].scrollIntoView(true);", updateBtn);

            Thread.sleep(500);

            // Remove ads again before clicking
            removeAds();

            // JS click (bypass overlay)
            ((JavascriptExecutor) baseClass.driver).executeScript("arguments[0].click();", updateBtn);

            System.out.println("Profile Updated Successfully");
            // STEP 7: Logout
//            removeAds();
//
//            WebElement logoutBtn = new WebDriverWait(baseClass.driver, Duration.ofSeconds(15))
//                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Log out']")));
//
//            js.executeScript("arguments[0].scrollIntoView(true);", logoutBtn);
//            Thread.sleep(500);
//
//            js.executeScript("arguments[0].click();", logoutBtn);
//
//            System.out.println("Logout Successful");

        } catch (Exception e) {
            System.out.println("Error in profile: " + e.getMessage());
        }
    }}