package com.wk.task2spring.converter;

import com.wk.task2spring.model.Client;

import javax.xml.bind.JAXBException;
import java.util.List;

/**
 * @author Denis Khalaev
 */
public interface Converter {

    List<Client> convertJSONToObj(String json);

    void convertClientListToXmlFile(List<Client> clientList) throws JAXBException;

    void convertToXslt();

    void writeXmltoXmlFile(String xml);

}
