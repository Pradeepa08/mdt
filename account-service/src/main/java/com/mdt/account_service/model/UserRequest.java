package com.mdt.account_service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserRequest {
    private String userName;
    private String password;
    private String email;
    private String role;
}
