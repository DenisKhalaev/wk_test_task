package com.wk.task2spring.thread;

import com.wk.task2spring.config.SpringConfig;
import com.wk.task2spring.connector.ConnectorToTaskOne;
import com.wk.task2spring.converter.Converter;
import com.wk.task2spring.util.SettingReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
 * @author Denis Khalaev
 */
public class Interrogator extends Thread {


    private Converter converter;

    private ConnectorToTaskOne connectorToTaskOne;

    private SettingReader settingReader;

    private void interrogatorTaskOne() throws IOException, InterruptedException {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        settingReader = new SettingReader().setSettingReader("setting/setting.properties");
        System.out.println(settingReader.getSetting("timeN"));

        connectorToTaskOne = context.getBean(ConnectorToTaskOne.class);
        converter = context.getBean(Converter.class);

        while (true) {
            if (Integer.parseInt(settingReader.getSetting("JSONOrXML")) == 0) {
                connectorToTaskOne.setSettingReader(settingReader).setNameController("nameControllerXML");
                converter.writeXMLtoXMLFile(connectorToTaskOne.getContent());
            } else {
                connectorToTaskOne.setSettingReader(settingReader).setNameController("nameControllerJSON");
                try {
                    converter.convertClientListToXMLFile(converter.convertJSONToObj(connectorToTaskOne.getContent()));
                } catch (JAXBException e) {
                    e.printStackTrace();
                }
            }
//                todo убрать потом, для отображения работы цикла.
            System.out.println(connectorToTaskOne.getContentType());
            System.out.println(connectorToTaskOne.getContent());
            System.out.println("Sleep:" + settingReader.getSetting("timeN"));

            converter.convertToXSLT();
            Interrogator.sleep((Long.parseLong(settingReader.getSetting("timeN"))) * 1000);
        }
    }

    public void run() {
        try {
            interrogatorTaskOne();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
