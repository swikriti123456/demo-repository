<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<form:form method="post">
<form:label path="username">User Name</form:label>
<form:input path="username" type="text"/><br>
<form:label path="email">Email</form:label>
<form:input path="email" type="email"/><br>
<form:label path="password">Password</form:label>
<form:input path="password" type="password"/><br>
<form:label path="password">Confirm Password</form:label>
<form:input path="password" type="password"/><br>
<button type="submit">Register</button>
</form:form>
</body>
</html>