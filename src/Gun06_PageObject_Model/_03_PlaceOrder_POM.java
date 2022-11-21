package Gun06_PageObject_Model;

import Utility.BaseDriver;
import Utility.Tools;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_PlaceOrder_POM extends BaseDriver {

    @Test
    void ProductPlaceOrder() {

        _02_PlaceOrderElements elements = new _02_PlaceOrderElements();  // ÖNEMLİ NOKTALARDAN BİRİSİ !


        elements.search.sendKeys("ipod");
        elements.searchButton.click();
        elements.addChart.click();
        elements.chart.click();
        elements.cOut.click();
        elements.devam.click();
        elements.devam2.click();
        elements.devam3.click();
        elements.terms.click();
        elements.devam4.click();
        elements.devam5.click();


        Tools.Bekle(2);
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("checkout/success"));

    }
}
