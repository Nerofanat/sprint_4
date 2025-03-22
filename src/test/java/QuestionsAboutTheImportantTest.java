import Exceptions.UndefinedBehaviorException;
import PageObjectPackage.MainPage;
import Provision.BrowserInitialization;
import Provision.Enum;
import Provision.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class QuestionsAboutTheImportantTest {

    private WebDriver driver;

    //Кнопку на которую мы хотим нажать
    private final Enum.BrowserType browser;

    private final String[][] compareTexts = new String[][]{
            {"0", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
            {"1", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
            {"2", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
            {"3", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
            {"4", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
            {"5", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
            {"6", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
            {"7", "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
    };

    public QuestionsAboutTheImportantTest(Enum.BrowserType browser) {
        this.browser = browser;
    }


    @Parameterized.Parameters
    public static Object[] browser() {
        return BrowserInitialization.browserList;
    }


    @Test
    public void checkQuestionsAboutTheImportantFirefoxTest() throws UndefinedBehaviorException {
        checkQuestionsAboutTheImportant(browser);
    }

    private void checkQuestionsAboutTheImportant(Enum.BrowserType browser) throws UndefinedBehaviorException {

        driver = BrowserInitialization.getBrowserDriver(browser);
        BrowserInitialization.goUrl(driver);

        MainPage page = new MainPage(driver);
        page.clickCookieButton();


        for (String[] elements : compareTexts) {

            By questionId = MainPage.getQuestionidByQuestionNumber(elements[0]);
            By answerId = MainPage.getAnsweridByAnswerNumber(elements[0]);
            String expectedText = elements[1];

            WebElement question = driver.findElement(questionId);

            //Подскролл к списку вопросов
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", question);

            //Ждем когда появятся на экране вопросы
            WaitUtils.waitForCondition(driver, ExpectedConditions.elementToBeClickable(questionId), 5, "Вопрос " + questionId + " на экране не отображается");

            //Кликнуть на вопрос
            driver.findElement(questionId).click();

            //Ждем открытия выпадашки с ответом
            WaitUtils.waitForCondition(driver, ExpectedConditions.visibilityOfElementLocated(answerId), 3, "Выпадашка с ответом" + answerId + "не отображается");

            //Получаем фактический ответ
            String actual = driver.findElement(answerId).getText();

            //Сравниваем ожидаемый и фактический результат
            assertEquals(expectedText, actual);
        }

    }

    @After
    public void teardown() {
        driver.quit();
    }
}

