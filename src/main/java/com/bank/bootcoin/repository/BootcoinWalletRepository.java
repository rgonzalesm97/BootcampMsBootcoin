package com.bank.bootcoin.repository;


import reactor.core.publisher.Mono;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.bank.bootcoin.model.BootcoinWallet;

@Repository
public interface BootcoinWalletRepository extends ReactiveMongoRepository<BootcoinWallet, String> {
	public Mono<BootcoinWallet> findByPhoneNumber(String phoneNumber);
}
