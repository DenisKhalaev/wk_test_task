package com.wk.task1.service;

import com.wk.task1.dto.ClientDTO;
import com.wk.task1.model.Client;

import java.util.List;

/** Интерфейс отвечающий за составление списка клиентов
 * @author Denis Khalaev
 */
public interface ClientService {

    List<ClientDTO> getAllClientDTO();
}
