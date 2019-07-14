package com.wk.task2.thread;

import com.wk.task2.connector.ConnectorToTaskOne;
import com.wk.task2.convertor.Converter;
import com.wk.task2.util.ReaderProperties;

import java.io.IOException;

/**
 * Класс потока который опрашивает часть1 с оспределенной переодичностью
 *
 * @author Denis Khalaev
 */
public class Interrogator extends Thread {

    private Converter converter = new Converter();

    /**
     * Метод который опрашивает часть 1 задания и преобразует результат в пару клиент/баланс
     *
     * @throws IOException
     * @throws InterruptedException
     */
    private void interrogatorTaskOne() throws IOException, InterruptedException {

        while (true) {
            //todo убрать потом, для отображения работы цикла.
            System.out.println(ConnectorToTaskOne.getContentType());
            System.out.println(ConnectorToTaskOne.getContent());

            Interrogator.sleep((Long.parseLong(ReaderProperties.getInstance().getSetting("timeN"))) * 1000);

            if (ConnectorToTaskOne.getContentType().contains("json")) {
                converter.setXMLFile(converter.convertClientToXML(converter.convertJSONToObj(ConnectorToTaskOne.getContent())));
                converter.convertToXSLT();
            } else {
                converter.setXMLFile(ConnectorToTaskOne.getContent());
                converter.convertToXSLT();
            }

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
