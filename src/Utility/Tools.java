package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static Utility.BaseDriver.driver;

public class Tools {

    public static void Bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void successMessageValidation()
    {
        WebElement msgLabel = driver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible'"));
        Assert.assertTrue(msgLabel.getText().toLowerCase().contains("success"));
    }
}
