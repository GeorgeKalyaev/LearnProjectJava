package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// На данных страница описываем
// Локаторы
// Методы для взаимодействия со страницей(простые методы- нажать секбокс, нажать кнопку, что-то ввести и т.д.)
public class InventoryPage extends BasePage{

    private final By inventoryContainer = By.id("inventory_container");

//    Конструктор
    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    //  Методы страницы
    public boolean isLoaded(){
        return driver.findElement(inventoryContainer).isDisplayed();
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

}
