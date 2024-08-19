package com.mdt.transaction_service.repository;

import com.mdt.transaction_service.model.Transaction;
import com.mdt.transaction_service.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionListRepository extends JpaRepository<Transactions,Integer> {
}
