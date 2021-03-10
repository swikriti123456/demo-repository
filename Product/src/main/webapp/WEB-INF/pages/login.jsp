<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<form method="post">
		<label>UserName</label> <input type="text" name="username" /><br>
		<label>Password</label> <input type="password" name="password" /> 
		<input
			type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<button>Login</button>
	</form>
</body>
</html>