package Provision;

import Exceptions.UndefinedBehaviorException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Provision.Enum.*;

import java.util.Arrays;
import java.util.List;

import static Provision.Constants.TESTING_SITE_URL;


public class BrowserInitialization {

    private static WebDriver driver;

    //Создаем список нужных нам браузеров
    public static final BrowserType[] browserList = BrowserType.values();

    //Основной метод инициализации браузера
    public static WebDriver getBrowserDriver(BrowserType browser) throws UndefinedBehaviorException {
        switch (browser) {
            case CHROME:
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            default:
                throw new UndefinedBehaviorException("В метод getBrowserDriver передан неизвестный браузер " + browser);
        }
        return driver;
    }

    public static void goUrl(WebDriver driver) {
        driver.navigate().to(TESTING_SITE_URL);
    }
    //Не знал о существовании такого подхода, указывал путь к драйверам черещ переменные  сисетмные, так выглядит более удобно. пусит лежит тут
    //public static void setLocalPathsToDrivers() {
    //    System.setProperty("webdriver.chrome.driver", "E:/AutotestDrivers/chromedriver-win64-133/chromedriver.exe");
    //    System.setProperty("webdriver.gecko.driver", "E:/AutotestDrivers/FireFoxDriver/geckodriver.exe");
    //}


}
