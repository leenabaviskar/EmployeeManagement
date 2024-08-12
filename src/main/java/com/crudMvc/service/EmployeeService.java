package com.crudMvc.service;

import java.util.List;

import com.crudMvc.model.Employee;

public interface EmployeeService 
{
	//method to insert into database
	public void save(Employee emp);
	
	//method to delete record from database
     public void delete(int id);
     
   //method to get all record from database
 	public List<Employee> getAllEmployee();
 	
 	
 	//method to get record by Id from database
 	public Employee getEmployeeById(int id);
 	
 	//method to update the record for the given id
 	public void update(Employee emp);
 	
}
