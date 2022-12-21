package com.kanni.service;

import com.kanni.exception.ServerBusyException;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MyRetrieveServiceImpl implements MyRetrieveService {

    @Override
    public String pushingMessageTOExternalSystem(String message) {
        System.out.println("call Invoke pushingMessageTOExternalSystem !!! : "+ Thread.currentThread().getName());
        boolean flag= new Random().nextBoolean();

        if(flag){
            System.out.println("============================================");
            return "successfully push message to External Server!!!!!!!!!!";

        }

        throw new ServerBusyException("Server busy Try sometimes later!!!");
    }

    @Override
    public String recover(ServerBusyException e, String errorMessage) {
        return "Server busy Try sometimes later!!!";
    }
}
