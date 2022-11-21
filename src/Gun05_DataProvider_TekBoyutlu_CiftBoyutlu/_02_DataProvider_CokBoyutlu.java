package Gun05_DataProvider_TekBoyutlu_CiftBoyutlu;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _02_DataProvider_CokBoyutlu {

    @Test (dataProvider = "getData")
    void LoginTest(String username, String password)
    {
        System.out.println("username: "+username+ " |<->|" + " password: "+password);
    }


    @DataProvider
    public Object[][] getData()
    {
        Object[][] logins={
                {"Hasan","12354321"},
                {"Birkan","12123414321"},
                {"Metin","11235bcc321"},
                {"Ufuk","sadfasdf2413fbv"}


        };
        return logins;
    }
}
