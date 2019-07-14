package com.wk.task1spring.dao;

import com.wk.task1spring.model.CashFlow;

import java.util.List;

/**
 * @author Denis Khalaev
 */
public interface CashFlowDAO {

    List<CashFlow> getOneClient(Long idClient);

    Double getCalcBalanceClientInDB(Long idClient);
}
