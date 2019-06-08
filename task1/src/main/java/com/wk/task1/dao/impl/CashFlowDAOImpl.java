package com.wk.task1.dao.impl;

import com.wk.task1.dao.CashFlowDAO;
import com.wk.task1.jdbc.DBConnector;
import com.wk.task1.jdbc.SQLQuery;
import com.wk.task1.model.CashFlow;

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
public class CashFlowDAOImpl implements CashFlowDAO {

    private Connection connection = DBConnector.getInstance().getConnection();

    @Override
    public List<CashFlow> getOneClient(Long clientId) {
        String query = SQLQuery.getInstance().getQuery("getCashFlowClient");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<CashFlow> cashFlowByClient = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, clientId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                CashFlow cashFlow = new CashFlow();
                cashFlow.setIdCashFlow(resultSet.getLong("id_cash_flow"));
                cashFlow.setClientId(resultSet.getLong("client_id"));
                cashFlow.setDate(resultSet.getDate("date"));
                cashFlow.setPayment(resultSet.getDouble("pay"));
                cashFlow.setRefill(resultSet.getDouble("refill"));
                cashFlowByClient.add(cashFlow);
            }
            return cashFlowByClient;
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            closeConnection(preparedStatement, resultSet);
        }
        return null;
    }

    @Override
    public Double getCalcBalanceClientInDB(Long clientId) {
        String query = SQLQuery.getInstance().getQuery("getBalanceClient");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, clientId);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getDouble(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(preparedStatement, resultSet);
        }
        return 0.0;
    }
}