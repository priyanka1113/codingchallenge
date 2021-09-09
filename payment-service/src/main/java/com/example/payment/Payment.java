package com.example.payment;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Payment {
	@Id
	private int paymentID;
	private String type;
	private int orderId;
	private double totalPrice;
	private String paymentStatus;
	private String transctionId;
	

	public String getTransctionId() {
		return transctionId;
	}

	public void setTransctionId(String transctionId) {
		this.transctionId = transctionId;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Payment [paymentID=" + paymentID + ", type=" + type + ", orderId=" + orderId + ", totalPrice="
				+ totalPrice + ", paymentStatus=" + paymentStatus + ", transctionId=" + transctionId + "]";
	}

	
	

	
}
