package com.kanni.keycloak.controller;

import com.kanni.keycloak.service.RemoteProductService;
import com.kanni.keycloak.utils.TokenUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
@Slf4j
public class TestController {

    @Autowired
    private  HttpServletRequest request;

    @Autowired
    KeycloakRestTemplate restTemplate;

    @Autowired
    RemoteProductService remoteProductService;


    private KeycloakSecurityContext getKeycloakSecurityContext() {
        return (KeycloakSecurityContext) request.getAttribute(KeycloakSecurityContext.class.getName());
    }

    @RolesAllowed("ROLE_HMS_ADMIN")
    @GetMapping(value = "/anonymous")
    public ResponseEntity<String> getAnonymous() {
               return ResponseEntity.ok("Response: "+ TokenUtils.getUserInfo());
    }

    @RolesAllowed("ROLE_HAS_USER")
    @GetMapping(value = "/user")
    public ResponseEntity<String> getUser() {
        return ResponseEntity.ok("Hello User"+ getKeycloakSecurityContext().getToken().getGivenName());
    }

    @RolesAllowed("ROLE_HMS_ADMIN")
    @GetMapping(value = "/admin")
    public ResponseEntity<String> getAdmin() {
        return ResponseEntity.ok("Hello Admin"+ getKeycloakSecurityContext().getToken().getGivenName());
    }

    @RolesAllowed("ROLE_HAS_USER")
    @GetMapping(value = "/all-user")
    public ResponseEntity<String> getAllUser() {
        return ResponseEntity.ok("Hello All User"+ getKeycloakSecurityContext().getToken().getGivenName());
    }
}