<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>
<head>
	<meta charset="ISO-8859-1">
	<title> ABC Restaurant </title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="header">
		<h1> ABC Restaurant Portal </h1>
	</div>
	<% String username = session.getAttribute("username").toString(); %>
	<div class="content">
		<div class="welcome_tag">
			<p style="padding-left:10px;" > Welcome!
				<strong> <%= username %></strong>
			</p>
			<p> <a href ="Logout" class="lo"> Logout </a> </p>
		</div>
	</div>
</body>
</html>