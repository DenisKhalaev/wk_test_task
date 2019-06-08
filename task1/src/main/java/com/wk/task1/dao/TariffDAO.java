package com.wk.task1.dao;

import com.wk.task1.model.Tariff;

import java.util.List;

/**
 * @author Denis Khalaev
 */
public interface TariffDAO {

    Tariff getOne(Long tariffId);

    List<Tariff> getAllTariff();

}
