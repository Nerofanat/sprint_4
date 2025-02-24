package PageObjectPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StatusModal {
    private WebDriver driver;
    // Кнопка "Посмотреть статус"
    private By statusButton = By.xpath(".//button [@class = 'Button_Button__ra12g Button_Middle__1CSJM' and contains(text(), 'Посмотреть статус')]");
    // Само окошко
    private By modalStatus = By.xpath(".//div[@class = 'Order_ModalHeader__3FDaJ' and contains(text(), 'оформлен')]");

    public StatusModal(WebDriver driver) {
        this.driver = driver;
    }

    // Для использования в ожиданиях
    public By getModalStatus() {
        return modalStatus;
    }

    // Кликнуть на кнопку "Посмотреть статус"
    public void clickStatusButton() {
        driver.findElement(statusButton).click();
    }

    // Попытка найти и проверить отображение окошка
    /* Мы еще не проходили конструкцию эту, но я не придумал как это можно
    сделать известными средствами, ведь нужно чтобы тест проверил наличие окошка, а если мы не найдем его на этом этапе,
    то мы не сможем попасть на условия теста на ассерт и не получаем нормально сообщение об ошибке */

    public boolean modalStatusBoolean() {
        try {
            return driver.findElement(modalStatus).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            //Обрабатываем ошибку исключение и теперь, если элемент не найден, возвращаем false
            return false;
        }
    }


}
