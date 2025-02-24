import PageObjectPackage.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class QuestionsAboutTheImportant {

    private WebDriver driver;

    //Кнопку на которую мы хотим нажать
    private final String selector;
    //Текст который должен появиться при открытии ответа
    private final String expectedText;

    public QuestionsAboutTheImportant(String selector, String expectedText) {
        this.selector = selector;
        this.expectedText = expectedText;
    }


    @Parameterized.Parameters

    public static Object[][] textComparison() {

        return new Object[][]{
                {"0", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"1", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {"2", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {"3", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {"4", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {"5", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {"6", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {"7", "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Test
    public void questionsAboutTheImportantFirefox() {

        driver = new FirefoxDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage page = new MainPage(driver);
        page.clickCookieButton();


        String headingId = "accordion__heading-" + selector;
        String panelId = "accordion__panel-" + selector;

        WebElement element = driver.findElement(By.id(headingId));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.id(headingId)));

        driver.findElement(By.id(headingId)).click();

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.attributeToBe(By.id(headingId), "aria-disabled", "true"));

        String actual = driver.findElement(By.xpath(".//div[@id='" + panelId + "']/p")).getText();

        //Неактуальный вариант через 2 метода
        //page.clickButton(selector);
        //String actual = page.idText(selector);

        //Сравниваем текст
        assertEquals(expectedText, actual);

    }

    @Test
    public void questionsAboutTheImportantGoogleChrome() {

        driver = new ChromeDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage page = new MainPage(driver);
        page.clickCookieButton();


        String headingId = "accordion__heading-" + selector;
        String panelId = "accordion__panel-" + selector;

        WebElement element = driver.findElement(By.id(headingId));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.id(headingId)));

        driver.findElement(By.id(headingId)).click();

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.attributeToBe(By.id(headingId), "aria-disabled", "true"));

        String actual = driver.findElement(By.xpath(".//div[@id='" + panelId + "']/p")).getText();

        //Сравниваем текст
        assertEquals(expectedText, actual);

    }

    @After
    public void teardown() {
        driver.quit();
    }
}
