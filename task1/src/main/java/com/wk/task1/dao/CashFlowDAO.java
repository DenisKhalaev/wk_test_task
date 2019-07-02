package com.wk.task1.dao;

import com.wk.task1.model.CashFlow;

import java.util.List;

/** Интерфейс обеспечивающий доступ данных к базе данных MySQL (таблица движение средств)
 * @author Denis Khalaev
 */
public interface CashFlowDAO {

    List<CashFlow> getOneClient(Long clientId);

    Double getCalcBalanceClientInDB(Long clientId);

}
