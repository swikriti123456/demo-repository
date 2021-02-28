<%@ page language="java"  contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand" href="home">Online shop</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/">Home </a></li>
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/about">About Us </a></li>
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/students">StudentList </a></li>
		</ul>
	</div>
</nav>