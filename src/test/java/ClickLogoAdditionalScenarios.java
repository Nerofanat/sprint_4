import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import PageObjectPackage.*;

import java.time.Duration;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ClickLogoAdditionalScenarios {

    private WebDriver driver;

    //Переход по клику на лого самоката на главную
    @Test
    public void clickScooterGoToTheMainPage() {

        driver = new FirefoxDriver();

        SiteHeader header = new SiteHeader(driver);

        driver.get("https://qa-scooter.praktikum-services.ru");

        header.clickLogoScooter();

        // Получаем список всех открытых вкладок браузера и переключаемся на первую
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));

        // Ожидаем нужный нам урл
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.urlToBe("https://qa-scooter.praktikum-services.ru/"));

        String expectedUrl = driver.getCurrentUrl();
        String actual = "https://qa-scooter.praktikum-services.ru/";

        assertEquals(actual, expectedUrl);

    }

    //Переход по клику на лого Яндекса на главную Яндекса
    @Test
    public void clickYandexGoToTheMainPage() {

        driver = new FirefoxDriver();

        SiteHeader header = new SiteHeader(driver);

        driver.get("https://qa-scooter.praktikum-services.ru");

        // Клик по кнопке + Переключение на новую вкладку

        header.clickLogoYandex();

        // Получаем список всех открытых вкладок браузера и переключаемся на вторую
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        /* Тут поменял urlMatches на urlToBe иначе он видел совпадение но проверка
        почему-то завершалась провалом при равных абсолютно урлах */
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.urlToBe("https://dzen.ru/?yredirect=true"));

        String expectedUrl = driver.getCurrentUrl();
        String actual = "https://dzen.ru/?yredirect=true";

        assertEquals(expectedUrl, actual);

    }

    @After
    public void teardown() {
        driver.quit();
    }
}
