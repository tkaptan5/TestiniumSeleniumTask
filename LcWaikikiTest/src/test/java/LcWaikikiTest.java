import org.junit.Assert;
import org.junit.Test;
import pages.*;

public class LcWaikikiTest extends BaseTest{

    @Test
    public void lcwHappyPath(){
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.goToHomePage());
        LoginPage loginPage = homePage.goToLoginPage();
        homePage = loginPage.login("test@test.com","123123");
        Assert.assertTrue(homePage.isLoggedIn());
        SearchResultPage searchResultPage = homePage.search("pantolon");
        searchResultPage.clickMoreProduct();
        ProductDetailPage productDetailPage = searchResultPage.clickProduct();
        String productDetailPrice = productDetailPage.getPrice();
        productDetailPage.clickAddBasket();
        BasketPage basketPage = homePage.goToBasket();
        String productBasketPrice = basketPage.getProductPrice();
        Assert.assertEquals(productDetailPrice,productBasketPrice);
        basketPage.clickPlus();
        String quantity = basketPage.getItemQuantity();
        Assert.assertEquals("2", quantity);
        basketPage.deleteItem();
        Assert.assertTrue(basketPage.isBasketEmpty());
    }
}
