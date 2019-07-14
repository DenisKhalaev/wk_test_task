package com.wk.task1spring.dao.impl;

import com.wk.task1spring.dao.TariffDAO;
import com.wk.task1spring.mapper.TariffMapper;
import com.wk.task1spring.model.Tariff;
import com.wk.task1spring.util.SettingReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author Denis Khalaev
 */
public class TariffDAOImpl implements TariffDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private SettingReader settingReader = SettingReader.getInstance("sql/mysql_query.properties");

    @Override
    public Tariff getOne(Long tariffId) {
        return jdbcTemplate.queryForObject(settingReader.getSetting("getTariffById"), new TariffMapper(), tariffId);
    }

    @Override
    public List<Tariff> getAllTariff() {
        return jdbcTemplate.query(settingReader.getSetting("getAllTariff"), new TariffMapper());
    }
}
