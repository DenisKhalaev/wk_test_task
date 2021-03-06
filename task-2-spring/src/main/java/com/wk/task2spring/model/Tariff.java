package com.wk.task2spring.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

/**
 * @author Denis Khalaev
 */
@Data
@JsonAutoDetect
public class Tariff {

    private Long tariffId;
    private String nameTariff;
    private Double charge;

}