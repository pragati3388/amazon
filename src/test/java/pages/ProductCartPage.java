package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import setUp.BaseSetUp;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import static setUp.BaseSetUp.*;

public class ProductCartPage {
    public ProductCartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "nav-cart")
    WebElement cartViewLink;

    @FindBy(xpath = "(//h2[normalize-space()='Your Amazon Cart is empty'])[1]")
    WebElement emptyCartConfirmation;

    @FindBy(id = "twotabsearchtextbox")
    WebElement searchFieldBox;

    @FindBy(id = "nav-search-submit-button")
    WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"search\"]/span[2]/div/h1/div/div[1]/div/div/span[3]")
    WebElement searchElementConfirmation;

    @FindBy(xpath = "//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[18]/div/div/div/div/div[2]/div[2]/h2/a/span")
    WebElement itemAddToCart;

    @FindBy(id = "add-to-cart-button")
    WebElement addToCartButton;

    @FindBy(xpath = "//div[@class='a-row']/h1")
    WebElement shoppingCartText;
    @FindBy(id = "quantity")
    WebElement quantityButton;

    @FindBy(id = "sc-subtotal-label-activecart")
    WebElement quantityConfirmation;

    @FindBy(xpath = "//input[@value='Delete']")
    WebElement deleteButton;

    @FindBy(xpath = "//*[@id=\"sc-active-cart\"]/div/div[1]/div/h1")
    WebElement deleteConfirmation;

    public void verifyingCartWithoutItem() {
        Assert.assertEquals((String) amazonJson.get("homePageVerification") , BaseSetUp.driver.getTitle());
        cartViewLink.click();
        Assert.assertEquals("EmptyCartVerification", emptyCartConfirmation.getText());

    }

    public void verifyingCartWithItem() {
        searchFieldBox.sendKeys((String) amazonJson.get("searchForItem"));
        searchButton.click();
        Assert.assertEquals((String) amazonJson.get("searchForItemConfirmation"), searchElementConfirmation.getText());
        itemAddToCart.click();
        String currentHandle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String actual : handles) {
            System.out.println(actual);
            if (!actual.equalsIgnoreCase(currentHandle)) {
                //Switch to the opened tab
                driver.switchTo().window(actual);
                System.out.println(driver.getCurrentUrl());
                break;
            }
        }
        addToCartButton.click();
        cartViewLink.click();
        Assert.assertEquals("Shopping Cart", shoppingCartText.getText());

    }

    public void increaseQuantityInCart(){
        Select quantityButtonSelect = new Select(quantityButton);
        quantityButtonSelect.selectByVisibleText("3");

        System.out.println(quantityConfirmation.getText());
        Assert.assertEquals((String) amazonJson.get("Quantity"),quantityConfirmation.getText());
    }

    public void deleteButtonForCart(){
        deleteButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println(driver.getCurrentUrl());
    }

    public void verifyCartIsEmpty(){
        System.out.println(deleteConfirmation.getText());
        Assert.assertEquals((String) amazonJson.get("EmptyCartVerification"), deleteConfirmation.getText());
    }

}
