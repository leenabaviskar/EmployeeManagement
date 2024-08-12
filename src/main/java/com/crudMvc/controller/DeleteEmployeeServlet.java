package com.crudMvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crudMvc.serviceImplementation.EmployeeServiceImpClass;

@WebServlet("/DeleteEmployeeServlet")
public class DeleteEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteEmployeeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String id1 = request.getParameter("id");

		if (id1 != null) {
			int id = Integer.parseInt(id1);
			EmployeeServiceImpClass empService = new EmployeeServiceImpClass();
			empService.delete(id);

			response.sendRedirect("adminaccount.jsp");

		} else {
			pw.println("Id is Null");
		}
	}

}
