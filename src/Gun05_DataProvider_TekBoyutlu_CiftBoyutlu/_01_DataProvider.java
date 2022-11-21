package Gun05_DataProvider_TekBoyutlu_CiftBoyutlu;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class _01_DataProvider {

    @Test(dataProvider = "getData")  // benim data, veri sağlayıcım getData fonksiyonudur.
    void searchTest(String searchText)
    {
        System.out.println("searchText = " + searchText);
    }

    // Data sağlayıcı.. Bu method'a sürekli veri gönderme görevi verildi.
    @DataProvider
    public Object[] getData(){ //dataprovider'ın dönüş değeri mutlaka Object olmak zorunda

        Object[] data={"Mac","Samsung","Huawei","iphone","pc","xaomi"}; // string olduğu kadar rakam da olabilir.

        return data;
    }

    /**************************************************************************************/

    @Test(dataProvider = "aranacaklar")  // benim data, veri sağlayıcım getData fonksiyonudur.
    void searchTest2(String searchText)
    {
        System.out.println("searchText = " + searchText);
    }

    // Data sağlayıcı.. Bu method'a sürekli veri gönderme görevi verildi.
    @DataProvider (name="aranacaklar")
    public Object[] getData2(){ //dataprovider'ın dönüş değeri mutlaka Object olmak zorunda

        Object[] data={"Mac","Samsung","Huawei","iphone","pc","xaomi"}; // string olduğu kadar rakam da olabilir.

        return data;
    }

}