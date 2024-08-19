package com.mdt.account_service.repository;

import com.mdt.account_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserByUserName(String userName);
//    User findUserPassword(String password);
}
