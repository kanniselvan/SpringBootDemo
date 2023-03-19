package com.kanni.dockerWithSpringBoot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class TestController {

    @GetMapping("/welcome")
    public Principal getMessage(Principal principal){
        return principal;
    }
}
