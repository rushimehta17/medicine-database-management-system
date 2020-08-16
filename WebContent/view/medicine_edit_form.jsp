<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MDMS</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<center>
		<fieldset>
			<legend>Edit Medicine Form</legend>
			<form action="${pageContext.request.contextPath}/edit_medicine_action"
				method="POST" modelAttribute="medicine">
				<input type="hidden" name="id" value="${medicine.id}"/>
			    Name:<input type="text" name="name" placeholder="Medicine Name" value="${medicine.name}" /><br /></br>
	     	    Quantity:<input type="number" name="quantity" placeholder="quantity" value="${medicine.quantity}"/><br /> <br/>
			    Price:<input type="text" name="price" placeholder="price" value="${medicine.price}" /><br/><br/>
			    Man Date:<input type="text" name="man_date" placeholder="Manufacturing Date" value="${medicine.man_date}"><br/><br/>
		        Exp Date:<input type="text" name="exp_date" placeholder="Expire Date" value="${medicine.exp_date}"><br/><br/>
					
					<input type="submit" value="Save">
			</form>
		</fieldset>
	</center>
</body>
</html>