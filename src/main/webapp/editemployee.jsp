<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.crudMvc.serviceImplementation.*"  %>
<%@ page import="com.crudMvc.model.*" %>
<!DOCTYPE html>


<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Admin Login | Wipro</title>
	<link rel="stylesheet" href="style.css">
	<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>

<body style="background: darkolivegreen;">
	<div class="wrapper">
		
			<h1>Edit Employee</h1>
			<%  String empId= request.getParameter("id");
			   if(empId != null) {
				  int id= Integer.parseInt(empId);
			   EmployeeServiceImpClass empService= new EmployeeServiceImpClass(); 
			   Employee emp=empService.getEmployeeById(id);
			  
			   if (emp != null) {
			%>
			<form action="EditEmployeeServlet" method="post">
		
		        <input type="hidden" placeholder="Id" name="id" value="<%= emp.getEmpId() %>" required>
			
			<div class="input-box">
				<input type="text" placeholder="First Name" name="firstname" value="<%= emp.getEmpFirstName() %>" required>
			
			</div>
			<div class="input-box">
				<input type="text" placeholder="Last Name" name="lastname" value="<%= emp.getEmpLastName() %>" required>
			
			</div>
			<div class="input-box">
				<input type="tel" placeholder="Mobile" name="mobile" value="<%= emp.getEmpMobile() %>" required>
			
			</div>
			<div class="input-box">
				<input type="email" placeholder="Email" name="email" value="<%= emp.getEmpEmail() %>" required>
				
			</div>
			<div class="input-box">
				<input type="text" placeholder="Address" name="address" value="<%= emp.getEmpAddress() %>" required>
				
			</div>
				<div class="input-box">
				<input type="number" placeholder="Salary" name="salary" value="<%= emp.getEmpSalary() %>" required>
				
			</div>
			
			<%
			   } else {
						out.println("Employee not found.");
					}
				} else {
					out.println("Invalid ID.");
				}
			%>
			<button type="submit" class="btn">Save Changes</button>
			
			
		</form>
	</div>
</body>

</html>