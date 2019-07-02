package com.wk.task2.convertor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wk.task2.model.Client;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс отвечает за преобразование контента в модель
 *
 * @author Denis Khalaev
 */
public class Converter {

    /**
     * Метод возвращает список клиентов из строки JSON
     *
     * @param json трока вида JSON
     * @return список клиентов
     */
    public List<Client> convertJSONToObj(String json) {

        Type listOfMyClassObject = new TypeToken<ArrayList<Client>>() {
        }.getType();
        Gson gson = new Gson();
        return gson.fromJson(json, listOfMyClassObject);
    }

    /**
     * Преобразует список клиентов в XML
     *
     * @param clientDTOList - список клиентов
     * @return возвращается список клиентов в виде XML
     */
    public  String convertClientToXML(List<Client> clientDTOList) {
        XmlMapper xmlMapper = new XmlMapper();
        StringBuilder stringXML = new StringBuilder();
        for (Client client : clientDTOList) {
            try {
                stringXML.append(xmlMapper.writeValueAsString(client));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return "<Clients>".concat(stringXML.toString()).concat("</Clients>");
    }

    /**
     * Конвертирует XML с помощью XSLT к html
     */
    public void convertToXSLT() {

        try {
            TransformerFactory tFactory = TransformerFactory.newInstance();

            Source xslDoc = new StreamSource("task2/src/main/resources/xslt/client.xsl");
            Source xmlDoc = new StreamSource("task2/src/main/resources/xslt/client.xml");

            String outputFileName = "task2/src/main/webapp/view/client.html";

            OutputStream htmlFile = new FileOutputStream(outputFileName);
            Transformer trasform = tFactory.newTransformer(xslDoc);
            trasform.transform(xmlDoc, new StreamResult(htmlFile));
        } catch (FileNotFoundException | TransformerException | TransformerFactoryConfigurationError e) {
            e.printStackTrace();
        }
    }

    /**
     * Записывает XML файл
     * @param xml - строка XML
     */
    public void setXMLFile(String xml) {
        try {
            FileWriter fileWriter = new FileWriter("task2/src/main/resources/xslt/client.xml", false);
            fileWriter.append(xml);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
