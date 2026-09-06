package org.example.ui.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Duration pollingInterval = Duration.ofMillis(500);

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, pollingInterval);
    }

    /**
     * Базовые методы ожиданий
     */

// Ожидание видимости одного элемента
    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
// Кастомное ожидание когда элемент станет кликабельным
    public WebElement waitFotClickable(By locator, Duration timeout){
        WebDriverWait customWait = new WebDriverWait(driver,timeout,pollingInterval);
        return customWait.until(ExpectedConditions.elementToBeClickable(locator));
    }

}
