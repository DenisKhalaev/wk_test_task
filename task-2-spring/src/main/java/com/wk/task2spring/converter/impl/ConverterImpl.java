package com.wk.task2spring.converter.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wk.task2spring.converter.Converter;
import com.wk.task2spring.model.Client;
import com.wk.task2spring.model.ClientList;
import org.springframework.stereotype.Service;

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

@Service
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
    public void convertClientListToXmlFile(List<Client> clientList) throws JAXBException {
        ClientList clients = new ClientList();
        clients.setClientList(clientList);

        JAXBContext jaxbContext = JAXBContext.newInstance(ClientList.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(clients, new File(new File("").getAbsolutePath()+"/target/classes/xslt/client.xml"));
    }

    @Override
    public void convertToXslt() {
        try {
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Source xslDoc = new StreamSource(new File("").getAbsolutePath()+"/target/classes/xslt/client.xsl");
            Source xmlDoc = new StreamSource(new File("").getAbsolutePath()+"/target/classes/xslt/client.xml");
            String outputFileName = new File("").getAbsolutePath()+"/target/task2spring-1.0-SNAPSHOT/view/client.html";
            OutputStream htmlFile = new FileOutputStream(outputFileName);
            Transformer transformer = tFactory.newTransformer(xslDoc);
            transformer.transform(xmlDoc, new StreamResult(htmlFile));
        } catch (FileNotFoundException | TransformerException | TransformerFactoryConfigurationError e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeXmltoXmlFile(String xml) {
        try {
            FileWriter fileWriter = new FileWriter(new File("").getAbsolutePath()+"/target/classes/xslt/client.xml", false);
            fileWriter.append(xml);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
