package Gun02;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class _03_ValidateMenu extends BaseDriver {

    /*
    1. siteyi aç
    2. top menude ki elemanların oldğunu doğrulayınız.
    3. Desktops, Laptops & Notebooks, Components, Tablets, Software, Phones & PDAs, Cameras, MP3 Players.
     */

    @Test (groups = "SmokeTest")
    void navBarValidate()
    {
        WebElement navBar = driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul"));

        if (navBar.isEnabled())
            System.out.println("Top Menu var");
        else
            System.out.println("Top Menu Yok.");

        List<WebElement> menuActualList = driver.findElements(By.cssSelector("ul[class='nav navbar-nav']>li"));

        for (WebElement e : menuActualList)
            System.out.println("NavBar Liste Ögesi: " + e.getText());

        List<String> menuExpectedList = new ArrayList<>();
        menuExpectedList.add("Desktops");
        menuExpectedList.add("Laptops & Notebooks");
        menuExpectedList.add("Components");
        menuExpectedList.add("Tablets");
        menuExpectedList.add("Software");
        menuExpectedList.add("Phones & PDAs");
        menuExpectedList.add("Cameras");
        menuExpectedList.add("MP3 Players");

        for (int i=0; i<menuExpectedList.size();i++)
            Assert.assertEquals(menuActualList.get(i).getText(),menuExpectedList.get(i),"Menu Beklenen Gibi Değil");


    }

}
