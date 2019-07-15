package com.wk.task2spring.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

/**
 * @author Denis Khalaev
 */
@Data
@JsonAutoDetect
public class Client {

    private Long idClient;
    private String name;
    private Tariff tariff;
    private Double balance;
}
