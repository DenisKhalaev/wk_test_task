package com.wk.task1spring.dao;

import com.wk.task1spring.model.CashFlow;

import java.util.List;

/**
 * @author Denis Khalaev
 */
public interface CashFlowDao {

    List<CashFlow> getOneClientCashFlow(Long idClient);

    Double getCalcBalanceClientInDB(Long idClient);
}
