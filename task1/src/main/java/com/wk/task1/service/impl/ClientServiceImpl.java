package com.wk.task1.service.impl;

import com.wk.task1.dao.CashFlowDAO;
import com.wk.task1.dao.ClientDAO;
import com.wk.task1.dao.TariffDAO;
import com.wk.task1.dao.impl.CashFlowDAOImpl;
import com.wk.task1.dao.impl.ClientDAOImpl;
import com.wk.task1.dao.impl.TariffDAOImpl;
import com.wk.task1.dto.ClientDTO;
import com.wk.task1.model.Client;
import com.wk.task1.service.ClientService;

import java.util.ArrayList;
import java.util.List;

/** Rласс реализует интерфейс ClientService
 * @author Denis Khalaev
 */
public class ClientServiceImpl implements ClientService {

    private ClientDAO clientDAO = new ClientDAOImpl();
    private TariffDAO tariffDAO = new TariffDAOImpl();
    private CashFlowDAO cashFlow = new CashFlowDAOImpl();

    /** Метод получает данные из базы и преобразует их в список клиентов
     *
     * @return список клиентов
     */
    @Override
    public List<ClientDTO> getAllClientDTO() {
        List<ClientDTO> clientDTOList = new ArrayList<>();

        List<Client> clientList = clientDAO.getAllClient();
        for (Client client : clientList) {
            ClientDTO clientDTO = new ClientDTO();
            clientDTO.setIdClient(client.getIdClient());
            clientDTO.setName(client.getName());
            clientDTO.setTariff(tariffDAO.getOne(client.getTariffId()));
            clientDTO.setBalance(cashFlow.getCalcBalanceClientInDB(client.getIdClient()));
            clientDTOList.add(clientDTO);
        }
        return clientDTOList;
    }
}
