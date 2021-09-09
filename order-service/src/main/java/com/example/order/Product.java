package com.example.order;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Product {

	@Id
	private int ID;
	private String Name;
	private String UPC;
	private float price;
	private int inventoryCount;
	@ManyToMany
	private List<CustomerOrder> customerorder = new ArrayList<CustomerOrder>();
	
	public List<CustomerOrder> getCustomerorder() {
		return customerorder;
	}

	public void setCustomerorder(List<CustomerOrder> customerorder) {
		this.customerorder = customerorder;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getUPC() {
		return UPC;
	}

	public void setUPC(String uPC) {
		UPC = uPC;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getInventoryCount() {
		return inventoryCount;
	}

	public void setInventoryCount(int inventoryCount) {
		this.inventoryCount = inventoryCount;
	}

	@Override
	public String toString() {
		return "Product [ID=" + ID + ", Name=" + Name + ", UPC=" + UPC + ", price=" + price + ", inventoryCount="
				+ inventoryCount + ", customerorder=" + customerorder + "]";
	}

	
}
