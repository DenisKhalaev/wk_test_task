package com.wk.task1.jdbc;

import com.wk.task1.util.PropertyUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/** Класс отвечающий за получаение SQL запросов из файла properties
 * @author Denis Khalaev
 */
public class SQLQuery {
    private static SQLQuery instance;
    private static Map<String, String> queries;

    /**
     * метод для получения карты запросов из файла mysql_query.properties
     */
    private SQLQuery() {
        Properties properties = PropertyUtils.getProperties("sql/mysql_query.properties");
        Map<String, String> map = new HashMap<>();
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            map.put((String) entry.getKey(), (String) entry.getValue());
        }
        queries = map;
    }

    /**
     * статический метод, возвращает единственный экземпляр класса, проверяя перед этим не создан ли он
     *
     * @return instance
     */
    public static SQLQuery getInstance() {
        if (instance == null) {
            instance = new SQLQuery();
        }
        return instance;
    }

    /**
     * получение запроса к БД по ключу
     *
     * @param key ключ по которому будет необходимый запрос к БД
     * @return запрос для БД
     */
    public String getQuery(String key) {
        return queries.get(key);
    }
}