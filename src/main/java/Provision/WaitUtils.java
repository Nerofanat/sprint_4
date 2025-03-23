package Provision;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//универсальный метод для работы с исключениями при ожиданиях
public class WaitUtils {
    public static void waitForCondition(WebDriver driver, ExpectedCondition<?> condition, int timeout, String message) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(timeout))
                    .until(condition);
        } catch (TimeoutException e) {
            System.out.println(message != null ? message : "Ожидание завершилось неудачно");
        }
    }
}
