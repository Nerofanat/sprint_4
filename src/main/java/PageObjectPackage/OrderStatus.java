package PageObjectPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderStatus {

    //Текст  имени и фамилии на странице
    public String textName;
    public String textSurname;

    private WebDriver driver;
    //Поле ввода номера заказа для поиска
    private By inputOrderNumber = By.className("Input_Input__1iN_Z.Track_Input__1g7lq.Input_Responsible__1jDKN");
    //Кнопка для поиска по номеру заказа
    private By searchButton = By.xpath(".//button [@class = 'Button_Button__ra12g Button_Middle__1CSJM' and contains(text(), 'Посмотреть')]");
    //Кнопка для отмены заказа
    private By orderCancellation = By.xpath(".//button [@class = 'Button_Button__ra12g Button_Middle__1CSJM' and contains(text(), 'Отменить заказ')]");
    //Картинка с предупреждением что заказ не найден
    private By thePictureThereIsNoSuchOrder = By.xpath(".//img [@src = '/assets/not-found.png']");
    // Селекторы полей из информации по заказу (проверю ради интереса имя и фамилию)
    // имя
    private By name = By.xpath(".//div[@class = 'Track_Row__1sN1F']/div[@class = 'Track_Title__1XfhB' and contains(text(), 'Имя')]/following-sibling::div[@class='Track_Value__15eEX']");
    //фамилия
    private By surname = By.xpath(".//div[@class = 'Track_Row__1sN1F']/div[@class = 'Track_Title__1XfhB' and contains(text(), 'Фамилия')]/following-sibling::div[@class='Track_Value__15eEX']");

    public OrderStatus(WebDriver driver) {
        this.driver = driver;
    }

    public boolean thePictureThereIsNoSuchOrderIsDisplayed() {
        return driver.findElement(thePictureThereIsNoSuchOrder).isDisplayed();
    }

    //Получить текст из имени и фамилии
    public void textNameAndSurname() {
        textName = driver.findElement(name).getText();
        textSurname = driver.findElement(surname).getText();
    }


}
