<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>
<head>
	<meta charset="ISO-8859-1">
	<title> MEGACITYCAB-Online </title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<style type = "text/css">
		#cd_header{
			background-color: rgb(200,180,50);
			height: 130px;
			text-align: center;
		}
		
		h1{
			color: white;
			padding-top: 10px;
			text-align: center;
			font-family: tahoma;
			text-shadow: 5px 5px 5px black;
		}
		
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
			background-color: rgb(180,180,50);
			text-align: center;
		}
		li a.active {
			background-color: rgb(150,150,50);
		}
		li a:hover{
			color: black;
			background-color: rgb(150,150,50);
		}
	</style>
</head>
<body>
	<div id="cd_header">
		<h1>MEGACITYCAB-Online</h1>
	</div>
	<%
		String username = session.getAttribute("username").toString();
		String type = session.getAttribute("type").toString();
	%>
	
	<div class="content">
		<div class="welcome_tag">
			<p style="padding-left:10px;" > Welcome!
				<strong> <%= username %></strong>
			</p>
			<p> <a href ="Logout" class="lo"> Logout </a> </p>
		</div>
		<%
			if (type.equals("customer"))
			{
		%>
			<div id="item">
				<p style="padding: 10px; box-shadow: 1px 1px 15px rgb(200,180,50); margin: 10px;"> <%= type %> </p>
				<ul>
					<li> <a href="book.jsp"> Book a Ride </a> </li>
					<li> <a href="cancel.jsp"> Cancel a Ride </a> </li>
					<li> <a href="query.jsp"> View a Ride </a> </li>	
					<li> <a href="bill.jsp"> Calculate Bill </a> </li>
				</ul>
			</div>
		<%
			}
			else if (type.equals("driver"))
			{
		%>
			<div id="item">
				<p style="padding: 10px; box-shadow: 1px 1px 15px rgb(200,180,50); margin: 10px;"> <%= type %> </p>
				<ul>
					<li> <a href="addride.jsp"> Add a Ride </a> </li>
					<li> <a href="viewride.jsp"> View a Ride </a> </li>
					<li> <a href="remride.jsp"> Remove a Ride </a> </li>
					<li> <a href="viewbook.jsp"> View Bookings </a> </li>
				</ul>
			</div>
		<%
			}
		%>
	</div>
</body>
</html>