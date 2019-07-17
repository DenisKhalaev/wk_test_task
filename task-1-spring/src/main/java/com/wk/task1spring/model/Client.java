package com.wk.task1spring.model;

import lombok.*;

/**
 * @author Denis Khalaev
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString // for test time
public class Client {

    private Long clientId;
    private String name;
    private Long IdTariff;

}
