package com.wk.task1spring.dao;

import com.wk.task1spring.model.Tariff;

import java.util.List;

/**
 * @author Denis Khalaev
 */
public interface TariffDAO {

    Tariff getOne(Long tariffId);

    List<Tariff> getAllTariff();
}
