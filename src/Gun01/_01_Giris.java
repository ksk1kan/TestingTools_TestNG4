package Gun01;

import org.testng.annotations.Test;

public class _01_Giris {

    // Eğer herhangi bir sıralama verilmezse metodların isimlerinin ALFABETİK sırasına göre çalışıyor.
    // priority default değeri 0, biz buna sırasıyla numara verdiğimizde test işlemlerini
    // priority değerine göre işleme alır.
    @Test(priority = 1)
    void weSitesiniAc()
    {
    System.out.println("driver Tanımlandı ve Web Sitesi Açıldı.");
    }

    @Test(priority = 2)
    void loginIslemiYap()
    {
        System.out.println("login Test İslemleri Yapıldı.");
    }

    @Test(priority = 3)
    void driveriKapat()
    {
        System.out.println("driver Kapatıldı ve Çıkıldı.");
    }




}
