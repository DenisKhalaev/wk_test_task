package com.wk.task2spring.converter.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wk.task2spring.converter.Converter;
import com.wk.task2spring.model.Client;
import com.wk.task2spring.model.Clients;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * @author Denis Khalaev
 */

public class ConverterImpl implements Converter {

    @Override
    public List<Client> convertJSONToObj(String json) {
        ObjectMapper mapper = new ObjectMapper();
        List<Client> clients = null;
        try {
            clients = Arrays.asList(mapper.readValue(json, Client[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clients;
    }

    @Override
    public void convertClientListToXMLFile(List<Client> clientList) throws JAXBException {
        Clients clients = new Clients();
        clients.setClients(clientList);
        JAXBContext jaxbContext = JAXBContext.newInstance(Clients.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(clients, new File("task-2-spring/src/main/resources/xslt/client.xml"));
    }

    @Override
    public void convertToXSLT() {
        try {
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Source xslDoc = new StreamSource("task-2-spring/src/main/resources/xslt/client.xsl");
            Source xmlDoc = new StreamSource("task-2-spring/src/main/resources/xslt/client.xml");
            String outputFileName = "task-2-spring/src/main/webapp/view/client.html";
            OutputStream htmlFile = new FileOutputStream(outputFileName);
            Transformer trasform = tFactory.newTransformer(xslDoc);
            trasform.transform(xmlDoc, new StreamResult(htmlFile));
        } catch (FileNotFoundException | TransformerException | TransformerFactoryConfigurationError e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeXMLtoXMLFile(String xml) {
        try {
            FileWriter fileWriter = new FileWriter("task-2-spring/src/main/resources/xslt/client.xml", false);
            fileWriter.append(xml);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
