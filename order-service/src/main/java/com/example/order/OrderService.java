package com.example.order;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;


@Service
public class OrderService {
	
	@Autowired
	private OrderRepo orderrepo;
	
	@Autowired
    private RestTemplate template;
	
	
	 //@Async("threadPoolTaskExecutor")
	public TransactionResponse createNewOrder(CustomerOrder order)
	{
		orderrepo.save(order);
		final double TAX_RATE =0.13;
		Payment paymentRequest = new Payment();
		paymentRequest.setOrderId(order.getOrderId());
		paymentRequest.setTotalPrice(order.getProductQuantity()*order.getProductPrice()*TAX_RATE);
        Payment paymentRes =
                template.postForObject("http://localhost:9003/makePayment/",
                		paymentRequest, Payment.class);
        TransactionResponse txResponse = new TransactionResponse();
        txResponse.setOrder(order);
        txResponse.setStatus(paymentRes.getPaymentStatus());
        txResponse.setAmount(paymentRes.getTotalPrice());
        txResponse.setTransactionId(paymentRes.getTransctionId());
		
		return txResponse;
	}
	
	public List<CustomerOrder> getOrders() throws Exception{
		return orderrepo.findAll();
		 
	}
	
	public Optional<CustomerOrder> getOrderbyId(int id) {
		return orderrepo.findById(id);
	}
	
	public List<CustomerOrder> getOrderDetails(int orderId) {
		return orderrepo.getOrderData(orderId);
	}
	
	
	
	
	

}
