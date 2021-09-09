package com.example.order;

public class TransactionResponse {

	private CustomerOrder order;
	private double amount;
	private String transactionId;
	private String status;
	public CustomerOrder getOrder() {
		return order;
	}
	public void setOrder(CustomerOrder order) {
		this.order = order;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "TransactionResponse [order=" + order + ", amount=" + amount + ", transactionId=" + transactionId
				+ ", status=" + status + "]";
	}
	
}
