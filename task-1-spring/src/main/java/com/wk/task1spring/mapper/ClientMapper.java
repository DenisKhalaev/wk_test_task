package com.wk.task1spring.mapper;

import com.wk.task1spring.model.Client;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Denis Khalaev
 */
public class ClientMapper implements RowMapper<Client> {

    public Client mapRow(ResultSet resultSet, int i) throws SQLException {
        Client client = new Client();
        client.setClientId(resultSet.getLong("id_client"));
        client.setName(resultSet.getString("name_client"));
        client.setIdTariff(resultSet.getLong("tariff_id"));
        return client;
    }
}
