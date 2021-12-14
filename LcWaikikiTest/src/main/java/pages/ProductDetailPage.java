package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage {
    WebDriver driver;

    public ProductDetailPage(WebDriver driver){
        this.driver = driver;
    }

    public String getPrice(){
       return driver.findElement(By.xpath("//*[@class='row']//*[@class='price']")).getText();
    }

    public void clickAddBasket(){
        driver.findElement(By.cssSelector("[data-tracking-label='BedenSecenekleri']")).click();
        driver.findElement(By.id("pd_add_to_cart")).click();
    }
}
