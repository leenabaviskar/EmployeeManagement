package com.crudMvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crudMvc.model.Employee;
import com.crudMvc.service.EmployeeService;
import com.crudMvc.serviceImplementation.EmployeeServiceImpClass;

/**
 * Servlet implementation class AddEmployeeServlet
 */
@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		String firstname= request.getParameter("firstname");
		String lastname= request.getParameter("lastname");
		String mobile= request.getParameter("mobile");
		String email= request.getParameter("email");
		String address= request.getParameter("address");
		int salary=Integer.parseInt(request.getParameter("salary"));
		
		Employee emp= new Employee();
		emp.setEmpFirstName(firstname);
		emp.setEmpLastName(lastname);
		emp.setEmpMobile(mobile);
		emp.setEmpEmail(email);
		emp.setEmpAddress(address);
		emp.setEmpSalary(salary);
		
		
		EmployeeServiceImpClass empService= new EmployeeServiceImpClass();
		empService.save(emp);
		response.sendRedirect("adminaccount.jsp");
		
	}}
