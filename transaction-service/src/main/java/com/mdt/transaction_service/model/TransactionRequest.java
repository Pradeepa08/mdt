package com.mdt.transaction_service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TransactionRequest {
    private Integer accountId;
    private Integer amount;
    private String description;
}
