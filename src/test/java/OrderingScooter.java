import PageObjectPackage.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import PageObjectPackage.*;
import java.time.Duration;
import static org.junit.Assert.*;

public class OrderingScooter {

    private WebDriver driver;

    //Тест на появление диалогового окна об успешном заказе самоката при заказе через нижнюю кнопку на основной странице
    @Test
    public void makingAnOrderInTheGoogleChromeTheButtonAtTheBottomOfThePage() {
        //Создаем вебдрайвер
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        //Начинаем оформление на главной странице
        MainPage page = new MainPage(driver);
        page.clickCookieButton();
        page.clickMainOrderButton();

        //Заполняем первую форму
        WhoIsTheScooterFor scooterForYou = new WhoIsTheScooterFor(driver);
        scooterForYou.fillOutTheOrderForm("Даниил", "Кондрашов", "Рязанские просторы", "Красные Ворота", "89969108932");

        //Ждем открытия второй формы и заполняем вторую форму
        RentalDetails rentalForYou = new RentalDetails(driver);
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.numberOfElementsToBe(rentalForYou.getRentalDetailsWindow(), 1));
        rentalForYou.fillOutTheRentalDetailsForm("12", "3", "серая", "Пробуем ввести комментарий");
        //Ждем появление модального окна и кликаем по кнопке "Да" в модальном окне... и ловим блокер
        OrderConfirmationModal confirmationModal = new OrderConfirmationModal(driver);
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.numberOfElementsToBe(confirmationModal.getModalYesNo(), 1));
        confirmationModal.clickYes();
        //проверяем наличие окна об успешном заказе самоката

        StatusModal modalWindow = new StatusModal(driver);
        /*Опять, если оставлю тут ожидание упадем на нем и не дойдем до конца теста,
         не придумал как решить проблему известными мне методами, обработку исключений и списки пока не проходили
         я чекнул, исключения проходить их будем в следующем спринте по юнит тестированию*/
        // new WebDriverWait(driver, Duration.ofSeconds(3))
        //        .until(ExpectedConditions.numberOfElementsToBe(modalWindow.getModalStatus(), 1));
        boolean actualResult = modalWindow.modalStatusBoolean();
        assertTrue("Модальное окно, подтверждающее оформление заказа, не появилось", actualResult);

    }

    // тест в хроме через вернюю кнопку
    @Test
    public void makingAnOrderInTheGoogleChromeTheButtonAtTheTopfThePage() {
        //Создаем вебдрайвер
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

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
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.numberOfElementsToBe(rentalForYou.getRentalDetailsWindow(), 1));
        rentalForYou.fillOutTheRentalDetailsForm("12", "3", "серая", "Пробуем ввести комментарий");
        //Ждем появление модального окна и кликаем по кнопке "Да" в модальном окне... и ловим блокер
        OrderConfirmationModal confirmationModal = new OrderConfirmationModal(driver);
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.numberOfElementsToBe(confirmationModal.getModalYesNo(), 1));
        confirmationModal.clickYes();
        //проверяем наличие окна об успешном заказе самоката
        StatusModal modalWindow = new StatusModal(driver);
        //new WebDriverWait(driver, Duration.ofSeconds(3))
        //        .until(ExpectedConditions.numberOfElementsToBe(modalWindow.getModalStatus(), 1));
        boolean actualResult = modalWindow.modalStatusBoolean();
        assertTrue("Модальное окно, подтверждающее оформление заказа, не появилось", actualResult);

    }

    // тест в мозиле нижняя кнопка
    @Test
    public void makingAnOrderInTheFirefoxTheButtonAtTheBottomOfThePage() {
        //Создаем вебдрайвер
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        //Начинаем оформление на главной странице
        MainPage page = new MainPage(driver);
        page.clickCookieButton();
        page.clickMainOrderButton();

        //Заполняем первую форму
        WhoIsTheScooterFor scooterForYou = new WhoIsTheScooterFor(driver);
        scooterForYou.fillOutTheOrderForm("Даниил", "Кондрашов", "Рязанские просторы", "Красные Ворота", "89969108932");

        //Ждем открытия второй формы и заполняем вторую форму
        RentalDetails rentalForYou = new RentalDetails(driver);
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.numberOfElementsToBe(rentalForYou.getRentalDetailsWindow(), 1));
        rentalForYou.fillOutTheRentalDetailsForm("12", "3", "серая", "Пробуем ввести комментарий");
        //Ждем появление модального окна и кликаем по кнопке "Да" в модальном окне... и ловим блокер
        OrderConfirmationModal confirmationModal = new OrderConfirmationModal(driver);
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.numberOfElementsToBe(confirmationModal.getModalYesNo(), 1));
        confirmationModal.clickYes();
        //проверяем наличие окна об успешном заказе самоката

        StatusModal modalWindow = new StatusModal(driver);
        //new WebDriverWait(driver, Duration.ofSeconds(3))
        //        .until(ExpectedConditions.numberOfElementsToBe(modalWindow.getModalStatus(), 1));
        boolean actualResult = modalWindow.modalStatusBoolean();
        assertTrue("Модальное окно, подтверждающее оформление заказа, не появилось", actualResult);

    }

    // тест в мозиле верхняя кнопка
    @Test
    public void makingAnOrderInTheFirefoxTheButtonAtTheTopfThePage() {
        //Создаем вебдрайвер
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

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
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.numberOfElementsToBe(rentalForYou.getRentalDetailsWindow(), 1));
        rentalForYou.fillOutTheRentalDetailsForm("12", "3", "серая", "Пробуем ввести комментарий");
        //Ждем появление модального окна и кликаем по кнопке "Да" в модальном окне... и ловим блокер
        OrderConfirmationModal confirmationModal = new OrderConfirmationModal(driver);
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.numberOfElementsToBe(confirmationModal.getModalYesNo(), 1));
        confirmationModal.clickYes();
        //проверяем наличие окна об успешном заказе самоката

        StatusModal modalWindow = new StatusModal(driver);
        //new WebDriverWait(driver, Duration.ofSeconds(3))
        //        .until(ExpectedConditions.numberOfElementsToBe(modalWindow.getModalStatus(), 1));
        boolean actualResult = modalWindow.modalStatusBoolean();
        assertTrue("Модальное окно, подтверждающее оформление заказа, не появилось", actualResult);

    }

    // дополнительный тест (ради интереса) в мозиле где проверяю что имя и фамилия которые я ввел корректно отображаются на странице информации о заказе
    @Test
    public void matchingTheSpecifiedDataToThoseDisplayedOnOrderStatus() {
        //Создаем вебдрайвер
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

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
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.numberOfElementsToBe(rentalForYou.getRentalDetailsWindow(), 1));
        rentalForYou.fillOutTheRentalDetailsForm("12", "3", "серая", "Пробуем ввести комментарий");
        //Ждем появление модального окна и кликаем по кнопке "Да" в модальном окне... и ловим блокер
        OrderConfirmationModal confirmationModal = new OrderConfirmationModal(driver);
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.numberOfElementsToBe(confirmationModal.getModalYesNo(), 1));
        confirmationModal.clickYes();
        //Попасть на старницу статуса заказа
        StatusModal modalWindow = new StatusModal(driver);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.numberOfElementsToBe(modalWindow.getModalStatus(), 1));
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

