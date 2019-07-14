package com.wk.task1spring.service;

import com.wk.task1spring.dto.ClientDTO;

import java.util.List;

/**
 * @author Denis Khalaev
 */
public interface ClientService {
    List<ClientDTO> getAllClientDTO();
}
