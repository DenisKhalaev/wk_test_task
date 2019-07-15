package com.wk.task1spring.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author Denis Khalaev
 */
@Data
@XmlRootElement
public class Clients {
    List<ClientDTO> client;
}
