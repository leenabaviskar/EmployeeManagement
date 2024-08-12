package com.crudMvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crudMvc.model.AdminAccount;
import com.crudMvc.model.Employee;
import com.crudMvc.service.AdminAccountService;
import com.crudMvc.serviceImplementation.AdminAccountServiceImpClass;
import com.crudMvc.serviceImplementation.EmployeeServiceImpClass;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		 PrintWriter pw= response.getWriter();
		String username= request.getParameter("username");
		String password= request.getParameter("password");
        
		AdminAccountServiceImpClass adminAccountServiceImpObject = new AdminAccountServiceImpClass();
        AdminAccount admin= adminAccountServiceImpObject.getAdminAccountDetail(username, password);
        
        String username_from_table=admin.getAdminUserName();
        String password_from_table=admin.getAdminPassword();
        System.out.println("user name is:" +username_from_table);
        System.out.println("pass is : " +password_from_table);
        if(username.equals(username_from_table) && password.equals(password_from_table))
        {
        	 System.out.println("matched");
        	 pw.println("<h1> Welcome "+username+ " </h1>");
        	HttpSession session= request.getSession();
        	session.setAttribute("user", username);
        	session.setAttribute("pass", password);
        	 Cookie ck=new Cookie("user",username);  
             response.addCookie(ck);
             
        	EmployeeServiceImpClass empService= new EmployeeServiceImpClass();
    		List<Employee> listofemp= empService.getAllEmployee();
    		request.setAttribute("list", listofemp);
    		 
    		response.sendRedirect("adminaccount.jsp");
    	
    		
        	
       
        }else {
        	
        	 pw.print("<html><body><div style= position=absolute; color=red;>");
     		pw.print("<h4>Incorrect Username or Password</h4>");
     		
     		RequestDispatcher rs= request.getRequestDispatcher("login.html");
     		rs.include(request, response);
     		pw.print("</div></body></html>");
     		
        }
        
		
		
	}

}
