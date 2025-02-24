package PageObjectPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WhoIsTheScooterFor {

    private WebDriver driver;
    public String textName;
    public String textSurname;
    private By name = By.xpath(".//input[@placeholder = '* Имя']");
    private By surname = By.xpath(".//input[@placeholder = '* Фамилия']");
    private By address = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    private By metroStation = By.xpath(".//input[@placeholder = '* Станция метро']");
    //Выпадашка со списком станций
    private By listMetroStation = By.className("select-search__select");
    private By phoneNumber = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    private By buttonNext = By.xpath(".//button [@class = 'Button_Button__ra12g Button_Middle__1CSJM' and contains(text(), 'Далее')]");
    private By errorName = By.xpath(".//div [@class = 'Input_ErrorMessage__3HvIb Input_Visible___syz6' and contains (text(), 'Введите корректное имя')]");
    private By errorSurname = By.xpath(".//div [@class = 'Input_ErrorMessage__3HvIb Input_Visible___syz6' and contains (text(), 'Введите корректную фамилию')]");
    private By errorAddress = By.xpath(".//div [@class = 'Input_ErrorMessage__3HvIb Input_Visible___syz6' and contains (text(), 'Введите корректный адрес')]");
    private By errorMetroStation = By.xpath(".//div [@class = 'Input_ErrorMessage__3HvIb Input_Visible___syz6' and contains (text(), 'Выберите станцию')]");
    private By errorPhoneNumber = By.xpath(".//div [@class = 'Input_ErrorMessage__3HvIb Input_Visible___syz6' and contains (text(), 'Введите корректный номер')]");


    public WhoIsTheScooterFor(WebDriver driver) {
        this.driver = driver;
    }

    //Заполнить форму "Для кого самокат" и перейти к след форме
    public void fillOutTheOrderForm(String yoursName, String yoursSurname, String yoursAddress, String yoursMetro, String yoursNumber) {
        driver.findElement(name).clear();
        driver.findElement(name).sendKeys(yoursName);
        driver.findElement(surname).clear();
        driver.findElement(surname).sendKeys(yoursSurname);
        driver.findElement(address).clear();
        driver.findElement(address).sendKeys(yoursAddress);
        driver.findElement(metroStation).clear();
        driver.findElement(metroStation).sendKeys(yoursMetro);
        //Выбрать из списка введенное значение и кликнуть на него
        //driver.findElement(listMetroStation).findElement(By.xpath("//button[contains(text(), '" + yoursMetro + "') and @value = '1']")).click();
        driver.findElement(listMetroStation).findElement(By.xpath("//ul[@class='select-search__options']/li[1]")).click();
        driver.findElement(phoneNumber).clear();
        driver.findElement(phoneNumber).sendKeys(yoursNumber);
        //Получить поля Имя Фамилия и записать их в переменные
        this.textSurname = yoursSurname;
        this.textName = yoursName;
        //Кликнуть по кнопке далее
        driver.findElement(buttonNext).click();
    }

    //Метод используется для проверки предупреждений об ошибках 1 формы
    public void fillOutTheOrderFormExceptForTheMetroStation(String yoursName, String yoursSurname, String yoursAddress, String yoursNumber) {
        driver.findElement(name).clear();
        driver.findElement(name).sendKeys(yoursName);
        driver.findElement(surname).clear();
        driver.findElement(surname).sendKeys(yoursSurname);
        driver.findElement(address).clear();
        driver.findElement(address).sendKeys(yoursAddress);
        driver.findElement(phoneNumber).clear();
        driver.findElement(phoneNumber).sendKeys(yoursNumber);
        //Кликнуть по кнопке далее
        driver.findElement(buttonNext).click();
    }

    public void buttonNextClick() {
        driver.findElement(buttonNext).click();
    }

    public boolean errorNameIsDesplaid() {
        try {
            return driver.findElement(errorName).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean errorSurnameIsDesplaid() {
        try {
            return driver.findElement(errorSurname).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean errorAddressIsDesplaid() {
        try {
            return driver.findElement(errorAddress).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean errorMetroStationIsDesplaid() {
        try {
            return driver.findElement(errorMetroStation).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean errorPhoneNumberIsDesplaid() {
        try {
            return driver.findElement(errorPhoneNumber).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

}
