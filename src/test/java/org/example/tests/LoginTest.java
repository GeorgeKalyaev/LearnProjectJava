package org.example.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.InventoryPage;
import org.example.pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


    @ParameterizedTest
    @ValueSource(strings = {"standard_user", "problem_user", "performance_glitch_user", "error_user", "visual_user"})
//    @DisplayName("")
    void shouldLoginWithValidWithCreads(String userName) {

        inventoryPage = loginPage
                .enterUserName(userName)
                .enterPassword("secret_sauce")
                .clickLogin();

        assertTrue(inventoryPage.isLoaded(), "Страница inventoryPage не загружена");
        assertTrue(inventoryPage.getCurrentUrl().contains("inventory.html"), "url не содержит inventory.html");
    }

    static Stream<Arguments> inValidData(){
        return Stream.of(
                arguments("Проверка неверного пароля", "standard_user", "qwerty"),
                arguments("Проверка неверного логина", "qwerty", "secret_sauce")
        );
    }
    @ParameterizedTest
    @MethodSource("inValidData")
    void shouldLoginWithInvalidUserName(String description, String userName, String password) {
        loginPage
                .enterUserName(userName)
                .enterPassword(password)
                .clickLogin();

        assertTrue(loginPage.isErrorMessageDisplayed(), "Сообщение об ошибки не появилось");
        assertEquals("Epic sadface: Username and password do not match any user in this service",
                loginPage.getTextErrorMessage(), "Неверный текст сообщения об ошибке");
    }

//    новый тест - логин и пас пустые то и то проверять. и класть что то в корзину. еще нужно  выйти из аккаунта

//
//    @Test
//    void first() throws InterruptedException {
////        driver.get("https://www.saucedemo.com");
////        String title = driver.getTitle();
////        System.out.println("title " + title);
//////        assertTrue(title.contains("Swag Labs1"), "неверный title");
////        assertEquals("Swag Labs", title, "неверный title");
////
////
////        driver.findElement(By.id("user-name")).sendKeys("standard_user");
////        driver.findElement(By.id("password")).sendKeys("secret_sauce");
////        driver.findElement(By.id("login-button")).click();
////
////        String productTitle = driver.findElement(By.className("title")).getText();
////        System.out.println("productTitle " + productTitle);
////        assertEquals("Products", productTitle, "неверный productTitle");
////        assertEquals(productTitle.contains("Products"), "неверный title");
//
//
////        driver.findElement(By.id("logout_sidebar_link")).click();
////        assertEquals("Swag Labs", title, "неверный title");
//
//
//    }
}

// подключить гит и запушить
// На сайте https://saucedemo.com находит Username по ID и вводим туда стандарт юзер и также находим passwoed
// нажимаем кнопку логин и проверяем
// проверяем что залогинились и проверяем что есть  слово Products
// загрузить в гит если все норм работает
