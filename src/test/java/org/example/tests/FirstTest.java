package org.example.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FirstTest {
    private WebDriver driver;

    @BeforeEach
    void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }

    @Test
    void first() throws InterruptedException {
        driver.get("https://saucedemo.com");
        String title = driver.getTitle();
        System.out.println("title " + title);
//        assertTrue(title.contains("Swag Labs1"), "неверный title");
        assertEquals("Swag Labs", title, "неверный title");
//        Assertions.assertTrue();
    }
}

// подключить гит и запушить
// На сайте https://saucedemo.com находит Username по ID и вводим туда стандарт юзер и также находим passwoed
// нажимаем кнопку логин и проверяем
// проверяем что залогинились и проверяем что есть  слово Products
// загрузить в гит если все норм работает

