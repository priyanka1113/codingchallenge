package com.example.order;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/neworder")
	@ResponseBody
	public TransactionResponse createNewOrder(@RequestBody CustomerOrder order)
	{
		return orderService.createNewOrder(order);
		
	}
	
	@GetMapping("/orders")
	@ResponseBody
	public List<CustomerOrder> getOrders() throws Exception{
		return orderService.getOrders();
	}
	
	@GetMapping("/order/{id}")
	@ResponseBody
	public Optional<CustomerOrder> getOrders(@PathVariable("id") int orderid){
		return orderService.getOrderbyId(orderid);
				
	}
	
		
	@GetMapping("/orderdetails/{id}")
	@ResponseBody
	public List<CustomerOrder> getOrderDetails(@PathVariable("id") int orderId) {
		return orderService.getOrderDetails(orderId);
	}
	
}
