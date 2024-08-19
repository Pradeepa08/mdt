package com.mdt.account_service.service;

import com.mdt.account_service.Exception.AccountInformationNotFoundException;
import com.mdt.account_service.model.*;

public interface UserService {
    void add(UserRequest userRequest);
    Account addAccount(AccountRequest accountRequest, Integer userId );
    User findUserByUserName(String userName);

    AccountResponse getAccountById(int accountId) throws AccountInformationNotFoundException;
    Account getAccountsById(int accountId );

    Account updateAccount(AccountRequest accountRequest, int accountId, Integer userId);

    void deleteAccount(int accountId);
//    User findUserPassword(String password);
}
