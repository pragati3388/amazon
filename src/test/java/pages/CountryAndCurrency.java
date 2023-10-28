package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import setUp.BaseSetUp;

import java.util.Set;

import static setUp.BaseSetUp.driver;

public class CountryAndCurrency {

    public CountryAndCurrency(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "icp-nav-flyout")
    WebElement languageDropdown;

    @FindBy(id = "icp-flyout-mkt-change")
    WebElement countryChangeLink;

    @FindBy(id = "icp-dropdown")
    WebElement country;

    @FindBy(xpath = "//*[@id=\"icp-save-button\"]/span/input")
    // @FindBy(xpath = "//span[@id='icp-save-button-announce']")
    WebElement goToWebsiteButton;

    @FindBy(xpath = "//a[@class='icp-flyout-change']")
    WebElement currencyChangeLink;

    @FindBy(xpath = "//span[@class='a-dropdown-prompt']")
    //@FindBy(id = "icp-currency-dropdown")
    WebElement currencyDropdown;
    @FindBy(id = "icp-currency-dropdown_1")
    WebElement selectCurrency;
    @FindBy(xpath = "//input[@class='a-button-input']")
    WebElement saveChangeButtonCurrency;

    public void countryChange() {
        Actions act = new Actions(BaseSetUp.driver);
        act.moveToElement(languageDropdown).perform();
        countryChangeLink.click();
        Select countrySelect = new Select(country);
        countrySelect.selectByVisibleText("Singapore");

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", goToWebsiteButton);
        String currentHandle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String actual : handles) {
            if (!actual.equalsIgnoreCase(currentHandle)) {
                //Switch to the opened tab
                driver.switchTo().window(actual);
                System.out.println(driver.getCurrentUrl());
                break;
            }
        }
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon.sg"));

    }

    public void currencyChange(){
        Actions act = new Actions(BaseSetUp.driver);
        act.moveToElement(languageDropdown).perform();
        currencyChangeLink.click();
        // Select currencySelect = new Select(currency);
        //currencySelect.selectByVisibleText("MYR - Malaysian Ringgit");
        currencyDropdown.click();
        selectCurrency.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveChangeButtonCurrency);
        System.out.println(" url " + driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("currency=MYR"));

    }

}
