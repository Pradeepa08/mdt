package com.mdt.account_service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AccountRequest {
    private String userName;
    private String email;
    private String accountType;
    private Integer initialDeposit;
    private String aadhaar;
}
