package com.wk.task2.connector;

import com.wk.task2.util.ReaderProperties;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Класс отвечает за соединение к первой части задания и получение данных
 *
 * @author Denis Khalaev
 */
public class ConnectorToTaskOne {

    private static URL myUrl;
    private static HttpURLConnection myUrlCon;

    /**
     * Метод устанавлиет URL к первой части задания беря настройки из setting.properties
     *
     * @throws IOException
     */
    private static void connect() throws IOException {

        String url = ReaderProperties.getInstance().getSetting("address") +
                ReaderProperties.getInstance().getSetting("serverPort") +
                ReaderProperties.getInstance().getSetting("nameModule") +
                ReaderProperties.getInstance().getSetting("nameController");

        myUrl = new URL(url);
        myUrlCon = (HttpURLConnection) myUrl.openConnection();
    }

    /**
     * Метод получает ContentType из первой части
     *
     * @return возвращает ContentType в виде строки
     * @throws IOException
     */
    public static String getContentType() throws IOException {
                    connect();
                return myUrlCon.getContentType();
    }

    /**
     * Метод получает контент запрос первой части
     *
     * @return строка контента
     * @throws IOException
     */
    public static String getContent() throws IOException {
        connect();

        BufferedReader bufReader = new BufferedReader(new InputStreamReader(myUrlCon.getInputStream()));

        StringBuilder sb = new StringBuilder();
        String line = bufReader.readLine();

        while (line != null) {
            sb.append(line).append("\n");
            line = bufReader.readLine();
        }
        bufReader.close();
        return sb.toString();
    }


}
