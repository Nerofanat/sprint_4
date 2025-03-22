package PageObjectPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    protected WebDriver driver;
    //Нижняя кнопка заказа на основной странице
    //private By mainOrderButtonAtTheBottom = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and contains(text(), 'Заказать')]");
    private By mainOrderButtonAtTheBottom = By.xpath(".//button[contains(@class, 'Button_Middle')]");
    //Кнопка куков
    private By cookieButton = By.id("rcc-confirm-button");

    //Получить селектор по номеру вопроса
    public static By getQuestionidByQuestionNumber(String questionNumber) {
        return By.id("accordion__heading-".concat(questionNumber));
    }

    //Получить селектор по номеру ответа
    public static By getAnsweridByAnswerNumber(String answerNumber) {
        return By.xpath(".//div [@id = 'accordion__panel-".concat(answerNumber).concat("']/p"));
    }

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

}
