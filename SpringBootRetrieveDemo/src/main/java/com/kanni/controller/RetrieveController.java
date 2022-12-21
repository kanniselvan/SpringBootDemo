package com.kanni.controller;

import com.kanni.service.MyRetrieveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RetrieveController {

    @Autowired
    MyRetrieveService myRetrieveService;

    @GetMapping
    public String messagePushing(@RequestParam String message){
        return myRetrieveService.pushingMessageTOExternalSystem(message);
    }
}
