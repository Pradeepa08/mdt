/*
package com.mdt.account_service.service;

import com.mdt.account_service.model.TransactionRequest;
import com.mdt.account_service.model.TransactionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@FeignClient(name = "transaction-service", url = "http://localhost:9081")

public interface TransactionClient {
    @PostMapping("/transactions/deposit")
    public ResponseEntity<TransactionResponse> deposit(@RequestBody TransactionRequest transactionRequest);
}
*/
