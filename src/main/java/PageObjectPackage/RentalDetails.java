package PageObjectPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RentalDetails {

    private WebDriver driver;


    //Сама форма
    private By rentalDetailsWindow = By.xpath(".//div[@class = 'Order_Header__BZXOb' and contains(text(), 'Про аренду')]");
    //Когда привезти самокат
    private By whenToBringTheScooter = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    //нужный день в календаре
    private By rightDay = By.className("react-datepicker__day--selected");
    //Период аренды
    private By rentalPeriod = By.className("Dropdown-root");
    //Цвет
    private By colorSelection = By.className("Order_Checkboxes__3lWSI");
    //Цвет черный жемчуг
    private By blackPearl = By.id("black");
    //Цвет серая безысходность
    private By grey = By.id("grey");
    //Комментарий для курьера
    private By comment = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    //Кнопка Заказать
    private By orderButton = By.xpath(".//button [@class = 'Button_Button__ra12g Button_Middle__1CSJM' and contains(text(), 'Заказать')]");

    public RentalDetails(WebDriver driver) {
        this.driver = driver;
    }

    //Получить селектор по номеру дня (с иключениями не заморачивался)
    public static By getDaySelector(int dayNamber) {
        int dayNumber = dayNamber;
        String[] dayNames = {
                "сутки",
                "двое суток",
                "трое суток",
                "четверо суток",
                "пятеро суток",
                "шестеро суток",
                "семеро суток"
        };

        return By.xpath(".//div[contains(text(), '" + dayNames[dayNumber - 1] + "')]");
    }

    public By getRentalDetailsWindow() {
        return rentalDetailsWindow;
    }

    public void fillOutRentalDetailsForm(String whenToBring, int period, String color, String yoursComment) {
        driver.findElement(whenToBringTheScooter).clear();
        driver.findElement(whenToBringTheScooter).sendKeys(whenToBring);
        driver.findElement(rightDay).click();
        driver.findElement(rentalPeriod).click();

        driver.findElement(getDaySelector(period)).click();

        if (color.contains("жемчуг")) {
            driver.findElement(blackPearl).click();
        } else {
            //не знаю как в данном случае лучше поступить (мб нужно вернуть ошибку)
            driver.findElement(grey).click();
        }

        driver.findElement(comment).clear();
        driver.findElement(comment).sendKeys(yoursComment);
        driver.findElement(orderButton).click();

    }

}
