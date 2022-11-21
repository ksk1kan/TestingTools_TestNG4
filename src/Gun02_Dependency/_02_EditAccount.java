package Gun02_Dependency;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
/*
  Senaryo
  1- Siteyi açınız.
  2- Edit Account sayfasına ulaşınız.
  3- Ad ve soyadı değiştirip tekrar kaydedidiniz.
 */


public class _02_EditAccount extends BaseDriver {

    By cont = By.xpath("//*[@id=\"content\"]/form/div/div[2]/input");
    @Test
    void editAccountPage()
    {
        WebElement edit = driver.findElement(By.xpath("//*[@id=\"content\"]/ul[1]/li[1]/a"));
        edit.click();

        WebElement name = driver.findElement(By.xpath("//*[@id=\"input-firstname\"]"));
        name.clear();
        name.sendKeys("Birkan Arslan");

        WebElement surname = driver.findElement(By.xpath("//*[@id=\"input-lastname\"]"));
        surname.clear();
        surname.sendKeys("Filizz");

        WebElement contButton = driver.findElement(cont);
        contButton.click();

        Tools.Bekle(2);
        Tools.successMessageValidation();
    }
}
