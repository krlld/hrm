package com.example.web.service.impl;

import com.example.web.dto.ClientDto;
import com.example.web.feign.ClientFeignClient;
import com.example.web.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientFeignClient clientFeignClient;

    @Override
    public ClientDto getClientById(String id) {
        return clientFeignClient.getClientById(id);
    }

    @Override
    public ClientDto getClientByClientId(String clientId) {
        return clientFeignClient.getClientByClientId(clientId);
    }
}
