package org.example.ui.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DriverFactory {

    public static WebDriver createDriver() {
        // ===== ОТКЛЮЧАЕМ ВСЕ ЛОГИ =====
        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
        Logger.getLogger("io.github.bonigarcia").setLevel(Level.OFF);
        Logger.getLogger("org.openqa.selenium.devtools").setLevel(java.util.logging.Level.SEVERE);
        Logger.getLogger("org.openqa.selenium.chromium").setLevel(java.util.logging.Level.SEVERE);

        System.setProperty("webdriver.chrome.silentOutput", "true");
        System.setProperty("webdriver.manager.silent", "true");
        System.setProperty("selenium.cdp.enabled", "false");
        System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "off");

        ChromeOptions options = getChromeOptions();

        // ===== ПРЕДПОЧТЕНИЯ (ПРОФИЛЬ) =====
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.password_manager_leak_detection", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("credentials_enable_service", false);
        prefs.put("credentials_enable_autosignin", false);
        prefs.put("password_manager.enabled", false);
        prefs.put("profile.default_content_setting_values.notifications", 2);
        prefs.put("profile.content_settings.exceptions.password_manager_protection", new HashMap<>());
        prefs.put("profile.password_manager_allow_show_passwords", false);
        prefs.put("profile.password_manager_leak_detection.enabled", false);
        options.setExperimentalOption("prefs", prefs);

        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(options);
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        options.addArguments("--disable-features=PasswordLeakDetection");
        options.addArguments("--disable-features=PasswordImport");
        options.addArguments("--disable-features=PasswordManagerReauthentication");
        options.addArguments("--disable-features=PasswordGeneration");
        options.addArguments("--disable-features=SavePasswordBubble");
        options.addArguments("--disable-features=PasswordManagerOnboarding");
        options.addArguments("--disable-features=PasswordManagerAccountStorage");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-default-apps");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-plugins");
        options.addArguments("--disable-translate");

        return options;
    }
}