package com.kanni.keycloak.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestInput {

    private String username;

    private String password;

    private String clientId;

    private String secret;

    private String grant_type;
}
