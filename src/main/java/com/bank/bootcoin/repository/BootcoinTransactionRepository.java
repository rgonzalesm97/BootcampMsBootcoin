package com.bank.bootcoin.repository;



import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.bank.bootcoin.model.BootcoinTransaction;

@Repository
public interface BootcoinTransactionRepository extends ReactiveMongoRepository<BootcoinTransaction, String> {
}
