import Exceptions.UndefinedBehaviorException;
import PageObjectPackage.MainPage;
import PageObjectPackage.OrderStatus;
import PageObjectPackage.SiteHeader;
import Provision.BrowserInitialization;
import Provision.Enum;
import Provision.WaitUtils;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class IncorrectOrderNumberAdditionalScenariosTest {
    private WebDriver driver;

    @Test
    public void checkIncorrectOrderNumberTest() throws UndefinedBehaviorException {

        driver = BrowserInitialization.getBrowserDriver(Enum.BrowserType.CHROME);

        MainPage main = new MainPage(driver);
        SiteHeader header = new SiteHeader(driver);
        OrderStatus status = new OrderStatus(driver);

        BrowserInitialization.goToUrl(driver);
        main.clickCookieButton();
        header.clickOrderStatusButton();

        WaitUtils.waitForCondition(driver, ExpectedConditions.elementToBeClickable(header.getOrderNumber()), 5, "Не открылось окно стутуса заказа");
        header.enterTheOrderNumber("88005553535");

        header.clickGoButton();

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));

        String expectedUrl = driver.getCurrentUrl();
        String actualUrl = "https://qa-scooter.praktikum-services.ru/track?t=88005553535";

        assertEquals("Не открылась страница статуса заказа", actualUrl, expectedUrl);

        //тут проверить что картинка c предупреждением есть
        boolean expected = status.PictureThereIsNoSuchOrderIsDisplayed();
        assert expected;

    }

    @After
    public void teardown() {
        driver.quit();
    }

}
