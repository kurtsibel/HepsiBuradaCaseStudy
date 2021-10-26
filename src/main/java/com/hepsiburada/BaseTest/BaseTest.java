package com.hepsiburada.BaseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

public class BaseTest {

    protected static WebDriver driver;
    public static Properties properties;
    public static Logger logger;

    public BaseTest() {
        try {
            properties = new Properties();

            FileInputStream file = new FileInputStream(System.getProperty("user.dir") +
                    "/src/main/resources/config/config.properties");
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialize() {
        String browserName = properties.getProperty("tarayici");
        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("useAutomationExtension", false);
            options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            //The chrome save password option is disabled.
            Map<String, Object> prefs = new LinkedHashMap<>();
            prefs.put("credentials_enable_service", Boolean.FALSE);
            prefs.put("profile.password_manager_enabled", Boolean.FALSE);
            options.setExperimentalOption("prefs", prefs);
            driver = new ChromeDriver(options);
        } else if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));

        logger = Logger.getLogger("Hepsi Burada");
        PropertyConfigurator.configure("log4j.properties");
    }
}
