package com.wk.task1spring.controller;

import com.wk.task1spring.dto.ClientDTO;
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

import java.util.List;

/**
 * @author Denis Khalaev
 */
@Controller
@RequestMapping("clientjson")
public class ClientControllerJSON {

    @Qualifier("clientServiceImpl")
    @Autowired
    private ClientService clientService;

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<ClientDTO> getAllUserRequest() {
        return clientService.getAllClientDTO();
    }
}
