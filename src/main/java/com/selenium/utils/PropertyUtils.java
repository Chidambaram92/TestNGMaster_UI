package com.selenium.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
    public static Properties propertyLoader(String filePath){
        Properties properties = new Properties();
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader(filePath));
        }catch(FileNotFoundException e){
            e.printStackTrace();
            throw new RuntimeException("Property file does not exist in the path: "+filePath);
        }
        try{
            properties.load(reader);
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
            throw new RuntimeException("Failed to load the Properties file: "+filePath);
        }
        return properties;
    }
}
