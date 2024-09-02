<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
	<head>
		<title> ABC Restaurant </title>
		<style type = "text/css">
			*, body{
				margin: 0;
			}
			
			
			
			#cd_header{
				background-color: rgb(50,50,200);
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
			
			
			
			h1{
				color: white;
				padding-top: 10px;
				text-align: center;
				font-family: tahoma;
				text-shadow: 5px 5px 5px black;
			}
			
			
			
			
			#cd_body{
				background-color: rgb(235,235,235);
				height: 79.68%;
			}
			#cd_table{
				margin:0 auto;
				padding: 10px;
			}
			embed{
				width: 100%;
				height: 300px;
			}
			td{
				border: 1px solid black;
				border-radius: 5px;
			}
			h3{
				padding: 10px;
				font-style: italic;
				font-family: tahoma;
			}
			#cdb_ul{
				list-style-type: circle;
				text-align: center;
			}
			#cdb_li{
				display: inline;
				padding: 10px;
				font-family: tahoma;
				font-size: 15px;
			}
			#cdb_a{
				color: rgb(50,50,200);
				background-color: rgb(235,235,235);
			}
			
			
			
			#cd_footer{
				background-color: rgb(50,50,200);
				height: 80px;
			}
			#add{
				color: white;
				text-align: center;
				padding: 10px;
			}
			#cdf_ul{
				list-style-type: none;
				text-align: center;
				height: 1px;
			}
			#cdf_li{
				display: inline;
			}
			#cdf_li_a{
				text-decoration: none;
				color: white;
				background-color: rgb(75,75,200);
			}
			#cdf_li_a:hover{
				color: black;
				text-decoration: underline;
			}
		</style>
	</head>
	<body>
		<div id = "cd_header">
			<ul>
				<li> <a class="active" href="index.jsp"> Home </a> </li>
				<li> <a href="services.jsp"> Services </a> </li>
				<li> <a href="gallary.jsp"> Gallary </a> </li>
				<li> <a href="about.jsp"> About Us </a> </li>
				<li> <a class="active"href="contact.jsp"> Contact Us </a> </li>
				<li> <a href="login.jsp"> Sign-In </a> </li>
			</ul>
			<h1> ABC Restaurant </h1>
		</div>
		<div id = "cd_body">
			<table id="cd_table">
				<tr>
					<td> <embed src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3960.432711920084!2d79.86029157386848!3d6.958174693042207!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3ae258ed8b4e17f7%3A0xce022f5f2cf7c0e0!2s337%20New%20Negombo%20Rd%2C%20Colombo%2001500!5e0!3m2!1sen!2slk!4v1725286967880!5m2!1sen!2slk"> </td>
				</tr>
				<tr>
					<td>
						<h3> Contact Details </h3>
						<ul id="cdb_ul">
							<li id="cdb_li"> <b>Address:</b> No.337/5 A, New Negombo Road, Wattala, Colombo </li>
							<li id="cdb_li"> <b>Telephone:</b> 011-1231234 </li>
							<li id="cdb_li"> <b>Email:</b> <a id="cdb_a" href="#"> info@abcrestaurant.com </a></li>
						</ul>
					</td>
				</tr>
			</table>
		</div>
		<div id = "cd_footer">
			<address id="add"> © 2024 ABC Restaurant </address>
			<ul id="cdf_ul">
				<li id="cdf_li"> <a id="cdf_li_a" href="#"> Privacy & Cookies </a> </li>
				<li id="cdf_li"> <a id="cdf_li_a" href="#"> Help </a> </li>
				<li id="cdf_li"> <a id="cdf_li_a" href="#"> Feedback </a> </li>
			</ul>
		</div>
	</body>
</html>