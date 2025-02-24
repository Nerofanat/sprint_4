import PageObjectPackage.MainPage;
import PageObjectPackage.WhoIsTheScooterFor;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class CheckingForFormErrorsAdditionalScenarios {

    private WebDriver driver;

    //Проверяем ошибки первой формы( это доп задание, так что решил просто первую форму проверить)
    //Не помню что там по требованиям, буду считать что валидация завязана на кнопку далее
    @Test
    public void checkingForTheFirstFormErrors() {

        //Создаем вебдрайвер
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        //Начинаем оформление на главной странице
        MainPage page = new MainPage(driver);
        page.clickCookieButton();
        page.clickMainOrderButton();

        // Жмем на кнопку далее
        WhoIsTheScooterFor scooterForYou = new WhoIsTheScooterFor(driver);
        scooterForYou.buttonNextClick();

        //Проверяем появление ошибок
        boolean expectedNameError = scooterForYou.errorNameIsDesplaid();
        boolean expectedSurnameError = scooterForYou.errorSurnameIsDesplaid();
        boolean expectedAddressError = scooterForYou.errorAddressIsDesplaid();
        boolean expectedMetroStationError = scooterForYou.errorMetroStationIsDesplaid();
        boolean expectedPhoneNumberError = scooterForYou.errorPhoneNumberIsDesplaid();
        boolean actualError = true;

        //Может тут просто ассерт использовать, но тогда не получится всучить сообщение об ошибке
        assertEquals("Не отображается ошибка о некорректном вводе Имени", expectedNameError, actualError);
        assertEquals("Не отображается ошибка о некорректном вводе Фамилии", expectedSurnameError, actualError);
        assertEquals("Не отображается ошибка о некорректном вводе Адреса", expectedAddressError, actualError);
        assertEquals("Не отображается ошибка о некорректном вводе Станции метро", expectedMetroStationError, actualError);
        assertEquals("Не отображается ошибка о некорректном вводе Номера телефона", expectedPhoneNumberError, actualError);

    }

    @After
    public void teardown() {
        driver.quit();
    }
}
