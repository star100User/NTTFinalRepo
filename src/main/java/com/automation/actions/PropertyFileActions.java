package com.automation.actions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileActions {

    public String getPropertyValue(String propertyFilePath, String key) {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(propertyFilePath)) {
            properties.load(fis);
            return properties.getProperty(key);
        } catch (IOException e) {
            return null;
        }
    }
}
