package pages;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import setUp.BaseSetUp;

import java.util.List;

import static setUp.BaseSetUp.*;

public class AmazonMiniTVPage {

    public AmazonMiniTVPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[@href='/minitv?ref_=nav_avod_desktop_topnav']")
    WebElement amazonMiniTV;
    @FindBy(xpath = "//span[@class=' AppNavbar_navItem___QI5L']")
    List<WebElement> menuBarList;
    public void amazonMiniTVFunctionality(JSONObject miniTvJson){
        Assert.assertEquals((String) amazonJson.get("homePageVerification"), BaseSetUp.driver.getTitle());
        amazonMiniTV.click();
        Assert.assertTrue(driver.getCurrentUrl().contains((String) miniTvJson.get("url")));
        Assert.assertEquals((String) miniTvJson.get("0"),menuBarList.get(0).getText());
        Assert.assertEquals((String) miniTvJson.get("1"),menuBarList.get(1).getText());
        Assert.assertEquals((String) miniTvJson.get("2"),menuBarList.get(2).getText());
    }
}
