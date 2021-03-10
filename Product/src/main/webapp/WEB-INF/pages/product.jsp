<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
	<table>
		<tr>
			<th>pid</th>
			<th>pname</th>
			<th>price</th>
			<th>ACTION</th>
		</tr>
		<tbody>
		<c:forEach var="p" items="${plist }">
		<tr>
		<th>${p.pid }</th>
		<th>${p.pname }</th>
		<th>${p.price }</th> 
		<th>
		<a href="/admin/editProduct/${p.pid}">EDIT</a>/
		<a href="/admin/deleteProduct/${p.pid}">DELETE</a>
		</th>
		</tr>
		</c:forEach>
			

		</tbody>
	</table>
</body>
</html>