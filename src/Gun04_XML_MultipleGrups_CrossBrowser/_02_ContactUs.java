package Gun04_XML_MultipleGrups_CrossBrowser;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _02_ContactUs extends BaseDriver {

    /*
  1- ContactUs a tıklayınız
  2- Mesaj kutusuna en az 10 karakterlik bir mesaj yazınız.
  3- Submit ettikten sonra Contact US yazısını doğrulayınız.
 */

    @Test
    @Parameters("mesaj")  // XML'de ki parametre adı aynı olmak zorunda
    void contact(String gelenMesaj) // method değeri vermemiz gerekli ama parametre ile aynı olmak zorunda değil
    {
        WebElement cnt = driver.findElement(By.xpath("/html/body/footer/div/div/div[2]/ul/li[1]/a"));
        cnt.click();

        WebElement msg = driver.findElement(By.cssSelector("#input-enquiry"));
        msg.sendKeys(gelenMesaj); // method'u eklemeyi sakın unutma !!

        WebElement submit = driver.findElement(By.cssSelector("input[value='Submit']"));
        submit.click();


        Assert.assertTrue(driver.getCurrentUrl().contains("success"));


        WebElement cntn = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a"));
        cntn.click();


    }


}
