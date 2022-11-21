package Gun02_Dependency;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class _01_SubscribeNewsletter extends BaseDriver {

    By newlink = By.xpath("//*[@id=\"content\"]/ul[4]/li/a");
    By yes = By.xpath("//*[@id=\"content\"]/form/fieldset/div/div/label[1]/input");
    By cont = By.xpath("//*[@id=\"content\"]/form/div/div[2]/input");
    By no = By.xpath("//*[@id=\"content\"]/form/fieldset/div/div/label[2]/input");

    @Test (priority = 1)
    void subscribeFunctionYes()
    {
        WebElement newsletter = driver.findElement(newlink);
        newsletter.click();

        Tools.Bekle(2);
        WebElement yesButton = driver.findElement(yes);
        yesButton.click();

        Tools.Bekle(2);
        WebElement contButton = driver.findElement(cont);
        contButton.click();

        Tools.Bekle(2);
        Tools.successMessageValidation();

    }

    @Test (priority = 2)
    void subscribeFunctionNo()
    {
        WebElement newsletter = driver.findElement(newlink);
        newsletter.click();

        WebElement noButton = driver.findElement(no);
        noButton.click();

        Tools.Bekle(2);
        WebElement contButton = driver.findElement(cont);
        contButton.click();

        Tools.Bekle(2);
        Tools.successMessageValidation();

    }

    @Test (priority = 3)
    void subscribeFunctionCheck()
    {
        WebElement newsletter = driver.findElement(newlink);
        newsletter.click();

        WebElement yesButton = driver.findElement(yes);
        WebElement noButton = driver.findElement(no);

        Tools.Bekle(2);
        if(yesButton.isSelected())
            noButton.click();
        else
            yesButton.click();

        Tools.Bekle(2);
        WebElement contButton = driver.findElement(cont);
        contButton.click();
    }

}