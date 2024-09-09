<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %> 
<%@ page import="java.util.List" %>
<%@ page import="services.loginService" %> 
<%@ page import="model.Query" %>  
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
		loginService logServ = new loginService();
		List<String> custIDList = logServ.GetCustIDList();
	%>
	<form action="ManageQuery" method="post">
		<p style="font-weight: bold; text-align:center; text-shadow: 2px 2px 2px rgb(220,220,220);"> Manage Queries </p>
		<div class = "inputs">
			<label> Customers </label>
			<select style="height: 35px; width: 105%; padding: 5px 10px; font-size: 16px; border-radius: 3px; border: 1px solid gray;" name="custid" id="custid">
				<%
	       			for (String cid : custIDList) {
	    		%>
				<option value="<%= cid %>"> <%= cid %> </option>
				<%
			       	}
				%>
  			</select>
		</div>
		<div class = "inputs">
			<input type="submit" class="button" value="Go">
		</div>
	</form>
	<%
		if (request.getAttribute("querylist") != null)
		{
			List<Query> list = (List<Query>) request.getAttribute("querylist");
	%>
	<div class="content">
	    <%
	       	for (Query que : list) {
	    %>
		<div id="item">
			<p style="font-weight: bold; text-align:center; text-shadow: 2px 2px 2px rgb(220,220,220);">
				<%= que.getmID() %>
				<p>Query Text: <%= que.getQueryText() %></p>
				<p>Reply Text: <%= que.getReplyText() %></p>
				<form method="post" style="padding: 10px; margin-bottom: 10px;" action="UpdateQuery">
					<div class = "inputs">
						<center><input type="text" name="rtext"></center>
					</div>
					<input type="submit" name="<%= que.getmID() %>" class="button" value="Answer">
				</form>
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