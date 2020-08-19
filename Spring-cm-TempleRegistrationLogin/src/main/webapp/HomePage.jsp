<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Temple Registration</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<!-- <link href="./css/bootstrap.css" rel="stylesheets">
<link href="./css/bootstrap.css.map" rel="stylesheets"> -->
<!-- <style type="text/css" href="./css/cssstyles.css"></style> -->
<style>
input[type=text], select {
	width: 30%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit] {
	background-color: green;
	color: white;
	padding: 14px 20px;
	margin: 6px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=reset] {
	width: 100%;
	background-color: red;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=number] {
	width: 10%;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}

div {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 50px;
}

#done {
	background-color: green;
	width: 15%;
}

#forgot {
	background-color: green;
	width: 18%;
}

#sel {
	margin-left: 10%;
	width: 20%;
}

</style>
</head>
<body>

	<!-- <h2
		style="background: green; color: white; padding: 20px; font-size: 20px">Register</h2> -->


	<div>
		<form action="landing.cm" method="get">

			<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
				<a class="navbar-brand" href="#">Temple Registration</a> <input
					type="reset" value="Register" id="done"
					onclick="window.location='landing.cm'"> <input
					type="reset" value="Resend" id="done"
					onclick="window.location='ResendMail.jsp'"> <input
					type="reset" value="Login" id="done"
					onclick="window.location='Login.jsp'"><input type="reset"
					value="ForgotPassword" id="forgot"
					onclick="window.location='ForgotPassword.jsp'"> <input
					type="reset" value="Logout" id="done"
					onclick="window.location='Logout.jsp'">
			</nav>

			<!--Carousel Wrapper-->
			<div id="carousel-example-1z"
				class="carousel slide carousel-fade z-depth-1-half"
				data-ride="carousel">
				<!--Indicators-->
				<ol class="carousel-indicators">
					<li data-target="#carousel-example-1z" data-slide-to="0"
						class="active"></li>
					<li data-target="#carousel-example-1z" data-slide-to="1"></li>
					<li data-target="#carousel-example-1z" data-slide-to="2"></li>
				</ol>
				<!--/.Indicators-->
				<!--Slides-->
				<div class="carousel-inner" role="listbox">
					<!--First slide-->
					<div class="carousel-item active">
						<img class="d-block w-100"
							src="https://i.pinimg.com/originals/12/fd/bb/12fdbbb8f0f43a5a6d71f81e845e138d.jpg"
							alt="First slide">
					</div>
					<!--/First slide-->
					<!--Second slide-->
					<div class="carousel-item">
						<img class="d-block w-100"
							src="https://www.newsfolo.com/wp-content/uploads/2017/12/vaikunta_ekadasi-810x464.jpg"
							alt="Second slide">
					</div>
					<!--/Second slide-->
					<!--Third slide-->
					<div class="carousel-item">
						<img class="d-block w-100"
							src="https://data1.ibtimes.co.in/en/full/527313/sri-venkateswara-swamy.png"
							alt="Third slide">
					</div>
					<!--/Third slide-->
					<!--Fourth slide-->
					<div class="carousel-item">
						<img class="d-block w-100"
							src="http://iskconkanpur.com/wp/wp-content/uploads/2019/06/ram-1024x720.jpg"
							alt="Fourth slide">
					</div>
					<!--/Fourth slide-->
					<!--Fifth slide-->
					<div class="carousel-item">
						<img class="d-block w-100"
							src="http://amamangalamvishnutemple.com/images/banner.jpg"
							alt="Fifth slide">
					</div>
					<!--/Fifth slide-->
				</div>
				<!--/.Slides-->
				<!--Controls-->
				<a class="carousel-control-prev" href="#carousel-example-1z"
					role="button" data-slide="prev"> <span
					class="carousel-control-prev-icon" aria-hidden="true"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="carousel-control-next" href="#carousel-example-1z"
					role="button" data-slide="next"> <span
					class="carousel-control-next-icon" aria-hidden="true"></span> <span
					class="sr-only">Next</span>
				</a>
				<!--/.Controls-->
			</div>

		</form>
	</div>
	<h5
		style="background: grey; color: white; padding: 10px; font-size: 20px">Powered
		by X-workz</h5>
</body>
</html>