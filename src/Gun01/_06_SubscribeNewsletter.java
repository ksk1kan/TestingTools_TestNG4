package Gun01;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
  Senaryo
  1- Siteyi açınız.
  2- Newsletter  Subscribe işlemini abone lunuz(YES)
 */

public class _06_SubscribeNewsletter extends BaseDriver {

    @Test
    void subscribeFunctionYes()
    {
        WebElement newsletter = driver.findElement(By.xpath("//*[@id=\"content\"]/ul[4]/li/a"));
        newsletter.click();

        WebElement yesButton = driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset/div/div/label[1]/input"));
        yesButton.click();

        WebElement contButton = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div[2]/input"));
        contButton.click();

        WebElement msgLabel = driver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible'"));

        Assert.assertTrue(msgLabel.getText().toLowerCase().contains("success"));

    }

}
