package com.wk.task2.convertor;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wk.task2.model.Client;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Denis Khalaev
 */
public class Converter {

    public List<Client> convertJSONToObj(String json) {

        Type listOfMyClassObject = new TypeToken<ArrayList<Client>>() {
        }.getType();
        Gson gson = new Gson();

        return gson.fromJson(json, listOfMyClassObject);
    }

    public List<Client> convertXMLToObj(String xml) throws IOException {
        List<Client> list = new ArrayList<>();
        XmlMapper xmlMapper = new XmlMapper();

        String separator = "(?=<Client>)";
        String[] xml12 = xml.split(separator);
        for (String s : xml12) {
            list.add(xmlMapper.readValue(s, Client.class));
        }
        return list;
    }
}
