package com.wk.task1.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.wk.task1.model.Tariff;
import lombok.*;

/**
 * @author Denis Khalaev
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString // for test time
@JacksonXmlRootElement(localName = "Client")
public class ClientDTO {
    private Long idClient;
    private String name;
    private Tariff tariff;
    private Double balance;

}
