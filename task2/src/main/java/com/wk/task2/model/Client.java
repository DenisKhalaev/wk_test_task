package com.wk.task2.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

/**
 * Класс модель клиента
 *
 * @author Denis Khalaev
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString // for test time
@JsonAutoDetect

public class Client {

    private Long idClient;
    private String name;
    private Tariff tariff;
    private Double balance;

}
