package testRunner;

import org.testng.annotations.Test;
import pages.ConnectUsLinkPage;
import setUp.BaseSetUp;

public class ConnectUsLinkTestRunner extends BaseSetUp {

    ConnectUsLinkPage connectUs;
    @Test(description = "Verifying Connect Us Link on Amazon Website")
    public void verifyConnectUs(){
        connectUs =new ConnectUsLinkPage(driver);
        connectUs.verifyConnectUsLink();
    }
}
