package com.wk.task1spring.controller;

import com.wk.task1spring.dto.ClientDto;
import com.wk.task1spring.dto.ClientList;
import com.wk.task1spring.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

/**
 * @author Denis Khalaev
 */
@Controller
@RequestMapping("/clients")
public class ClientController {

    @Qualifier("clientServiceImpl")
    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/getXml", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ClientList getAllUsersXml() {
        ClientList client = new ClientList();
        client.setClient(clientService.getAllClientDto());
        return client;
    }

    @RequestMapping(value = "/getJson", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<ClientDto>> getAllUsersJson() {
        List<ClientDto> clientDtoList = clientService.getAllClientDto();
        return !clientDtoList.isEmpty() ?
                new ResponseEntity<>(clientDtoList, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
