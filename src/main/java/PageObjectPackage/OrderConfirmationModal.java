package PageObjectPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationModal {

    private WebDriver driver;
    //Само модальное окошко
    private By modalYesNo = By.xpath(".//div [contains(@class, 'Order_ModalHeader')]");
    //Кнопка "Да"
    private By yesButton = By.xpath(".//button [contains(text(), 'Да')]");


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
