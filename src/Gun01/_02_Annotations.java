package Gun01;

import org.testng.annotations.*;

public class _02_Annotations {

    /*
        @BeforeClass     -->  Class'ın başında çalışacak. (driver işlemleri)
          @BeforeMethod  --> Her method (test methodları)'dan önce çalışacak.
            @Test        --> testlerin çalıştığı methodlar.
            @Test        --> testlerin çalıştığı methodlar.
          @AfterMethod   --> Her methoddan sonra çalışacak
        @AfterClass      --> Class'ın çalışmasının sonunda çalışacak. (driverkapat)
     */

    @BeforeClass
    void beforeClass()
    {
    System.out.println("Her class'dan ÖNCE çalışacak. --> @BeforeClass");
        // driver ve diğer test öncesi bütün işlemler yapılabilir.
    }

    @BeforeMethod
    void beforeMethod()
    {
        System.out.println("Her method'dan ÖNCE çalışacak. --> @BeforeMethod");
    }

    @AfterMethod
    void afterMethod()
    {
        System.out.println("Her method'dan SONRA çalışacak. --> @AfterMethod");
    }

    @AfterClass
    void afterClass()
    {
        System.out.println("Her class'dan SONRA çalışacak. --> @AfterClass");
        // driver kapat v.s kullanılabilir.
    }

    @Test
    void test1()
    {
        System.out.println("Test 1 çalıştı. --> @Test");
    }
    @Test
    void test2()
    {
        System.out.println("Test 2 çalıştı. --> @Test");
    }




}
