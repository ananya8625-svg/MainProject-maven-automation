package Mainproject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class ProfilePage {

    WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void logout() {

        WebElement logout = driver.findElement(By.xpath("//input[@value='Log out']"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", logout);

        System.out.println("Logged out");
    }
}