package com.crudMvc.service;

import java.util.List;

import com.crudMvc.model.Customer;

public interface CustomerService 
{
	  //method to insert into database
	   public void save(Customer customer);
	   
	 //method to get list of all customer detail 
		public List<Customer> getCustomerDetails();
}
