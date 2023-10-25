package com.selenium.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManagerFirefox implements DriverManager {
    @Override
    public WebDriver createWebDriver() {
        WebDriver driver= new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
