package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage {
    WebDriver driver;

    public BasketPage(WebDriver driver){
        this.driver = driver;
    }

    public String getProductPrice(){
        return driver.findElement(By.cssSelector("[class*='rd-cart-item-price']")).getText();
    }

    public void clickPlus(){
        driver.findElement(By.cssSelector("[class='oq-up plus']")).click();
    }

    public String getItemQuantity(){
        return driver.findElement(By.cssSelector("[class*='item-quantity-input']")).getAttribute("value");
    }

    public void deleteItem(){
        driver.findElement(By.className("cart-square-link")).click();
        driver.findElement(By.cssSelector("[class*='sc-delete']")).click();
    }

    public boolean isBasketEmpty(){
        String emptyBasketTitle = driver.findElement(By.className("cart-empty-title")).getText();
        return emptyBasketTitle.contains("Sepetinizde ürün bulunmamaktadır.");
    }
}
