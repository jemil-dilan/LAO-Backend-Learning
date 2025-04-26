package com.lao.backend.money_transfer;

import org.springframework.boot.SpringApplication;

public class TestMoneyTransferApplication {

	public static void main(String[] args) {
		SpringApplication.from(MoneyTransferApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
