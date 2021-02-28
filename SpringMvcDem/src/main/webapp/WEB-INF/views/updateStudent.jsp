<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Student</title>
<jsp:include page="links.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="mt-5">
		<div class="row justify-content-center">
			<div class="col-md-7">

				<div class="jumbotron shadow-lg bg-light mt-1">
					<h3 style="text-align: center;">Edit Form</h3>
					<hr>
					<form:form  method="post" modelAttribute="student">
					<div class="form-group row">
						<form:label path="rollNo" cssClass="col-2">RollNo</form:label>
						<div class="col-10">
							<div class="input-group">
							<div class="input-group-prepend">
							<div class="input-group-text"><i class="fas fa-user"></i></div>
							</div>
								<form:input type="text" path="rollNo" cssClass="form-control"  cssErrorClass="form-control is-invalid" disabled="true"/>
								<div class="invalid-feedback">
									<form:errors path="rollNo">
									</form:errors>
								</div>
							</div>
						</div>
						</div>

						<div class="form-group row">
						<form:label path="sname" cssClass="col-2">Student Name</form:label>
						<div class="col-10">
							<div class="input-group">
							<div class="input-group-prepend">
							<div class="input-group-text"><i class="fas fa-users"></i></div>
							</div>
								<form:input type="text" path="sname" cssClass="form-control"
									cssErrorClass="form-control is-invalid" />
								<div class="invalid-feedback">
									<form:errors path="sname">
									</form:errors>
								</div>
							</div>
						</div>
						</div>

						<div class="form-group row">
						<form:label path="age" cssClass="col-2">Age</form:label>
						<div class="col-10">
							<div class="input-group">
							<div class="input-group-prepend">
							<div class="input-group-text"><i class="fas fa-user"></i></div>
							</div>
								<form:input type="text" path="age" cssClass="form-control"
									cssErrorClass="form-control is-invalid" />
								<div class="invalid-feedback">
									<form:errors path="age">
									</form:errors>
								</div>
							</div>
						</div>
					</div>
					<div class="row justify-content-center">
					<div class="col-9 ml-5">
					<form:button class="btn btn-block btn-left btn-success">Update</form:button>
					</div>
					</div>
					</form:form>
				</div>
			</div>

		</div>
	</div>
</body>
</html>