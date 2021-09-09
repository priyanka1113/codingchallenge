package com.example.cashier;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CashierService {
	
	@Autowired
	private CashierRepo repo;
	
	
	public List<Cashier> getCashiers() throws Exception {
	return repo.findAll();	
	}

	
	public Optional<Cashier> getCashierById(int id) {
		return repo.findById(id);
	}

	public Cashier createCashierTerminal(Cashier cashier){
	repo.save(cashier);
	return cashier;
	}
	


}
