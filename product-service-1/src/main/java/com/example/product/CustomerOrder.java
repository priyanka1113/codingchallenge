package com.example.product;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity

public class CustomerOrder {

	@Id

	@GeneratedValue
	private int orderId;
	// @OneToOne
	//private Cashier cashier;
	//@ManyToMany(mappedBy = "customerorder")
	//private List<Product> product = new ArrayList<Product>();
	private int productId;
	private String productName;
	private int productQuantity;
	/*
	 * private int productId; private String productName;
	 */

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	/*
	 * public String getProductName() { return productName; } public void
	 * setProductName(String productName) { this.productName = productName; }
	 */
	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "CustomerOrder [orderId=" + orderId + ", productId=" + productId + ", productName=" + productName
				+ ", productQuantity=" + productQuantity + "]";
	}

	
	/*
	 * public float getProductPrice() { return productPrice; } public void
	 * setProductPrice(float productPrice) { this.productPrice = productPrice; }
	 */
	/*
	 * public int getProductId() { return productId; } public void setProductId(int
	 * productId) { this.productId = productId; } public String getProductName() {
	 * return productName; } public void setProductName(String productName) {
	 * this.productName = productName; }
	 */
	/*
	 * public Cashier getCashier() { return cashier; }
	 * 
	 * public void setCashier(Cashier cashier) { this.cashier = cashier; }
	 * 
	 * public List<Product> getProduct() { return product; }
	 * 
	 * public void setProduct(List<Product> product) { this.product = product; }
	 * 
	 * @Override public String toString() { return "CustomerOrder [orderId=" +
	 * orderId + ", cashier=" + cashier + ", product=" + product +
	 * ", productQuantity=" + productQuantity + ", productId=" + productId + "]"; }
	 */
}
