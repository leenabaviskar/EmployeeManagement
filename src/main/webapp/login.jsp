<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

	<link rel="stylesheet" href="style.css">
	<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
<div class="wrapper">
		<form action="LoginServlet" method="post">
			<h1>Login</h1>
			<div class="input-box">
				<input type="text" placeholder="Username" name="username" required>
				<i class='bx bxs-user'></i>
			</div>
			<div class="input-box">
				<input type="password" placeholder="Password" name="password" required>
				<i class='bx bxs-lock-alt'></i>
			</div>
			<div class="remember-forgot">
				<label><input type="checkbox">Remember Me</label>
				<a href="#">Forgot Password?</a>
			</div>
			
			<button type="submit" class="btn">Login</button>
			
			<div class="register-link">
				<p>Don't have an account? <a href="register.html">Register</a></p>
			</div>
		</form>
	</div>
</body>
</html>