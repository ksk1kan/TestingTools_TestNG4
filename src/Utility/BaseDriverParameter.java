package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriverParameter {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    @Parameters ("browser")
    public void baslangicIslemleri(String browser) {

        //http://opencart.abstracta.us/index.php?route=account/login

        System.out.println("Test işlemleri başlıyor ...");
        //ilk adımda çalışan kod kısmı

        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);

        if (browser.equalsIgnoreCase("chrome"))
        {
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox"))
        {
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }


        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        Duration dr = Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(dr);

        driver.manage().timeouts().implicitlyWait(dr);

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


    @AfterClass
    public void bitisIslemleri()
    {
        System.out.println("Test işlemi tamamlandı.");
        Tools.Bekle(3);
        driver.quit();
    }


}
