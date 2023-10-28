package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static setUp.BaseSetUp.driver;

public class ConnectUsLinkPage {

    public ConnectUsLinkPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(partialLinkText = "Facebook")
    WebElement facebookLink;
    @FindBy(partialLinkText = "Twitter")
    WebElement twitterLink;
    @FindBy(partialLinkText = "Instagram")
    WebElement instagramLink;

    public void verifyConnectUsLink(){
        Assert.assertEquals("Facebook", facebookLink.getText());
        Assert.assertEquals("Twitter", twitterLink.getText());
        Assert.assertEquals("Instagram", instagramLink.getText());
        facebookLink.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("AmazonIN"));
        driver.navigate().back();
        twitterLink.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("AmazonIN"));
        driver.navigate().back();
        instagramLink.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("amazondotin"));
    }

}
