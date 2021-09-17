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
		<h1>New Dorm</h1>	
		<a href="/dashboard">Dashboard</a>
		
		<form:form method="POST" action="/dorms/create" modelAttribute="dorm">
			<div class="form-group row">
				<form:label path="name" class="col-sm-2 col-form-label">Name:
					<form:errors path="name"/>
					<div class="col-sm-10">
						<form:input path="name" class="form-control"/>
					</div>
				</form:label>
			</div>
			
			<button>Create</button>
			
		</form:form>
 
	</div>

</body>
</html>