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
	<%  
	String strqueryerr = request.getAttribute("queryerr") != null ? (String) request.getAttribute("queryerr") : "";
	%>
	<form action="Query" method="post">
		<p style="font-weight: bold; text-align:center; text-shadow: 2px 2px 2px rgb(220,220,220);"> Make a Query </p>
		<div class = "inputs">
			<label> Query Text </label>
			<input type="text" name="querytext">
		</div>
		<h5 class="error"> <%= strqueryerr %> </h5>
		<div class = "inputs">
			<input type="submit" class="button" value="Query">
		</div>
	</form>
</body>
</html>