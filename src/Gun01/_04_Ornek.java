package Gun01;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _04_Ornek extends BaseDriver {

    @Test
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

}
