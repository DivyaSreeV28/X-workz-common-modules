<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success Page</title>
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
			
	<!-- <h3
		style="background: green; color: white; padding: 20px; font-size: 20px">Registration
		Success</h3> -->

	<div>
<br>
	<h2>Registration Success</h2>
	
		<c:if test="${dataValid}">
			<h2>Personal Information</h2>
			<h4>Name of Visitor is: ${registrationDto.name}</h4>
			<h4>Mobile number of Visitor is: ${registrationDto.mobileNumber}</h4>
			<h4>Address of Visitor is: ${registrationDto.address}</h4>
			<h4>Age of Visitor is: ${registrationDto.age}</h4>
			<h4>State of Visitor is : ${registrationDto.state}</h4>
			<h4>EmailId of Visitor is: ${registrationDto.emailId}</h4><br>
			<h2>Visiting Details</h2>
			<h4>Date of visiting is: ${registrationDto.date}</h4>
			<h4>Special Entrance type is : ${registrationDto.selist}</h4>
			<h4>Pooja type is : ${registrationDto.ptlist}</h4>
			<h4>Id card type is : ${registrationDto.idcard}</h4>
			<h4>Id number is : ${registrationDto.idnumber}</h4>
			<h4>Prasada type is : ${registrationDto.prasada}</h4>
			<h4>Number of persons visiting is :
				${registrationDto.numberOfPersons}</h4><br>
			<h2>Registration Details sent to registered Email-Id
				successfully, check it...</h2>

		</c:if>


	</div>

	<h5
		style="background: grey; color: white; padding: 10px; font-size: 20px">Powered
		by X-workz</h5>
</body>
</html>