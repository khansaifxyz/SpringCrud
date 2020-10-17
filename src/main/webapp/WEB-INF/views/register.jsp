<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<link href="/CRUDSpringMVC/resources/css/bootstrap.min.css"
	rel="stylesheet" />
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.error{
          color: red;
          }
</style>
</head>
<body>
	<div class="container">
		<div class="col-4">
			<div class="card" style="box-shadow: 4px 8px 20px 0px #BBB;">
				<div class="card-header">Registration page</div>

				<form:form action="/CRUDSpringMVC/employee/saveRegister.do" method="POST"
					modelAttribute="registerBean">
				
					<div class="card-body">
						<div class="row">
							<div class="col-12 form-group">
								<label class="label" for="firstName">FirstName</label>
								<form:input path="firstName" class="form-control"/>
								<form:errors path="firstName" class="error"></form:errors>
							</div>
						</div>

						<div class="row">
							<div class="col-12 form-group">
								<label class="label" for="lastName">LastName</label>
								<form:input path="lastName"  class="form-control"/>
								<form:errors path="lastName" class="error"></form:errors>
							</div>
						</div>

						<div class="row">
							<div class="col-12 form-group">
								<label class="label" for="password">Password</label>
								<form:password path="password" class="form-control"/>
								<form:errors path="password" class="error"></form:errors>
							</div>
						</div>

						<div class="row">
							<div class="col-12 form-group">
								<label class="label" for="confirmPassword">ConfPass</label>
								<form:password path="confirmPassword" class="form-control"/>
								<form:errors path="confirmPassword" class="error"></form:errors>
							</div>
						</div>

						<div class="row">
							<div class="col-12 form-group">
								<label class="label" for="email">Email</label>
								<form:input path="email" class="form-control"/>
							</div>
						</div>

						<div class="row">
							<div class="col-12 form group">
							<div class="card" style="box-shadow: 4px 8px 20px 0px #BBB">
								<input type="submit" style= "float: right;" value="Register" class="btn btn-primary"  >
								</div>
							</div>
						</div>

					</div>
				
				</form:form>
	
			</div>
		</div>
	</div>


</body>
</html>