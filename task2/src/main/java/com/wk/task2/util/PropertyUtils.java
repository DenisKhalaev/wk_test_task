package com.wk.task2.util;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
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

