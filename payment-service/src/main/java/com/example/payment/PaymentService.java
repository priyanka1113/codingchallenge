package com.example.payment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class PaymentService {
	@Autowired
	private PaymentRepo paymentRepo;

	public Payment createPayment(Payment payment) {
		payment.setPaymentStatus(paymentStatus());
		payment.setTransctionId(UUID.randomUUID().toString());
		return paymentRepo.save(payment);
	}

	public String paymentStatus() {
		return new Random().nextBoolean() ? "Open" : "Close";
	}

	public Payment addPaymentType(Payment payment) {
		return paymentRepo.save(payment);
	}
	
	public Payment getOrderPrice(@PathVariable("id") int orderid){
		return paymentRepo.getOrderPrice(orderid);
				
	}
	
	public Optional<Payment> getPayment(@PathVariable("id") int orderid){
		return paymentRepo.findById(orderid);
				
	}

	public String exportReport(String reportFormat) throws JRException, FileNotFoundException {
		List<Payment> payment = paymentRepo.findAll();
		// load file and compile it
		String path = "C:\\Users\\Priyanka\\Desktop";
		File file = ResourceUtils.getFile("classpath:SalesReport.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(payment);
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("created by", "Priyanka");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, datasource);
		
		if (reportFormat.equalsIgnoreCase("html")) {
			JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\CitySalesReport.html");
		}
		if (reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\CitySalesReport.pdf");

		}
		return "Sales Report Generated at" + path;
	}
}
