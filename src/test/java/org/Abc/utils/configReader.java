package org.Abc.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configReader {
    private static Properties properties = new Properties();

    public configReader(String filepath){
        properties = new Properties();

        try {
            FileInputStream fis = new FileInputStream(filepath);
            properties.load(fis);
        } catch (Exception e) {
           e.printStackTrace();
        }
    }

    public String getProperty(String key){
        return properties.getProperty(key);
    }
}
