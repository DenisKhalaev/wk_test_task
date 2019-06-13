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


        StringBuilder url = new StringBuilder();

        url
                .append(ReaderProperties.getInstance().getSetting("address"))
                .append(ReaderProperties.getInstance().getSetting("serverPort"))
                .append(ReaderProperties.getInstance().getSetting("nameModule"))
                .append(ReaderProperties.getInstance().getSetting("nameController"));

        URL myUrl = new URL(url.toString());
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
