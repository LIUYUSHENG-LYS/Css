package com.eureka.client;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

    private static Properties properties;

    static{
        InputStream inputStream= ConfigManager.class.getClassLoader().getResourceAsStream("aliyun.properties");
        properties=new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }

}
