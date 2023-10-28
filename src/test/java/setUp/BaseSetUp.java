package setUp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import utils.Utils;

import java.time.Duration;

public class BaseSetUp {
    public static WebDriver driver;
    public static SoftAssert softAssert;
    public static JSONObject miniTVJson = Utils.loadJsonFile("./src/test/resources/miniTv.json");
    public static JSONObject amazonJson = Utils.loadJsonFile("./src/test/resources/amazon.json");

    //public static JSONObject  = Utils.loadJsonFile("./src/test/resources/userRegistration.json");

    @BeforeMethod
    public void setup(){
        softAssert = new SoftAssert();
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("load-extension=" + "C:\\Users\\ashis\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\cjpalhdlnbpafiamejdnhcphjbkeiagm\\1.52.2_0");
        WebDriverManager.chromedriver().capabilities(chromeOptions).setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.in/");
        driver.findElement(By.partialLinkText("Update location")).click();
    }
    @AfterMethod
    public void closeDriver(){
        driver.quit();
    }

    public static JavascriptExecutor getJavascriptExecutor(){
        return (JavascriptExecutor) driver;
    }
}
