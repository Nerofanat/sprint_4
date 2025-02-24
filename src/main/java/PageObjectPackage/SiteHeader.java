package PageObjectPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SiteHeader {

    private WebDriver driver;
    //лого Яндекса
    private By logoYandex = By.className("Header_LogoYandex__3TSOI");
    //лого Самоката
    private By logoScooter = By.className("Header_LogoScooter__3lsAR");
    //Кнопка заказа
    private By orderButtonAtTheTop = By.xpath(".//div[@class = 'Header_Nav__AGCXC']/button[@class = 'Button_Button__ra12g']");
    //Кнопка статуса заказа Header_Link__1TAG7
    private By orderStatusButton = By.xpath(".//div[@class = 'Header_Nav__AGCXC']/button[@class = 'Header_Link__1TAG7']");
    //поле ввода номера заказа в шапке
    private By orderNumber = By.xpath(".//input[@class = 'Input_Input__1iN_Z Header_Input__xIoUq' and @placeholder = 'Введите номер заказа']");
    //странная кнопка GO
    private By goButton = By.xpath(".//button[@class = 'Button_Button__ra12g Header_Button__28dPO' and contains (text(), 'Go!')]");

    public SiteHeader(WebDriver driver) {
        this.driver = driver;
    }

    public By getOrderNumber() {
        return orderNumber;
    }

    public void clickLogoYandex() {
        driver.findElement(logoYandex).click();
    }

    public void clickLogoScooter() {
        driver.findElement(logoScooter).click();
    }

    public void clickOrderStatusButton() {
        driver.findElement(orderStatusButton).click();
    }

    public void clickOrderButtonAtTheTop() {
        driver.findElement(orderButtonAtTheTop).click();
    }

    //Метод на ввод номера заказа в поле
    public void enterTheOrderNumber(String number) {
        driver.findElement(orderNumber).sendKeys(number);
    }

    //Метод нажатия на кнопку Go
    public void clickGoButton() {
        driver.findElement(goButton).click();
    }


}
