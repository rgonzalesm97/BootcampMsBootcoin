package com.bank.bootcoin.service.impl;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.bank.bootcoin.model.BootcoinTransaction;
import com.bank.bootcoin.model.BootcoinWallet;
import com.bank.bootcoin.model.MessageDto;
import com.bank.bootcoin.repository.BootcoinWalletRepository;
import com.bank.bootcoin.service.BootcoinWalletService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BootcoinWalletServiceImpl implements BootcoinWalletService{
	
	private final BootcoinWalletRepository repo;
	private final KafkaTemplate<String, MessageDto> kafkaTemplate;
	
	@Override
	public Flux<BootcoinWallet> findAll() {
		return repo.findAll();
	}

	@Override
	public Mono<BootcoinWallet> findById(String id) {
		return repo.findById(id);
	}

	@Override
	public Mono<BootcoinWallet> findByPhoneNumber(String phoneNumber) {
		return repo.findByPhoneNumber(phoneNumber);
	}

	@Override
	public Mono<BootcoinWallet> save(BootcoinWallet wallet) {
		return repo.save(wallet);
	}

	@Override
	public void deleteById(String id) {
		repo.deleteById(id).subscribe();
	}

	@Override
	public void bootcoinBuyRequest(MessageDto message) {
		kafkaTemplate.send("bootcoinBuyRequest", message);
	}

	@Override
	@KafkaListener(topics="bootcoinBuyRequest", groupId="groupId")
	public void bootcoinAcceptBuyRequest(MessageDto message) {
		//Este sera un numero elegido al azar ya que no hay un UI para que reciba la notificacion y le de aceptar al request
		
		BootcoinTransaction transaction = generateTransaction(message.getPhoneNumber(), "94351684", message.getAmount());
		System.out.println(transaction);
		
		
	}
	
	//UTIL METHODS
	public BootcoinTransaction generateTransaction(String from, String to, Double amount) {
		return BootcoinTransaction.builder().from(from).to(to).amount(amount).build();
	}
	
	public void validTransaction(BootcoinTransaction transaction) {
		
	}


}
