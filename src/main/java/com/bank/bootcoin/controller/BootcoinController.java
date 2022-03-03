package com.bank.bootcoin.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.bootcoin.model.Bootcoin;
import com.bank.bootcoin.model.BootcoinWallet;
import com.bank.bootcoin.model.MessageDto;
import com.bank.bootcoin.service.BootcoinService;
import com.bank.bootcoin.service.BootcoinWalletService;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/bootcoin")
public class BootcoinController {

	private final BootcoinService service;
	private final BootcoinWalletService walletService;
	
	@GetMapping("/coin")
	public Mono<Bootcoin> getBootcoin(){
		return service.findCoin();
	}
	
	@PostMapping("/coin")
	public Mono<Boolean> save(@RequestBody Bootcoin bootcoin){
		return service.save(bootcoin);
	}
	
	@GetMapping("/wallet")
	public Flux<BootcoinWallet> findAll() {
		return walletService.findAll();
	}
	
	@GetMapping("/wallet/{id}")
	public Mono<BootcoinWallet> findById(@PathVariable("id") String id) {
		return walletService.findById(id);
	}
	
	@PostMapping("/wallet")
	public Mono<BootcoinWallet> save(@RequestBody BootcoinWallet bootcoinWallet) {
		return  walletService.save(bootcoinWallet);
	}
	
	@DeleteMapping("/wallet/{id}")
    public void delete(@PathVariable("id")String id) {
		walletService.deleteById(id);
    }
	
	@PostMapping("/wallet/buy-request")
	public void save(@RequestBody MessageDto message) {
		walletService.bootcoinBuyRequest(message);
	}
}
