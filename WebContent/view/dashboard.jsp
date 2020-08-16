<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="jstlc" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MDMS</title>
</head>
<body>
	<jsp:include page="header.jsp" />

	<center>
		<h3>Medicine list</h3>
		<table border="1" cellspacing="5" cellpadding="10" bgcolor="white">
			<thead>
				<th>id</th>
				<th>Name</th>
				<th>Quantity</th>
				<th>Price</th>
				<th>Man_Date</th>
				<th>Exp_Date</th>
				<th>Action</th>
			</thead>
			<jstlc:forEach var="meds" items="${medicine_list}">
				<tr>
					<td>${meds.id}</td>
					<td>${meds.name}</td>
					<td>${meds.quantity}</td>
					<td>${meds.price} Rs</td>
					<td>${meds.man_date}</td>
					<td>${meds.exp_date}</td>
					<td>
						<a href="edit?id=${meds.id}">Edit</a> | 
						<a href="delete?id=${meds.id}" 
							onclick="javascript: return confirm('Are you sure you want to delete this record?');">Delete</a>
					</td>
				</tr>
			</jstlc:forEach>
		</table>
	</center>
</body>
</html>