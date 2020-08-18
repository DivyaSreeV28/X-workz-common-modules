<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Visit Page</title>
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

	<!-- <h3
		style="background: green; color: white; padding: 20px; font-size: 20px">Re-Sending
		Mail Success</h3>
 -->
	<div>
		<form action="book.cm" method="post">
		
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<a class="navbar-brand" href="#">Temple Registration</a> 
				<h4>Welcome, ${emailId}</h4>
			</nav>
			<br>
			<h2>Visiting Details</h2>
			<br> <label>Enter Date of visiting: </label> <input type="date"
				name="date" placeholder="Date of Visiting"><br> <br>

			<!-- for(AppPropertyDTO seList:specialEntryList){
						seList.getPropertyName();
				} -->
			<label>Select Entrance Type : </label> <select name="selist" id="sel">
				<c:forEach var="selist" items="${specialEntryList}">
					<option value="${selist.propValue}">${selist.propName}</option>
				</c:forEach>
			</select> <br> <label>Select number of people:</label> <input type="text"
				name="numberOfPersons" placeholder="Enter number of persons"><br>

			<label>Select Prasada type: </label> <select name="prasada" id="sel">
				<c:forEach var="prasadaList" items="${prasadaList}">
					<option value="${prasadaList.propValue}">${prasadaList.propName}</option>
				</c:forEach>
			</select> <br> <label>Select valid ID Type : </label> <select
				name="idcard" id="sel">
				<c:forEach var="idlist" items="${idList}">
					<option value="${idlist.propValue}">${idlist.propName}</option>
				</c:forEach>
			</select> <br> <label>Enter Id card number of above selected
				type: </label> <input type="text" name="idnumber"
				placeholder="Enter Id card number"><br> <label>Select
				Pooja Type : </label> <select name="ptlist" id="sel">
				<c:forEach var="ptlist" items="${poojaTypeList}">
					<option value="${ptlist.propValue}">${ptlist.propName}</option>
				</c:forEach>
			</select>

			<div>
				<input type="submit" value="Book" id="done">
			</div>
		</form>
	</div>

	<h5
		style="background: grey; color: white; padding: 10px; font-size: 20px">Powered
		by X-workz</h5>
</body>
</html>