<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %> 
<%@ page import="java.util.List" %>
<%@ page import="model.RideType" %>
<%@ page import="services.loginService"%>  
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
		.button {
			margin-left: 10px;
			font-size: 16px;	
			color: white;
			background: rgb(200,180,50);
			border-radius: 3px;
			border: none;
		}
		.button:hover{
			box-shadow: 0px 0px 5px black;
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
		<h1> MEGACITYCAB-Online </h1>
	</div>
	<form action="ViewRide" method="post">
		<p style="font-weight: bold; text-align:center; text-shadow: 2px 2px 2px rgb(220,220,220);"> View Rides </p>
		<div class = "inputs">
			<input type="submit" class="button" value="Go">
		</div>
	</form>
	<%
		loginService logServ = new loginService();
	
		if (request.getAttribute("ridelist") != null)
		{
			List<RideType> list = (List<RideType>) request.getAttribute("ridelist");
	%>
	<div class="content">
	    <%
	       	for (RideType ride : list) {
	    %>
		<div id="item">
			<p style="font-weight: bold; text-align:center; text-shadow: 2px 2px 2px rgb(220,220,220);">
				<%= ride.getmID() %>
				<p style="text-align:center;">Ride Type: <%= ride.getmRideType() %></p>
				<p style="text-align:center;">Ride Details: <%= ride.getmRideDetails() %></p>
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