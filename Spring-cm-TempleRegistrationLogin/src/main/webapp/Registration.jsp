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

			<input type="text" name="name" placeholder="enter name"> 
			<input type="text" name="mobileNumber" placeholder="enter mobile number"><br>
			<textarea rows="2" cols="30" name="address" placeholder="enter address"></textarea><br> 
			<input type="text" name="age" placeholder="enter age">
			<input type="text" name="state" placeholder="enter state"> 
			<input type="text" name="emailId" placeholder="enter email">
			<hr>

			<h2>Booking Information</h2>
			<input type="date" name="date" placeholder="Date of Visiting">
			
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
			</select> <br> <br> 
			<label>Select Prasada : </label> <select name="prasada" id="sel">
				<c:forEach var="prlist" items="${prasadaList}">
					<option value="${prasada.propValue}">${prasada.propName}</option>
				</c:forEach>
			</select> <br> 
			<label>Select ID Type : </label> <select name="id" id="sel">
				<c:forEach var="idlist" items="${idList}">
					<option value="${idlist.propValue}">${idlist.propName}</option>
				</c:forEach>
			</select> <br> 
			<label>Select Pooja Type : </label> <select name="pt" id="sel">
				<c:forEach var="ptlist" items="${poojaTypeList}">
					<option value="${ptlist.propValue}">${ptlist.propName}</option>
				</c:forEach>
			</select>

			<div>
				<input type="submit" value="Submit" id="done"> <input
					type="reset" value="Reset" id="done">
			</div>
		</form>
	</div>
</body>
</html>