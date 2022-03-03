package com.bank.bootcoin.service;

import com.bank.bootcoin.model.BootcoinWallet;
import com.bank.bootcoin.model.MessageDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BootcoinWalletService {

	public Flux<BootcoinWallet> findAll();
	public Mono<BootcoinWallet> findById(String id);
	public Mono<BootcoinWallet> findByPhoneNumber(String phoneNumber);
	public Mono<BootcoinWallet> save(BootcoinWallet wallet);
	public void deleteById(String id);
	
	public void bootcoinBuyRequest(MessageDto message);
	public void bootcoinAcceptBuyRequest(MessageDto message);
}
