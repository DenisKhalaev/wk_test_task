package com.wk.task1.dao.impl;

import com.wk.task1.dao.TariffDAO;
import com.wk.task1.jdbc.DBConnector;
import com.wk.task1.jdbc.SQLQuery;
import com.wk.task1.model.Tariff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.wk.task1.util.PropertyUtils.closeConnection;

/**класс реализует интерфейс TariffDAO, получает данные из таблиц БД MySQL,
 * с использованием JDBC.
 *
 * @author Denis Khalaev
 */
public class TariffDAOImpl implements TariffDAO {

    private Connection connection = DBConnector.getInstance().getConnection();

    /**
     * Метод получает из базы тариф по Id
     * @param tariffId тариф id
     * @return Tariff
     */
    @Override
    public Tariff getOne(Long tariffId) {
        String query = SQLQuery.getInstance().getQuery("getTariffById");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Tariff tariff = new Tariff();
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, tariffId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                tariff.setIdTariff(resultSet.getLong("id_tariff"));
                tariff.setNameTariff(resultSet.getString("name_tariff"));
                tariff.setCharge(resultSet.getDouble("charge"));
            }
            return tariff;
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            closeConnection(preparedStatement, resultSet);
        }
        return null;
    }

    /**
     * Метод получает список всех тарифов
     *
     * @return список тарифов
     */
    @Override
    public List<Tariff> getAllTariff() {
        String query = SQLQuery.getInstance().getQuery("getAllTariff");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Tariff> tariffs = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Tariff tariff = new Tariff();
                tariff.setIdTariff(resultSet.getLong("id_tariff"));
                tariff.setNameTariff(resultSet.getString("name_tariff"));
                tariff.setCharge(resultSet.getDouble("charge"));
                tariffs.add(tariff);
            }
            return tariffs;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(preparedStatement, resultSet);
        }
        return null;
    }

}
