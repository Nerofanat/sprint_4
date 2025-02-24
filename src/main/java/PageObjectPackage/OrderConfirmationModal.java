package PageObjectPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationModal {

    private WebDriver driver;
    //Само модальное окошко
    private By modalYesNo = By.xpath(".//div [@class = 'Order_ModalHeader__3FDaJ' and contains(text(), 'Хотите оформить заказ')]");
    //Кнопка "Да"
    private By yesButton = By.xpath(".//button [@class = 'Button_Button__ra12g Button_Middle__1CSJM' and contains(text(), 'Да')]");


    public By getModalYesNo() {
        return modalYesNo;
    }

    public OrderConfirmationModal(WebDriver driver) {
        this.driver = driver;
    }

    public void clickYes() {
        driver.findElement(yesButton).click();
    }
}
