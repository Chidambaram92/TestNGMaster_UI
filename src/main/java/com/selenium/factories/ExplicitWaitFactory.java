package com.selenium.factories;

import com.selenium.constants.FrameWorkConstants;
import com.selenium.driver.DriverManager;
import com.selenium.driver.DriverManagerAttribute;
import com.selenium.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class ExplicitWaitFactory {
    private ExplicitWaitFactory(){

    }
    public static WebElement performExplicitWait(WaitStrategy waitStrategy, By by){
        WebElement element= null;

        if(waitStrategy==WaitStrategy.CLICKABLE){
            WebDriverWait wait = new WebDriverWait(DriverManagerAttribute.getDriver(), Duration.ofSeconds(FrameWorkConstants.getExplicitWait()));
            wait.until(ExpectedConditions.elementToBeClickable(by));
        }
        else if (waitStrategy == WaitStrategy.PRESENCE) {
            WebDriverWait wait = new WebDriverWait(DriverManagerAttribute.getDriver(), Duration.ofSeconds(FrameWorkConstants.getExplicitWait()));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        }
        else if (waitStrategy == WaitStrategy.VISIBLE) {
            WebDriverWait wait = new WebDriverWait(DriverManagerAttribute.getDriver(), Duration.ofSeconds(FrameWorkConstants.getExplicitWait()));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }else{
            System.out.println("No specific wait is required");
        }
        return element;
    }
}
