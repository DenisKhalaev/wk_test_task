package com.wk.task2.convertor;

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

    public List<Client> convertJSON(String json) throws IOException {

        Type listOfMyClassObject = new TypeToken<ArrayList<Client>>() {
        }.getType();
        Gson gson = new Gson();

        return gson.fromJson(json, listOfMyClassObject);
    }

    public List<String> convertXML(String xml) {
        List<String> list = new ArrayList<>();

        return list;
    }
}
