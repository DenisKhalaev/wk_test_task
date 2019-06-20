package com.wk.task2;

import com.wk.task2.connector.ConnectorToTaskOne;
import com.wk.task2.convertor.Converter;
import com.wk.task2.model.Client;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        List<String> list = ConnectorToTaskOne.connect();

        System.out.println("xml: " + list.get(0).contains("xml"));
        System.out.println("json: " + list.get(0).contains("json"));

        System.out.println(list.get(1));


        Converter converter = new Converter();
        List<Client> clients = converter.convertXMLToObj(list.get(1));

//        System.out.println(converter.convertJSONToObj(list.get(1)));
//
//        List<Client> clients = converter.convertJSONToObj(list.get(1));
        for (Client client : clients) {
            System.out.println(client);
        }

    }
}
