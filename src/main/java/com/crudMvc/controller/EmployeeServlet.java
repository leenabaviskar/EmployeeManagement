package com.crudMvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crudMvc.model.Employee;
import com.crudMvc.serviceImplementation.EmployeeServiceImpClass;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EmployeeServlet() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
		response.setContentType("text/html");
		EmployeeServiceImpClass empservice=  new EmployeeServiceImpClass();
		List<Employee> listofemp= empservice.getAllEmployee();
		response.sendRedirect("listofemp");
	}

}
