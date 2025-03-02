<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
	<head>
		<title> MEGACITYCAB-Online </title>
		<style type = "text/css">
			*, body{
				margin: 0;
			}

			#cd_header{
				background-color: rgb(200,180,50);
				height: 130px;
				text-align: center;
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
			
			img {
			  border: 1px solid #ddd;
			  border-radius: 4px;
			  padding: 5px;
			  width: 60%;
			  height: 80%;
			  justify-content: center;
			  margin: 0 auto;
			}
			
			img:hover {
			  box-shadow: 0 0 2px 1px rgba(0, 140, 186, 0.5);
			}
			
			h1{
				color: white;
				padding-top: 10px;
				text-align: center;
				font-family: tahoma;
				text-shadow: 5px 5px 5px black;
			}
								
			#cd_body{
				background-color: rgb(235,235,235);
				height: 80%;
				display: flex;
            	justify-content: center;
            	align-items: center;
			}
			
			#cd_footer{
				background-color: rgb(200,180,50);
				height: 80px;
			}
			#add{
				color: white;
				text-align: center;
				padding: 10px;
			}
			#cdf_ui{
				list-style-type: none;
				text-align: center;
				height: 1px;
				padding: 10px;
			}
			#cdf_li{
				display: inline;
			}
			#cdf_li_a{
				text-decoration: none;
				color: white;
				background-color: rgb(180,180,50);
			}
			#cdf_li_a:hover{
				color: black;
				text-decoration: underline;
			}
		</style>
	</head>
	<body>
		<div id = "cd_header">
			<ul class="navsel">
				<li> <a class="active" href="index.jsp"> Home </a> </li>
				<li> <a href="signin.jsp"> Sign In </a> </li>
				<li> <a href="register.jsp"> Register </a> </li>
			</ul>
			<h1> MEGACITYCAB-Online </h1>
		</div>
		<div id = "cd_body">
			<img src = "Images/mcc.jpeg">
		</div>
		<div >
		<footer id = "cd_footer">
			<address id="add"> © 2025 MEGACITYCAB </address>
			<ul id="cdf_ui">
				<li id="cdf_li"> <a id="cdf_li_a" href="#"> Privacy & Cookies </a> </li>
				<li id="cdf_li"> <a id="cdf_li_a" href="#"> Help </a> </li>
				<li id="cdf_li"> <a id="cdf_li_a" href="#"> Feedback </a> </li>
			</ul>
		</footer>

		</div>
	</body>
</html>
