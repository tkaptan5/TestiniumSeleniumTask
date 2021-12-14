package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public HomePage login(String userName, String password){
        driver.findElement(By.id("LoginEmail")).sendKeys(userName);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("loginLink")).click();
        return new HomePage(driver);
    }
}
