package org.example.ui.pages;

import org.example.ui.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WaitUtils wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    public WebElement isVisible(By locator){
        return wait.waitForVisibility(locator);
    }

    public WebElement isClickable(By locator, Duration timeout){
        return wait.waitFotClickable(locator, timeout);
    }

}
