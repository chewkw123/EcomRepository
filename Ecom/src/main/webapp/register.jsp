<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="RegisterEcomServlet" method="post">
	<h3>Username: <input type="text" name= "username"></h3>
	<h3>Password: <input type="password" name ="password"></h3>
	<h3>Email: <input type="text" name= "email"></h3>
	<h3>Mobile Number: <input type="text" name= "mobilenumber"></h3>
	<h3>Gender: <select name="gender">
		<option>Male</option>
		<option>Female</option>
		<option>Prefers not say</option>
	</select></h3>
	<input type="submit" value="Call Servlet"/>
</form>

</body>
</html>