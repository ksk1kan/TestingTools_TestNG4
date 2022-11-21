package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass (groups = "SmokeTest")
    public void baslangicIslemleri() {

        //http://opencart.abstracta.us/index.php?route=account/login

        System.out.println("Test işlemleri başlıyor ...");
        //ilk adımda çalışan kod kısmı

        Logger logger = Logger.getLogger(""); // sisteme ait bütün logları üreten objeye/servise ulaştım ""
        logger.setLevel(Level.SEVERE); // Sadece errorları göster

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");  // ChromeService'i sessiz modda çalıştır
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();   // web sayfasını kontrol eden görevli
        //driver.manage().window().setPosition(new Point(-1650,130));

        driver.manage().window().maximize();  // Ekranı max yapıyor.
        driver.manage().deleteAllCookies();  // sitenin senin bilgisayarında yaptığı ayarlar siliniyor, sayfa başlangıç ayarlarına dönüyor

        Duration dr = Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(dr); // Sadece tüm sayfanın kodlarının bilgisyarınıza inmesi süresiyle ilgili
        //bu eklenmezse Selenium sayfa yüklenene kadar (sonsuza) bekler.: 30 sn süresince sayfanın yüklenmesini bekle yüklenmezse hata ver
        // eğer 2 sn yüklerse 30 sn. beklemez.

        driver.manage().timeouts().implicitlyWait(dr); // Bütün weblementlerin element bazında, elemente özel işlem yapılmadan önce
        // hazır hale gelmesi verilen mühlet yani süre. // eğer 2 sn yüklerse 30 sn. beklemez.

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        loginTest();
  }

    void loginTest()
    {
        driver.get("http://opencart.abstracta.us/index.php?route=account/login");
        System.out.println("Sisteme Giriş Yapıldı.");
        WebElement username = driver.findElement(By.xpath("//*[@id=\"input-email\"]"));
        username.sendKeys("birkantest@gmail.com");

        WebElement password = driver.findElement(By.xpath("//*[@id=\"input-password\"]"));
        password.sendKeys("birkan123");

        WebElement submit = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
        submit.click();

        Assert.assertEquals(driver.getTitle(),"My Account","Login Başarısız.");
    }



    @AfterClass(groups = "SmokeTest")
    public void bitisIslemleri()
    {
        System.out.println("Test işlemi tamamlandı.");
        Tools.Bekle(3);
        driver.quit();
    }


}
