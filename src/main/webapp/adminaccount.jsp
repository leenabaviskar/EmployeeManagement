<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.*"%>
<%@ page import="com.crudMvc.model.Employee"%>
<%@ page import="com.crudMvc.serviceImplementation.*"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin Account | GokulInfocare</title>
<link rel="stylesheet" href="adminaccountstyle.css">

</head>


<body>
<nav>
	<div class="nav">
		<div class="navbar">
			<a href="adminaccount.jsp">
				<h1>Employee Management App</h1>

			</a>
		
		     <div>
		     	<button type="button" class="btn btn-secondary"><a href="LogoutServlet">Log Out </a></button>
		     </div>
		</div>
		

	</div>
</nav>
	<div class="wrapper">
		<div class="list">
			<h1>List Of Users</h1>

			<button type="button" class="btn">
				<a href="addemployee.html">Add User </a>
			</button>

			<%
			EmployeeServiceImpClass empService = new EmployeeServiceImpClass();
			List<Employee> listofemp = empService.getAllEmployee();
			request.setAttribute("list", listofemp);
			%>

			<br>
			<table class="table" border=1>
				<thead>
					<tr>
						<th>ID</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Mobile</th>
						<th>Email</th>
						<th>Address</th>
						<th>Salary</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<%
					List<Employee> list = (List<Employee>) request.getAttribute("list");

					if (list != null) {
						for (Employee emp : list) {
					%>
					
					<tr>
						<td> &nbsp;&nbsp;&nbsp;&nbsp;
						<%=emp.getEmpId()%>
						&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
						<td>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<%=emp.getEmpFirstName()%>
						&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
						<td>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<%=emp.getEmpLastName()%>
						&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
						<td>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<%=emp.getEmpMobile()%>
						&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
						<td>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<%=emp.getEmpEmail()%>
						&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
						<td>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<%=emp.getEmpAddress()%>
						&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
						<td>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<%=emp.getEmpSalary()%>
						&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
						<td>    &nbsp;&nbsp;&nbsp;&nbsp;
								<a href="editemployee.jsp?id=<%= emp.getEmpId() %>">Edit</a>
						        &nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="DeleteEmployeeServlet?id=<%= emp.getEmpId() %>">Delete</a>
							&nbsp;&nbsp;&nbsp;&nbsp;
						</td>

					</tr>
					<%
					}
					}

					else {
					%>

					<tr>
						<td colspan="3">No employees found</td>
					</tr>

					<%
					}
					%>

				</tbody>

			</table>
		</div>
	</div>





	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>


</body>
</html>