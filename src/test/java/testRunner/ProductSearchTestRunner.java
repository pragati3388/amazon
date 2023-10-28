package testRunner;

import org.testng.annotations.Test;
import pages.ProductSearchPage;
import setUp.BaseSetUp;

public class ProductSearchTestRunner extends BaseSetUp {
    ProductSearchPage searchPage;

    @Test(description = "Verify Valid Product Search")
    public void validProductSearchField(){
        searchPage =new ProductSearchPage(driver);
        searchPage.validProductSearch();
    }

    @Test(description = "Verify Invalid Product Search")
    public void invalidProductSearch(){
        searchPage =new ProductSearchPage(driver);
        searchPage.invalidProductSearch();
    }

    @Test(description = "One Day Delivery from \"Delivery Day\" Filter")
    public void oneDayDeliveryFilter(){
        searchPage =new ProductSearchPage(driver);
        searchPage.oneDayDeliveryFilter();
    }
    @Test(description = "Apply Multi Filter On Product")
    public void applyAndVerifyMultiFilter(){
        searchPage =new ProductSearchPage(driver);
        searchPage.applyMultipleFilter();
        searchPage =new ProductSearchPage(driver);
        searchPage.verifyProduct("Women");
    }

    @Test(description = "Apply & Remove Filter on Product")
    public void applyAndRemoveFilter(){
        searchPage =new ProductSearchPage(driver);
        searchPage.applyMultipleFilter();
        searchPage =new ProductSearchPage(driver);
        searchPage.verifyProduct("Women");
        searchPage =new ProductSearchPage(driver);
        searchPage.removeMultipleFilter();
    }

    @Test
    public void searchDropDownFunctionality(){
        searchPage =new ProductSearchPage(driver);
        searchPage.searchDropDownFunctionality();
    }

}
