package com.selenium.utils;

import com.selenium.driver.DriverManagerAttribute;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.sql.DriverManager;

public final class ScreenshotUtils {
    private ScreenshotUtils(){

    }
    public static String getScreenShot(){
    return ((TakesScreenshot) DriverManagerAttribute.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
