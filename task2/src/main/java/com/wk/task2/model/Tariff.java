package com.wk.task2.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

/**
 * @author Denis Khalaev
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString // for test time
@JsonAutoDetect
public class Tariff {

    private Long idTariff;
    private String nameTariff;
    private Double charge;

}
