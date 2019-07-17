package com.wk.task1spring.dto;


import com.wk.task1spring.model.Tariff;
import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author Denis Khalaev
 */
@Data
@XmlRootElement
public class ClientDto implements Serializable {
    private Long clientId;
    private String name;
    private Tariff tariff;
    private Double balance;

}
