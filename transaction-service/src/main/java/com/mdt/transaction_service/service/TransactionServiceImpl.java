package com.mdt.transaction_service.service;

import com.mdt.transaction_service.model.AccountResponse;
import com.mdt.transaction_service.model.Transaction;
import com.mdt.transaction_service.model.TransactionRequest;
import com.mdt.transaction_service.model.Transactions;
import com.mdt.transaction_service.repository.TransactionListRepository;
import com.mdt.transaction_service.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private TransactionListRepository transactionListRepository;

    @Override
    public Transaction addAccount(TransactionRequest transactionRequest , AccountResponse accountResponse) {
   Transaction existingTransaction= transactionRepository.findTransactionByAccountId(transactionRequest.getAccountId());
   List<Transaction> transactionsList = new ArrayList<>();

        if(existingTransaction != null) {
            List<Transactions> listOfTransaction = transactionListRepository.findAll();
            for (Transactions transactions : listOfTransaction) {
                List<Transaction> t = transactions.getTransactionList();
                for (Transaction i : t) {
                    int totalAmount = i.getTotalAmount();
                    int total = totalAmount + transactionRequest.getAmount();
                    Transaction transaction = Transaction.builder().accountId(transactionRequest.getAccountId()).totalAmount(total).amount(transactionRequest.getAmount()).description(transactionRequest.getDescription()).build();
                    transactionsList.add(transaction);
                    Transactions.builder().transactionList(transactionsList);
                    return transactionRepository.save(transaction);
                }
                return null;
            }
        }
        int total = accountResponse.getBalance() + transactionRequest.getAmount();
        Transaction initialTransaction = Transaction.builder().accountId(transactionRequest.getAccountId()).totalAmount(total).amount(transactionRequest.getAmount()).description(transactionRequest.getDescription()).build();
        transactionsList.add(initialTransaction);
        Transactions.builder().transactionList(transactionsList);
        return transactionRepository.save(initialTransaction);


    }

    @Override
    public Transaction withdrawAmount(TransactionRequest transactionRequest) {
       /*Transaction transaction= transactionRepository.findTransactionByAccountId(transactionRequest.getAccountId());
       int withdrawAmt =transactionRequest.getAmount();
       int totalAmount = transaction.getTotalAmount()-withdrawAmt ;
        Transaction transaction1 =Transaction.builder().accountId(transactionRequest.getAccountId()).totalAmount(totalAmount).amount(transactionRequest.getAmount()).description(transactionRequest.getDescription()).build();
        return transactionRepository.save(transaction1);*/
return null;
    }
}
