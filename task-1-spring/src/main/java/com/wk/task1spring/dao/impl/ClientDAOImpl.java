package com.wk.task1spring.dao.impl;

import com.wk.task1spring.dao.ClientDAO;
import com.wk.task1spring.mapper.ClientMapper;
import com.wk.task1spring.model.Client;
import com.wk.task1spring.util.SettingReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author Denis Khalaev
 */
public class ClientDAOImpl implements ClientDAO {


    @Autowired
    private JdbcTemplate jdbcTemplate;
    private SettingReader settingReader = SettingReader.getInstance("sql/mysql_query.properties");

    @Override
    public Client getClient(Long idClient) {
        return jdbcTemplate.queryForObject(settingReader.getSetting("getClientById"), new ClientMapper(), idClient);
    }

    @Override
    public List<Client> getAllClient() {
        return jdbcTemplate.query(settingReader.getSetting("getAllClient"), new ClientMapper());
    }
}
