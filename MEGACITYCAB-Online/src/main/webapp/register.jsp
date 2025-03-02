<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
	</style>
</head>
<body>
	<%  
		if(session.getAttribute("username") != null){
			response.sendRedirect("Home");
		}
	String strloginerr = request.getAttribute("loginerr") != null ? (String) request.getAttribute("loginerr") : "";
	String strusername = request.getAttribute("username") != null ? (String) request.getAttribute("username") : "";
	String stremail = request.getAttribute("email") != null ? (String) request.getAttribute("email") : "";
	%>
	<div id="cd_header">
		<h1>MEGACITYCAB-Online</h1>
		<ul>
			<li>
				<a href="index.jsp">
					<span class="span-logo">
						<img src="Images/mcc.jpeg">
					</span>
				</a>
			</li>
		</ul>
	</div>
	<form action="Register" method="post">
		<p style="font-weight: bold; text-align:center; text-shadow: 2px 2px 2px rgb(220,220,220);"> Create New Account </p>
		<div class = "inputs">
			<label> Username </label>
			<input type="text" name="username" value=<%= strusername %>>
		</div>
		<div class = "inputs">
			<label> E-mail </label>
			<input type="text" name="email" value=<%= stremail %>>
		</div>
		<div class = "inputs">
			<label> Type </label>
			<select style="height: 35px; width: 105%; padding: 5px 10px; font-size: 16px; border-radius: 3px; border: 1px solid gray;" name="type" id="type">
				<option value="customer"> Customer </option>
				<option value="driver"> Driver </option>
  			</select>
		</div>
		<div class = "inputs">
			<label> NIC </label>
			<input type="text" name="nic" value="">
		</div>
		<div class = "inputs">
			<label> Telephone No </label>
			<input type="text" name="telephone" value="">
		</div>
		<div class = "inputs">
			<label> Address </label>
			<input type="text" name="address" value="">
		</div>
		<div class = "inputs">
			<label> Password </label>
			<input type="password" name="password_1">
		</div>
		<div class = "inputs">
			<label> Confirm Password </label>
			<input type="password" name="password_2">
		</div>
		<h5 class="error"> <%= strloginerr %> </h5>
		<div class = "inputs">
			<input type="submit" class="button" value="Register">
		</div>
		<p>
			Already a member? <a href="login.jsp" style="text-decoration: none; text-shadow: 2px 2px 2px rgb(220,220,220);"> Log In </a>
		</p>
	</form>
</body>
</html>