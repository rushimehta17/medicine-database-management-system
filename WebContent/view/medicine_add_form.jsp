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
			<legend>Add Medicine Form</legend>
			<form action="${pageContext.request.contextPath}/add_medicine_action"
				method="POST" modelAttribute="medicine">
				<input type="text" name="name" placeholder="Medicine Name"
					autocomplete="off" /><br /><br/>
					 <input type="number" name="quantity" placeholder="quantity" /><br /> <br/>
					<input type="text" name="price" placeholder="price" /><br/><br/>
					<input type="text" name="man_date" placeholder="Manufacturing Date"><br/><br/>
					<input type="text" name="exp_date" placeholder="Expire Date"><br/><br/>
					
					<input type="submit" name="add" value="Add">
					<input type="reset" value="Clear">
			</form>
		</fieldset>
	</center>
</body>
</html>