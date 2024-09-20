package com.crudMvc.service;

import com.crudMvc.model.AdminAccount;
import com.crudMvc.serviceImplementation.AdminAccountServiceImpClass;

public interface AdminAccountService 
{
	//method to insert admin details to database
		public void save(AdminAccount admin);
		
		//method to get user and pass from table for login verification
		public AdminAccount getAdminAccountDetail(String username, String password);
		
		//method to get details by email
		public AdminAccount getAdminByEmail(String adminEmail);
		
		public static boolean isEmailExists(String adminEmail) {
			AdminAccountServiceImpClass ads = new AdminAccountServiceImpClass();
			AdminAccount admin= ads.getAdminByEmail(adminEmail);
			String email=admin.getAdminEmail();
			
			if(email != null) {
			return true;
			}else
				return false;
		}
		
		
}
