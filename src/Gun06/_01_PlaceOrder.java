package Gun06;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

  /*
   Senaryo :
   1- Siteyi açınız.
   2- Sitede "ipod" kelimesini aratınız
   3- Çıkan sonuçlardan ilkini sepete atınız.
   4- Shopping Chart a tıklatınız.
   5- Checkout yapınız.
   6- Continue butonalarına tıklatıp bilgileri giriniz.
   7- En confirm ile siparişi verdiğinizi doğrulayınız.
      doğrulamayı çıkan sayfadaki "Your order has been placed" yazısı ile yapınız.
*/

public class _01_PlaceOrder extends BaseDriver {

         @Test
            void ProductPlaceOrder(){

         WebElement search = driver.findElement(By.cssSelector("input[placeholder='Search']"));
         search.sendKeys("ipod");

         WebElement searchButton = driver.findElement(By.cssSelector("button[class='btn btn-default btn-lg']"));
         searchButton.click();

         WebElement addChart = driver.findElement(By.xpath("(//span[contains(text(),'Add to Cart')])[1]"));
         addChart.click();

         WebElement chart = driver.findElement(By.xpath("(//a[normalize-space()='shopping cart'])[1]"));
         chart.click();
         WebElement cOut = driver.findElement(By.xpath("(//a[@class='btn btn-primary'])[1]"));
         cOut.click();

         WebElement devam = driver.findElement(By.cssSelector("#button-payment-address"));
         devam.click();
         WebElement devam2 = driver.findElement(By.cssSelector("#button-shipping-address"));
         devam2.click();
         WebElement devam3 = driver.findElement(By.xpath("(//input[@id='button-shipping-method'])[1]"));
         devam3.click();
         WebElement terms = driver.findElement(By.cssSelector("input[value='1']"));
         terms.click();
         WebElement devam4 = driver.findElement(By.cssSelector("#button-payment-method"));
         devam4.click();
         WebElement devam5 = driver.findElement(By.cssSelector("#button-confirm"));
         devam5.click();

             Tools.Bekle(2);
         Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("checkout/success"));

    }
}
