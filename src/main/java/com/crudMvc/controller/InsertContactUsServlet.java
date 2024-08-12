package com.crudMvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crudMvc.model.Customer;
import com.crudMvc.service.CustomerService;
import com.crudMvc.serviceImplementation.CustomerServiceImpClass;


@WebServlet("/InsertContactUsServlet")
public class InsertContactUsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public InsertContactUsServlet() {
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
		String firstname=request.getParameter("firstname");
		System.out.println(firstname);
        String lastname=request.getParameter("lastname");
        System.out.println(lastname);
		String email=request.getParameter("email");
		String jobtitle=request.getParameter("jobtitle");
		String company=request.getParameter("company");
		String country=request.getParameter("country");
		String message=request.getParameter("message");
        
		Customer customer= new Customer();
		customer.setFirstName(firstname);
        customer.setLastName(lastname);
		customer.setEmail(email);
		customer.setJobTitle(jobtitle);
		customer.setCompany(company);
		customer.setCountry(country);
		customer.setMessage(message);
		
		CustomerServiceImpClass customerServiceImpOjbect = new CustomerServiceImpClass(); 
		customerServiceImpOjbect.save(customer);
		response.sendRedirect("index.html");
	}

}
