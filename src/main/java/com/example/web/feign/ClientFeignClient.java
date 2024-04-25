package com.example.web.feign;

import com.example.web.dto.ClientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "clientFeignClient",
        url = "${keycloak.realm-uri}/clients"
)
public interface ClientFeignClient {

    @GetMapping("/{id}")
    ClientDto getClientById(@PathVariable String id);

    @GetMapping
    ClientDto getClientByClientId(@RequestParam String client);

}
