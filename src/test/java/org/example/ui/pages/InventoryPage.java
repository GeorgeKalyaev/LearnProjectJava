package org.example.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

// На данных страница описываем
// Локаторы
// Методы для взаимодействия со страницей(простые методы- нажать чекбокс, нажать кнопку, что-то ввести и т.д.)
public class InventoryPage extends BasePage {


    private final By inventoryContainer = By.id("inventory_container");
    //    private final By burgerMenuButton = By.id("bm-menu-wrap");
    private final By burgerMenuButton = By.className("bm-burger-button");
    private final By logoutLink = By.id("logout_sidebar_link");

    //    Конструктор
    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    //  Методы страницы
    public boolean isLoaded() {
        return driver.findElement(inventoryContainer).isDisplayed();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public InventoryPage openSideMenu() {
        driver.findElement(burgerMenuButton).click();
        return this;
    }

    public boolean isLogoutDisplayed() {
        return driver.findElement(logoutLink).isDisplayed();
    }

    public String getLogoutText() {
        return driver.findElement(logoutLink).getText();
    }

    public LoginPage clickLogout() {
        isClickable(logoutLink, Duration.ofMillis(1000));

        driver.findElement(logoutLink).click();
        return new LoginPage(driver);
    }

}
