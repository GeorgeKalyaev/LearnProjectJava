package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    //    Локаторы
    private final By userName = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");

    private final By errorMessage = By.cssSelector("[data-test='error']");

    //    Конструкторы
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //  Методы страницы
    public LoginPage enterUserName(String inputUserName) {
        driver.findElement(userName).sendKeys(inputUserName);
        return this;
    }

    public LoginPage enterPassword(String inputPassword){
        driver.findElement(password).sendKeys(inputPassword);
        return this;
    }

    public InventoryPage clickLogin(){
        driver.findElement(loginButton).click();
        return new InventoryPage(driver);
    }

    public boolean isErrorMessageDisplayed(){
        return driver.findElement(errorMessage).isDisplayed();
    }

    public String getTextErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }


}
