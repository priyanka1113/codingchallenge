package com.example.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface OrderRepo extends JpaRepository<CustomerOrder, Integer> {

	@Query("select orderId,productId,productQuantity from CustomerOrder where orderId=?1")
	public List<CustomerOrder> getOrderData(int orderId);
	
	

}
