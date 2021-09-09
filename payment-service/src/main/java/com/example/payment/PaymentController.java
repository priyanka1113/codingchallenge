package com.example.payment;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JRException;

@RestController
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/makePayment")
	public Payment createPayment(@RequestBody Payment payment) {
		return paymentService.createPayment(payment);
	}
	
	@PutMapping("/makePayment/type/{type}")
	public Payment paymentType(@RequestBody Payment payment) {
		return paymentService.addPaymentType(payment);
	}
	
	@GetMapping("/generateReport/{reportFormat}")
	//@ResponseBody
	public String exportReport(@PathVariable("reportFormat") String reportFormat) throws FileNotFoundException, JRException {
		return paymentService.exportReport(reportFormat);
		
	}
	
	@GetMapping("/orderPrice/{id}")
	@ResponseBody
	public Payment getOrderPrice(@PathVariable("id") int orderid){
		return paymentService.getOrderPrice(orderid);
				
	}
	
	
	@GetMapping("/payments/{id}")
	@ResponseBody
	public Optional<Payment> getPaymentDetails(@PathVariable("id") int orderid){
		return paymentService.getPayment(orderid);
				
	}

	
	
	
}
