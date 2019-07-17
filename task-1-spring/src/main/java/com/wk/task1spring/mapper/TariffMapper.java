package com.wk.task1spring.mapper;

import com.wk.task1spring.model.Tariff;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Denis Khalaev
 */
public class TariffMapper implements RowMapper<Tariff> {
    @Override
    public Tariff mapRow(ResultSet resultSet, int i) throws SQLException {
        Tariff tariff = new Tariff();
        tariff.setTariffId(resultSet.getLong("id_tariff"));
        tariff.setNameTariff(resultSet.getString("name_tariff"));
        tariff.setCharge(resultSet.getDouble("charge"));
        return tariff;
    }
}
