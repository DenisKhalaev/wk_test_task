package com.wk.task1.model;

import lombok.*;

/** Класс отражающий талицу в БД
 * @author Denis Khalaev
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString // for test time
public class Client {

    private Long idClient;
    private String name;
    private Long tariffId;

}
