package Gun06;


import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class _02_PlaceOrderElements {


    public _02_PlaceOrderElements() {
        PageFactory.initElements(BaseDriver.driver,this);
        //constructor oluşturuyorsun
        //static ise driver'ı basedriver.driver şeklinde alıyorsun.

    }

    @FindBy(css="input[placeholder='Search']")
    public WebElement search;

    @FindBy(css="button[class='btn btn-default btn-lg']")
    public WebElement searchButton;

    @FindBy(xpath="(//span[contains(text(),'Add to Cart')])[1]")
    public WebElement addChart;

    @FindBy(xpath="(//a[normalize-space()='shopping cart'])[1]")
    public WebElement chart;

    @FindBy(xpath="(//a[@class='btn btn-primary'])[1]")
    public WebElement cOut;

    @FindBy(css="#button-payment-address")
    public WebElement devam;

    @FindBy(css="#button-shipping-address")
    public WebElement devam2;

    @FindBy(xpath="(//input[@id='button-shipping-method'])[1]")
    public WebElement devam3;

    @FindBy(css="input[value='1']")
    public WebElement terms;

    @FindBy(css="#button-payment-method")
    public WebElement devam4;

    @FindBy(css="#button-confirm")
    public WebElement devam5;


}

