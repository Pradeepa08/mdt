package com.mdt.transaction_service.controller;

import com.mdt.transaction_service.model.AccountResponse;
import com.mdt.transaction_service.model.Transaction;
import com.mdt.transaction_service.model.TransactionRequest;
import com.mdt.transaction_service.service.AccountClient;
import com.mdt.transaction_service.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/transactions")
@RestController
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @Autowired
    private AccountClient accountClient;

    @GetMapping("/sample")
    public String sam(){
        return "welcome";
    }
    @PostMapping("/deposit")
    public ResponseEntity<?> deposit(@RequestBody TransactionRequest transactionRequest){
        ResponseEntity<AccountResponse>  accountResponse=accountClient.getAccountInformation(transactionRequest.getAccountId());
        if(accountResponse!=null) {
            Transaction transaction = transactionService.addAccount(transactionRequest, accountResponse.getBody());
            return new ResponseEntity<Transaction>(transaction, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Account Not Found", HttpStatus.NOT_FOUND);


    }
    @PostMapping("/withdraw")
    public ResponseEntity<?> withdraw(@RequestBody TransactionRequest transactionRequest){
        Transaction transaction =  transactionService.withdrawAmount(transactionRequest);
        return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
    }

    }
