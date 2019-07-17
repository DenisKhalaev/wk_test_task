package com.wk.task1spring.model;

import lombok.Data;

import java.util.Date;

/**
 * @author Denis Khalaev
 */
@Data
public class CashFlow {

    private Long cashFlowId;
    private Long IdClient;
    private Date date;
    private Double payment;
    private Double refill;

}

