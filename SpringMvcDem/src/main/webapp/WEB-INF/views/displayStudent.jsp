<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student List</title>
<jsp:include page="links.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>

	<div class="container shadow mt-4 ">
	<button class="btn btn-success" href="addProduct">Add Product</button>
		<c:if test="${not empty slist}">
			<a class="btn btn-success pr-4 m-4" href="addStudent">Add Student</a>
			<br>
			<br>
			<table class="table table-bordered m-4">
				<thead class="pr-3 thead-dark ">
					<tr>
						<th>ROLLNO</th>
						<th>NAME</th>
						<th>AGE</th>
						<th>ACTION</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="student" items="${slist}">
						<tr>
							<td>${student.rollNo}</td>
							<td>${student.sname}</td>
							<td>${student.age}</td>
							<td><a href="editStudent/${student.rollNo}"><i class="fas fa-user-edit text-info"></i></a>/<a
								href="deleteStudent/${student.rollNo}"><i class="fas fa-trash text-danger"></i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>

</body>
</html>