package com.mdt.account_service.controller;

import com.mdt.account_service.Exception.AccountInformationNotFoundException;
import com.mdt.account_service.Exception.BadRequestException;
import com.mdt.account_service.config.JwtGeneratorImpl;
import com.mdt.account_service.model.*;
import com.mdt.account_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController

public class AccountController {
    @Autowired
    private JwtGeneratorImpl jwtGenerator;

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<?> registerUser(@RequestBody UserRequest userRequest) {
        try {
            if(userRequest.getUserName() == null && userRequest.getPassword() == null) {
                throw new BadRequestException();
            }
            userService.add(userRequest);
            return new ResponseEntity<>(jwtGenerator.generateToken(userRequest), HttpStatus.CREATED);
        } catch (BadRequestException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("auth/login")
    public ResponseEntity<?> loginUser(@RequestBody UserRequest userRequest ){
        User userNameExists = userService.findUserByUserName(userRequest.getUserName());
        if(userNameExists != null) {
            if (userRequest.getPassword().equals(userNameExists.getPassword())) {
                return new ResponseEntity<>("login-user", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Invalid Credential", HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/accounts")
    public ResponseEntity<Account> createAccount(@RequestBody AccountRequest accountRequest) {
        User userExist = userService.findUserByUserName(accountRequest.getUserName());
        if(userExist != null) {
            Account account = userService.addAccount(accountRequest, userExist.getId());
            return new ResponseEntity<Account>(account, HttpStatus.CREATED);
        }
        return new ResponseEntity<Account>((Account) null, HttpStatus.NOT_FOUND);


    }
    @GetMapping("/accounts/{accountId}/balance")
    public ResponseEntity<?> getAccountInformation(@PathVariable int accountId)  {
        try {

            AccountResponse accountResponse = userService.getAccountById(accountId);
                return new ResponseEntity<AccountResponse>(accountResponse, HttpStatus.OK);

        } catch ( AccountInformationNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);


        }


    }
    @PutMapping("/accounts/{accountId}")
    public ResponseEntity<Account> updateAccount(@RequestBody AccountRequest accountRequest ,@PathVariable int accountId ) {
        Account existingAccount = userService.getAccountsById(accountId);
        if(existingAccount!=null) {

            Account updatedAccount = userService.updateAccount(accountRequest, accountId,existingAccount.getUserId());
            return new ResponseEntity<Account>(updatedAccount, HttpStatus.OK);
        }
        return new ResponseEntity<Account>((Account) null, HttpStatus.NOT_FOUND);

    }
    @DeleteMapping("/accounts/{accountId}")
    public ResponseEntity<?> deleteAccount(@PathVariable int accountId) {
        userService.deleteAccount(accountId);
        return new ResponseEntity<>("deleted-account", HttpStatus.NO_CONTENT);

    }
    }
