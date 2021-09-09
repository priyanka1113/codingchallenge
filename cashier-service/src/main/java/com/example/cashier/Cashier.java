package com.example.cashier;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cashier {
	@Id
	private int cashierId;
	private String name;
	private String user;
	private String pwd;
	private String token;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

	public int getCahierId() {
		return cashierId;
	}

	public void setCahierId(int cahierId) {
		this.cashierId = cahierId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Cashier [cashierId=" + cashierId + ", name=" + name + ", user=" + user + ", pwd=" + pwd + ", token="
				+ token + "]";
	}

	

}
