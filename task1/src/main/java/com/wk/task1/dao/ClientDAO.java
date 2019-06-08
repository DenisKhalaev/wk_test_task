package com.wk.task1.dao;

import com.wk.task1.model.Client;

import java.util.List;

/**
 * @author Denis Khalaev
 */
public interface ClientDAO {

    Client getOne(Long clientId);

    List<Client> getAllClient();

}
