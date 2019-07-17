package com.wk.task2spring.connector;

import com.wk.task2spring.util.SettingReader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Denis Khalaev
 */
@Service
public class TaskOneConnector {

    private SettingReader settingReader;
    private HttpURLConnection myUrlCon;
    private String nameController;

    public TaskOneConnector() {
    }

    public TaskOneConnector(SettingReader settingReader, String nameController) {
        this.settingReader = settingReader;
        this.nameController = nameController;
    }

    public TaskOneConnector setSettingReader(SettingReader settingReader) {
        this.settingReader = settingReader;
        return this;
    }

    public TaskOneConnector setNameController(String nameController) {
        this.nameController = nameController;
        return this;
    }

    private void connect() throws IOException {
        String url = settingReader.getSetting("address") +
                settingReader.getSetting("serverPort") +
                settingReader.getSetting("nameModule") +
                settingReader.getSetting(nameController);
        URL myUrl = new URL(url);
        myUrlCon = (HttpURLConnection) myUrl.openConnection();
    }

    public String getContentType() throws IOException {
        if (myUrlCon == null) {
            connect();
        }
        return myUrlCon.getContentType();
    }

    public String getContent() throws IOException {
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
