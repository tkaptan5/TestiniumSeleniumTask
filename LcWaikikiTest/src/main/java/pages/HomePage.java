package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public boolean goToHomePage(){
        driver.get("https://www.lcwaikiki.com/tr-TR/TR");
        return driver.findElement(By.className("main-header-logo")).isDisplayed();
    }

    public LoginPage goToLoginPage(){
        driver.findElement(By.cssSelector("a[href*='giris']")).click();
        return new LoginPage(driver);
    }

    public boolean isLoggedIn(){
        String text = driver.findElement(By.className("dropdown-label")).getText();
        return text.equals("Hesabım");
    }

    public SearchResultPage search(String text){
        driver.findElement(By.id("search_input")).sendKeys(text, Keys.ENTER);
        return new SearchResultPage(driver);
    }

    public BasketPage goToBasket(){
        driver.findElement(By.cssSelector("[data-tracking-label='Sepetim']")).click();
        return new BasketPage(driver);
    }
}
