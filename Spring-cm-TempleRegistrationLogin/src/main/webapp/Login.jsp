<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link href="./css/bootstrap.css" rel="stylesheets">
<link href="./css/bootstrap.css.map" rel="stylesheets">
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

#sel {
	margin-left: 10%;
	width: 20%;
}
</style>
</head>
<body>

	<nav class="navbar navbar-dark bg-dark">
		<form class="form-inline">
			<nav class="navbar navbar-light bg-light">
				Login <input type="reset" value="Register" id="done"
					onclick="window.location='Registration.jsp'"> <input
					type="reset" value="Resend Mail" id="done"
					onclick="window.location='ResendMail.jsp'"> <input
					type="reset" value="Login" id="done"
					onclick="window.location='Login.jsp'">
			</nav>
		</form>
	</nav>
	<div>
		<form action="login.cm" method="post">
			<label>Enter Email-Id: </label> <input type="text" name="emailId"
				placeholder="enter email"><br> 
			<label>Enter Password: </label> <input type="text" name="password"
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