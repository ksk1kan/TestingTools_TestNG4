package Gun03;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class _0_AddressFunctionality extends BaseDriver {

    /*
       Senaryo;
       1- Siteyi açınız.
       2- Adress Ekleyiniz.
       3- En son adresi edit yaparak ad ve soyadı değiştirip kaydediniz.
       4- En son adresi siliniz.
 */

    @Test (priority = 2)
    void Test1()
    {
        WebElement adressBook = driver.findElement(By.xpath("//*[@id=\"content\"]/ul[1]/li[3]/a"));
        adressBook.click();
        WebElement newAddress = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/a"));
        newAddress.click();
    }

    @Test (priority = 3)
    void Test2()
    {
        WebElement name = driver.findElement(By.cssSelector("#input-firstname"));

        Actions aksiyon = new Actions(driver);
        aksiyon.click(name)
                .sendKeys("Birkan")
                .sendKeys(Keys.TAB)
                .sendKeys("Filiz")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("babatasi mah.")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("Mugla")
                .sendKeys(Keys.TAB)
                .sendKeys("48300")
                .sendKeys(Keys.TAB).build().perform();

        WebElement countrySelect = driver.findElement(By.xpath("(//select[@id='input-country'])[1]"));

        Select slct=new Select(countrySelect);
        slct.selectByVisibleText("Turkey");  // implicitly wait ile bağlantılı çalıştı, arkaplanda.
        aksiyon.sendKeys(Keys.ENTER).build().perform();

        WebElement regionSelect = driver.findElement(By.xpath("(//select[@id='input-zone'])[1]"));

        Select slct2=new Select(regionSelect);
        slct2.selectByVisibleText("Muğla");
        aksiyon.sendKeys(Keys.ENTER).build().perform();

        WebElement radioButton = driver.findElement(By.cssSelector("input[value='1']"));
        radioButton.click();

        WebElement confirm = driver.findElement(By.cssSelector("input[value='Continue']"));
        confirm.click();


    }

    @Test (priority = 4)
    void Test3()
    {
        WebElement editButton = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/a[1]"));
        editButton.click();
        WebElement name = driver.findElement(By.cssSelector("#input-firstname"));
        name.click();
        name.clear();
        name.sendKeys("arslan");
        WebElement lastName = driver.findElement(By.cssSelector("#input-lastname"));
        lastName.clear();
        lastName.sendKeys("filiz");

        WebElement devam = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div[2]/input"));
        devam.click();
    }

    @Test (dependsOnMethods = {"Test3"})
    void Test4()
    {
        List<WebElement> deleteButton = driver.findElements(By.linkText("Delete"));
        WebElement sonDelete = deleteButton.get(deleteButton.size()-3);
        sonDelete.click();
        Tools.successMessageValidation();
    }

}
