package com.kanni.service;

import com.kanni.exception.ServerBusyException;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

public interface MyRetrieveService {

    @Retryable(value = ServerBusyException.class,maxAttempts = 2)
   String pushingMessageTOExternalSystem(String message);

  @Recover
  String recover(ServerBusyException e, String errorMessage);
}
