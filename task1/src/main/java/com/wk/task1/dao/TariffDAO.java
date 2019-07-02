package com.wk.task1.dao;

import com.wk.task1.model.Tariff;

import java.util.List;

/** Интерфейс обеспечивающий доступ данных к базе данных MySQL (таблица тарифы)
 *
 * @author Denis Khalaev
 */
public interface TariffDAO {

    Tariff getOne(Long tariffId);

    List<Tariff> getAllTariff();

}
