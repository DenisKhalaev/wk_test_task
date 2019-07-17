package com.wk.task1spring.model;


import lombok.Data;

/**
 * @author Denis Khalaev
 */
@Data
public class Tariff {

    private Long tariffId;
    private String nameTariff;
    private Double charge;

}
