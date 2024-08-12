package com.crudMvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw= response.getWriter();
		HttpSession session = request.getSession(false); // false means don't create a new session if one doesn't exist
        if (session != null && session.getAttribute("user") != null) {
            String username = (String) session.getAttribute("user");
            response.setContentType("text/html");
            response.getWriter().println("<h1>Welcome, " + username + "!</h1>");
            response.sendRedirect("adminaccount.jsp");
        } else {
            response.sendRedirect("login.html");
        }
         Integer obj=(Integer)session.getAttribute("count");
        if(obj==null)
        {
        	obj=1;
        }
        else
        {
        	obj=obj+1;
        }
        session.setAttribute("count" ,obj);
        pw.println("<h1> Page accessed for" +obj+ " times</h1>");
        
        

	
	}}
