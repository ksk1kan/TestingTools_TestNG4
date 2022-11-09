package Gun01;

import Utility.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

// Yeşil tik : test de hata yok
// Sarı çarpi : test de hata var
// Beyaz  : test çalıştırılmadı.skip

public class _05_Assertions extends BaseDriver {

    @Test
    void EqualOrnek()    // değerler birbiri ile aynı mı ?
    {
        String s1="Merhaba";
        String s2="Merhaba1";

        // Actual(oluşan), Expect(beklenen) , Mesaj(opsiyonel)

        Assert.assertEquals(s1,s2,"Karşılaştırma Sonucu");  // ----> HARD ASSERTTION
                                                               // SOFT ASSERTION durumu var bir de.
    }

    @Test
    void NotEqualOrnek()    // değerler birbirinden farklı mı ?
    {
        String s1="Merhaba";
        String s2="Merhaba";

        Assert.assertNotEquals(s1,s2,"Karşılaştırma sonucu");
    }

    @Test
    void TrueOrnek()
    {
        int s1=55;
        int s2=66;

        Assert.assertTrue(s1==s2,"Karşılaştırma Sonucu");
    }

    @Test
    void nullOrnek()   // null değeri
    {
        String s1="birkan";

        Assert.assertNull(s1,"işlem sonucu");
    }

    @Test
    void directFailOrnek()   // böyle böyle olursa bilerek hata versin denilen ve kullanılan nokta.
    {
        int a=55;

        if (a==55)
        Assert.fail();
    }


}
