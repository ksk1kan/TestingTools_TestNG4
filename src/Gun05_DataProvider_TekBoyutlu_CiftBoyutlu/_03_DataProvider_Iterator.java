package Gun05_DataProvider_TekBoyutlu_CiftBoyutlu;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _03_DataProvider_Iterator {

    @Test(dataProvider = "getData")  // benim data, veri sağlayıcım getData fonksiyonudur.
    void searchTest(String searchText)
    {
        System.out.println("searchText = " + searchText);
    }


    @DataProvider
    public Iterator <Object> getData()
    {
        List<Object> data = new ArrayList<>();
        data.add("Mac");
        data.add("Samsung");
        data.add("Huawei");
        data.add("iphone");
        data.add("pc");
        data.add("xaomi");

        return data.iterator();
    }
    /****************************************************************************/
    @Test (dataProvider = "getData2")
    void LoginTest(String username, String password)
    {
        System.out.println("username: "+username+ " |<->|" + " password: "+password);
    }


    @DataProvider
    public Iterator<Object[]> getData2()
    {
        List<Object[]> logins= new ArrayList<>();
        logins.add(new Object[]{"Hasan","12354321"});
        logins.add(new Object[]{"Birkan","12345324321"});
        logins.add(new Object[]{"Ufuk","1235asdfa4321"});
        logins.add(new Object[]{"Metin","123wrewv54321"});


        return logins.iterator();
    }

}

