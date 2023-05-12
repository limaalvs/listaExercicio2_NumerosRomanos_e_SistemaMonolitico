package com.fit.tarefas.tarefa.Exercico2;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;	

@RestController
@RequestMapping("/account")
public class AccountController {

	private Account account = new Account();

	@GetMapping
	public ResponseEntity<BigDecimal> getBalance() {
		return new ResponseEntity<>(account.getBalance(), HttpStatus.OK);
	}

	@PostMapping(value = "/deposit")
	public ResponseEntity<BigDecimal> deposit(@RequestBody String value) {
		TransactionType.DEPOSIT.doTransactionOperation(account, new BigDecimal(value));
		return new ResponseEntity<>(account.getBalance(), HttpStatus.OK);
	}

	@PostMapping(value = "/withdrawal")
	public ResponseEntity<BigDecimal> withdrawal(@RequestBody String value) {
		TransactionType.WITHDRAWAL.doTransactionOperation(account, new BigDecimal(value));
		return new ResponseEntity<>(account.getBalance(), HttpStatus.OK);
	}

}
