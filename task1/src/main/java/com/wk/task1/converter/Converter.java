package com.wk.task1.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.wk.task1.dto.ClientDTO;
import com.wk.task1.util.SettingReader;

import java.util.List;

/**
 * @author Denis Khalaev
 */
public class Converter {

    public String convertClientXMLOrJSON(List<ClientDTO> clientDTO) {
        Boolean setting = SettingReader.getInstance().getSetting("settingXMLOrJSON");
        return setting ? convertClientToJSON(clientDTO) : convertClientToXML(clientDTO);
    }

    private String convertClientToXML(List<ClientDTO> clientDTOList) {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            return xmlMapper.writeValueAsString(clientDTOList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }

    private String convertClientToJSON(List<ClientDTO> clientDTOList) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = null;
        try {
            jsonStr = mapper.writeValueAsString(clientDTOList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
//        Foo result = mapper.readValue(jsonStr, Foo.class);
//        assertEquals(foo.getId(),result.getId());
        return jsonStr;
    }
}
