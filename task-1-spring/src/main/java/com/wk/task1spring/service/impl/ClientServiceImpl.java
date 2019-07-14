package com.wk.task1spring.service.impl;

import com.wk.task1spring.dao.CashFlowDAO;
import com.wk.task1spring.dao.ClientDAO;
import com.wk.task1spring.dao.TariffDAO;
import com.wk.task1spring.dto.ClientDTO;
import com.wk.task1spring.model.Client;
import com.wk.task1spring.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Denis Khalaev
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientDAO clientDAO;
    @Autowired
    TariffDAO tariffDAO;
    @Autowired
    CashFlowDAO cashFlowDAO;

//    @Autowired
//    public ClientServiceImpl(ClientDAO clientDAO, TariffDAO tariffDAO, CashFlowDAO cashFlowDAO) {
//        this.clientDAO = clientDAO;
//        this.tariffDAO = tariffDAO;
//        this.cashFlowDAO = cashFlowDAO;
//    }

    @Override
    public List<ClientDTO> getAllClientDTO() {
        List<ClientDTO> clients = new ArrayList<>();
        List<Client> clientList = clientDAO.getAllClient();
        for (Client client : clientList) {
            ClientDTO clientDTO = new ClientDTO();
            clientDTO.setIdClient(client.getIdClient());
            clientDTO.setName(client.getName());
            clientDTO.setTariff(tariffDAO.getOne(client.getTariffId()));
            clientDTO.setBalance(cashFlowDAO.getCalcBalanceClientInDB(client.getIdClient()));
            clients.add(clientDTO);
        }
        return clients;
    }
}
