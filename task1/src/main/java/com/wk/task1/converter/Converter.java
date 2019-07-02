package com.wk.task1.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.wk.task1.dto.ClientDTO;

import java.util.List;

/**
 * Класс конвертор, преобразует список клиентов в XML или JSON
 *
 * @author Denis Khalaev
 */
public class Converter {

    /**
     * Преобразует список клиентов в XML
     *
     * @param clientDTOList - список клиентов
     * @return возвращается список клиентов в виде XML
     */
    public static String convertClientToXML(List<ClientDTO> clientDTOList) {
        XmlMapper xmlMapper = new XmlMapper();
        StringBuilder stringXML = new StringBuilder();
        for (ClientDTO clientDTO : clientDTOList) {
            try {
                stringXML.append(xmlMapper.writeValueAsString(clientDTO));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return "<Clients>".concat(stringXML.toString()).concat("</Clients>");
    }


    /**
     * Преобразует список клиентов в JSON
     *
     * @param clientDTOList - список клиентов
     * @return возвращается список клиентов в виде JSON
     */
    public static String convertClientToJSON(List<ClientDTO> clientDTOList) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(clientDTOList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
