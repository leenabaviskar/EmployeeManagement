package com.crudMvc.model;


public class AdminAccount
{
	int adminId;
	String adminUserName;
	String adminEmail;
	String adminPassword;
	public AdminAccount(int adminId, String adminUserName, String adminEmail, String adminPassword) {
		super();
		this.adminId = adminId;
		this.adminUserName = adminUserName;
		this.adminEmail = adminEmail;
		this.adminPassword = adminPassword;
	}
	
	
	public AdminAccount() {
		super();
	}


	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminUserName() {
		return adminUserName;
	}
	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
	

}



