package com.crudMvc.service;

import com.crudMvc.model.AdminAccount;

public interface AdminAccountService 
{
	//method to insert admin details to database
		public void save(AdminAccount admin);
		
		//method to get user and pass from table for login verification
		public AdminAccount getAdminAccountDetail(String username, String password);
}
