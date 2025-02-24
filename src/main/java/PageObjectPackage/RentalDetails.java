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
    //1 сутки
    private By day_1 = By.xpath(".//div[contains (@class, 'Dropdown-option') and contains(text(), 'сутки')]");
    //2 суток
    private By day_2 = By.xpath(".//div[contains (@class, 'Dropdown-option') and contains(text(), 'двое суток')]");
    //3 суток
    private By day_3 = By.xpath(".//div[contains (@class, 'Dropdown-option') and contains(text(), 'трое суток')]");
    //4 суток
    private By day_4 = By.xpath(".//div[contains (@class, 'Dropdown-option') and contains(text(), 'четверо суток')]");
    //5 суток
    private By day_5 = By.xpath(".//div[contains (@class, 'Dropdown-option') and contains(text(), 'пятеро суток')]");
    //6 суток
    private By day_6 = By.xpath(".//div[contains (@class, 'Dropdown-option') and contains(text(), 'шестеро суток')]");
    //7 суток
    private By day_7 = By.xpath(".//div[contains (@class, 'Dropdown-option') and contains(text(), 'семеро суток')]");
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

    public By getRentalDetailsWindow() {
        return rentalDetailsWindow;
    }

    public void fillOutTheRentalDetailsForm(String whenToBring, String period, String color, String yoursComment) {
        driver.findElement(whenToBringTheScooter).clear();
        driver.findElement(whenToBringTheScooter).sendKeys(whenToBring);
        driver.findElement(rightDay).click();
        driver.findElement(rentalPeriod).click();
        if (period.equals("1")) {
            driver.findElement(day_1).click();
        } else if (period.equals("2")) {
            driver.findElement(day_2).click();
        } else if (period.equals("3")) {
            driver.findElement(day_3).click();
        } else if (period.equals("4")) {
            driver.findElement(day_4).click();
        } else if (period.equals("5")) {
            driver.findElement(day_5).click();
        } else if (period.equals("6")) {
            driver.findElement(day_6).click();
        } else {
            //не знаю как в данном случае лучше поступить
            driver.findElement(day_7).click();
        }

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
