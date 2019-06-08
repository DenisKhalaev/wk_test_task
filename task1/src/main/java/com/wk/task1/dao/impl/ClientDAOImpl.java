package com.wk.task1.dao.impl;

import com.wk.task1.dao.ClientDAO;
import com.wk.task1.jdbc.DBConnector;
import com.wk.task1.jdbc.SQLQuery;
import com.wk.task1.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.wk.task1.util.PropertyUtils.closeConnection;

/**
 * @author Denis Khalaev
 */
public class ClientDAOImpl implements ClientDAO {

    private Connection connection = DBConnector.getInstance().getConnection();

    @Override
    public Client getOne(Long clientId) {
        String query = SQLQuery.getInstance().getQuery("getClientById");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Client client = new Client();
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, clientId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                client.setIdClient(resultSet.getLong("id_client"));
                client.setName(resultSet.getString("name_client"));
                client.setTariffId(resultSet.getLong("tariff_id"));
            }
            return client;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(preparedStatement, resultSet);
        }
        return null;
    }

    @Override
    public List<Client> getAllClient() {
        String query = SQLQuery.getInstance().getQuery("getAllClient");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Client> clientList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Client client = new Client();
                client.setIdClient(resultSet.getLong("id_client"));
                client.setName(resultSet.getString("name_client"));
                client.setTariffId(resultSet.getLong("tariff_id"));
                clientList.add(client);
            }
            return clientList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(preparedStatement, resultSet);
        }
        return null;
    }
}