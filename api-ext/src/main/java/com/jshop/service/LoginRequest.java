package com.jshop.service;

public class LoginRequest {

	private String tenant;
	private String userName;
	private String password;
	
	public String getTenant() {
		return tenant;
	}
	public void setTenantId(String tenant) {
		this.tenant = tenant;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
}
