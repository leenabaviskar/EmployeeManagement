package com.crudMvc.serviceImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.crudMvc.dao.UtilConnectionClass;
import com.crudMvc.model.AdminAccount;
import com.crudMvc.model.Customer;
import com.crudMvc.model.Employee;
import com.crudMvc.service.AdminAccountService;

public class AdminAccountServiceImpClass implements AdminAccountService {
	// method to insert admin details to database
	public void save(AdminAccount admin) {
		try {
			Connection connection = UtilConnectionClass.getConnection();
			PreparedStatement ps = connection.prepareStatement(
					"insert into adminaccount(adminusername, adminemail, adminpassword)values(?,?,?)");

			ps.setString(1, admin.getAdminUserName());
			ps.setString(2, admin.getAdminEmail());
			ps.setString(3, admin.getAdminPassword());
			ps.execute();
			ps.close();
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// method to get user and pass from table for login verification
	public AdminAccount getAdminAccountDetail(String username, String password) {

		AdminAccount admin = new AdminAccount();
		try {

			Connection connection = UtilConnectionClass.getConnection();

			PreparedStatement ps = connection
					.prepareStatement("select * from adminaccount where adminusername = ? and adminpassword = ?");

			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int adminId = rs.getInt(1);
				String adminUserName = rs.getString(2);
				String adminEmail = rs.getString(3);
				String adminPasaword = rs.getString(4);

				admin.setAdminId(adminId);
				admin.setAdminUserName(adminUserName);
				admin.setAdminPassword(adminPasaword);

			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return admin;

	}
	

	//method to get record by email from databas
	public AdminAccount getAdminByEmail(String adminEmail)
	{
		
		AdminAccount admin= new AdminAccount();
		try 
		{
			
			Connection con= UtilConnectionClass.getConnection();
			PreparedStatement ps= con.prepareStatement("select * from adminaccount where adminemail=?");
			
			    ps.setString(1, adminEmail);
			    ResultSet rs=ps.executeQuery();
			    
			    while(rs.next())
			    {
			    	int aid=rs.getInt(1);
			    	String aname= rs.getString(2);
			    	String aemail=rs.getString(3);
			    	String apass=rs.getString(4);
			    	
			    	admin.setAdminId(aid);
			    	admin.setAdminUserName(aname);
			    	admin.setAdminEmail(adminEmail);
			    	admin.setAdminPassword(apass);
			    	
			 
			    }
			    ps.close();
			    con.close();
		}
		catch(Exception e){
			System.out.println(e);
		} 
		return admin;	  
		
	}

	
	

}
