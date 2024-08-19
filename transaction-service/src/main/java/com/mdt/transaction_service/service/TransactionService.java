package com.mdt.transaction_service.service;

import com.mdt.transaction_service.model.AccountResponse;
import com.mdt.transaction_service.model.Transaction;
import com.mdt.transaction_service.model.TransactionRequest;

public interface TransactionService {
    Transaction addAccount(TransactionRequest transactionRequest, AccountResponse accountResponse);
    Transaction withdrawAmount(TransactionRequest transactionRequest);
}
