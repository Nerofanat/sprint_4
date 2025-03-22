import Exceptions.UndefinedBehaviorException;
import PageObjectPackage.MainPage;
import Provision.BrowserInitialization;
import Provision.WaitUtils;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.support.ui.ExpectedConditions;
import PageObjectPackage.*;

import static org.junit.Assert.*;

import Provision.Enum.*;

@RunWith(Parameterized.class)
public class OrderingScooterTest {

    private WebDriver driver;
    private final BrowserType browser;
    private final String button;

    //Улучшенный конструктор который умеет в ловлю исключения для случая, когда переданное значение не из enum
    public OrderingScooterTest(Object browser, String button) {
        try {
            this.browser = (BrowserType) browser;
        } catch (ClassCastException e) {
            throw new ClassCastException("Неверный тип браузера");
        }
        this.button = button;
    }

    @Parameterized.Parameters(name = "{index}: browser={0}, button={1}")
    public static Object[][] browserAndButton() {

        return new Object[][]{
                //{BrowserType.CHROME, "UP"},
                //{BrowserType.CHROME, "DOWN"},
                //{BrowserType.FIREFOX, "UP"},
                {BrowserType.FIREFOX, "DOWN"},
        };
    }

    @Test
    public void checkMakingAnOrderTest() throws UndefinedBehaviorException {

        //Инициализируем браузер и переходим по ссылке
        driver = BrowserInitialization.getBrowserDriver(browser);
        BrowserInitialization.goUrl(driver);

        //Начинаем оформление на главной странице
        MainPage page = new MainPage(driver);
        SiteHeader headerUp = new SiteHeader(driver);
        page.clickCookieButton();

        //Логика в зависимости от выбора кнопки
        switch (button) {
            case "UP":
                page.clickMainOrderButton();
                break;
            case "DOWN":
                headerUp.clickOrderButtonAtTheTop();
                break;
            default:
                throw new UndefinedBehaviorException("Кнопки " + button + " не ожидается в тесте, ожидаем значение UP или DOWN");
        }

        //Заполняем первую форму
        WhoIsTheScooterFor scooterForYou = new WhoIsTheScooterFor(driver);
        scooterForYou.fillOutTheOrderForm("Даниил", "Кондрашов", "Рязанские просторы", "Красные Ворота", "89969108932");

        //Ждем открытия второй формы и заполняем вторую форму
        RentalDetails rentalForYou = new RentalDetails(driver);
        WaitUtils.waitForCondition(driver, ExpectedConditions.numberOfElementsToBe(rentalForYou.getRentalDetailsWindow(), 1), 3, "Форма RentalDetailsWindow не обнаружена");
        rentalForYou.fillOutRentalDetailsForm("12", 3, "серая", "Пробуем ввести комментарий");

        //Ждем появление модального окна и кликаем по кнопке "Да" в модальном окне... и ловим блокер
        OrderConfirmationModal confirmationModal = new OrderConfirmationModal(driver);
        WaitUtils.waitForCondition(driver, ExpectedConditions.numberOfElementsToBe(confirmationModal.getModalYesNo(), 1), 3, "Модальное окно confirmationModal не появилось");
        confirmationModal.clickYes();

        //проверяем наличие окна об успешном заказе самоката
        StatusModal modalWindow = new StatusModal(driver);
        WaitUtils.waitForCondition(driver, ExpectedConditions.numberOfElementsToBe(modalWindow.getModalStatus(), 1), 3, "Модальное окошко об успешном заказе не появилось");

        boolean actualResult = modalWindow.modalStatusBoolean();
        assertTrue("Модальное окно, подтверждающее оформление заказа, не появилось", actualResult);

    }


    // дополнительный тест (ради интереса) в мозиле где проверяю что имя и фамилия которые я ввел корректно отображаются на странице информации о заказе
    @Test
    public void checkMatchingTheSpecifiedDataToThoseDisplayedOnOrderStatusTest() throws UndefinedBehaviorException {

        //Инициализируем браузер и переходим по ссылке
        driver = BrowserInitialization.getBrowserDriver(browser);
        BrowserInitialization.goUrl(driver);

        //Начинаем оформление на главной странице
        MainPage page = new MainPage(driver);
        page.clickCookieButton();
        SiteHeader headerUp = new SiteHeader(driver);
        headerUp.clickOrderButtonAtTheTop();

        //Заполняем первую форму
        WhoIsTheScooterFor scooterForYou = new WhoIsTheScooterFor(driver);
        scooterForYou.fillOutTheOrderForm("Даниил", "Кондрашов", "Рязанские просторы", "Красные Ворота", "89969108932");

        //Ждем открытия второй формы и заполняем вторую форму
        RentalDetails rentalForYou = new RentalDetails(driver);
        WaitUtils.waitForCondition(driver, ExpectedConditions.numberOfElementsToBe(rentalForYou.getRentalDetailsWindow(), 1), 3, "Форма RentalDetailsWindow не обнаружена");
        rentalForYou.fillOutRentalDetailsForm("12", 3, "серая", "Пробуем ввести комментарий");

        //Ждем появление модального окна и кликаем по кнопке "Да" в модальном окне... и ловим блокер
        OrderConfirmationModal confirmationModal = new OrderConfirmationModal(driver);
        WaitUtils.waitForCondition(driver, ExpectedConditions.numberOfElementsToBe(confirmationModal.getModalYesNo(), 1), 3, "Модальное окно не появилось");
        confirmationModal.clickYes();

        //проверяем наличие окна об успешном заказе самоката
        StatusModal modalWindow = new StatusModal(driver);
        WaitUtils.waitForCondition(driver, ExpectedConditions.numberOfElementsToBe(modalWindow.getModalStatus(), 1), 3, "Модальное окошко об успешном заказе не появилось");
        modalWindow.clickStatusButton();

        //Получить имя и фамилию отображаемые на странице заказа
        OrderStatus orderWindow = new OrderStatus(driver);

        // !!!!!!!!!! Потом добавить ожидание (если захочется)
        orderWindow.textNameAndSurname();

        //СРавниваем имена (Нужно точно получить текст элемента)
        assertEquals(scooterForYou.textName, orderWindow.textName);

        //Сравниваем фамилию
        assertEquals(scooterForYou.textSurname, orderWindow.textSurname);

    }

    @After
    public void teardown() {
        driver.quit();
    }
}

