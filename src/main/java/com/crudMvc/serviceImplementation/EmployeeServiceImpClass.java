package com.crudMvc.serviceImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.crudMvc.dao.UtilConnectionClass;
import com.crudMvc.model.Employee;
import com.crudMvc.service.EmployeeService;


public class EmployeeServiceImpClass implements EmployeeService
{
	
	

	//method to insert into database
	public void save(Employee emp)
	{
		try 
		{
			Connection con= UtilConnectionClass.getConnection();
			PreparedStatement ps= con.prepareStatement("insert into employee(employeename,employeeemail,employeesalary)values(?,?,?)");
				ps.setString(1, emp.getEmpName());
				ps.setString(2, emp.getEmpEmail());
				ps.setInt(3, emp.getEmpSalary());
			    ps.execute();
			    ps.close();
			    con.close();
		}
		catch(Exception e){
			System.out.println(e);
		} 
			  

	}

	//method to delete record from database
	public void delete(int id)
	{
		try 
		{
			Connection con= UtilConnectionClass.getConnection();
			PreparedStatement ps= con.prepareStatement("delete from employee where employeeid=?");
				ps.setInt(1, id);
			    ps.execute();
			    ps.close();
			    con.close();
		}
		catch(Exception e){
			System.out.println(e);
		} 
			  

	}


	//method to get all record from database
	public List<Employee> getAllEmployee()
	{
		List<Employee> list= new ArrayList<Employee>();
		Connection con= UtilConnectionClass.getConnection();
		try 
		{
			
			PreparedStatement ps= con.prepareStatement("select * from employee");
				
			    ResultSet rs=  ps.executeQuery();
			    while(rs.next())
			    {
			    	int id=rs.getInt(1);
			    	String name= rs.getString(2);
			    	String email= rs.getString(3);
			    	int sal=rs.getInt(4);
			    	Employee emp= new Employee();
			    	emp.setEmpId(id);
			    	emp.setEmpName(name);
			    	emp.setEmpEmail(email);
			    	emp.setEmpSalary(sal);
			    	list.add(emp);
			    }
			    ps.close();
			    con.close();
		}
		catch(Exception e){
			System.out.println(e);
		} 
			  return list;

	}

	//method to get record by Id from database
	public Employee getEmployeeById(int id)
	{
		
		Employee emp= new Employee();
		try 
		{
			
			Connection con= UtilConnectionClass.getConnection();
			PreparedStatement ps= con.prepareStatement("select * from employee where employeeid=?");
			
			    ps.setInt(1, id);
			    ResultSet rs=ps.executeQuery();
			    
			    while(rs.next())
			    {
			    	int eid=rs.getInt(1);
			    	String ename= rs.getString(2);
			    	String email=rs.getString(3);
			    	int sal=rs.getInt(4);
			    	
			    	emp.setEmpId(eid);
			    	emp.setEmpName(ename);
			    	emp.setEmpEmail(email);
			    	emp.setEmpSalary(sal);
			    	
			 
			    }
			    ps.close();
			    con.close();
		}
		catch(Exception e){
			System.out.println(e);
		} 
		return emp;	  
		
	}

 	//method to update the record for the given id
	public void update(Employee emp) 
	{
		try {
			Connection con=UtilConnectionClass.getConnection();
			PreparedStatement ps=con.prepareStatement("UPDATE employee SET employeename=?, employeeemail =? ,employeesalary=? WHERE employeeid=?");
			ps.setString(1, emp.getEmpName() );
			ps.setString(2, emp.getEmpEmail());
			ps.setInt(3, emp.getEmpSalary());
			ps.setInt(4, emp.getEmpId());
			int noofrowupdated= ps.executeUpdate();
			System.out.println(noofrowupdated);
			ps.close();
		    con.close();
			
			
		}catch(Exception e) {
			System.out.println(e);
			
		}
		
	}
	
}

