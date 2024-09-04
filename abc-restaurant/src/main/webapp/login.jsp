<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
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
	<form action="Login" method="post" >
		<p style="font-weight: bold; text-align:center; text-shadow: 2px 2px 2px rgb(220,220,220);"> Log in to ABC Restaurant </p>
		<div class = "inputs">
			<label> Username </label>
			<input type="text" name="username" value=${username} >
		</div>
		<div class = "inputs">
			<label> Password </label>
			<input type="password" name="password">
		</div>
		<h5 class="error"> ${loginerr} </h5>
		<div class="inputs">
			<input type="submit" class="button" value="Login" >
		</div>
		<p>
			Still not a member? <a href="register.jsp" style="text-decoration: none; text-shadow: 2px 2px 2px rgb(220,220,220);"> Register </a>
		</p>
	</form>
</body>
</html>