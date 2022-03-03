package com.bank.bootcoin.service;

import com.bank.bootcoin.model.Bootcoin;

import reactor.core.publisher.Mono;

public interface BootcoinService {

	public Mono<Bootcoin> findCoin();
	public Mono<Boolean> save(Bootcoin bootcoin);
	
}
