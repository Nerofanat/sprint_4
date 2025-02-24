import PageObjectPackage.MainPage;
import PageObjectPackage.OrderStatus;
import PageObjectPackage.SiteHeader;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class IncorrectOrderNumberAdditionalScenarios {
    private WebDriver driver;

    @Test
    public void incorrectOrderNumber() {

        driver = new ChromeDriver();

        MainPage main = new MainPage(driver);
        SiteHeader header = new SiteHeader(driver);
        OrderStatus status = new OrderStatus(driver);

        driver.get("https://qa-scooter.praktikum-services.ru");
        main.clickCookieButton();
        header.clickOrderStatusButton();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(header.getOrderNumber()));
        header.enterTheOrderNumber("88005553535");

        header.clickGoButton();

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));

        String expectedUrl = driver.getCurrentUrl();
        String actualUrl = "https://qa-scooter.praktikum-services.ru/track?t=88005553535";

        assertEquals("Не открылась страница статуса заказа", actualUrl, expectedUrl);

        //тут проверить что картинка c предупреждением есть
        // Возможно тут можно получить прям текст с картинки но мы точно это не проходили
        boolean expected = status.thePictureThereIsNoSuchOrderIsDisplayed();
        assert expected;

    }

    @After
    public void teardown() {
        driver.quit();
    }

}
