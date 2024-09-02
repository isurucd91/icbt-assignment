<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title> ABC Restaurant </title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<%  
		if(session.getAttribute("username") != null){
			response.sendRedirect("Home");
		}
	%>
	<div class="header">
		<h1> ABC Restaurant </h1>
		<ul>
			<li>
				<a href="index.jsp">
					<span class="span-logo">
						<img src="images/abc.jpg">
					</span>
				</a>
			</li>
		</ul>
	</div>
	<form action="Register" method="post">
		<p style="font-weight: bold; text-align:center; text-shadow: 2px 2px 2px rgb(220,220,220);"> Create New Account </p>
		<div class = "inputs">
			<label> Username </label>
			<input type="text" name="username" value="${username}">
		</div>
		<div class = "inputs">
			<label> E-mail </label>
			<input type="text" name="email" value="${email}">
		</div>
		<div class = "inputs">
			<label> Role </label>
			<select style="height: 35px; width: 105%; padding: 5px 10px; font-size: 16px; border-radius: 3px; border: 1px solid gray;" name="roles" id="roles">
				<option value="customer"> Customer </option>
				<option value="staff"> Staff </option>
				<option value="administrator"> Administrator </option>
  			</select>
		</div>
		<div class = "inputs">
			<label> Password </label>
			<input type="password" name="password_1">
		</div>
		<div class = "inputs">
			<label> Confirm Password </label>
			<input type="password" name="password_2">
		</div>
		<h5 class="error"> ${loginerr} </h5>
		<div class = "inputs">
			<input type="submit" class="button" value="Register">
		</div>
		<p>
			Already a member? <a href="login.jsp" style="text-decoration: none; text-shadow: 2px 2px 2px rgb(220,220,220);"> Log In </a>
		</p>
	</form>
</body>
</html>