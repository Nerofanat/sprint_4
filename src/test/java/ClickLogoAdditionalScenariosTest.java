import Exceptions.UndefinedBehaviorException;
import Provision.BrowserInitialization;
import Provision.Enum;
import Provision.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.support.ui.ExpectedConditions;
import PageObjectPackage.*;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ClickLogoAdditionalScenariosTest {

    private WebDriver driver;

    //Переход по клику на лого самоката на главную
    @Test
    public void clickScooterGoToTheMainPage() throws UndefinedBehaviorException {

        driver = BrowserInitialization.getBrowserDriver(Enum.BrowserType.FIREFOX);
        BrowserInitialization.goUrl(driver);

        SiteHeader header = new SiteHeader(driver);
        header.clickLogoScooter();

        // Получаем список всех открытых вкладок браузера и переключаемся на первую
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));

        // Ожидаем нужный нам урл
        WaitUtils.waitForCondition(driver, ExpectedConditions.urlToBe("https://qa-scooter.praktikum-services.ru/"), 2, "Не дождались URL 'https://qa-scooter.praktikum-services.ru/'");

        String expectedUrl = driver.getCurrentUrl();
        String actual = "https://qa-scooter.praktikum-services.ru/";

        assertEquals(actual, expectedUrl);

    }

    //Переход по клику на лого Яндекса на главную Яндекса
    @Test
    public void checkClickYandexGoToTheMainPageTest() throws UndefinedBehaviorException {

        driver = BrowserInitialization.getBrowserDriver(Enum.BrowserType.FIREFOX);
        BrowserInitialization.goUrl(driver);


        // Клик по кнопке + Переключение на новую вкладку
        SiteHeader header = new SiteHeader(driver);
        header.clickLogoYandex();

        // Получаем список всех открытых вкладок браузера и переключаемся на вторую
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        // Ожидаем нужный нам урл
        WaitUtils.waitForCondition(driver, ExpectedConditions.urlToBe("https://dzen.ru/?yredirect=true"), 2, "Не дождались URL 'https://dzen.ru/?yredirect=true'");

        String expectedUrl = driver.getCurrentUrl();
        String actual = "https://dzen.ru/?yredirect=true";

        assertEquals(actual, expectedUrl);

    }

    @After
    public void teardown() {
        driver.quit();
    }
}
