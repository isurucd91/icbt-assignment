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
	String strreserveerr = request.getAttribute("reserveerr") != null ? (String) request.getAttribute("reserveerr") : "";
	%>
	<form action="Reserve" method="post">
		<p style="font-weight: bold; text-align:center; text-shadow: 2px 2px 2px rgb(220,220,220);"> Make a Reservation </p>
		<div class = "inputs">
			<label> Date </label>
			<input type="date" name="resdate">
		</div>
		<div class = "inputs">
			<label> Time </label>
			<input type="time" name="restime">
		</div>
		<div class = "inputs">
			<label> Types </label>
			<select style="height: 35px; width: 105%; padding: 5px 10px; font-size: 16px; border-radius: 3px; border: 1px solid gray;" name="type" id="type">
				<option value="Hotel"> Hotel </option>
				<option value="Group"> Group </option>
				<option value="Suite"> Suite </option>
  			</select>
		</div>
		<div class = "inputs">
			<label> Status </label>
			<select style="height: 35px; width: 105%; padding: 5px 10px; font-size: 16px; border-radius: 3px; border: 1px solid gray;" name="status" id="status">
				<option value="Reserved"> Reserved </option>
				<option value="Cancelled"> Cancelled </option>
  			</select>
		</div>
		<h5 class="error"> <%= strreserveerr %> </h5>
		<div class = "inputs">
			<input type="submit" class="button" value="Reserve">
		</div>
	</form>
	<div id="item">
		<ul>
			<li> <a href="Home"> Back </a> </li>
		</ul>
	</div>
</body>
</html>