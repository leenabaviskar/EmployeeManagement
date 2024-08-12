package com.crudMvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crudMvc.model.AdminAccount;
import com.crudMvc.serviceImplementation.AdminAccountServiceImpClass;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		String adminName= request.getParameter("username");
		String adminEmail=request.getParameter("email");
		String adminPassword=request.getParameter("password");
		
		AdminAccount admin= new AdminAccount();
		admin.setAdminUserName(adminName);
		admin.setAdminEmail(adminEmail);
		admin.setAdminPassword(adminPassword);
		AdminAccountServiceImpClass adminService= new AdminAccountServiceImpClass();
		adminService.save(admin);
		response.sendRedirect("adminaccount.jsp");
		
		
		
	}

}
