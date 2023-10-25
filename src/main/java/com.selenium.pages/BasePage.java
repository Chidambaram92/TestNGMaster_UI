package com.selenium.pages;

import com.selenium.constants.FrameWorkConstants;
import com.selenium.driver.DriverManagerAttribute;
import com.selenium.enums.WaitStrategy;
import com.selenium.factories.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(FrameWorkConstants.getExplicitWait()));
    }

    public void click(By by, WaitStrategy waitStrategy, String elementName) {
        ExplicitWaitFactory.performExplicitWait(waitStrategy, by).click();
    }

    public void sendKeys(By by, String value, WaitStrategy waitStrategy, String elementName) {
        ExplicitWaitFactory.performExplicitWait(waitStrategy, by).sendKeys(value);
    }

    protected void clear(By by, WaitStrategy waitStrategy, String elementName) {
        ExplicitWaitFactory.performExplicitWait(waitStrategy, by).clear();
    }

    protected void clearAndSendKeys(By by, String value, WaitStrategy waitStrategy, String elementName) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
        element.clear();
        element.sendKeys(value);
    }
}
