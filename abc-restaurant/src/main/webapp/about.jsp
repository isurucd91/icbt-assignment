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
			.cd_ban{
				display: block;
				margin-left: 0px;
				margin-top: 0px;
				width: 10%;
				transition: margin-left 1s, margin-top 1s, width 1s;
			}
			.cd_ban:hover{
				margin-left: 5%;
				margin-top: -20%;
				width: 60%;
			}
			.top-left-text {
				position: relative;
				top:0%;
				left: 0%;
				color: black;
				font-size: 130%;
				text-shadow: 3px 2px 5px rgb(200,200,200);
			}
			img{
				width: 48%;
			}
			.mySlides {
				display: none;
				text-align: center;
			}
			.myDots {
				cursor: pointer;
				height: 15px;
				width: 15px;
				margin: 5px 2px;
				background-color: rgb(160,160,200);
				border-radius: 50%;
				display: inline-block;
				transition: background-color 0.6s ease;
			}
			.myDots:hover{
				background-color: black;
			}
			.active{
				background-color: rgb(50,50,200);
			}
			.fade{
				-webkit-animation-name: fade;
				-webkit-animation-duration: 1.5s;
				animation-name: fade;
				animation-duration: 1.5s;
			}
			@-webkit-keyframes fade{
				from {opacity: .4} 
				to {opacity: 1}
			}
			@keyframes fade{
				from {opacity: .4} 
				to {opacity: 1}
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
				<li> <a href="index.jsp"> Home </a> </li>
				<li> <a href="services.jsp"> Services </a> </li>
				<li> <a href="gallary.jsp"> Gallary </a> </li>
				<li> <a class="active"href="about.jsp"> About Us </a> </li>
				<li> <a href="contact.jsp"> Contact Us </a> </li>
				<li> <a href="login.jsp"> Sign-In </a> </li>
			</ul>
			<h1> ABC Restaurant </h1>
		</div>
		<div id = "cd_body">
			<p>
				ABC Restaurant is a renowned restaurant located in Colombo, known for its commitment to using the freshest organic and local ingredients. The cuisine, crafted by Michelin star Chef Isuru Dissanayake, focuses on sustainable, seasonal produce that is free from pesticides, synthetic fertilizers, insecticides, and GMOs. The meat, fish, and dairy are sourced from humanely treated, pasture-fed animals without antibiotics or hormones.
				The restaurant's menu changes regularly to reflect the availability of local ingredients. ABC Restaurant also emphasizes community and the future of the slow food movement, working closely with regional farmers and fair-trade cooperatives.
			</p>
		</div>
		<div id = "cd_footer">
			<address id="add"> © 2024 ABC Restaurant </address>
			<ul id="cdf_ui">
				<li id="cdf_li"> <a id="cdf_li_a" href="#"> Privacy & Cookies </a> </li>
				<li id="cdf_li"> <a id="cdf_li_a" href="#"> Help </a> </li>
				<li id="cdf_li"> <a id="cdf_li_a" href="#"> Feedback </a> </li>
			</ul>
		</div>
	</body>
</html>