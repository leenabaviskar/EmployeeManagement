package com.crudMvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crudMvc.model.AdminAccount;
import com.crudMvc.service.AdminAccountService;
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
		PrintWriter pw = response.getWriter();
		String adminName= request.getParameter("username");
		String adminEmail=request.getParameter("email");
		String adminPassword=request.getParameter("password");
		
		
		if (AdminAccountService.isEmailExists(adminEmail)) {
            request.setAttribute("errorMessage", "Admin with this email already exists.");
            
            pw.print("<html><body><div style= position=absolute; color=red;>");
     		pw.println("<h4>errorMessage\", \"Admin with this email already exists.</h4>");
     		
     		RequestDispatcher rs= request.getRequestDispatcher("register.html");
     		rs.include(request, response);
     		pw.print("</div></body></html>");
           
        } else {
		AdminAccount admin= new AdminAccount();
		admin.setAdminUserName(adminName);
		admin.setAdminEmail(adminEmail);
		admin.setAdminPassword(adminPassword);
		AdminAccountServiceImpClass adminService= new AdminAccountServiceImpClass();
		adminService.save(admin);
		response.sendRedirect("adminaccount.jsp");
		
        }
		
	}

}
