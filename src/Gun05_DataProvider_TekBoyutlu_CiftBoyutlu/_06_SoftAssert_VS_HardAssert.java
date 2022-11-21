package Gun05_DataProvider_TekBoyutlu_CiftBoyutlu;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _06_SoftAssert_VS_HardAssert {

    @Test
    void hardAssert() {
        String s1 = "Merhaba";

        System.out.println("HARD Assert kontrol öncesi");
        Assert.assertEquals("Merhaba 123", s1, "HARDAssert Sonucu");
        System.out.println("HARD Assert kontrol sonrası");
    }

    @Test
    void softAssert() {
        String strHomePage = "www.facebook.com/homepage";
        String strCartPage = "www.facebook.com/cartpage";
        String strEditAccount = "www.facebook.com/editaccountpage";

        SoftAssert _softAssert = new SoftAssert();

        _softAssert.assertEquals("www.facebook.com/homepage", strHomePage); // true
        System.out.println("***** ASSERT 1 KONTROL *****");

        _softAssert.assertEquals("www.facebook.com/profile", strCartPage); //false
        System.out.println("***** ASSERT 2 KONTROL *****");

        _softAssert.assertEquals("www.facebook.com/settings", strEditAccount); //false
        System.out.println("***** ASSERT 3 KONTROL *****");


        _softAssert.assertAll();

    }
}
