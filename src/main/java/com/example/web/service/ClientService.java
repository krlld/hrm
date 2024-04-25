package com.example.web.service;

import com.example.web.dto.ClientDto;

public interface ClientService {

    ClientDto getClientById(String id);

    ClientDto getClientByClientId(String email);

}
