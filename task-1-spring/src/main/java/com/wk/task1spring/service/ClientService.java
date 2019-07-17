package com.wk.task1spring.service;

import com.wk.task1spring.dto.ClientDto;

import java.util.List;

/**
 * @author Denis Khalaev
 */
public interface ClientService {
    List<ClientDto> getAllClientDto();
}
