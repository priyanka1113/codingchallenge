package com.example.payment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface PaymentRepo extends JpaRepository<Payment, Integer>{

	
	@Query("select totalPrice from Payment where orderId=?1")
	public Payment getOrderPrice(int orderId);
	
	
	
	
}
