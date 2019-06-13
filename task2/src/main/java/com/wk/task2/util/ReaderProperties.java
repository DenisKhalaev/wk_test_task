package com.wk.task2.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ReaderProperties {

    private static ReaderProperties instance;
    private static Map<String, String> setting;

    private ReaderProperties() {
        Properties properties = PropertyUtils.getProperties("connection/connectiontaskone.properties");
        Map<String, String> map = new HashMap<>();
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            map.put((String) entry.getKey(), (String) entry.getValue());
        }
        setting = map;
    }

    public static ReaderProperties getInstance() {
        if (instance == null) {
            instance = new ReaderProperties();
        }
        return instance;
    }

    public String getSetting(String key) {
        return setting.get(key);
    }

}
