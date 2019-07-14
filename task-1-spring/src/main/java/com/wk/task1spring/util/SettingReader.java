package com.wk.task1spring.util;


import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author Denis Khalaev
 */
public class SettingReader {

    private static SettingReader instance;
    private static Map<String, String> setting;


    private SettingReader(String fileName) {

        Properties properties = PropertyUtils.getProperties(fileName);
        Map<String, String> map = new HashMap<>();
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            map.put((String) entry.getKey(), (String) entry.getValue());
        }
        setting = map;
    }

    public static SettingReader getInstance(String fileName) {
        instance = new SettingReader(fileName);
        return instance;
    }

    public String getSetting(String key) {
        return setting.get(key);
    }
}
