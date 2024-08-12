package com.crudMvc.serviceImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.crudMvc.dao.UtilConnectionClass;
import com.crudMvc.model.Customer;
import com.crudMvc.service.CustomerService;


public class CustomerServiceImpClass implements CustomerService
{
	
	//method to insert into database
	public void save(Customer customer)
	{
		try 
		{
			Connection connection=UtilConnectionClass.getConnection();
			PreparedStatement ps=connection.prepareStatement("insert into contactus(firstname,lastname,email,jobtitle,company,country,message)values(?,?,?,?,?,?,?)");
		
			ps.setString(1, customer.getFirstName());
			ps.setString(2, customer.getLastName());
			ps.setString(3, customer.getEmail());
			ps.setString(4, customer.getJobTitle());	
			ps.setString(5, customer.getCompany());	
			ps.setString(6, customer.getCountry());	
			ps.setString(7, customer.getMessage());
			    ps.execute();
			    ps.close();
			    connection.close();
		}
		catch(Exception e){
			System.out.println(e);
		} 
			  

	}

	//method to get list of all customer detail 
	public List<Customer> getCustomerDetails()
	{
		List<Customer> list= new ArrayList<>();
		
		try {
		Connection connection=UtilConnectionClass.getConnection();
		PreparedStatement ps=connection.prepareStatement("select * from contactus");
	    ResultSet rs=ps.executeQuery();
		
		while(rs.next())
		{
			int id= rs.getInt(1);
			String firstname=rs.getString(2);
			String lastname=rs.getString(3);
			String email= rs.getString(4);
			String jobtitle= rs.getString(5);
			String company= rs.getString(6);
			String country= rs.getString(7);
			String message= rs.getString(8);
			
			Customer customer= new Customer();
			customer.setCustomerId(id);
			customer.setFirstName(firstname);
			customer.setLastName(lastname);
			customer.setEmail(email);
			customer.setJobTitle(jobtitle);
			customer.setCompany(company);
			customer.setCountry(country);
			customer.setMessage(message);
			
			list.add(customer);
		}
		
		
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		return list;
	}
}
