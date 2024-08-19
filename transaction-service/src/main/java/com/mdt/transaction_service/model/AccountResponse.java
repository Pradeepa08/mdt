package com.mdt.transaction_service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountResponse {
    private Integer accountId;
    private Integer balance;
}
