package PageObjectPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;
    // НИЖНЯЯ кнопка заказа на основной странице
    private By mainOrderButtonAtTheBottom = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and contains(text(), 'Заказать')]");
    //Кнопка куков
    private By cookieButton = By.id("rcc-confirm-button");
    //Далее перечислены селекторы для кнопок вопросов о важном
    //сколько это стоит и как оплатить?
    private By howMuchButton = By.id("accordion__heading-0");
    //Хочу сразу несколько самокатов! Так можно?
    private By multipleScootersButton = By.id("accordion__heading-1");
    //Как рассчитывается время аренды?
    private By rentСalculationButton = By.id("accordion__heading-2");
    //Можно ли заказать самокат прямо на сегодня?
    private By orderTodayButton = By.id("accordion__heading-3");
    //Можно ли продлить заказ или вернуть самокат раньше?
    private By changeTheRentalTimeButton = By.id("accordion__heading-4");
    //Вы привозите зарядку вместе с самокатом?
    private By chargingButton = By.id("accordion__heading-5");
    //Можно ли отменить заказ?
    private By orderCancellationButton = By.id("accordion__heading-6");
    //Я жизу за МКАДом, привезёте?
    private By areaButton = By.id("accordion__heading-7");
    // А вот тут перечислить селекторы уже текста в выпадашках
    private By howMuch = By.xpath(".//div [@id = 'accordion__panel-0']/p");
    //Хочу сразу несколько самокатов! Так можно?
    private By multipleScooters = By.xpath(".//div [@id = 'accordion__panel-1']/p");
    //Как рассчитывается время аренды?
    private By rentСalculation = By.xpath(".//div [@id = 'accordion__panel-2']/p");
    //Можно ли заказать самокат прямо на сегодня?
    private By orderToday = By.xpath(".//div [@id = 'accordion__panel-3']/p");
    //Можно ли продлить заказ или вернуть самокат раньше?
    private By changeTheRentalTime = By.xpath(".//div [@id = 'accordion__panel-4']/p");
    //Вы привозите зарядку вместе с самокатом?
    private By charging = By.xpath(".//div [@id = 'accordion__panel-5']/p");
    //Можно ли отменить заказ?
    private By orderCancellation = By.xpath(".//div [@id = 'accordion__panel-6']/p");
    //Я жизу за МКАДом, привезёте?
    private By area = By.xpath(".//div [@id = 'accordion__panel-7']/p");

    //Конструктор
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Кликнуть на кнопку заказать
    public void clickMainOrderButton() {
        driver.findElement(mainOrderButtonAtTheBottom).click();
    }

    //Кликнуть на кнопку куки
    public void clickCookieButton() {
        if (driver.findElement(cookieButton).isDisplayed()) {
            driver.findElement(cookieButton).click();
        }
    }

    /* Изначально делал параметризацию так, но потом решил чутка по другому чтобы
    не городить такие методы, а то смысл параметризациии теряется
    */
    //Кликнуть по кнопке
    public void clickButton(int id) {
        if (id == 0) {
            driver.findElement(howMuchButton).click();
        } else if (id == 1) {
            driver.findElement(multipleScootersButton).click();
        } else if (id == 2) {
            driver.findElement(rentСalculationButton).click();
        } else if (id == 3) {
            driver.findElement(orderTodayButton).click();
        } else if (id == 4) {
            driver.findElement(changeTheRentalTimeButton).click();
        } else if (id == 5) {
            driver.findElement(chargingButton).click();
        } else if (id == 6) {
            driver.findElement(orderCancellationButton).click();
        } else {
            driver.findElement(areaButton).click();
        }
    }

    //получить текст вопроса о главном
    public String idText(int id) {
        if (id == 0) {
            return driver.findElement(howMuch).getText();
        } else if (id == 1) {
            return driver.findElement(multipleScooters).getText();
        } else if (id == 2) {
            return driver.findElement(rentСalculation).getText();
        } else if (id == 3) {
            return driver.findElement(orderToday).getText();
        } else if (id == 4) {
            return driver.findElement(changeTheRentalTime).getText();
        } else if (id == 5) {
            return driver.findElement(charging).getText();
        } else if (id == 6) {
            return driver.findElement(orderCancellation).getText();
        } else {
            return driver.findElement(area).getText();
        }
    }

}
