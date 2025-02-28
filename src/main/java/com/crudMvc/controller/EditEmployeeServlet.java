package com.crudMvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crudMvc.model.Employee;
import com.crudMvc.serviceImplementation.EmployeeServiceImpClass;


@WebServlet("/EditEmployeeServlet")
public class EditEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public EditEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		int id=Integer.parseInt(request.getParameter("id"));
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String mobile=request.getParameter("mobile");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		int salary=Integer.parseInt(request.getParameter("salary"));
		Employee emp= new Employee();
		emp.setEmpId(id);
		emp.setEmpFirstName(firstname);
		emp.setEmpLastName(lastname);
		emp.setEmpMobile(mobile);
		emp.setEmpEmail(email);
		emp.setEmpAddress(address);
		emp.setEmpSalary(salary);
		EmployeeServiceImpClass empService= new EmployeeServiceImpClass();
		empService.update(emp);
		
		response.sendRedirect("adminaccount.jsp");
		
		
	}

}
