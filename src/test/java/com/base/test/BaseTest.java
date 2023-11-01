package com.base.test;

import com.selenium.driver.DriverManagerAttribute;
import com.selenium.driver.DriverManagerFactory;
import com.selenium.enums.DriverType;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    public WebDriver getDriver() {
        return DriverManagerAttribute.getDriver();
    }

    public void setDriver(WebDriver driver) {
        DriverManagerAttribute.setDriver(driver);
    }

    @Parameters("browser")
    @BeforeMethod
    public synchronized void startDriver(String browser) {
        browser = setBrowserValue(browser);
        setDriver(DriverManagerFactory.getWebDriver(DriverType.valueOf(browser)).createWebDriver());
        System.out.println("Current Thread info = " + Thread.currentThread().getId() + ", Driver = " + getDriver());
    }

    private String setBrowserValue(String browser) {
        if (browser == null) {
            browser = "EDGE";
            System.out.println(
                    "Test execution not done by Maven cmd or TestNG.xml file ->  setting the value: " + "EDGE");
        }
        /* This is for test case execution from Maven command line or testng.xml file */
        browser = System.getProperty("browser", browser);
        return browser;
    }

    private void takeScreenshot(File destFile) throws IOException {
        File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, destFile);
    }

    private void takeScreenShotOnFailure(String browser, ITestResult result) throws IOException {
        browser = setBrowserValue(browser);
        System.out.println("Current Thread info = " + Thread.currentThread().getId() + ", Driver = " + getDriver());
        if (result.getStatus() == ITestResult.FAILURE) {
            File destFile = new File("Screenshots" + File.separator + browser + File.separator
                    + result.getTestClass().getRealClass().getSimpleName() + "_" + result.getMethod().getMethodName()
                    + ".png");
            takeScreenshot(destFile);
        }
    }

    @Parameters("browser")
    @AfterMethod
    public synchronized void quitDriver(String browser, ITestResult result) throws IOException {
        takeScreenShotOnFailure(browser, result);
        getDriver().quit();
    }
}

