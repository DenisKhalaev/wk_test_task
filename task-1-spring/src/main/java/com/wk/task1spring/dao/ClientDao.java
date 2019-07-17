package com.wk.task1spring.dao;

import com.wk.task1spring.model.Client;

import java.util.List;

/**
 * @author Denis Khalaev
 */
public interface ClientDao {

    List<Client> getAllClient();

    Client getOne(Long clientId);
}
