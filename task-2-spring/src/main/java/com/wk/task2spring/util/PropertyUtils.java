package com.wk.task2spring.util;

import java.io.IOException;
import java.util.Properties;

/**
 * @author Denis Khalaev
 */
public class PropertyUtils {

    static Properties getProperties(String fileName) {

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

