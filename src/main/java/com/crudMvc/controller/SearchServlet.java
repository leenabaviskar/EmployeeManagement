package com.crudMvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter pw= response.getWriter();
		response.setContentType("text/html");
		pw.println("<html><body>");
		String s1=request.getParameter("search");
       // pw.println("<a href='UrlRewritingServlet2?search="+s1+"'>visit</a>");
		response.sendRedirect("https://www.google.co.in/search?q="+s1);
		pw.println("</body></html>");
		pw.close();
	}

}
