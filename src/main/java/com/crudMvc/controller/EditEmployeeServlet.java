wpackage com.crudMvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crudMvc.model.Employee;
import com.crudMvc.serviceImplementation.EmployeeServiceImpClass;


@WebServlet("/EditEmployeeServlet")
public class EditEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public EditEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		int salary=Integer.parseInt(request.getParameter("salary"));
		Employee emp= new Employee();
		emp.setEmpId(id);
		emp.setEmpName(name);
		emp.setEmpName(name);
		emp.setEmpEmail(email);
		emp.setEmpSalary(salary);
		EmployeeServiceImpClass empService= new EmployeeServiceImpClass();
		empService.update(emp);
		
		response.sendRedirect("adminaccount.jsp");
		
		
	}

}
