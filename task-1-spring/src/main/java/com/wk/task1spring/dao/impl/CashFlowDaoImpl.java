package com.wk.task1spring.dao.impl;

import com.wk.task1spring.dao.CashFlowDao;
import com.wk.task1spring.mapper.CashFlowMapper;
import com.wk.task1spring.model.CashFlow;
import com.wk.task1spring.util.SettingReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author Denis Khalaev
 */
public class CashFlowDaoImpl implements CashFlowDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private SettingReader settingReader = SettingReader.getInstance("sql/mysql_query.properties");

    @Override
    public List<CashFlow> getOneClientCashFlow(Long idClient) {
        return jdbcTemplate.query(settingReader.getSetting("getCashFlowClient"), new CashFlowMapper(), idClient);

    }

    @Override
    public Double getCalcBalanceClientInDB(Long idClient) {
        return (jdbcTemplate.queryForObject(
                settingReader.getSetting("getBalanceClient"), (rs, rowNum) -> rs.getDouble(1), idClient));

    }
}
