package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import setUp.BaseSetUp;

import java.util.concurrent.TimeUnit;

import static setUp.BaseSetUp.amazonJson;
import static setUp.BaseSetUp.driver;

public class Language {

    public Language(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "icp-nav-flyout")
    WebElement languageDropdown;
    @FindBy(xpath = "(//i[@class='a-icon a-icon-radio'])[2]")
    WebElement hindiLanguage;
    @FindBy(xpath= "(//input[@class='a-button-input'])[1]")
    WebElement saveChangeButton;
    @FindBy(css = "span[class='nav-line-2'] div")
    WebElement changeLanguageConfirmation;

    @FindBy(xpath = "//span[contains(text(),'TA')]")
    WebElement taLanguageSelection;

    @FindBy(xpath = "(//span[@class='hm-icon-label'])[1]")
    WebElement verifyTaLanguage;

    public void languageChange(){
        languageDropdown.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        hindiLanguage.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        saveChangeButton.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals("HI",changeLanguageConfirmation.getText());
    }

    public void languageDropdown() {
        Assert.assertEquals((String) amazonJson.get("homePageVerification"), BaseSetUp.driver.getTitle());
        Actions act = new Actions(BaseSetUp.driver);
        act.moveToElement(languageDropdown).perform();
        taLanguageSelection.click();
        Assert.assertEquals("அனைத்தும்",verifyTaLanguage.getText());
    }


}
