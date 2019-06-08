package com.wk.task1;

import com.wk.task1.dao.CashFlowDAO;
import com.wk.task1.dao.ClientDAO;
import com.wk.task1.dao.impl.CashFlowDAOImpl;
import com.wk.task1.dao.impl.ClientDAOImpl;
import com.wk.task1.dao.impl.TariffDAOImpl;
import com.wk.task1.dto.ClientDTO;
import com.wk.task1.model.CashFlow;
import com.wk.task1.model.Client;
import com.wk.task1.service.ClientService;
import com.wk.task1.service.impl.ClientServiceImpl;

/**
 * @author Denis Khalaev
 */
public class Main {
    public static void main(String[] args){

//        TariffDAOImpl tariffDAO = new TariffDAOImpl();
//        System.out.println(tariffDAO.getOne(1L));
//        System.out.println(tariffDAO.getAllTariff());

//        CashFlowDAO cashFlowDAO = new CashFlowDAOImpl();
//
//        for (CashFlow cashFlow : cashFlowDAO.getOneClient(3L)) {
//            System.out.println(cashFlow);
//        }
//        System.out.println();
//
//        System.out.println(cashFlowDAO.getCalcBalanceClientInDB(3L));


//        ClientDAO clientDAO = new ClientDAOImpl();
//        for (Client client : clientDAO.getAllClient()) {
//            System.out.println(client);
//        }
//
//        System.out.println();
//
//        System.out.println(clientDAO.getOne(1L));

        ClientService clientService = new ClientServiceImpl();
        for (ClientDTO clientDTO : clientService.getAllClientDTO()) {
            System.out.println(clientDTO);
        }
    }
}
