package com.example.cashier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CashierServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CashierServiceApplication.class, args);
		System.out.println("cahier application running on port 9001");
	}

}
