package com.wk.task1spring.mapper;

import com.wk.task1spring.model.CashFlow;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Denis Khalaev
 */
public class CashFlowMapper implements RowMapper<CashFlow> {
    @Override
    public CashFlow mapRow(ResultSet resultSet, int i) throws SQLException {
        CashFlow cashFlow = new CashFlow();
        cashFlow.setIdCashFlow(resultSet.getLong("id_cash_flow"));
        cashFlow.setClientId(resultSet.getLong("client_id"));
        cashFlow.setDate(resultSet.getDate("date"));
        cashFlow.setPayment(resultSet.getDouble("pay"));
        cashFlow.setRefill(resultSet.getDouble("refill"));
        return cashFlow;
    }
}
