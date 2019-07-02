package com.wk.task2.util;

import java.io.IOException;
import java.util.Properties;

/**
 * Класс отвечает за чтение properties
 *
 * @author Denis Khalaev
 */
public class PropertyUtils {

    public static Properties getProperties(String fileName) {

        Properties properties = new Properties();

        try {
            properties.load(
                    PropertyUtils.class
                            .getClassLoader()
                            .getResourceAsStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}

