package com.wk.task1spring.controller;

import com.wk.task1spring.dto.Clients;
import com.wk.task1spring.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Denis Khalaev
 */

@Controller
@RequestMapping("client")
public class ClientController {

    @Qualifier("clientServiceImpl")
    @Autowired
    private ClientService clientService;

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Clients getAllUserRequest() {
        Clients list = new Clients();
        list.setClient(clientService.getAllClientDTO());
        return list;
    }
}