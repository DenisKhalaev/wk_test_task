package com.wk.task1.util;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public static void closeConnection(PreparedStatement preparedStatement, ResultSet resultSet) {

        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

