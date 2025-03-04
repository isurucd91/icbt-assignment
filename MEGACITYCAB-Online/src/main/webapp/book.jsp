<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %> 
<%@ page import="java.util.List" %>
<%@ page import="services.loginService" %> 
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
	<%  
		String strbookerr = request.getAttribute("bookerr") != null ? (String) request.getAttribute("bookerr") : "";
		loginService logServ = new loginService();
		List<String> drvIDList = logServ.GetDriverIDList();
	%>
	<form action="Book" method="post">
		<p style="font-weight: bold; text-align:center; text-shadow: 2px 2px 2px rgb(220,220,220);"> Make a Reservation </p>
		<div class = "inputs">
			<label> Pickup Address </label>
			<input type="text" name="pickadd">
		</div>
		<div class = "inputs">
			<label> Drop Address </label>
			<input type="text" name="dropadd">
		</div>
		<div class = "inputs">
			<label> Ride Types </label>
			<select style="height: 35px; width: 105%; padding: 5px 10px; font-size: 16px; border-radius: 3px; border: 1px solid gray;" name="ridetypes" id="ridetypes">
				<option value="Car"> Car </option>
				<option value="Van"> Van </option>
				<option value="Threewheeler"> Threewheeler </option>
  			</select>
		</div>
		<div class = "inputs">
			<label> Driver </label>
			<select style="height: 35px; width: 105%; padding: 5px 10px; font-size: 16px; border-radius: 3px; border: 1px solid gray;" name="driver" id="driver">
				<%
	       			for (String did : drvIDList) {
	    		%>
				<option value="<%= did %>"> <%= did %> </option>
				<%
			       	}
				%>
  			</select>
		</div>
		<h5 class="error"> <%= strbookerr %> </h5>
		<div class = "inputs">
			<input type="submit" class="button" value="Book">
		</div>
	</form>
	<div id="item">
		<ul>
			<li> <a href="Home"> Back </a> </li>
		</ul>
	</div>
</body>
</html>