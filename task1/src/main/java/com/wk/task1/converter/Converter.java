package com.wk.task1.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.wk.task1.dto.ClientDTO;

import java.util.List;

/**
 * @author Denis Khalaev
 */
public class Converter {

    public static String convertClientToXML(List<ClientDTO> clientDTOList) {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            return xmlMapper.writeValueAsString(clientDTOList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }

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
