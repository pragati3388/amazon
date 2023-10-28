package testRunner;

import org.testng.annotations.Test;
import pages.ProductCartPage;
import setUp.BaseSetUp;

public class ProductCartTestRunner extends BaseSetUp {
    ProductCartPage cartPage;
    @Test
    public void verifyingCartWithoutItem(){
        cartPage =new ProductCartPage(driver);
        cartPage.verifyingCartWithoutItem();
    }

    @Test
    public void verifyingCartWithItem(){
        cartPage =new ProductCartPage(driver);
        cartPage.verifyingCartWithItem();
    }

    @Test
    public void increaseQuantityInCart(){
        cartPage =new ProductCartPage(driver);
        cartPage.verifyingCartWithoutItem();
        cartPage =new ProductCartPage(driver);
        cartPage.verifyingCartWithItem();
        cartPage =new ProductCartPage(driver);
        cartPage.increaseQuantityInCart();
    }


    @Test
    public void deleteButtonForCart(){
        cartPage =new ProductCartPage(driver);
        cartPage.verifyingCartWithoutItem();
        cartPage =new ProductCartPage(driver);
        cartPage.verifyingCartWithItem();
        cartPage =new ProductCartPage(driver);
        cartPage.increaseQuantityInCart();
        cartPage =new ProductCartPage(driver);
        cartPage.deleteButtonForCart();
        cartPage =new ProductCartPage(driver);
        cartPage.verifyCartIsEmpty();
    }
}
