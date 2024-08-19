package com.mdt.transaction_service.service;

import com.mdt.transaction_service.model.AccountResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "account-service", url = "http://localhost:8081")
public interface AccountClient {
    @GetMapping("/accounts/{accountId}/balance")
    public ResponseEntity<AccountResponse> getAccountInformation(@PathVariable("accountId") int accountId);
}
