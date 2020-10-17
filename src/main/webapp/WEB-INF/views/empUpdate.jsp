<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<div class="card-header">Update Information</div>

				<form:form action="/CRUDSpringMVC/employee/updateEmployee.do" method="POST"
					modelAttribute="registerBean">
					<%-- <c:forEach items="${employeeList}" var="emp"> --%>
				    <div class="card-body">
						<div class="row">
							<div class="col-12 form-group">
								<label class="label" for="firstName">Emp_id</label>
								<form:input path="empid" value="${employeeList.empid}" class="form-control" readonly="true"/>				
							</div>
						</div>
					<div class="card-body">
						<div class="row">
							<div class="col-12 form-group">
								<label class="label" for="firstName">FirstName</label>
								<form:input path="firstName" value="${employeeList.firstName}" class="form-control"/>
								<form:errors path="firstName" class="error"></form:errors>
							</div>
						</div>

						<div class="row">
							<div class="col-12 form-group">
								<label class="label" for="lastName">LastName</label>
								<form:input path="lastName" value="${employeeList.lastName}" class="form-control"/>
								<form:errors path="lastName" class="error"></form:errors>
							</div>
						</div>

						<div class="row">
							<div class="col-12 form-group">
								<!-- <label class="label" for="password">Password</label> -->
								<form:hidden path="password" value="${employeeList.password}" class="form-control"/>
								<form:errors path="password" class="error"></form:errors>
							</div>
						</div>

						<div class="row">
							<div class="col-12 form-group">
							<!-- 	<label class="label" for="confirmPassword">ConfPass</label> -->
								<form:hidden path="confirmPassword" value="${employeeList.confirmPassword}" class="form-control"/>
								<form:errors path="confirmPassword" class="error"></form:errors>
							</div>
						</div> 

						<div class="row">
							<div class="col-12 form-group">
								<label class="label" for="email">Email</label>
								<form:input path="email" value="${employeeList.email}" class="form-control"/>
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
					</div>
			<%-- 	</c:forEach> --%>
				</form:form>
	
			</div>
		</div>
	</div>

</body>
</html>