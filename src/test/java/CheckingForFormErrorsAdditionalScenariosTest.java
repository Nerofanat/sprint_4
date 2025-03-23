import Exceptions.UndefinedBehaviorException;
import PageObjectPackage.MainPage;
import PageObjectPackage.WhoIsTheScooterFor;
import Provision.BrowserInitialization;
import Provision.Enum;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class CheckingForFormErrorsAdditionalScenariosTest {

    private WebDriver driver;

    //Проверяем ошибки первой формы( это доп задание, так что решил просто первую форму проверить)
    @Test
    public void checkForTheFirstFormErrorsTest() throws UndefinedBehaviorException {

        //Создаем вебдрайвер
        driver = BrowserInitialization.getBrowserDriver(Enum.BrowserType.FIREFOX);
        BrowserInitialization.goToUrl(driver);

        //Начинаем оформление на главной странице
        MainPage page = new MainPage(driver);
        page.clickCookieButton();
        page.clickMainOrderButton();

        // Жмем на кнопку далее
        WhoIsTheScooterFor scooterForYou = new WhoIsTheScooterFor(driver);
        scooterForYou.buttonNextClick();

        //Проверяем появление ошибок
        boolean actualNameError = scooterForYou.errorTextFieldIsDisplayed(scooterForYou.getErrorName());
        boolean actualSurnameError = scooterForYou.errorTextFieldIsDisplayed(scooterForYou.getErrorSurname());
        boolean actualAddressError = scooterForYou.errorTextFieldIsDisplayed(scooterForYou.getErrorAddress());
        boolean actualMetroStationError = scooterForYou.errorTextFieldIsDisplayed(scooterForYou.getErrorMetroStation());
        boolean actualPhoneNumberError = scooterForYou.errorTextFieldIsDisplayed(scooterForYou.getErrorPhoneNumber());
        boolean expectedError = true;

        //Может тут просто ассерт использовать, но тогда не получится всучить сообщение об ошибке
        assertEquals("Не отображается ошибка о некорректном вводе Имени", expectedError, actualNameError);
        assertEquals("Не отображается ошибка о некорректном вводе Фамилии", expectedError, actualSurnameError);
        assertEquals("Не отображается ошибка о некорректном вводе Адреса", expectedError, actualAddressError);
        assertEquals("Не отображается ошибка о некорректном вводе Станции метро", expectedError, actualMetroStationError);
        assertEquals("Не отображается ошибка о некорректном вводе Номера телефона", expectedError, actualPhoneNumberError);

    }

    @After
    public void teardown() {
        driver.quit();
    }
}
