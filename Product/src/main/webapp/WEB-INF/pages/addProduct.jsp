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

<form:label path="pname">PNAME</form:label>
<form:input type="text" path="pname"/>
<form:label path="price">PRICE</form:label>
<form:input type="text" path="price"/>
<button type="submit">Add</button>
</form:form>
</body>
</html>