<%

	String session_username = (String)session.getAttribute("username");
	
%>
<style>
body{
background-image: url("https://previews.123rf.com/images/kerdkanno/kerdkanno1510/kerdkanno151000219/47780521-herbal-medicine-vs-chemical-medicine-the-alternative-healthy-care-on-white-background-.jpg");
 background-size:cover;
 }
 </style>
<div>
	<div style="float: left">
		<% if(session_username != null) { %>
			<a href="${pageContext.request.contextPath}/add_medicine">Add</a> | 
			<a href="${pageContext.request.contextPath}/dashboard">List</a>
		<% } %>
	</div>

	<div style="float: right">
		<% if(session_username == null) { %>
			<a href="${pageContext.request.contextPath}/login">Login</a>
		<% } %>
		
		<% if(session_username != null) { %>
			Welcome <%= session.getAttribute("username") %> | 
			<a href="${pageContext.request.contextPath}/logout">Logout</a>
		<% } %>

	</div>
</div>


<br />
<br />

<center>
	<header style="background-color: black; color: white; height: 50px;">
		<h1>Medicine Database Management System</h1>
	</header>
</center>