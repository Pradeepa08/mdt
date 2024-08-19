package com.mdt.account_service.service;

import com.mdt.account_service.Exception.AccountInformationNotFoundException;
import com.mdt.account_service.Exception.BadRequestException;
import com.mdt.account_service.model.*;
import com.mdt.account_service.repository.AccountRepository;
import com.mdt.account_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;
   /* @Autowired
    private TransactionClient transactionClient;*/
    @Override
    public void add(UserRequest userRequest) {
        User user= User.builder().userName(userRequest.getUserName()).password(userRequest.getPassword()).email(userRequest.getEmail()).role(userRequest.getRole()).build();
        userRepository.save(user);
    }

    @Override
    public Account addAccount(AccountRequest accountRequest, Integer userId) {
       Account account =Account.builder().userId(userId).userName(accountRequest.getUserName()).email(accountRequest.getEmail()).accountType(accountRequest.getAccountType()).balance(accountRequest.getInitialDeposit()).aadhaar(accountRequest.getAadhaar()).build();
       return accountRepository.save(account);
    }

    @Override
    public User findUserByUserName(String userName) {
       return userRepository.findUserByUserName(userName);
    }

    @Override
    public AccountResponse getAccountById(int accountId) throws AccountInformationNotFoundException {
       Account accountDetails = accountRepository.findAccountByAccountId(accountId);

        if(accountDetails == null){
            throw new AccountInformationNotFoundException();
        }
        AccountResponse accountID =AccountResponse.builder().accountId(accountDetails.getAccountId()).balance(accountDetails.getBalance()).build();

return accountID;
    }

    @Override
    public Account getAccountsById(int accountId) {
        Account accountDetails = accountRepository.findAccountByAccountId(accountId);
return accountDetails;
    }

    @Override
    public Account updateAccount(AccountRequest accountRequest, int accountId, Integer userId) {
         Account updated = Account.builder().userId(userId).accountId(accountId).userName(accountRequest.getUserName()).email(accountRequest.getEmail()).accountType(accountRequest.getAccountType()).balance(accountRequest.getInitialDeposit()).aadhaar(accountRequest.getAadhaar()).build();
        return accountRepository.save(updated);

    }

    @Override
    public void deleteAccount(int accountId) {
        accountRepository.deleteById(accountId);
    }


//    @Override
//    public User findUserPassword(String password) {
//        return userRepository.findUserPassword(password);
//    }


}
