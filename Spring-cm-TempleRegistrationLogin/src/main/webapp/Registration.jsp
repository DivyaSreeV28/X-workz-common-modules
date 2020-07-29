<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Temple Registration</title>
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
	width: 15%;
}

#sel {
	margin-left: 10%;
	width: 20%;
}
</style>
</head>
<body>

	<h3
		style="background: green; color: white; padding: 20px; font-size: 20px">Register</h3>

	<div>
		<h2>Personal Information</h2>
		<form action="/landing.cm" method="post">

			<label>Enter Full Name: </label>
			<input type="text" name="name" placeholder="enter full name"><br>
			<label>Enter valid Mobile number: </label>
			<input type="text" name="mobileNumber" placeholder="enter mobile number"><br><br>
			<label>Enter present Address: </label>
			<textarea rows="2" cols="30" name="address" placeholder="enter address"></textarea><br><br>
			<label>Enter age: </label> 
			<input type="text" name="age" placeholder="enter age"><br>
			<label>Enter Email-Id: </label>
			<input type="text" name="emailId" placeholder="enter email"><br>
			<label>Enter State: </label>
			<input type="text" name="state" placeholder="enter state"><br>
			<hr>

			<h2>Booking Information</h2><br>
			<label>Enter Date of visiting: </label>
			<input type="date" name="date" placeholder="Date of Visiting"><br><br>
			
				<!-- for(AppPropertyDTO seList:specialEntryList){
						seList.getPropertyName();
				} -->
			<label>Select Entrance Type : </label> <select name="se" id="sel">
				<c:forEach var="selist" items="${specialEntryList}">
					<option value="${selist.propValue}">${selist.propName}</option>
				</c:forEach>
			</select> <br> 
			<label>Select number of people: </label> <select name="nop" id="sel">
				<c:forEach var="noOfPersonList" items="${noOfPersonList}">
					<option value="${noOfPersonList.propValue}">${noOfPersonList.propName}</option>
				</c:forEach>
			</select> <br> 
			<label>Select Prasada type: </label> <select name="prasada" id="sel">
				<c:forEach var="prasadaList" items="${prasadaList}">
					<option value="${prasadaList.propValue}">${prasadaList.propName}</option>
				</c:forEach>
			</select> <br> 
			<label>Select valid ID Type : </label> <select name="id" id="sel">
				<c:forEach var="idlist" items="${idList}">
					<option value="${idlist.propValue}">${idlist.propName}</option>
				</c:forEach>
			</select> <br> 
			<label>Enter Id card number of above selected type: </label>
			<input type="text" name="idnumber" placeholder="Enter Id card number"><br>
			
			<label>Select Pooja Type : </label> <select name="pt" id="sel">
				<c:forEach var="ptlist" items="${poojaTypeList}">
					<option value="${ptlist.propValue}">${ptlist.propName}</option>
				</c:forEach>
			</select>

			<div>
				<input type="submit" value="Submit" id="done"> <input
					type="reset" value="Reset" id="done">
			</div>
			
			<!-- <footer class="w3-center w3-light-grey w3-padding-32">
					<p class="text-white-50 bg-dark">Powered by X-workz &reg;</p>
				</footer> -->
		</form>
	</div>
	<h5
		style="background: grey; color: white; padding: 10px; font-size: 20px">Powered by X-workz</h5>
</body>
</html>