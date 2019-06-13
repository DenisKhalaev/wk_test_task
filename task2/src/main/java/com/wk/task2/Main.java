package com.wk.task2;

import com.wk.task2.connector.ConnectorToTaskOne;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        List<String> list = ConnectorToTaskOne.connect();

        System.out.println(list.get(0).contains("xml"));
        System.out.println(list.get(0).contains("json"));


        System.out.println(list.get(1));

    }
}
