<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %> 
<%@ page import="java.util.List" %>
<%@ page import="model.Reservation" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>
<head>
	<meta charset="ISO-8859-1">
	<title> ABC Restaurant </title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<style type = "text/css">
		ul{
			list-style-type: none;
			padding: 10px;
		}
		li{
			display: inline;
		}
		li a{
			padding: 10px;
			text-decoration: none;
			color: white;
			background-color: rgb(75,75,200);
			text-align: center;
		}
		li a.active {
			background-color: rgb(160,160,200);
		}
		li a:hover{
			color: black;
			background-color: rgb(160,160,200);
		}
	</style>
</head>
<body>
	<div class="header">
		<h1> ABC Restaurant Portal </h1>
	</div>
	<form action="ViewReserve" method="post">
		<p style="font-weight: bold; text-align:center; text-shadow: 2px 2px 2px rgb(220,220,220);"> View Reservations </p>
		<div class = "inputs">
			<input type="submit" class="button" value="Go">
		</div>
	</form>
	<%
		if (request.getAttribute("reservelist") != null)
		{
			List<Reservation> list = (List<Reservation>) request.getAttribute("reservelist");
	%>
	<div class="content">
	    <%
	       	for (Reservation res : list) {
	    %>
		<div id="item">
			<p style="font-weight: bold; text-align:center; text-shadow: 2px 2px 2px rgb(220,220,220);">
				<%= res.getmID() %>
				<p>Date: <%= res.getmDate() %></p>
				<p>Time: <%= res.getmTime() %></p>
				<p>Type: <%= res.getmType() %></p>
				<p>Status: <%= res.getmStatus() %></p>
			</p>
		</div>		
		<%
	       	}
		%>
	</div>
	<%
		}
	%>
	<div id="item">
		<ul>
			<li> <a href="Home"> Back </a> </li>
		</ul>
	</div>
</body>
</html>