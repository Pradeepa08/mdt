package com.mdt.transaction_service.model;

import lombok.Data;

@Data
public class TransactionResponse {
    private Integer accountId;
    private Integer amount;
    private String description;
    private AccountResponse accountResponse;
}
