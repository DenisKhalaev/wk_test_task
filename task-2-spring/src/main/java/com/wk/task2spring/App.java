package com.wk.task2spring;

import com.wk.task2spring.connector.ConnectorToTaskOne;
import com.wk.task2spring.converter.Converter;
import com.wk.task2spring.converter.impl.ConverterImpl;
import com.wk.task2spring.util.SettingReader;

import java.io.IOException;

/**
 * @author Denis Khalaev
 */
public class App {
    public static void main(String[] args) throws IOException {

//        ConnectorToTaskOne connectorToTaskOneJSON = new ConnectorToTaskOne();
//        connectorToTaskOneJSON.setSettingReader(new SettingReader("setting/setting.properties"))
//                .setNameController("nameControllerJSON");

        Converter converter = new ConverterImpl();
//        try {
//            converter.convertClientListToXMLFile(converter.convertJSONToObj(connectorToTaskOneJSON.getContent()));
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
//        converter.convertToXSLT();

   ConnectorToTaskOne connectorToTaskOneXML = new ConnectorToTaskOne()
           .setSettingReader(new SettingReader("setting/setting.properties"))
           .setNameController("nameControllerXML");

   converter.writeXMLtoXMLFile(connectorToTaskOneXML.getContent());
   converter.convertToXSLT();
    }
}
