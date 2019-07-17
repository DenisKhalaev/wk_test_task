package com.wk.task2spring.thread;

import com.wk.task2spring.config.SpringConfig;
import com.wk.task2spring.connector.TaskOneConnector;
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

    private static Integer count = 0;

    private Converter converter;

    private TaskOneConnector taskOneConnector;

    private SettingReader settingReader;

    public int getStatus() {
        return count;
    }

    private void interrogatorTaskOne() throws IOException, InterruptedException {

        count++;
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        settingReader = new SettingReader().setSettingReader("setting/setting.properties");

        taskOneConnector = context.getBean(TaskOneConnector.class);
        converter = context.getBean(Converter.class);

        while (true) {
            if (Integer.parseInt(settingReader.getSetting("JSONOrXML")) == 0) {
                taskOneConnector.setSettingReader(settingReader).setNameController("nameControllerXml");
                converter.writeXmltoXmlFile(taskOneConnector.getContent());
            } else {
                taskOneConnector.setSettingReader(settingReader).setNameController("nameControllerJson");
                try {
                    converter.convertClientListToXmlFile(converter.convertJSONToObj(taskOneConnector.getContent()));
                } catch (JAXBException e) {
                    e.printStackTrace();
                }
            }
//                todo убрать потом, для отображения работы цикла.
            System.out.println("Sleep: " + settingReader.getSetting("timeN") + " sec.");
            System.out.println(taskOneConnector.getContentType());
            System.out.println(taskOneConnector.getContent());

            converter.convertToXslt();
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
