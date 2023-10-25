package com.selenium.driver;

import org.openqa.selenium.WebDriver;

public final class  DriverManagerAttribute {
    private DriverManagerAttribute(){

    }
    private static ThreadLocal<WebDriver> driver= new ThreadLocal<>();
    public static WebDriver getDriver()
    {
        return driver.get();
    }
    public static void setDriver(WebDriver driverValue) {
        driver.set(driverValue);
    }
}
