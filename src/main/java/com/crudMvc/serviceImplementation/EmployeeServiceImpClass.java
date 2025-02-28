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
			PreparedStatement ps= con.prepareStatement("insert into employeedata(employeefirstname, employeelastname, employeemobile, employeeemail, employeeaddress, employeesalary)values(?,?,?,?,?,?)");
				ps.setString(1, emp.getEmpFirstName());
				ps.setString(2, emp.getEmpLastName() );
				ps.setString(3, emp.getEmpMobile() );
				ps.setString(4, emp.getEmpEmail());
				ps.setString(5, emp.getEmpAddress() );
				ps.setInt(6, emp.getEmpSalary());
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
			PreparedStatement ps= con.prepareStatement("delete from employeedata where employeeid=?");
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
			
			PreparedStatement ps= con.prepareStatement("select * from employeedata");
				
			    ResultSet rs=  ps.executeQuery();
			    while(rs.next())
			    {
			    	int id=rs.getInt(1);
			    	String firstName= rs.getString(2);
			    	String lastName= rs.getString(3);
			    	String mobile= rs.getString(4);
			    	String email= rs.getString(5);
			    	String address= rs.getString(6);
			    	int sal=rs.getInt(7);
			    	Employee emp= new Employee();
			    	emp.setEmpId(id);
			    	emp.setEmpFirstName(firstName);
			    	emp.setEmpLastName(lastName);
			    	emp.setEmpMobile(mobile);
			    	emp.setEmpEmail(email);
			    	emp.setEmpAddress(address);
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
			PreparedStatement ps= con.prepareStatement("select * from employeedata where employeeid=?");
			
			    ps.setInt(1, id);
			    ResultSet rs=ps.executeQuery();
			    
			    while(rs.next())
			    {
			    	int eid=rs.getInt(1);
			    	String efirstname= rs.getString(2);
			    	String elastname= rs.getString(3);
			    	String emobile= rs.getString(4);
			    	String email=rs.getString(5);
			    	String eaddress= rs.getString(6);
			    	int sal=rs.getInt(7);
			    	
			    	emp.setEmpId(eid);
			    	emp.setEmpFirstName(efirstname);
			    	emp.setEmpLastName(elastname);
			    	emp.setEmpMobile(emobile);
			    	emp.setEmpEmail(email);
			    	emp.setEmpAddress(eaddress);
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
			PreparedStatement ps=con.prepareStatement("UPDATE employeedata SET employeefirstname=?,employeefirstname=?,employeemobile=?, employeeemail =?, employeeaddress=?, employeesalary=? WHERE employeeid=?");
			ps.setString(1, emp.getEmpFirstName() );
			ps.setString(2, emp.getEmpLastName() );
			ps.setString(3, emp.getEmpMobile() );
			ps.setString(4, emp.getEmpEmail());
			ps.setString(5, emp.getEmpAddress() );
			ps.setInt(6, emp.getEmpSalary());
			ps.setInt(7, emp.getEmpId());
			int noofrowupdated= ps.executeUpdate();
			System.out.println(noofrowupdated);
			ps.close();
		    con.close();
			
			
		}catch(Exception e) {
			System.out.println(e);
			
		}
		
	}
	
}

