package testRunner;

import org.testng.annotations.Test;
import pages.CountryAndCurrency;
import setUp.BaseSetUp;

public class CountryAndCurrencyTestRunner extends BaseSetUp {

    @Test
    public void countryChange(){
        CountryAndCurrency country =new CountryAndCurrency(driver);
        country.countryChange();
    }

    @Test
    public void countryCurrencyChange(){
        CountryAndCurrency country =new CountryAndCurrency(driver);
        country.countryChange();
        CountryAndCurrency currency =new CountryAndCurrency(driver);
        currency.currencyChange();
    }
}
