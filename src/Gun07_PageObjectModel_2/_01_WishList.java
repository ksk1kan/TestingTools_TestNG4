package Gun07_PageObjectModel_2;

import Utility.BaseDriverParameter;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _01_WishList extends BaseDriverParameter {
/*
    Senaryo ;
    1- Siteye gidiniz..

   1.Test;
   2- "ipod" ürününü aratınız."ipod" u xml den gönderiniz
   3- çıkan elamnlardan random bir elelamnı Add Wish butonuna tıklayınız.
   4- Daha sonra WishList e tıklatınız
   5- Burada çıkan ürünle tıklanan ürünün isminin aynı olup olmadığını doğrulayınız.

 */

    @Parameters("searchText")
    @Test
    void wishList(String aranacakKelime)
    {
        WebElement searchInput = driver.findElement(By.cssSelector("input[placeholder='Search']"));
        searchInput.sendKeys(aranacakKelime);

        WebElement searchButton = driver.findElement(By.xpath("//i[@class='fa fa-search']"));
        searchButton.click();


        // alttaki random search item textleri buldu.
        List<WebElement> searchResults=driver.findElements(By.xpath("//div[@id='content']/div/div//h4"));
        int randomSecim= Tools.RandomNumberGenerator(searchResults.size());
        String wishItemText = searchResults.get(randomSecim).getText();
        System.out.println("wishItemText = " + wishItemText);  // kontrol amaçlı

        // altta ki random search item wishList butonlarından yukarıdakiyle aynısını buldu ve clickledi.
        List<WebElement> wishBtnList=driver.findElements(By.xpath("//button[@data-original-title='Add to Wish List']"));
        wishBtnList.get(randomSecim).click();

        WebElement btnWishList = driver.findElement(By.id("wishlist-total"));
        btnWishList.click();

        List<WebElement> wishTableNames=driver.findElements(By.cssSelector("td[class='text-left']>a"));

        Tools.listContainsString(wishTableNames, wishItemText);

    }
}
