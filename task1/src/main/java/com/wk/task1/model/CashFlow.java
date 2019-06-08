package com.wk.task1.model;

import lombok.*;

import java.util.Date;

/**
 * @author Denis Khalaev
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString // for test time
public class CashFlow {

    private Long idCashFlow;
    private Long clientId;
    private Date date;
    private Double payment;
    private Double refill;

}

