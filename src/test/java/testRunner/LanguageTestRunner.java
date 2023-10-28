package testRunner;

import org.testng.annotations.Test;
import pages.Language;
import setUp.BaseSetUp;

public class LanguageTestRunner extends BaseSetUp {
    Language language;
    @Test
    public void languageChange(){
        language =new Language(driver);
        language.languageChange();
    }

    @Test
    public void languageDropdown() throws InterruptedException {
        language =new Language(driver);
        language.languageDropdown();
        Thread.sleep(10000);
    }
}
