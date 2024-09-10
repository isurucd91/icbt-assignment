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
	<%
		String username = session.getAttribute("username").toString();
		String role = session.getAttribute("role").toString();
	%>
	
	<div class="content">
		<div class="welcome_tag">
			<p style="padding-left:10px;" > Welcome!
				<strong> <%= username %></strong>
			</p>
			<p> <a href ="Logout" class="lo"> Logout </a> </p>
		</div>
		<%
			if (role.equals("customer"))
			{
		%>
			<div id="item">
				<p style="padding: 10px; box-shadow: 1px 1px 15px darkblue; margin: 10px;"> <%= role %> </p>
				<ul>
					<li> <a href="reserve.jsp"> Make Reservation </a> </li>
					<li> <a href="makpayment.jsp"> Make Payment </a> </li>
					<li> <a href="query.jsp"> Make Query </a> </li>	
					<li> <a href="viewreserve.jsp"> View Reservation </a> </li>
					<li> <a href="viewquery.jsp"> View Query </a> </li>
				</ul>
			</div>
		<%
			}
			else if (role.equals("staff"))
			{
		%>
			<div id="item">
				<p style="padding: 10px; box-shadow: 1px 1px 15px darkblue; margin: 10px;"> <%= role %> </p>
				<ul>
					<li> <a href="manqueries.jsp"> Manage Queries </a> </li>
					<li> <a href="upreservations.jsp"> Update Reservation Status </a> </li>
					<li> <a href="procpay.jsp"> Process Payment </a> </li>
				</ul>
			</div>
		<%
			}
			else if (role.equals("administrator"))
			{
		%>
			<div id="item">
				<p style="padding: 10px; box-shadow: 1px 1px 15px darkblue; margin: 10px;"> <%= role %> </p>
				<ul>
					<li> <a href="manusers.jsp"> Manage Users </a> </li>
					<li> <a href="viewrep.jsp"> View Reports </a> </li>
				</ul>
			</div>
		<%
			}
		%>
	</div>
</body>
</html>