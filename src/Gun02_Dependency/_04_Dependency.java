package Gun02_Dependency;

import org.testng.annotations.Test;

public class _04_Dependency {
    //arabanın hareketleri : start, drive, park, stop

    // dependsOnMethods bağlı çalıştırmak için kullanılıyor.
    // dependsOnMethods ile priority de kullanılabiliyor.
    // tek tek kendi içerisinde çalıştırabilirsin fakat depends olduğunda maksimum 2 önceki method
    // çalıştırılabiliyor. onun dışında direkt hata veriyor.

    @Test
    void startCar()
    {
        System.out.println("startCar");
        //Assert.fail();
    }

    @Test(dependsOnMethods = {"startCar"})  // bu testin çalışması startCar method'una bağlı.
    void driveCar()
    {
        System.out.println("driveCar");
    }

    @Test(dependsOnMethods = {"startCar","driveCar"})
    void parkCar()
    {
        System.out.println("parkCar");
    }

    @Test(dependsOnMethods = {"parkCar"}, alwaysRun = true)
    void stopCar()
    {
        System.out.println("stopCar");
    }
}
