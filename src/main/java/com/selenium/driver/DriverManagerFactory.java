package com.selenium.driver;

import com.selenium.enums.DriverType;

public class DriverManagerFactory {
    public static DriverManager getWebDriver(DriverType driverType){
        switch(driverType){
            case CHROME:{
                return new DriverManagerChrome();
            }
            case FIREFOX:{
                return new DriverManagerFirefox();
            }
            case EDGE:{
                return new DriverManagerEdge();
            }
            default : throw new IllegalArgumentException("Invalid Driver: " + driverType);
        }
    }
}

