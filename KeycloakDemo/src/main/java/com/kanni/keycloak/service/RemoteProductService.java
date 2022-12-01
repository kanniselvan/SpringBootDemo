package com.kanni.keycloak.service;

import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RemoteProductService {


    @Autowired
    private KeycloakRestTemplate template;

    private String endpoint="http://localhost:8080/realms/SpringBootApp/protocol/openid-connect/token";


    public List<String> getProducts() {
        ResponseEntity<String[]> response = template.getForEntity(endpoint, String[].class);
        return Arrays.asList(response.getBody());
    }
}
