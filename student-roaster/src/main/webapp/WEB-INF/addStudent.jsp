<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>New Student</h1>	
		<a href="/dashboard">Dashboard</a>
		
		<form:form method="POST" action="/students/create" modelAttribute="student">
			<div class="form-group row">
				<form:label path="firstName" class="col-sm-2 col-form-label">First Name:
					<form:errors path="firstName"/>
					<div class="col-sm-10">
						<form:input path="firstName" class="form-control"/>
					</div>
				</form:label>
			</div>
			<div class="form-group row">
				<form:label path="lastName" class="col-sm-2 col-form-label">Last Name:
					<form:errors path="lastName"/>
					<div class="col-sm-10">
						<form:input path="lastName" class="form-control"/>
					</div>
				</form:label>
			</div>
			<div class="form-group row">
				<form:label path="age" class="col-sm-2 col-form-label">Age:
					<form:errors path="age"/>
					<div class="col-sm-10">
						<form:input path="age" class="form-control"/>
					</div>
				</form:label>
			</div>
			
			<button>Create</button>
			
		</form:form>
 
	</div>
</body>
</html>