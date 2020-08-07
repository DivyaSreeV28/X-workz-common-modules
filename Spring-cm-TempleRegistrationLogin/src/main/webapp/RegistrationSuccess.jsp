<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success Page</title>
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
				Registration Success<input type="reset" value="Register" id="done"
					onclick="window.location='Registration.jsp'"> <input
					type="reset" value="Resend Mail" id="done"
					onclick="window.location='ResendMail.jsp'"> <input
					type="reset" value="Login" id="done"
					onclick="window.location='Login.jsp'">
			</nav>
		</form>
	</nav>

	<!-- <h3
		style="background: green; color: white; padding: 20px; font-size: 20px">Registration
		Success</h3> -->
	
	<div>
		<h2>Personal Information</h2><br>
		${name}<br>
		${mobilenumber}<br>
		${address}<br>
		${age}<br>
		${emailid}<br>
		${state}<br>
		
		<h2>Visiting Details</h2><br>
		${date}<br>
		${entrance}<br>
		${pooja}<br>
		${idcard}<br>
		${idnumber}<br>
		${prasada}<br>
		${noofpersons}<br>
		
		<h2>Registration Details sent to registered Email-Id successfully, check it...</h2>
	</div>
	
		<h5
		style="background: grey; color: white; padding: 10px; font-size: 20px">Powered by X-workz</h5>
</body>
</html>