package com.mdt.account_service.repository;

import com.mdt.account_service.model.Account;
import com.mdt.account_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {

    Account findAccountByAccountId(Integer accountId);
}
