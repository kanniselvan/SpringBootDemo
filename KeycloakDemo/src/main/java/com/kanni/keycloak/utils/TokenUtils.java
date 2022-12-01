package com.kanni.keycloak.utils;

import com.kanni.keycloak.model.KeyClockTokenInfo;
import lombok.experimental.UtilityClass;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.security.core.context.SecurityContextHolder;

import java.security.Principal;

@UtilityClass
public class TokenUtils {

    public KeyClockTokenInfo getUserInfo(){
        KeycloakAuthenticationToken authentication = (KeycloakAuthenticationToken) SecurityContextHolder.getContext()
                .getAuthentication();

        final Principal principal = (Principal) authentication.getPrincipal();

        String dob = "";

        if (principal instanceof KeycloakPrincipal) {

            KeycloakPrincipal<KeycloakSecurityContext> kPrincipal = (KeycloakPrincipal<KeycloakSecurityContext>) principal;
            AccessToken token =  kPrincipal.getKeycloakSecurityContext()
                    .getToken();

            return new KeyClockTokenInfo(token);
        }
        return null;
    }
}
