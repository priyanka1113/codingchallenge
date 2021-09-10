package com.example.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface OrderRepo extends JpaRepository<CustomerOrder, Integer> {

	@Query(value="select c.orderId,c.prodcutId,c.productQuantity from CustomerOrder c where c.orderId=?1",nativeQuery = true)
	public List<CustomerOrder> getOrderData(int orderId);
	
	

}

