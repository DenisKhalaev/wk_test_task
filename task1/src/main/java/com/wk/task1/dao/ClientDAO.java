package com.wk.task1.dao;

import com.wk.task1.model.Client;

import java.util.List;

/** Интерфейс обеспечивающий доступ данных к базе данных MySQL (таблица клиент)
 * @author Denis Khalaev
 */
public interface ClientDAO {

    Client getOne(Long clientId);

    List<Client> getAllClient();

}
