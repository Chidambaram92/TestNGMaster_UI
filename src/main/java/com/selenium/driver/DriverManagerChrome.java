package com.selenium.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManagerChrome implements DriverManager {

    @Override
    public WebDriver createWebDriver() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
