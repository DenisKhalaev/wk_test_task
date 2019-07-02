package com.wk.task1.util;


import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Класс отвечает за чтение настроек
 *
 * @author Denis Khalaev
 */
public class SettingReader {

    private static SettingReader instance;
    private static Map<String, Boolean> setting;

    private SettingReader() {
        Properties properties = PropertyUtils.getProperties("setting/setting.properties");
        Map<String, Boolean> map = new HashMap<>();
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            map.put((String) entry.getKey(), Boolean.valueOf(entry.getValue().toString()));
        }
        setting = map;
    }

    public static SettingReader getInstance() {
        if (instance == null) {
            instance = new SettingReader();
        }
        return instance;
    }

    public Boolean getSetting(String key) {
        return setting.get(key);
    }
}
