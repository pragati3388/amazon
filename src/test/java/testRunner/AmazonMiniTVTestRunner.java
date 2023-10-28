package testRunner;

import org.testng.annotations.Test;
import pages.AmazonMiniTVPage;
import setUp.BaseSetUp;

public class AmazonMiniTVTestRunner extends BaseSetUp {

    @Test(description = "Verifying Mini TV Page & Menu")
    public void amazonMiniTVFunctionality(){
        AmazonMiniTVPage miniTV =new AmazonMiniTVPage(driver);
        miniTV.amazonMiniTVFunctionality(miniTVJson);
    }
}
