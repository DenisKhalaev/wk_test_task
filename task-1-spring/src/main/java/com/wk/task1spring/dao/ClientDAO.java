package com.wk.task1spring.dao;

import com.wk.task1spring.model.Client;

import java.util.List;

/**
 * @author Denis Khalaev
 */
public interface ClientDAO {
    List<Client> getAllClient();
    Client getClient (Long id);
}
