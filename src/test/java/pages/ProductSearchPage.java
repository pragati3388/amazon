package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import setUp.BaseSetUp;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static setUp.BaseSetUp.*;

import javax.swing.*;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ProductSearchPage {
    WebDriverWait wait;

    public ProductSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
    }

    @FindBy(id = "twotabsearchtextbox")
    WebElement searchFieldBox;

    @FindBy(xpath = "//div[@class='left-pane-results-container']/div[2]")
    WebElement dropdownElement;

    @FindBy(id = "nav-search-submit-button")
    WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"search\"]/span[2]/div/h1/div/div[1]/div/div/span[3]")
    WebElement searchElementConfirmation;

    @FindBy(xpath = "(//div[@class='a-row'])[1]")
    WebElement errorMessage;

    @FindBy(xpath = "(//i[@class='a-icon a-icon-checkbox'])[1]")
    WebElement deliveryDayFilter;


    @FindBy(xpath = "//ul[@aria-labelledby='n-title']//span[@data-csa-c-type='element']/li")
    List<WebElement> categories;

    @FindBy(xpath = "//div[@id='brandsRefinements']//span[@data-csa-c-type='element']/li")
    List<WebElement> brands;

    @FindBy(xpath = "(//ul[@class='a-unordered-list a-nostyle a-horizontal a-spacing-medium'])[1]//span[@data-csa-c-type='element']/li")
    List<WebElement> sizes;

    @FindBy(xpath = "//ul[@class='a-unordered-list a-nostyle a-horizontal a-spacing-medium']//li[@class='a-spacing-micro s-list-item']")
    WebElement removeSizeFilter;

    @FindBy(xpath = "(//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2'])[1]")
    WebElement categoryName;

    @FindBy(id = "GLUXZipUpdateInput")
    WebElement pinCode;

    @FindBy(xpath = "//*[@id=\"GLUXZipUpdate\"]/span/input")
    WebElement applyPinCode;

    @FindBy(id = "searchDropdownBox")
    WebElement searchProductDropBox;

    @FindBy(xpath = "(//span[@class='nav-a-content'])[1]")
    WebElement searchDropDownConfirmation;

    public void validProductSearch() {
        Assert.assertEquals((String) amazonJson.get("homePageVerification"), BaseSetUp.driver.getTitle());
        searchFieldBox.sendKeys((String) amazonJson.get("mobilesearchItem"));
        dropdownElement.click();
        searchButton.click();
        Assert.assertEquals((String) amazonJson.get("searchItemConfirmation"), searchElementConfirmation.getText());
    }

    public void invalidProductSearch() {
        Assert.assertEquals((String) amazonJson.get("homePageVerification"), BaseSetUp.driver.getTitle());
        searchFieldBox.sendKeys((String) amazonJson.get("invalidSearch"));
        searchButton.click();
        Assert.assertEquals((String) amazonJson.get("invalidResult"), errorMessage.getText());

    }

    public void oneDayDeliveryFilter() {
        Assert.assertEquals((String) amazonJson.get("homePageVerification"), BaseSetUp.driver.getTitle());
        searchFieldBox.sendKeys("samsung mobile");
        wait.until(ExpectedConditions.elementToBeClickable(dropdownElement)).click();
        searchButton.click();
        Assert.assertEquals("\"samsung mobile\"", searchElementConfirmation.getText());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        deliveryDayFilter.click();
        Assert.assertTrue(deliveryDayFilter.isSelected());
    }

    public void applyMultipleFilter() {
        Assert.assertEquals((String) amazonJson.get("homePageVerification"), BaseSetUp.driver.getTitle());
        searchFieldBox.sendKeys("Apparels");
        searchButton.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals("\"Apparels\"", searchElementConfirmation.getText());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        for (WebElement category : categories) {
            System.out.println(category.getText());
            if (category.getText().equals("Women’s Winter Wear")) {
                category.click();
                break;
            }
        }

        for (WebElement brand : brands) {
            System.out.println(brand.getText());
            if (brand.getText().equals("VERO MODA")) {
                brand.click();
                break;
            }
        }

        for (WebElement size : sizes) {
            System.out.println(size.getText());
            if (size.getText().equals("M")) {
                size.click();
                break;
            }
        }
    }

    public void verifyProduct(String name) {
        Assert.assertTrue(categoryName.getText().contains("Women"));
    }

    public void removeMultipleFilter() {
        removeSizeFilter.click();
    }

    public void updateDeliveryPinCode() {
        pinCode.sendKeys("500089");
        applyPinCode.click();
    }

    public void searchDropDownFunctionality() {
        Select selectDropDown = new Select(searchProductDropBox);
        List<WebElement> dropDownList = selectDropDown.getOptions();
        System.out.println("Total number of options available :" + selectDropDown.getOptions().size());
        for (WebElement op : dropDownList) {
            System.out.println(op.getText());
            if(op.getText().equals("Books")){
                op.click();
                break;
            }
        }
        searchButton.click();
        Assert.assertEquals("Books",searchDropDownConfirmation.getText());
    }
}





