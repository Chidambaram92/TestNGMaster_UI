package com.selenium.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverManagerEdge implements DriverManager{

    @Override
    public WebDriver createWebDriver() {
        WebDriver driver= new EdgeDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
