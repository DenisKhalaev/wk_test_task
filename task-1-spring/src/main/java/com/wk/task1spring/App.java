package com.wk.task1spring;

import com.wk.task1spring.config.SpringConfig;
import com.wk.task1spring.dao.CashFlowDAO;
import com.wk.task1spring.dao.ClientDAO;
import com.wk.task1spring.dao.TariffDAO;
import com.wk.task1spring.service.ClientService;
import com.wk.task1spring.service.impl.ClientServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Denis Khalaev
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//        while (true) {
//            Thread.sleep(5000);
//            System.out.println(context.getBean(ClientDAO.class).getClient(1L));
//            System.out.println(context.getBean(ClientDAO.class).getAllClient());
//            System.out.println(context.getBean(TariffDAO.class).getOne(1L));
//            System.out.println(context.getBean(TariffDAO.class).getAllTariff());
//            System.out.println(context.getBean(CashFlowDAO.class).getCalcBalanceClientInDB(1L));
//            System.out.println(context.getBean(CashFlowDAO.class).getOneClient(1L));
//            System.out.println(context.getBean(ClientService.class).getAllClientDTO());

//        ClientService clientService = new ClientServiceImpl(context.getBean(ClientDAO.class), context.getBean(TariffDAO.class), context.getBean(CashFlowDAO.class));
//        System.out.println(clientService.getAllClientDTO());
//        }

    }


}
