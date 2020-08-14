<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
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

	<div>
		<form action="login.cm" method="post">
		
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
				<a class="navbar-brand" href="#">Temple Registration</a> <input
					type="reset" value="Register" id="done"
					onclick="window.location='Registration.jsp'"> <input
					type="reset" value="Resend" id="done"
					onclick="window.location='ResendMail.jsp'"> <input
					type="reset" value="Login" id="done"
					onclick="window.location='Login.jsp'"><input type="reset"
					value="ForgotPassword" id="forgot"
					onclick="window.location='ForgotPassword.jsp'"> <input
					type="reset" value="Logout" id="done"
					onclick="window.location='Logout.jsp'">
			</nav>
			<br>
			<h2>Login</h2>
			
			<label>Enter Email-Id: </label> <input type="text" name="emailId"
				placeholder="enter email"><br> 
			<label>Enter Password: </label> <input type="password" name="password"
				placeholder="enter password"><br>		
			<div>
				<input type="submit" value="Login" id="done">
				<a href="GeneratePassword.jsp" value="Login for first time">Login for first time</a>
			</div>
		</form>
	</div>

	<h5
		style="background: grey; color: white; padding: 10px; font-size: 20px">Powered
		by X-workz</h5>

</body>
</html>