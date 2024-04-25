package com.example.web.controller;

import com.example.web.dto.ClientDto;
import com.example.web.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/{id}")
    ClientDto getClientById(@PathVariable String id) {
        return clientService.getClientById(id);
    }

    @GetMapping
    ClientDto getClientByClientId(@RequestParam String clientId){
        return clientService.getClientByClientId(clientId);
    }

}
