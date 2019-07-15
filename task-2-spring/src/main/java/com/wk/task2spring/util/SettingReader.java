package com.wk.task2spring.util;


import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author Denis Khalaev
 */
@Service
public class SettingReader {

    private Map<String, String> setting;
    private SettingReader instance;

    public SettingReader() {
    }

    private SettingReader(String fileName) {
        Properties properties = PropertyUtils.getProperties(fileName);
        Map<String, String> map = new HashMap<>();
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            map.put((String) entry.getKey(), (String) entry.getValue());
        }
        setting = map;
    }

    public SettingReader setSettingReader(String fileName) {
        instance = new SettingReader(fileName);
        return instance;
    }

    public String getSetting(String key) {
        return setting.get(key);
    }
}
