package com.crudMvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UrlRewritingServlet2
 */
@WebServlet("/UrlRewritingServlet2")
public class UrlRewritingServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UrlRewritingServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		String s2= request.getParameter("search");
		PrintWriter pw= response.getWriter();
		
		pw.println("<h1>Welcome "+s2+"</h1>");
		
		pw.close();
	}

}
