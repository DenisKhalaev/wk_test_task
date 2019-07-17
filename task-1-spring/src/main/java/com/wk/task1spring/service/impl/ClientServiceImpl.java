package com.wk.task1spring.service.impl;

import com.wk.task1spring.dao.CashFlowDao;
import com.wk.task1spring.dao.ClientDao;
import com.wk.task1spring.dao.TariffDao;
import com.wk.task1spring.dto.ClientDto;
import com.wk.task1spring.model.Client;
import com.wk.task1spring.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Denis Khalaev
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientDao clientDao;
    @Autowired
    TariffDao tariffDao;
    @Autowired
    CashFlowDao cashFlowDao;

    @Override
    public List<ClientDto> getAllClientDto() {
        List<ClientDto> clientDtoList = new ArrayList<>();
        List<Client> clientList = clientDao.getAllClient();
        for (Client client : clientList) {
            ClientDto clientDto = new ClientDto();
            clientDto.setClientId(client.getClientId());
            clientDto.setName(client.getName());
            clientDto.setTariff(tariffDao.getOne(client.getIdTariff()));
            clientDto.setBalance(cashFlowDao.getCalcBalanceClientInDB(client.getClientId()));
            clientDtoList.add(clientDto);
        }
        return clientDtoList;
    }
}
