package com.wk.task2.connector;

import com.wk.task2.util.ReaderProperties;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ConnectorToTaskOne {

    public static List<String> connect() throws IOException {

        String url = ReaderProperties.getInstance().getSetting("address") +
                ReaderProperties.getInstance().getSetting("serverPort") +
                ReaderProperties.getInstance().getSetting("nameModule") +
                ReaderProperties.getInstance().getSetting("nameController");
        URL myUrl = new URL(url);
        HttpURLConnection myUrlCon = (HttpURLConnection) myUrl.openConnection();

        BufferedReader bufReader = new BufferedReader(new InputStreamReader(myUrlCon.getInputStream()));

        StringBuilder sb = new StringBuilder();
        String line = bufReader.readLine();

        while (line != null) {
            sb.append(line).append("\n");
            line = bufReader.readLine();
        }
        bufReader.close();

        List<String> list = new ArrayList<>();
        list.add(myUrlCon.getContentType());
        list.add(sb.toString());

        return list;
    }
}
