package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class SearchResultPage {
    WebDriver driver;
    Actions actions;

    public SearchResultPage(WebDriver driver){
        this.driver = driver;
        actions = new Actions(driver);
    }

    public void clickMoreProduct(){
        actions.moveToElement(driver.findElement(By.className("lazy-load-button"))).build().perform();
        driver.findElement(By.className("lazy-load-button")).click();
    }

    public ProductDetailPage clickProduct(){
        driver.findElement(By.cssSelector("[data-tracking-label='Ürünüİncele']")).click();
        return new ProductDetailPage(driver);
    }
}
